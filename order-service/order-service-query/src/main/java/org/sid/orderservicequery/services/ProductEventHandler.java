package org.sid.orderservicequery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.sid.events.CreatedProductEvent;
import org.sid.events.DeletedProductEvent;
import org.sid.events.UpdatedProductEvent;
import org.sid.exceptions.ProductNotFoundException;
import org.sid.orderservicequery.entities.Product;
import org.sid.orderservicequery.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class ProductEventHandler {
    private ProductRepository productRepository;

    @EventHandler
    public void on(CreatedProductEvent event){
        Product product = new Product();
        product.setId(event.getId());
        product.setName(event.getPayload().getProductName());
        product.setQTE(event.getPayload().getProductQTE());
        product.setPrice(event.getPayload().getPrice());
        product.setProductState(event.getPayload().getProductState());
        productRepository.save(product);
    }

    @EventHandler
    public void on(UpdatedProductEvent event) throws  ProductNotFoundException {
        Product product = productRepository.findById(event.getId()).orElseThrow(()->new ProductNotFoundException(String.format("customer %s not found", event.getId())));
        product.setName(event.getPayload().getProductName());
        product.setQTE(event.getPayload().getProductQTE());
        product.setPrice(event.getPayload().getPrice());
        product.setProductState(event.getPayload().getProductState());

        productRepository.save(product);
    }

    @EventHandler
    public void on(DeletedProductEvent event) throws ProductNotFoundException {
        Product product = productRepository.findById(event.getId()).orElseThrow(()->new ProductNotFoundException(String.format("customer %s not found", event.getId())));
        productRepository.delete(product);
    }
}
