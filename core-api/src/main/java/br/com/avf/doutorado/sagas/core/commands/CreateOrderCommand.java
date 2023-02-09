package br.com.avf.doutorado.sagas.core.commands;

import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@NoArgsConstructor
public class CreateOrderCommand {
    @TargetAggregateIdentifier
    public String orderId;

    public String itemType;

    public BigDecimal price;

    public String currency;

    public String orderStatus;

    public CreateOrderCommand(String orderId, String itemType, BigDecimal price, String currency, String orderStatus) {
        this.orderId = orderId;
        this.itemType = itemType;
        this.price = price;
        this.currency = currency;
        this.orderStatus = orderStatus;
    }
}
