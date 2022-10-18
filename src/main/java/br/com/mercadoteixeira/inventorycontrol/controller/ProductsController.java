package br.com.mercadoteixeira.inventorycontrol.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mercadoteixeira.inventorycontrol.dto.ProductsDto;
import br.com.mercadoteixeira.inventorycontrol.model.Products;
import br.com.mercadoteixeira.inventorycontrol.service.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    
    @Autowired
    private ProductsService service;

    @GetMapping
    public List<Products> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsDto> detail(@PathVariable @NotNull Long id) {
        ProductsDto dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProductsDto> register(@RequestBody @Valid ProductsDto dto, UriComponentsBuilder uriBuilder) {
        ProductsDto products = service.registerProduct(dto);
        URI addres = uriBuilder.path("/{id}").buildAndExpand(products.getId()).toUri();

        return ResponseEntity.created(addres).body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsDto> update(@PathVariable @NotNull Long id, @RequestBody @Valid ProductsDto dto) {
        ProductsDto updated = service.updateProducts(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductsDto> remove(@PathVariable @NotNull Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
