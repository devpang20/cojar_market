package com.cojar.market.cart.controller;

import com.cojar.market.cart.entity.Cart;
import com.cojar.market.cart.service.CartService;
import com.cojar.market.member.entity.Member;
import com.cojar.market.member.service.MemberService;
import com.cojar.market.product.entity.Product;
import com.cojar.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final ProductService productService;
    private final MemberService memberService;
    private final CartService cartService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("list")
    public String list (Principal principal, Model model) {
        Member member = memberService.findByUsername(principal.getName());
        List<Cart> cartList = this.cartService.getList(member);
        model.addAttribute("cartList", cartList);

        return "cart/list";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add/{id}")
    public String add (@PathVariable Long id, Principal principal) {
        Product product = productService.getProduct(id);
        Member member = memberService.findByUsername(principal.getName());

        this.cartService.add(product, member);

        return "redirect:/cart/list";
    }
}
