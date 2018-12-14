package com.log.parser;

import com.log.parser.common.dto.LogInfoDTO;
import com.log.parser.common.dto.resultdto.LogsResultDTO;
import com.log.parser.common.enums.DurationEnum;
import com.log.parser.common.util.DateUtils;
import com.log.parser.core.services.ILogParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LogParseConsoleApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(LogParseConsoleApplication.class);

	@Autowired
	private ILogParseService logParseService;

	public static void main(String[] args) {
		SpringApplication.run(LogParseConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("[Start][LogParseConsoleApplication][run]");

		Scanner scanner = new Scanner(System.in);

		String date = scanner.nextLine();
		String duration = scanner.nextLine();
		long treadHolder = scanner.nextLong();

		Date startDate = DateUtils.getDateUploadFormat(date);

		if (duration.equals(DurationEnum.DAILY.toString()) || duration.equals(DurationEnum.HOURLY.toString())){

			LogInfoDTO logInfoDTO = new LogInfoDTO(startDate, DurationEnum.valueOf(duration), treadHolder);

			List<LogsResultDTO> resultList = logParseService.getIpAddressFromLog(logInfoDTO);

			resultList.forEach(result -> {
				logger.info("Ip address: {} ,number of calls: {}", result.getIpAddress(), result.getCallsNumber());
			});
		}else{
			logger.info("The duration values need to be {} or {}", DurationEnum.DAILY.toString(), DurationEnum.HOURLY.toString());
		}

		logger.info("[End][LogParseConsoleApplication][run]");
	}

}

