package com.example.tsexchangeconnectivity.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Order {
    //to be deserialized from redis queue
        public Long id;
        public String product;
        public String side;
        public Double price;
        public int quantity;
        //public String exchange;
        public Long clientId;
        public Boolean isValid;
        public String strategy;
}
