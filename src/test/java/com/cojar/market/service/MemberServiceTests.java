package com.cojar.market.service;

import com.cojar.market.member.entity.Member;
import com.cojar.market.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("회원가입")
    void t1 () {
        String username = "user1";
        String password = "1234";
        String email = "test@test.com";
        String nickname = "tester";

        memberService.join(username, password, email, nickname);
    }

    void t2 () {
        String username = "user1";
        String password = "1234";
        String email = "test@test.com";
        String nickname = "tester";

        memberService.join(username, password, email, nickname);

    }
}
