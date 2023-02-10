package com.thientvse.springboottutorial.service;

import com.thientvse.springboottutorial.model.Product;

import java.util.Collection;

public interface ProductService {

    public abstract void createProduct(Product product);
    public abstract void updateProduct(String id, Product product);
    public abstract void deleteProduct(String id);
    public abstract Collection<Product> getProducts();
}
