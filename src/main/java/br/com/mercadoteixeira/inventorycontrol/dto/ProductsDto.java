package br.com.mercadoteixeira.inventorycontrol.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDto {
    private Long id;
    private String description;
    private BigDecimal code;
    private BigDecimal price;
    private String amount;
}
