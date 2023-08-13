package com.cojar.market.question.service;

import com.cojar.market.member.entity.Member;
import com.cojar.market.product.entity.Product;
import com.cojar.market.question.entity.Question;
import com.cojar.market.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public void create(Product product, Member member, String content) {
        Question q = new Question();
                q.setProduct(product);
                q.setMember(member);
                q.setContent(content);
                q.setCreateDate(LocalDateTime.now());
                this.questionRepository.save(q);
    }
}
