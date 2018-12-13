package com.log.parser.core.services;

import com.log.parser.common.dto.LogInfoDTO;
import com.log.parser.common.dto.resultdto.LogParseResultDTO;
import com.log.parser.common.dto.resultdto.LogsResultDTO;

import java.util.List;

public interface ILogParseService {

    /**
     * Return all the information of log parse records.
     * */
    List<LogParseResultDTO> getAllLogParseRecords();


    /**
     * Get the information from the log base on the information provided.
     * @param logInfoDTO - this object contains all the information to be search.
     * */
    List<LogsResultDTO> getIpAddressFromLog(LogInfoDTO logInfoDTO);
}
