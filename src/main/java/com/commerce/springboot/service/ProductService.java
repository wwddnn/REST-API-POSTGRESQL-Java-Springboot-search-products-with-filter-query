package com.commerce.springboot.service;

import com.commerce.springboot.DTO.ProductDTO;
import com.commerce.springboot.entities.Product;
import com.commerce.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> searchByName (String name, Pageable pageable) {
        Page<Product> list = repository.searchByName(name, pageable);
        return list.map(obj -> new ProductDTO(obj));
    }

}
