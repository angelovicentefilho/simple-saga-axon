package br.com.avf.doutorado.sagas.order.services;

import br.com.avf.doutorado.sagas.core.commands.CreateOrderCommand;
import br.com.avf.doutorado.sagas.order.aggregates.OrderStatus;
import br.com.avf.doutorado.sagas.order.protocols.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CommandGateway commandGateway;


    @Override
    public CompletableFuture<String> createOrder(OrderRequest request) {
        return commandGateway.send(new CreateOrderCommand(UUID.randomUUID().toString(), request.getItemType(),
                request.getPrice(), request.getCurrency(), String.valueOf(OrderStatus.CREATED)));
    }
}
