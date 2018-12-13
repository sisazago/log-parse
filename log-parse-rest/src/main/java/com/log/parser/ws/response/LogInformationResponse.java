package com.log.parser.ws.response;

import com.log.parser.common.dto.resultdto.LogsResultDTO;

import java.util.ArrayList;
import java.util.List;

public class LogInformationResponse {

    private String ipAddress;

    private int treadHolder;

    public LogInformationResponse(){
        super();
    }

    public LogInformationResponse(LogsResultDTO logsResultDTO){
        this.ipAddress = logsResultDTO.getIpAddress();
        this.treadHolder = logsResultDTO.getCallsNumber();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getTreadHolder() {
        return treadHolder;
    }

    public void setTreadHolder(int treadHolder) {
        this.treadHolder = treadHolder;
    }

    public List<LogInformationResponse> getLogInformationResponseList(List<LogsResultDTO> logsResultDTOS){
        List<LogInformationResponse> logInformationResponseList = new ArrayList<>();

        logsResultDTOS.forEach(logsResultDTO -> {
            logInformationResponseList.add(new LogInformationResponse(logsResultDTO));
        });
        return logInformationResponseList;
    }
}
