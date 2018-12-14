DROP TABLE IF EXISTS `log_parse_records`;

CREATE TABLE `log_parse_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `record_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ip_address` varchar(16) DEFAULT NULL,
  `request` varchar(50) DEFAULT NULL,
  `service_status` varchar(10) DEFAULT NULL,
  `user_agent` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8;