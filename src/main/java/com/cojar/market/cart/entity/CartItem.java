package com.cojar.market.cart.entity;

import com.cojar.market.base.entity.BaseEntity;
import com.cojar.market.member.entity.Member;
import com.cojar.market.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
public class CartItem extends BaseEntity {

    @ManyToOne
    private Member member;

    @ManyToOne
    private Product product;

}
