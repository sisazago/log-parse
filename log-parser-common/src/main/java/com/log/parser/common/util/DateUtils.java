package com.log.parser.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    private static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date getDate(String value){
        logger.debug("[Start][DateUtils][getDate]Input:[value{}]", value);

        Date date = null;

        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            date = dateFormat.parse(value);
        }catch (Exception e){
            logger.error("[Error][DateUtils][getDate] Error transforming the string value to a date.", e);
        }
        return date;
    }
}
