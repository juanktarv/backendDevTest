package com.jtarazona.backendDevTest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jtarazona.backendDevTest.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	private RestTemplate restTemplate;
	

	
	 public ProductServiceImpl(RestTemplate restTemplate) {
	    this.restTemplate = restTemplate;
	 }
	 
	 
	 @Override
	    public List<Integer> getSimilarProductIds(int productId) {
	        // Realiza la llamada al endpoint http://localhost:3001/product/1/similarids
	        // y devuelve los IDs de productos similares obtenidos
	        
	        // Ejemplo de implementación:
	        String url = "http://localhost:3001/product/{productId}/similarids";
	        Integer[] similarProductIds = restTemplate.getForObject(url, Integer[].class, productId);
	        
	        return Arrays.asList(similarProductIds);
	 }
	 
	 
    @Override
    public List<Product> getProductsByIds(List<Integer> productIds) {
        // Realiza la llamada al endpoint http://localhost:3001/product/{productId}
        // para cada ID de producto en la lista productIds y devuelve los detalles de los productos obtenidos
        
        // Ejemplo de implementación:
        List<Product> products = new ArrayList<>();
        
        for (Integer productId : productIds) {
            String url = "http://localhost:3001/product/{productId}";
            Product product = restTemplate.getForObject(url, Product.class, productId);
            
            if (product != null) {
                products.add(product);
            }
        }
        
        return products;
    }
	 

}
