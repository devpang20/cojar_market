package com.cojar.market.cart.service;

import com.cojar.market.cart.entity.Cart;
import com.cojar.market.cart.repository.CartRepository;
import com.cojar.market.member.entity.Member;
import com.cojar.market.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    public void add(Product product, Member member) {
        Cart c = new Cart();
            c.setProduct(product);
            c.setMember(member);
            c.setCreateDate(LocalDateTime.now());

        this.cartRepository.save(c);
    }

    public List<Cart> getList(Member member) {
        return this.cartRepository.findByMember(member);
    }
}
