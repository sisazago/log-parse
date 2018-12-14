package com.log.parser.common.dto.resultdto;

import com.log.parser.common.entity.LogParseRecordEntity;

import java.util.Date;

public class LogParseResultDTO {

    /**
     * Log parse record unique identifier.
     * */
    private int id;

    /**
     * This date is the date went the log is write
     * */
    private Date date;

    /**
     * This value is the ip address that makes the call
     * */
    private String ipAddress;

    /**
     * This value is the request that is logged
     * */
    private String request;

    /**
     * This value is the status of the call
     * */
    private String status;

    /**
     * This value contains additional information of the call
     * */
    private String userAgent;

    public LogParseResultDTO(){
        super();
    }

    public LogParseResultDTO(LogParseRecordEntity logParseRecordEntity){
        this.date = logParseRecordEntity.getRecordDate();
        this.id = logParseRecordEntity.getId();
        this.ipAddress = logParseRecordEntity.getIpAddress();
        this.request = logParseRecordEntity.getRequest();
        this.status = logParseRecordEntity.getStatus();
        this.userAgent = logParseRecordEntity.getUserAgent();
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
