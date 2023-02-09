package br.com.avf.doutorado.sagas.order.services;

import br.com.avf.doutorado.sagas.order.protocols.OrderRequest;

import java.util.concurrent.CompletableFuture;

public interface OrderService {
    CompletableFuture<String> createOrder(OrderRequest request);
}
