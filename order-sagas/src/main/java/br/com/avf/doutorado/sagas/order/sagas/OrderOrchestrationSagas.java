package br.com.avf.doutorado.sagas.order.sagas;

import br.com.avf.doutorado.sagas.core.commands.CreateInvoiceCommand;
import br.com.avf.doutorado.sagas.core.commands.CreateShippingCommand;
import br.com.avf.doutorado.sagas.core.commands.UpdateOrderStatusCommand;
import br.com.avf.doutorado.sagas.core.events.InvoiceCreatedEvent;
import br.com.avf.doutorado.sagas.core.events.OrderCreatedEvent;
import br.com.avf.doutorado.sagas.core.events.OrderShippedEvent;
import br.com.avf.doutorado.sagas.core.events.OrderUpdatedEvent;
import br.com.avf.doutorado.sagas.order.aggregates.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.axonframework.modelling.saga.SagaLifecycle.associateWith;
import static org.axonframework.modelling.saga.SagaLifecycle.end;

@Saga
@RequiredArgsConstructor
public class OrderOrchestrationSagas {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent orderCreatedEvent) {
        String paymentId = UUID.randomUUID().toString();
        System.out.println("Saga invoked");

        //associate Saga
        associateWith("paymentId", paymentId);

        System.out.println("order id" + orderCreatedEvent.orderId);

        //send the commands
        commandGateway.send(new CreateInvoiceCommand(paymentId, orderCreatedEvent.orderId));
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(InvoiceCreatedEvent invoiceCreatedEvent) {
        String shippingId = UUID.randomUUID().toString();

        System.out.println("Saga continued");

        //associate Saga with shipping
        associateWith("shipping", shippingId);

        //send the create shipping command
        commandGateway.send(new CreateShippingCommand(shippingId, invoiceCreatedEvent.orderId, invoiceCreatedEvent.paymentId));
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderShippedEvent orderShippedEvent) {
        commandGateway.send(new UpdateOrderStatusCommand(orderShippedEvent.orderId, String.valueOf(OrderStatus.SHIPPED)));
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderUpdatedEvent orderUpdatedEvent) {
        end();
    }
}
