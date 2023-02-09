package br.com.avf.doutorado.sagas.core.events;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderShippedEvent {
    public String shippingId;

    public String orderId;

    public String paymentId;

    public OrderShippedEvent(String shippingId, String orderId, String paymentId) {
        this.shippingId = shippingId;
        this.orderId = orderId;
        this.paymentId = paymentId;
    }
}
