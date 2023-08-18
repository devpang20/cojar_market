package com.cojar.market.product.controller;

import com.cojar.market.product.entity.Product;
import com.cojar.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adm/product")
public class AdmProductController {

    private final ProductService productService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/create")
    public String create(Model model) {
        List<Product> productList = this.productService.getList();

        model.addAttribute("productList", productList);
        return "adm/product/create";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public String createContent(
            @RequestParam String name, @RequestParam String description, @RequestParam int price,
            MultipartFile thumbnail
    ) {
        this.productService.create(name, description, price, thumbnail);

        return "adm/product/create";
    }
}
