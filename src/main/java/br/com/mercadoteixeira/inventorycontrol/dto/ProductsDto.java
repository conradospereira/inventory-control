package br.com.mercadoteixeira.inventorycontrol.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDto {
    private Long id;
    private BigDecimal price;
    private String description;
    private String amount;
}
