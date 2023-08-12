package com.cojar.market.service;

import com.cojar.market.cart.service.CartService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class CartServiceTests {
    @Autowired
    private CartService cartService;

    @Test
    @DisplayName("카트 상품 생성")
    void test1() {
    }
}
