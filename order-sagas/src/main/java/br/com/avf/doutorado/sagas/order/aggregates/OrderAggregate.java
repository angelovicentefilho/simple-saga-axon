package br.com.avf.doutorado.sagas.order.aggregates;

import br.com.avf.doutorado.sagas.core.commands.CreateOrderCommand;
import br.com.avf.doutorado.sagas.core.commands.UpdateOrderStatusCommand;
import br.com.avf.doutorado.sagas.core.events.OrderCreatedEvent;
import br.com.avf.doutorado.sagas.core.events.OrderUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;

    private ItemType itemType;

    private BigDecimal price;

    private String currency;

    private OrderStatus orderStatus;

    public OrderAggregate() {
    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand) {
        apply(new OrderCreatedEvent(createOrderCommand.orderId, createOrderCommand.itemType,
                createOrderCommand.price, createOrderCommand.currency, createOrderCommand.orderStatus));
    }

    @EventSourcingHandler
    protected void on(OrderCreatedEvent orderCreatedEvent) {
        this.orderId = orderCreatedEvent.orderId;
        this.itemType = ItemType.valueOf(orderCreatedEvent.itemType);
        this.price = orderCreatedEvent.price;
        this.currency = orderCreatedEvent.currency;
        this.orderStatus = OrderStatus.valueOf(orderCreatedEvent.orderStatus);
    }

    @CommandHandler
    protected void on(UpdateOrderStatusCommand updateOrderStatusCommand) {
        apply(new OrderUpdatedEvent(updateOrderStatusCommand.orderId, updateOrderStatusCommand.orderStatus));
    }

    @EventSourcingHandler
    protected void on(OrderUpdatedEvent orderUpdatedEvent) {
        this.orderId = orderId;
        this.orderStatus = OrderStatus.valueOf(orderUpdatedEvent.orderStatus);
    }
}
