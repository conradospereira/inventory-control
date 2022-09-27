package br.com.mercadoteixeira.inventorycontrol.service;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mercadoteixeira.inventorycontrol.dto.ProductsDto;
import br.com.mercadoteixeira.inventorycontrol.model.Products;
import br.com.mercadoteixeira.inventorycontrol.repository.ProductsRepository;

@Service
public class ProductsService {
    
    @Autowired
    private ProductsRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<ProductsDto> getAll(Pageable pagination) {
        return repository
                .findAll(pagination)
                .map(p -> modelMapper.map(p, ProductsDto.class));
    }

    public ProductsDto getById(Long id) {
        Products products = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(products, ProductsDto.class);
    }

    public ProductsDto registerProduct(ProductsDto dto) {
        Products products = modelMapper.map(dto, Products.class);
        repository.save(products);

        return modelMapper.map(products, ProductsDto.class);
    }
}
