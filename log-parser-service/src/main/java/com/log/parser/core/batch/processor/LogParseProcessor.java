package com.log.parser.core.batch.processor;

import com.log.parser.common.dto.LogParseDTO;
import com.log.parser.common.entity.LogParseRecordEntity;
import com.log.parser.common.util.DateUtils;
import com.log.parser.core.batch.abstracts.AbstractLogParseProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class LogParseProcessor extends AbstractLogParseProcessor implements ItemProcessor<LogParseDTO, LogParseRecordEntity> {

    private static final Logger logger = LoggerFactory.getLogger(LogParseProcessor.class);

    /**
     * This method will transform the DTO to the entity to be save in the database.
     * */
    @Override
    public LogParseRecordEntity process(LogParseDTO logParseDTO) throws Exception {

        logger.trace("[Start][LogParseProcessor][process]");

        LogParseRecordEntity logParseRecordEntity = logParseDTO.getLogParseRecordEntity();
        logParseRecordEntity.setRecodDate(DateUtils.getDate(logParseDTO.getDate()));

        logger.trace("[End][LogParseProcessor][process]");

        return logParseRecordEntity;
    }
}
