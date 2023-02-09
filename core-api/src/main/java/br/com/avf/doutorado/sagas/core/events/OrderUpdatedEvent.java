package br.com.avf.doutorado.sagas.core.events;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderUpdatedEvent {
    public  String orderId;

    public  String orderStatus;

    public OrderUpdatedEvent(String orderId, String orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }
}
