package com.cojar.market.member.entity;

import com.cojar.market.base.entity.BaseEntity;
import com.cojar.market.cart.entity.Cart;
import com.cojar.market.product.entity.Product;
import com.cojar.market.question.entity.Question;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class Member extends BaseEntity {
    @Column(unique = true)
    private String username;
    private String password;
    private String nickname;
    private String email;
    private  String level;
    private String isActive;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Product> productList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Question> questionList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Cart> cartList;

}
