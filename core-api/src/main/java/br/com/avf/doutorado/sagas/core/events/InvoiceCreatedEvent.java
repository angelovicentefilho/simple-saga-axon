package br.com.avf.doutorado.sagas.core.events;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvoiceCreatedEvent {
    public String paymentId;

    public String orderId;

    public InvoiceCreatedEvent(String paymentId, String orderId) {
        this.paymentId = paymentId;
        this.orderId = orderId;
    }
}
