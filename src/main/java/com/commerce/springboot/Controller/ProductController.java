package com.commerce.springboot.Controller;

import com.commerce.springboot.DTO.ProductDTO;
import com.commerce.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Page<ProductDTO> searchByName (@RequestParam(name = "name", defaultValue = "")  String name, Pageable pageable) {
        return service.searchByName(name, pageable);
    }

}
