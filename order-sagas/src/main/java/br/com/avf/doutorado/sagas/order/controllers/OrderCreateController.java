package br.com.avf.doutorado.sagas.order.controllers;

import br.com.avf.doutorado.sagas.order.protocols.OrderRequest;
import br.com.avf.doutorado.sagas.order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/orders")
@RequiredArgsConstructor
public class OrderCreateController {
    private final OrderService service;

    @PostMapping
    public CompletableFuture<String> createOrder(@RequestBody OrderRequest request) {
        return service.createOrder(request);
    }
}
