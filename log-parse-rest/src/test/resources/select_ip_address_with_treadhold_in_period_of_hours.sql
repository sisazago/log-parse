select `log_parse_records`.`ip_address`, count(*) from `log_parse_records` where `log_parse_records`.`record_date` BETWEEN '2017-01-01.00:00:00' and DATE_ADD('2017-01-01.00:00:00', INTERVAL 1 HOUR) GROUP BY `log_parse_records`.`ip_address` HAVING count(*) > 200;