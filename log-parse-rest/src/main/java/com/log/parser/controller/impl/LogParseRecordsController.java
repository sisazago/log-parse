package com.log.parser.controller.impl;

import com.log.parser.common.dto.resultdto.LogParseResultDTO;
import com.log.parser.controller.ILogParseRecordsController;
import com.log.parser.core.services.ILogParseService;
import com.log.parser.ws.response.LogParseRecordsResponse;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("/log-parse-records")
@RestController
@RequestMapping("/log-parse-records")
public class LogParseRecordsController implements ILogParseRecordsController {

    private static final Logger logger = LoggerFactory.getLogger(LogParseRecordsController.class);

    @Autowired
    private ILogParseService logParseService;

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<LogParseRecordsResponse> getAllLogParseRecords() {
        logger.info("[Start][LogParseRecordsController][getAllLogParseRecords]");

        List<LogParseResultDTO> logParseResultDTOS = logParseService.getAllLogParseRecords();

        LogParseRecordsResponse logParseRecordsResponse = new LogParseRecordsResponse(logParseResultDTOS);

        return new ResponseEntity<>(logParseRecordsResponse, HttpStatus.OK);
    }
}
