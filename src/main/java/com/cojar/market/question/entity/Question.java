package com.cojar.market.question.entity;

import com.cojar.market.base.entity.BaseEntity;
import com.cojar.market.member.entity.Member;
import com.cojar.market.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Question extends BaseEntity {
    private String title;
    private String content;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Product product;
}
