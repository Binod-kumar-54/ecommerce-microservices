package com.ecommerce.order_service.service;

import com.ecommerce.order_service.client.ProductClient;
import com.ecommerce.order_service.dto.OrderResponse;
import com.ecommerce.order_service.dto.ProductResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ProductClient productClient;
    public OrderService(ProductClient productClient){
        this.productClient = productClient;
    }

    public OrderResponse getOrder(Long orderId){
        ProductResponse product = productClient.getProduct(orderId);
        return  new OrderResponse(orderId,"CONFIRMED",product);
    }
}
