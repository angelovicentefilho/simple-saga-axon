package br.com.avf.doutorado.sagas.core.commands;

import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@NoArgsConstructor
public class CreateShippingCommand {
    @TargetAggregateIdentifier
    public String shippingId;

    public String orderId;

    public String paymentId;

    public CreateShippingCommand(String shippingId, String orderId, String paymentId) {
        this.shippingId = shippingId;
        this.orderId = orderId;
        this.paymentId = paymentId;
    }
}
