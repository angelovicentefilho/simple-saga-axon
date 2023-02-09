package br.com.avf.doutorado.sagas.core.events;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class OrderCreatedEvent {

    public String orderId;

    public String itemType;

    public BigDecimal price;

    public String currency;

    public String orderStatus;

    public OrderCreatedEvent(String orderId, String itemType, BigDecimal price, String currency, String orderStatus) {
        this.orderId = orderId;
        this.itemType = itemType;
        this.price = price;
        this.currency = currency;
        this.orderStatus = orderStatus;
    }
}
