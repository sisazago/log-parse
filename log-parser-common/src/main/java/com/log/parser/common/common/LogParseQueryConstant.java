package com.log.parser.common.common;

public class LogParseQueryConstant {

    public static final String GET_IP_ADDRESS_BY_DATE_AND_TREAD_HOLDER = "select log_record.ipAddress AS ipAddress, count(*) AS occurrences from LogParseRecordEntity AS log_record where log_record.recordDate BETWEEN :startDate and :endDate GROUP BY log_record.ipAddress HAVING count(*) > :treadHolder";

    public static final String START_DATE_PARAMETER = "startDate";

    public static final String END_DATE_PARAMETER = "endDate";

    public static final String TREAD_HOLDER_PARAMETER = "treadHolder";
}
