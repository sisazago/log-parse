package com.log.parser.core.services;

import com.log.parser.common.dto.resultdto.LogParseResultDTO;

import java.util.List;

public interface ILogParseService {

    /**
     * Return all the information of log parse records.
     * */
    List<LogParseResultDTO> getAllLogParseRecords();
}
