package com.dmstjd1024.toyproject.module.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.beans.PropertyEditorSupport;
import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping()
    public String productList(Model model, @RequestParam String cId) {

        Long categoryId;
        if(cId == null){
            categoryId = 0L;
        }else{
            categoryId = Long.parseLong(cId);
        }

        List<Product> productList = productService.listOfProduct(categoryId);

        model.addAttribute(productList);

        return "product/list";
    }

    @GetMapping("/{productId}")
    public String productDetail(Model model, @PathVariable Long productId) {

        Product product = productRepository.findById(productId).orElseThrow(() ->
                new EntityNotFoundException());

        model.addAttribute(product);
        return "product/detail";
    }
}
