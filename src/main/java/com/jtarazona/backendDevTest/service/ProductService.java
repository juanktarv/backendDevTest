package com.jtarazona.backendDevTest.service;

import java.util.List;

import com.jtarazona.backendDevTest.model.Product;

public interface ProductService {

	List<Integer> getSimilarProductIds(int productId);
    List<Product> getProductsByIds(List<Integer> productIds);
}
