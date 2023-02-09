package br.com.avf.doutorado.sagas.core.commands;

import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@NoArgsConstructor
public class UpdateOrderStatusCommand {
    @TargetAggregateIdentifier
    public String orderId;

    public String orderStatus;

    public UpdateOrderStatusCommand(String orderId, String orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }
}
