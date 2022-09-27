package br.com.mercadoteixeira.inventorycontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadoteixeira.inventorycontrol.dto.ProductsDto;
import br.com.mercadoteixeira.inventorycontrol.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    private ProductsService service;

    @GetMapping
    public Page<ProductsDto> list(@PageableDefault(size = 10) Pageable pagination) {
        return service.getAll(pagination);
    }
}
