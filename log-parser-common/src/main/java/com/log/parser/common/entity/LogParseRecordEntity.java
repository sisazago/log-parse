package com.log.parser.common.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log_parse_records")
public class LogParseRecordEntity {

    /**
     * This value is the unique identifier for the record
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * This date is the date went the log is write
     * */
    @Column(name = "record_date")
    private Date recodDate;

    /**
     * This value is the ip address that makes the call
     * */
    @Column(name = "ip_address")
    private String ipAddress;

    /**
     * This value is the request that is logged
     * */
    @Column(name = "request")
    private String request;

    /**
     * This value is the status of the call
     * */
    @Column(name = "service_status")
    private String status;

    /**
     * This value contains additional information of the call
     * */
    @Column(name = "user_agent")
    private String userAgent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRecodDate() {
        return recodDate;
    }

    public void setRecodDate(Date recodDate) {
        this.recodDate = recodDate;
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
