package com.log.parser.core.batch.abstracts;

import com.log.parser.dao.repo.ILogParseRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractLogParseProcessor {

    @Autowired
    protected ILogParseRecordRepository logParseRecordRepository;
}
