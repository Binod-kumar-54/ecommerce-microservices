package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.dto.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id){
        return new ProductResponse(id,"laptop",55000,"Dell Inspiration Laptop");
    }
}
