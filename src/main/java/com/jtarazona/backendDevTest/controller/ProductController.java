package com.jtarazona.backendDevTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtarazona.backendDevTest.model.Product;
import com.jtarazona.backendDevTest.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	
    private ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}/similar")
    public List<Product> getSimilarProducts(@PathVariable int productId) {
        List<Integer> similarProductIds = productService.getSimilarProductIds(productId);
        List<Product> similarProducts = productService.getProductsByIds(similarProductIds);
        
        return similarProducts;
    }

}
