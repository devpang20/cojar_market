package com.cojar.market.question.repository;

import com.cojar.market.member.entity.Member;
import com.cojar.market.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
