package com.example.tsexchangeconnectivity.services;

import com.example.tsexchangeconnectivity.model.ExchangeActivity;
import com.example.tsexchangeconnectivity.model.ExchangeOrder;
import com.example.tsexchangeconnectivity.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeService {
    @Autowired
    RestTemplate restTemplate;

    public void exchangeOrder(ExchangeOrder exchangeOrder) {
        String exchangeUrl = exchangeOrder.getExchange() + "/e9d1863b-7d56-4c51-9e20-926ac77c6d73/order";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Order> request = new HttpEntity<>(exchangeOrder.getOrder(), headers);

        ResponseEntity<String> result = restTemplate.postForEntity(exchangeUrl, request, String.class);
        System.out.println("#Note "+exchangeOrder.getOrder().getQuantity()+ " X "+ exchangeOrder.getOrder().getPrice()+
                " "+ " Exchange on: -> "+ exchangeUrl+" at "+exchangeOrder.getOrder().getPrice());
        System.out.println("$ Response: -> "+ result.getStatusCode());
        System.out.println("$ Exchange orderId.: -> "+ result.getBody());

        ExchangeActivity exchangeActivity = new ExchangeActivity(exchangeOrder.getExchange(),
                exchangeOrder.getOrder().getSide(),
                exchangeOrder.getOrder().getQuantity(),
                exchangeOrder.getOrder().getPrice(),
                result.getBody(), exchangeOrder.getOrder().getProduct());

        HttpEntity<ExchangeActivity> report = new HttpEntity<>(exchangeActivity, headers);
//       Reporting
        restTemplate.postForEntity("http://localhost:8086/exchange-activity-report", report, Void.class);
    }
}
