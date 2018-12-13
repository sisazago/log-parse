package com.log.parser.common.dto.resultdto;

public class LogsResultDTO {

    /**
     * This value indicate the IP address that have more or equals the numbers of calls.
     * */
    private String ipAddress;

    /**
     * This value is the number of calls
     * */
    private int callsNumber;

    public LogsResultDTO(){
        super();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getCallsNumber() {
        return callsNumber;
    }

    public void setCallsNumber(int callsNumber) {
        this.callsNumber = callsNumber;
    }
}
