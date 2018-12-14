package com.log.parser.schedule;

import com.log.parser.core.services.ILogFileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LoadLogFileSchedule {

    private static final Logger logger = LoggerFactory.getLogger(LoadLogFileSchedule.class);

    @Autowired
    private ILogFileUploadService logFileUploadService;

    /**
     * Schedule to load the log file to the database.
     * */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void loadLogFile (){
        logger.info("[Start][LoadLogFileSchedule][loadLogFile]");
        try{
            logFileUploadService.processLogFile();
        }catch (Exception e){
            logger.error("[Error][LoadLogFileSchedule][loadLogFile] Error loading the log file.", e);
        }
        logger.info("[End][LoadLogFileSchedule][loadLogFile]");
    }
}
