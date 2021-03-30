package com.example.tsexchangeconnectivity.controller;

import com.example.tsexchangeconnectivity.model.ExchangeOrder;
import com.example.tsexchangeconnectivity.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;
    private static int requestNumber = 0;

    @PostMapping("/trade-exchange")
    public ResponseEntity<Object> tradeExchange(@RequestBody ExchangeOrder exchangeOrder) {

        requestNumber++;;
        exchangeService.exchangeOrder(exchangeOrder);
        System.out.println("Exchange order-> "+requestNumber+" --" + exchangeOrder);
        return ResponseEntity.ok().build();
    }
}
