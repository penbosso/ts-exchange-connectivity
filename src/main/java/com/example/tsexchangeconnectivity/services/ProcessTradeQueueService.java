package com.example.tsexchangeconnectivity.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

@Service
public class ProcessTradeQueueService {
    @Value("${spring.redis.host}")
    private String HOST;
    @Value("${spring.redis.port}")
    private Integer PORT;
    @Value("${spring.redis.password}")
    private String PASSWORD;

    public void tradeOrderQueue() {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), HOST, PORT, 10000, PASSWORD);
        while (true) {
            List<String> orderQueue = jedisPool.getResource().blpop(10000, "exchange-trade");

            if (orderQueue == null) continue;

            System.out.println("Received -> " + orderQueue);

            //exchange trade

            exchangeTrade(orderQueue.get(1));
        }
    }

    private void exchangeTrade(String tradeOrder) {

        System.out.println("Trading -> " + tradeOrder);
    }
}
