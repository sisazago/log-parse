package com.log.parser.ws.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.log.parser.common.dto.resultdto.LogParseResultDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class LogParseRecordsResponse {

    /**
     * This is the list of all the records.
     * */
    @ApiModelProperty(name = "logParseRecordResponses" , value = "List of all the records of the log saved on the database", required = true)
    private List<LogParseRecordResponse> logParseRecordResponses;

    public LogParseRecordsResponse(){
        super();
    }

    public LogParseRecordsResponse(List<LogParseResultDTO> logParseResultDTOS){
        List<LogParseRecordResponse> logParseRecordResponses = new ArrayList<>();

        logParseResultDTOS.forEach(logParseResultDTO -> {
            logParseRecordResponses.add(new LogParseRecordResponse(logParseResultDTO));
        });

        this.logParseRecordResponses = logParseRecordResponses;
    }

    public List<LogParseRecordResponse> getLogParseRecordResponses() {
        return logParseRecordResponses;
    }

    public void setLogParseRecordResponses(List<LogParseRecordResponse> logParseRecordResponses) {
        this.logParseRecordResponses = logParseRecordResponses;
    }
}
