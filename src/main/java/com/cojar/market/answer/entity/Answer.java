package com.cojar.market.answer.entity;

import com.cojar.market.base.entity.BaseEntity;
import com.cojar.market.member.entity.Member;
import com.cojar.market.question.entity.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Answer extends BaseEntity {
    private String comment;
    @OneToOne
    private Member member;
    @OneToOne
    private Question question;
}
