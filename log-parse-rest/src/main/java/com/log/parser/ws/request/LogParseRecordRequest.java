package com.log.parser.ws.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.log.parser.common.dto.LogInfoDTO;
import com.log.parser.common.enums.DurationEnum;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class LogParseRecordRequest {

    /**
     * Start date for the search
     * */
    @ApiModelProperty(name = "startDate", value = "This value is the start date for the search of the records", required = true)
    private Date startDate;

    /**
     * This value indicate the period of the date, so this can be in hours or dates.
     * */
    @ApiModelProperty(name = "durationEnum", value = "Indicate if the period to be search is in days or in hours", allowableValues = "[HOURLY, DAILY]", required = true)
    private DurationEnum durationEnum;

    /**
     * This value indicate the number of coincidences to search
     * */
    @ApiModelProperty(name = "threadHold", value = "Number of coincidences to search", required = true)
    private int threadHold;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public DurationEnum getDurationEnum() {
        return durationEnum;
    }

    public void setDurationEnum(DurationEnum durationEnum) {
        this.durationEnum = durationEnum;
    }

    public int getThreadHold() {
        return threadHold;
    }

    public void setThreadHold(int threadHold) {
        this.threadHold = threadHold;
    }

    public LogInfoDTO getLogInforDto (){
        LogInfoDTO logInfoDTO = new LogInfoDTO();

        logInfoDTO.setDurationEnum(this.durationEnum);
        logInfoDTO.setStartDate(this.startDate);
        logInfoDTO.setTreadHolder(this.threadHold);

        return logInfoDTO;
    }
}
