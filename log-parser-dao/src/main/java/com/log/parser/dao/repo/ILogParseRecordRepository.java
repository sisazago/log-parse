package com.log.parser.dao.repo;

import com.log.parser.common.dto.resultdto.LogsResultDTO;
import com.log.parser.common.entity.LogParseRecordEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
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
    @Query(value = "select LogParseRecordEntity .ipAddress, count(*) from LogParseRecordEntity where LogParseRecordEntity.recodDate BETWEEN ?1 and DATE_ADD(?2, INTERVAL 1 HOUR) GROUP BY LogParseRecordEntity.ipAddress HAVING count(*) > ?3",
            nativeQuery = true)
    List<LogsResultDTO> getAllIpAddressInPeriodOfAnHourByDate(Date startDate, Date endDate, int treadHolder);

    /**
     * Get the IP address in the period of an day that have more than tread holder.
     * @param startDate - indicate the time that we want to search
     * @param endDate - indicate the end date that we want to search (in this case is the same as the start date +1 day)
     * @param treadHolder - indicate the minimum number of occurrences that we want to search
     * */
    @Query(value = "select LogParseRecordEntity .ipAddress, count(*) from LogParseRecordEntity where LogParseRecordEntity.recodDate BETWEEN ?1 and DATE_ADD(?2, INTERVAL 1 DAY) GROUP BY LogParseRecordEntity.ipAddress HAVING count(*) > ?3",
            nativeQuery = true)
    List<LogsResultDTO> getAllIpAddressInPeriodOfAnDayByDate(Date startDate, Date endDate, int treadHolder);
}
