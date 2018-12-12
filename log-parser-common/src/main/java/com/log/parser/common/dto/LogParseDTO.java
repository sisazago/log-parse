package com.log.parser.common.dto;

import com.log.parser.common.entity.LogParseRecordEntity;

import java.util.Date;

public class LogParseDTO {

    /**
     * This date is the date went the log is write
     * */
    private String date;

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

    public LogParseDTO(){
        super();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public LogParseRecordEntity getLogParseRecordEntity(){
        LogParseRecordEntity logParseRecordEntity = new LogParseRecordEntity();

        logParseRecordEntity.setIpAddress(this.ipAddress);
        logParseRecordEntity.setStatus(this.status);
        logParseRecordEntity.setUserAgent(this.userAgent);

        return logParseRecordEntity;
    }
}
