package br.com.avf.doutorado.sagas.payment.aggregates;

import br.com.avf.doutorado.sagas.core.commands.CreateInvoiceCommand;
import br.com.avf.doutorado.sagas.core.events.InvoiceCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class InvoiceAggregate {

    @AggregateIdentifier
    private String paymentId;

    private String orderId;

    private InvoiceStatus status;

    @CommandHandler
    public InvoiceAggregate(CreateInvoiceCommand command) {
        apply(new InvoiceCreatedEvent(command.paymentId, command.orderId));
    }

    @EventSourcingHandler
    protected void on(InvoiceCreatedEvent event) {
        this.paymentId = event.paymentId;
        this.orderId = event.orderId;
        this.status = InvoiceStatus.PAID;
    }

}
