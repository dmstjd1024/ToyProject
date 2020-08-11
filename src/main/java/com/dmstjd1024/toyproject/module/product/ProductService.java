package com.dmstjd1024.toyproject.module.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> listOfProduct(long categoryId) {

        List<Product> productList = productRepository.findByCategoryId(categoryId);

        return productList;
    }
}
