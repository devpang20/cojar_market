package com.cojar.market.cart.repository;


import com.cojar.market.cart.entity.CartItem;
import com.cojar.market.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByMember (Member member);
}
