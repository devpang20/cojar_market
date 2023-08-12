package com.cojar.market.question.controller;

import com.cojar.market.member.entity.Member;
import com.cojar.market.member.service.MemberService;
import com.cojar.market.product.entity.Product;
import com.cojar.market.product.service.ProductService;
import com.cojar.market.question.entity.Question;
import com.cojar.market.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private  final QuestionService questionService;
    private  final ProductService productService;
    private final MemberService memberService;

    @PostMapping("/create/{id}")
    public String create(@PathVariable Long id, Principal principal, @RequestParam String content) {
        Product product = this.productService.getProduct(id);
        Member member = this.memberService.findByUsername(principal.getName());
        this.questionService.create(product, member, content);

        return String.format("redirect:/product/detail/%s", id);
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Model model) {

        Question question = this.questionService.getQuestion(id);
        long productId = question.getProduct().getId();
        Product product = this.productService.getProduct(productId);

        model.addAttribute("question", question);
        model.addAttribute("product", product);

        return "question/modify";
    }

    @PostMapping("/modify/{id}")
    public String modifyContent(@PathVariable Long id, @RequestParam String content) {
        Question question = this.questionService.getQuestion(id);
        long productId = question.getProduct().getId();
        this.questionService.modify(question, content);

        return String.format("redirect:/product/detail/%s", productId);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Question question = this.questionService.getQuestion(id);
        long productId = question.getProduct().getId();
        this.questionService.delete(question);

        return String.format("redirect:/product/detail/%s", productId);
    }
}
