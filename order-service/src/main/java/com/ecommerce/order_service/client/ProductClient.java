package com.ecommerce.order_service.client;

import com.ecommerce.order_service.dto.ProductResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ProductClient {
    private final RestClient restClient;

    public ProductClient(RestClient restClient){
        this.restClient = restClient;
    }

    public ProductResponse getProduct(Long productId){
        return restClient.get().uri("/api/products/{id}",productId).retrieve().body(ProductResponse.class);
    }
}
