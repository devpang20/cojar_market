package com.cojar.market.question.service;

import com.cojar.market.member.entity.Member;
import com.cojar.market.product.entity.Product;
import com.cojar.market.question.entity.Question;
import com.cojar.market.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public void create(Product product, Member member, String content) {
        Question question = Question.builder()
                .member(member)
                .product(product)
                .content(content)
                .build();
            this.questionRepository.save(question);
    }

    public Question getQuestion(Long id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return  question.get();
        } else {
            throw new RuntimeException("member not found");
        }

    }
    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public void modify(Question  question, String content) {
        Question modifyQuestion = question.toBuilder()
                .content(content)
                .build();
        this.questionRepository.save(modifyQuestion);
    }

    public void delete(Question question) {
        this.questionRepository.delete(question);
    }
}
