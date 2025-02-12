package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
     ProductService productService;

    @GetMapping(path="/product/{id}",produces= {"application/json"})
    public ProductResponse searchProduct(@PathVariable int id) {
        return productService.searchProduct(id);
    }

    @PostMapping(path="/product",produces= {"application/json"},consumes= {"application/json"})
    public ProductResponse saveProduct(@RequestBody ProductRequest product) {
        return productService.saveProduct(product);
    }

    @GetMapping(path="/product",produces= {"application/json"})
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
