package com.example.tsexchangeconnectivity.Service.Queue;

import com.example.tsexchangeconnectivity.Models.ExchangeActivity;
import com.example.tsexchangeconnectivity.Models.ExchangeOrder;
import com.example.tsexchangeconnectivity.Models.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Value("${groupTwo.trade.privateKey}")
    String privateKey;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private final RestTemplate restTemplate=new RestTemplate();

    public void getAndExecuteTrade(){
        String data="n";
        while(true){
             data= stringRedisTemplate.opsForList().leftPop("exchange-trade");
            try {

                if(data == null) continue;

                System.out.println(data);
                ObjectMapper mapper=new JsonMapper();

                ExchangeOrder exchangeOrder = mapper.readValue(data, ExchangeOrder.class);
                HttpEntity<ActualOrder> request = new HttpEntity<>(
                        new ActualOrder(
                                exchangeOrder.order.product,
                                exchangeOrder.order.quantity,
                                exchangeOrder.order.side,
                                exchangeOrder.order.price
                        ));
                String orderKey="";
                String url= String.format("%s/%s/order",exchangeOrder.exchange,privateKey);
                System.out.println(url);
//                ResponseEntity<String> response = restTemplate
//                       .exchange(exchangeOrder.exchange + privateKey , HttpMethod.POST, request,String.class);
//                if(response.getStatusCodeValue() == 200){
//                    orderKey=response.getBody();
//                    orderKey=orderKey.substring(1,orderKey.length()-1);
//                }


//                HttpEntity<ExchangeActivity> requestLog = new HttpEntity<>(
//                        new ExchangeActivity(exchangeOrder.order.id,
//                                exchangeOrder.order.side,
//                                exchangeOrder.order.side,
//                                exchangeOrder.order.quantity,
//                                exchangeOrder.order.price,
//                                orderKey
//                        ));
//                ResponseEntity<String> responseLog = restTemplate
//                        .exchange("http://localhost:3005/exchange-activity-report", HttpMethod.POST, request, String.class);
//                response.getStatusCodeValue();
            }catch (JsonProcessingException e){
                System.out.println("exception" + e.getMessage());

            }

        }
    }


}

@AllArgsConstructor @Getter @Setter
class ActualOrder{
    private String product;
    private int quantity;
    private String side;
    private Double price;
}