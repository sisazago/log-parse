package com.log.parser.dao.repo;

import com.log.parser.common.entity.LogParseRecordEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogParseRecordRepository extends CrudRepository<LogParseRecordEntity, Integer> {
}
