package com.log.parser.common.dto.resultdto;

public class LogsResultDTO {

    /**
     * This value indicate the IP address that have more or equals the numbers of calls.
     * */
    private String ipAddress;

    /**
     * This value is the number of calls
     * */
    private long callsNumber;

    public LogsResultDTO(){
        super();
    }

    public LogsResultDTO(String ipAddress, long callsNumber){
        this.ipAddress = ipAddress;
        this.callsNumber = callsNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public long getCallsNumber() {
        return callsNumber;
    }

    public void setCallsNumber(long callsNumber) {
        this.callsNumber = callsNumber;
    }
}
