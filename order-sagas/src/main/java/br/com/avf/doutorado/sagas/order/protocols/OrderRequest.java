package br.com.avf.doutorado.sagas.order.protocols;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {
    private String itemType;
    private BigDecimal price;
    private String currency;
}
