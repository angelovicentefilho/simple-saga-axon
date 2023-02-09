package br.com.avf.doutorado.sagas.core.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

public class CreateInvoiceCommand implements Serializable {
    @TargetAggregateIdentifier
    public String paymentId;

    public String orderId;

    public CreateInvoiceCommand() {
    }

    public CreateInvoiceCommand(String paymentId, String orderId) {
        this.paymentId = paymentId;
        this.orderId = orderId;
    }
}
