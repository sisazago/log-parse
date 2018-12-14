package com.log.parser.config;

import com.log.parser.common.dto.LogParseDTO;
import com.log.parser.common.entity.LogParseRecordEntity;
import com.log.parser.core.batch.processor.LogParseProcessor;
import com.log.parser.core.batch.writer.LogParseWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private static final Logger logger = LoggerFactory.getLogger(BatchConfig.class);

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    /**
     * Bean creation for the Log parse process.
     * In this we indicate the tokenizer (This contains the structure of the file)
     * and the log mapper (This indicates the object were we are going to set this information)
     * */
    @Bean(name = "logParseLineMapper")
    public LineMapper<LogParseDTO> createLogParseLineMapper (){
        logger.debug("[Start][BatchConfig][createLogParseLineMapper]");

        DefaultLineMapper<LogParseDTO> runtLineMapper = new DefaultLineMapper<>();

        runtLineMapper.setLineTokenizer(createLogParseTokenizer());
        runtLineMapper.setFieldSetMapper(createLogParseInformationMapper());

        logger.debug("[End][BatchConfig][createLogParseLineMapper]");

        return runtLineMapper;
    }

    /**
     * This indicate the fields and the delimiter for the file to be read.
     * */
    @Bean(name = "logParseTokenizer")
    public LineTokenizer createLogParseTokenizer() {
        logger.debug("[Start][BatchConfig][createLogParseTokenizer]");

        DelimitedLineTokenizer logParseTokenizer = new DelimitedLineTokenizer();
        logParseTokenizer.setDelimiter("|");
        logParseTokenizer.setNames(new String[] {"date" , "ipAddress" , "request" , "status" , "userAgent"});

        logger.debug("[End][BatchConfig][createLogParseTokenizer]");
        return logParseTokenizer;
    }

    /**
     * This will map all the lines into the DTOs to be saved on the database.
     * */
    @Bean(name = "logParseInformationMapper")
    public FieldSetMapper<LogParseDTO> createLogParseInformationMapper (){
        logger.debug("[Start][BatchConfig][createLogParseInformationMapper]");

        BeanWrapperFieldSetMapper<LogParseDTO> logParseInformationMapper = new BeanWrapperFieldSetMapper<>();
        logParseInformationMapper.setTargetType(LogParseDTO.class);

        logger.debug("[End][BatchConfig][createLogParseInformationMapper]");
        return logParseInformationMapper;
    }

    /**
     * This will return the class that save the information in the database
     * */
    @Bean(name = "logWriter")
    public ItemWriter<LogParseRecordEntity> logParseWriter (){
        return new LogParseWriter();
    }

    /**
     * This will transform the information into entities.
     * */
    @Bean(name = "logProcessor")
    public ItemProcessor<LogParseDTO, LogParseRecordEntity> logParseProcessor(){
        return new LogParseProcessor();
    }

}
