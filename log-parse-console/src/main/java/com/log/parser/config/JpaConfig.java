package com.log.parser.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.log.parser.common.entity"})
@EnableJpaRepositories(basePackages = {"com.log.parser.dao.repo"})
public class JpaConfig {
}
