package com.log.parser.ws.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.log.parser.common.dto.resultdto.LogParseResultDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class LogParseRecordResponse {

    /**
     * Log parse record unique identifier.
     * */
    @ApiModelProperty(name = "id", value = "This value is the record unique identifier", required = true)
    private int id;

    /**
     * This date is the date went the log is write
     * */
    @ApiModelProperty(name = "id", value = "This value is the date of the call", required = true)
    private Date date;

    /**
     * This value is the ip address that makes the call
     * */
    @ApiModelProperty(name = "id", value = "This value is the ip address that made the call", required = true)
    private String ipAddress;

    /**
     * This value is the request that is logged
     * */
    @ApiModelProperty(name = "id", value = "This value is the type of request done", required = true)
    private String request;

    /**
     * This value is the status of the call
     * */
    @ApiModelProperty(name = "status", value = "This value is the status of the call", required = true)
    private String status;

    /**
     * This value contains additional information of the call
     * */
    @ApiModelProperty(name = "id", value = "This value contains additional information of the call", required = true)
    private String userAgent;

    public LogParseRecordResponse(){
        super();
    }

    public LogParseRecordResponse(LogParseResultDTO logParseResultDTO){
        this.id = logParseResultDTO.getId();
        this.date = logParseResultDTO.getDate();
        this.ipAddress = logParseResultDTO.getIpAddress();
        this.request = logParseResultDTO.getRequest();
        this.status = logParseResultDTO.getStatus();
        this.userAgent = logParseResultDTO.getUserAgent();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
