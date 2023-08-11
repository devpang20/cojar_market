package com.cojar.market.service;

import com.cojar.market.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@ActiveProfiles("test")
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

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
