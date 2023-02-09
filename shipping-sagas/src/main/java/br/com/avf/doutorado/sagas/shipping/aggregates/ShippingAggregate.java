package br.com.avf.doutorado.sagas.shipping.aggregates;

import br.com.avf.doutorado.sagas.core.commands.CreateShippingCommand;
import br.com.avf.doutorado.sagas.core.events.OrderShippedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class ShippingAggregate {

    @AggregateIdentifier
    private String shippingId;

    private String orderId;

    private String paymentId;

    @CommandHandler
    public ShippingAggregate(CreateShippingCommand command) {
        apply(new OrderShippedEvent(command.shippingId, command.orderId, command.paymentId));
    }

    @EventSourcingHandler
    protected void on(OrderShippedEvent event) {
        this.shippingId = event.shippingId;
        this.orderId = event.orderId;
    }
}
