package com.cojar.market.product.controller;

import com.cojar.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adm/product")
public class AdmProductController {
    private final ProductService productService;
    @GetMapping("/list")
    public String list() {

        return "adm/product/list";
    }

    @GetMapping("/create")
    public String create() {
        return "adm/product/create";
    }

    @PostMapping("/create")
    public String createProduct(
            @RequestParam String name, @RequestParam String description, @RequestParam int price, MultipartFile thumbnail) {

        this.productService.create(name, description, price, thumbnail);
        return "adm/product/create";
    }
}
