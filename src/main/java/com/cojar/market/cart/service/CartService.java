package com.cojar.market.cart.service;

import com.cojar.market.cart.entity.CartItem;
import com.cojar.market.cart.repository.CartRepository;
import com.cojar.market.member.entity.Member;
import com.cojar.market.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    public void add(Product product, Member member) {
        CartItem c = CartItem.builder()
            .product(product)
            .member(member)
            .build();
        this.cartRepository.save(c);
    }

    public List<CartItem> getList(Member member) {
        return this.cartRepository.findByMember(member);
    }
}
