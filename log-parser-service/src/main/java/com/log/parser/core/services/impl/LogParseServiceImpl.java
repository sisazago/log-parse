package com.log.parser.core.services.impl;

import com.log.parser.common.dto.LogInfoDTO;
import com.log.parser.common.dto.resultdto.LogParseResultDTO;
import com.log.parser.common.dto.resultdto.LogsResultDTO;
import com.log.parser.common.entity.LogParseRecordEntity;
import com.log.parser.core.services.ILogParseService;
import com.log.parser.dao.repo.ILogParseRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogParseServiceImpl implements ILogParseService {

    private static final Logger logger = LoggerFactory.getLogger(LogParseServiceImpl.class);

    @Autowired
    private ILogParseRecordRepository logParseRecordRepository;

    @Override
    public List<LogParseResultDTO> getAllLogParseRecords() {
        logger.trace("[Start][LogParseServiceImpl][getAllLogParseRecords]");
        List<LogParseResultDTO> logParseResultList = new ArrayList<>();

        List<LogParseRecordEntity> logParseRecordEntities = (List<LogParseRecordEntity>) logParseRecordRepository.findAll();

        logParseRecordEntities.forEach(logParseRecordEntity -> {
            logParseResultList.add(new LogParseResultDTO(logParseRecordEntity));
        });

        logger.trace("[End][LogParseServiceImpl][getAllLogParseRecords]Output:[size={}]", logParseResultList.size());

        return logParseResultList;
    }

    @Override
    public List<LogsResultDTO> getIpAddressFromLog(LogInfoDTO logInfoDTO) {
        logger.trace("[Start][LogParseServiceImpl][getIpAddressFromLog]");

        List<LogsResultDTO> logsResultDTOS = new ArrayList<>();

        //Identify if the search is on the period of days or hours.
        switch (logInfoDTO.getDurationEnum()){
            case HOURLY:
                logsResultDTOS = logParseRecordRepository.getAllIpAddressInPeriodOfAnHourByDate(logInfoDTO.getStartDate(), logInfoDTO.getStartDate(), logInfoDTO.getTreadHolder());
                break;
            case DAILY:
                logsResultDTOS = logParseRecordRepository.getAllIpAddressInPeriodOfAnDayByDate(logInfoDTO.getStartDate(), logInfoDTO.getStartDate(), logInfoDTO.getTreadHolder());
                break;
        }

        logger.trace("[End][LogParseServiceImpl][getIpAddressFromLog]");
        return logsResultDTOS;
    }
}
