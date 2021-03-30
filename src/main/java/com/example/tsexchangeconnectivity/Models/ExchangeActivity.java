package com.example.tsexchangeconnectivity.Models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExchangeActivity {
    public long id;
    public String exchange;
    public String side;
    public int quantity;
    public double price;
    public String orderKey;
}
