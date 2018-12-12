package com.log.parser.core.services.impl;

import com.log.parser.common.dto.resultdto.LogParseResultDTO;
import com.log.parser.core.services.ILogParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogParseServiceImpl implements ILogParseService {

    private static final Logger logger = LoggerFactory.getLogger(LogParseServiceImpl.class);

    @Override
    public List<LogParseResultDTO> getAllLogParseRecords() {

        
        return null;
    }
}
