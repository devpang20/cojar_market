package com.cojar.market.cart.entity;

import com.cojar.market.base.entity.BaseEntity;
import com.cojar.market.member.entity.Member;
import com.cojar.market.product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Cart extends BaseEntity{
    @ManyToOne
    private Member member;

    @ManyToOne
    private Product product;
}
