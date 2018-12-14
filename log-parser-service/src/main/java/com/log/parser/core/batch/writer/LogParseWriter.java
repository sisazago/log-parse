package com.log.parser.core.batch.writer;

import com.log.parser.common.entity.LogParseRecordEntity;
import com.log.parser.core.batch.abstracts.AbstractLogParseProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogParseWriter extends AbstractLogParseProcessor implements ItemWriter<LogParseRecordEntity> {

    private static final Logger logger = LoggerFactory.getLogger(LogParseWriter.class);

    /**
     * This method is done to save all the records of the log in the database.
     * */
    @Override
    public void write(List<? extends LogParseRecordEntity> list) throws Exception {
        logger.trace("[Start][LogParseWriter][write]");

        try {
            list.forEach(logParseEntity -> {
                logParseRecordRepository.save(logParseEntity);
            });

        }catch (Exception e){
            logger.error("[Error][LogParseWriter][write]There was an error saving the log records.", e);
            throw new Exception(e);
        }

        logger.trace("[End][LogParseWriter][write]");
    }
}
