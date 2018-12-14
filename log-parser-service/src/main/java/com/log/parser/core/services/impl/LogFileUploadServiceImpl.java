package com.log.parser.core.services.impl;

import com.log.parser.common.dto.LogParseDTO;
import com.log.parser.common.entity.LogParseRecordEntity;
import com.log.parser.core.services.ILogFileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;

@Service
public class LogFileUploadServiceImpl implements ILogFileUploadService {

    private static final Logger logger = LoggerFactory.getLogger(LogFileUploadServiceImpl.class);

    @Autowired
    private LineMapper<LogParseDTO> logParseLineMapper;

    @Autowired
    private ItemProcessor<LogParseDTO, LogParseRecordEntity> logProcessor;

    @Autowired
    private ItemWriter<LogParseRecordEntity> logWriter;

    @Autowired
    private JobBuilderFactory logParseJobBuilder;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobLauncher jobLauncher;

    @Value("${log.path}")
    private String resources;


    @Override
    public void processLogFile() {
        logger.debug("[Start][LogFileUploadServiceImpl][processLogFile]");

        try{

            FlatFileItemReader<LogParseDTO> logParseDTOFlatFileItemReader = new FlatFileItemReader<>();
            logParseDTOFlatFileItemReader.setLineMapper(logParseLineMapper);
            logParseDTOFlatFileItemReader.setResource(new InputStreamResource(new FileInputStream(new File(resources))));

            jobLauncher.run(executeLogParseJob(logParseDTOFlatFileItemReader), new JobParameters());

        }catch (Exception e){
            logger.error("[Error][LogFileUploadServiceImpl][processLogFile]Error processing the log file.", e);
        }

        logger.debug("[End][LogFileUploadServiceImpl][processLogFile]");
    }

    private Job executeLogParseJob(FlatFileItemReader<LogParseDTO> flatFileItemReader){
        logger.trace("[Start][LogFileUploadServiceImpl][executeLogParseJob]");
        try {
            return logParseJobBuilder.get("executeLogParseJob")
                    .flow(logParseStep(flatFileItemReader))
                    .end()
                    .build();
        }catch (Exception e){
            logger.error("[Error][LogFileUploadServiceImpl][executeLogParseJob]Error building the job.", e);
            throw e;
        }
    }

    private Step logParseStep(FlatFileItemReader<LogParseDTO> flatFileItemReader) {
        logger.trace("[Start][LogFileUploadServiceImpl][logParseStep]");
        try {
            return stepBuilderFactory.get("logParseStep")
                    .<LogParseDTO, LogParseRecordEntity>chunk(100)
                    .reader(flatFileItemReader)
                    .processor(logProcessor)
                    .writer(logWriter)
                    .faultTolerant()
                    .skipLimit(100)
                    .skip(Exception.class)
                    .build();
        } catch (Exception e) {
            logger.error("[Error][LogFileUploadServiceImpl][logParseStep]There was an error while executing the batch load", e);
            throw e;
        }
    }

}
