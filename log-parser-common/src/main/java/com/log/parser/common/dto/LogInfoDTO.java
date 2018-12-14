package com.log.parser.common.dto;

import com.log.parser.common.enums.DurationEnum;

import java.util.Date;

public class LogInfoDTO {

    /**
     * This value indicate the date that we want to search
     * */
    private Date startDate;

    /**
     * This value indicate the duration of the search and it can be +1 hour or +1 day
     * */
    private DurationEnum durationEnum;

    /**
     * This value indicate the number of occurrences that we want to search.
     * */
    private long treadHolder;

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

    public long getTreadHolder() {
        return treadHolder;
    }

    public void setTreadHolder(long treadHolder) {
        this.treadHolder = treadHolder;
    }
}
