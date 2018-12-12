package com.log.parser.core.services;

import com.log.parser.common.dto.resultdto.LogParseResultDTO;

import java.util.List;

public interface ILogParseService {

    List<LogParseResultDTO> getAllLogParseRecords();
}
