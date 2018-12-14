package com.log.parser.core.services.impl;

import com.log.parser.common.common.LogParseQueryConstant;
import com.log.parser.common.dto.LogInfoDTO;
import com.log.parser.common.dto.resultdto.LogParseResultDTO;
import com.log.parser.common.dto.resultdto.LogsResultDTO;
import com.log.parser.common.entity.LogParseRecordEntity;
import com.log.parser.core.services.ILogParseService;
import com.log.parser.dao.repo.ILogParseRecordRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import java.util.*;

@Service
public class LogParseServiceImpl implements ILogParseService {

    private static final Logger logger = LoggerFactory.getLogger(LogParseServiceImpl.class);

    @Autowired
    private ILogParseRecordRepository logParseRecordRepository;

    @Autowired
    private EntityManager entityManager;

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

        List<LogsResultDTO> resultList = new ArrayList<>();

        Date endDate = new Date();

        //Identify if the search is on the period of days or hours.
        switch (logInfoDTO.getDurationEnum()){
            case HOURLY:
                endDate = DateUtils.addHours(logInfoDTO.getStartDate(), 1);
                break;
            case DAILY:
                endDate = DateUtils.addDays(logInfoDTO.getStartDate(), 1);
                break;
        }

        logParseRecordRepository.findIpAddressByRecordDateBetweenAndTreadHolder(logInfoDTO.getStartDate(), endDate, logInfoDTO.getTreadHolder()).forEach(logsResultDTO -> {
            LogsResultDTO logResult = new LogsResultDTO(logsResultDTO.getIpAddress(), logsResultDTO.getCallsNumber());
            resultList.add(logResult);
        });

        logger.trace("[End][LogParseServiceImpl][getIpAddressFromLog]");
        return resultList;
    }
}
