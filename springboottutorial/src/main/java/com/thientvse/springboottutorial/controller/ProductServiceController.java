package com.thientvse.springboottutorial.controller;

import com.thientvse.springboottutorial.exception.ProductNotfoundException;
import com.thientvse.springboottutorial.model.Product;
import com.thientvse.springboottutorial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {

    private static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);
        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value="/products", method=RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully",
                HttpStatus.CREATED);
    }

    @RequestMapping(value="/products/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){

       productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successsfully",
                HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successsfully",
                HttpStatus.OK);
    }
}
