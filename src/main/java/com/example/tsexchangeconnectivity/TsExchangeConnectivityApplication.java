package com.example.tsexchangeconnectivity;

import com.example.tsexchangeconnectivity.Service.Queue.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TsExchangeConnectivityApplication implements ApplicationRunner {

	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(TsExchangeConnectivityApplication.class, args);


	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		while (true) {
			//System.out.println("Kid Cudi");
			orderService.getAndExecuteTrade();
		}

	}
}
