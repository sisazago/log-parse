package com.log.parser.dao.repo;

import com.log.parser.common.entity.LogParseRecordEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ILogParseRecordRepository extends CrudRepository<LogParseRecordEntity, Integer> {

    /**
     * Get the IP address in the period of an hour that have more than tread holder.
     * @param startDate - indicate the time that we want to search
     * @param endDate - indicate the end date that we want to search (in this case is the same as the start date +1 hour)
     * @param treadHolder - indicate the minimum number of occurrences that we want to search
     * */
    @Query(value = "select log_parse.ipAddress AS ipAddress, count(*) AS callsNumber from LogParseRecordEntity as log_parse where log_parse.recordDate BETWEEN :startDate and :endDate GROUP BY log_parse.ipAddress HAVING count(*) > :treadHolder")
    List<LogsResultDTO> findIpAddressByRecordDateBetweenAndTreadHolder(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("treadHolder") long treadHolder);

    /**
     * This interface is used to transform the result of the query to an object.
     * */
    public interface LogsResultDTO{
        public String getIpAddress();
        public Long getCallsNumber();
    }

}
