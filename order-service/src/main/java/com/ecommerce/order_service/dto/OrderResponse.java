package com.ecommerce.order_service.dto;

public record OrderResponse(
        Long id ,
        String status,
        ProductResponse product ) {
}
