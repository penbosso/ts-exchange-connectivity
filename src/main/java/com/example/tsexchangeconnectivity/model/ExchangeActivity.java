package com.example.tsexchangeconnectivity.model;


public class ExchangeActivity {
    private long id;
    private String exchange;
    private String side;
    private int quantity;
    private double price;
    private String orderKey;
    private String product;

    public ExchangeActivity(String exchange, String side, int quantity, double price, String orderKey, String product) {
        this.exchange = exchange;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.orderKey = orderKey;
        this.product = product;
    }

    public ExchangeActivity(){

    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    @Override
    public String toString() {
        return "ExchangeActivity{" +
                "id=" + id +
                ", exchange='" + exchange + '\'' +
                ", side='" + side + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderKey='" + orderKey + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
