package com.cojar.market.product.controller;

import com.cojar.market.product.entity.Product;
import com.cojar.market.product.service.ProductService;
import com.cojar.market.question.entity.Question;
import com.cojar.market.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final QuestionService questionService;
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue = "0") int page) {
        Page<Product> paging = productService.getList(page);
        model.addAttribute("paging", paging);

        return "product/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {

        Product product = productService.getProduct(id);


        model.addAttribute("product", product);

        return "product/detail";
    }
}
