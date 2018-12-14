package com.log.parser.ws.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.log.parser.common.dto.resultdto.LogsResultDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class LogInformationResponse {

    /**
     * This value is the Ip address that made more calls than the specified on the tread holder
     * */
    @ApiModelProperty(name = "ipAddress", value = "This value indicate the ip that made more call than the specified on the tread Holder", required = true)
    private String ipAddress;

    /**
     * This value indicate the number of call made by that IP address.
     * */
    @ApiModelProperty(name = "treadHolder", value = "This value indicate the number of call made by that IP address", required = true)
    private long treadHolder;

    public LogInformationResponse(){
        super();
    }

    public LogInformationResponse(LogsResultDTO logsResultDTO){
        this.ipAddress = logsResultDTO.getIpAddress();
        this.treadHolder = logsResultDTO.getCallsNumber();
    }

    public LogInformationResponse(String ipAddress, long callsNumber){
        this.treadHolder = callsNumber;
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public long getTreadHolder() {
        return treadHolder;
    }

    public void setTreadHolder(long treadHolder) {
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
