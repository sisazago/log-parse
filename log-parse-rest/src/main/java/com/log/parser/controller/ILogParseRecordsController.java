package com.log.parser.controller;

import com.log.parser.ws.response.LogParseRecordsResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

public interface ILogParseRecordsController {

    /**
     * Get all the information of the log after this is save in the database
     * */
    @ApiOperation(value = "Get all the Log parse records", response = LogParseRecordsResponse.class , httpMethod = "GET")
    ResponseEntity<LogParseRecordsResponse> getAllLogParseRecords();
}
