package com.cojar.market.member.entity;

import com.cojar.market.base.entity.BaseEntity;
import com.cojar.market.cart.entity.CartItem;
import com.cojar.market.cash.entity.CashLog;
import com.cojar.market.product.entity.Product;
import com.cojar.market.question.entity.Question;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {
    @Column(unique = true)
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String isActive;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Product> productList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Question> questionList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private  List<CartItem> cartList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private  List<CashLog> cashLogList;
}
