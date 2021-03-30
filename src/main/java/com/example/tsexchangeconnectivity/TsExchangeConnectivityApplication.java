package com.example.tsexchangeconnectivity;

import com.example.tsexchangeconnectivity.services.ProcessTradeQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TsExchangeConnectivityApplication implements ApplicationRunner {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	ProcessTradeQueueService processTradeQueueService;

	public static void main(String[] args) {
		SpringApplication.run(TsExchangeConnectivityApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("^^Processing TradeOrder Service subscription");
//			processTradeQueueService.tradeOrderQueue();
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

	}
}
