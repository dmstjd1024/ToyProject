package com.dmstjd1024.toyproject.module.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/list")
    public String productList(Model model){
        List<Product> productList = productRepository.findAll();
        model.addAttribute(productList);

        return "product/list";
    }
}
