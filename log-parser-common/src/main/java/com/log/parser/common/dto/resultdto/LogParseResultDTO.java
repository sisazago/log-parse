package com.log.parser.common.dto.resultdto;

public class LogParseResultDTO {

    /**
     * Log parse record unique identifier.
     * */
    private int id;

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
}
