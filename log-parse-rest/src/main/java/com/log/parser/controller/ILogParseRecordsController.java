package com.log.parser.controller;

import com.log.parser.ws.request.LogParseRecordRequest;
import com.log.parser.ws.response.LogInformationResponse;
import com.log.parser.ws.response.LogParseRecordsResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ILogParseRecordsController {

    /**
     * Get all the information of the log after this is save in the database
     * */
    @ApiOperation(value = "Get all the Log parse records", response = LogParseRecordsResponse.class , httpMethod = "GET")
    ResponseEntity<LogParseRecordsResponse> getAllLogParseRecords();

    /**
     * Get the IP address that have more occurrences than the value provided on the tread holder.
     * */
    @ApiOperation(value = "Get all the IP address that have more occurrences than the value provided", response = LogInformationResponse.class, httpMethod = "GET")
    ResponseEntity<List<LogInformationResponse>> getIpAddressesBaseOnInformation(
            @ApiParam(value = "This object contains the information needed to be search") LogParseRecordRequest logParseRecordRequest);
}
