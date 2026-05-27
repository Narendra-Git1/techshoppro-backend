package com.nari.techshoppro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nari.techshoppro.entity.Product;
import com.nari.techshoppro.repository.ProductRepository;
import com.nari.techshoppro.service.ProductService;

@Service
public class ProductServiceImpl
        implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Product updateProduct(
            Long id,
            Product product) {

        Product existingProduct =
                productRepository.findById(id)
                        .orElseThrow();

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }
}