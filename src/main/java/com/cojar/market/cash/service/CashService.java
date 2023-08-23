package com.cojar.market.cash.service;

import com.cojar.market.cash.entity.CashLog;
import com.cojar.market.cash.repository.CashRepository;
import com.cojar.market.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashService {
    private final CashRepository cashRepository;
    public void addCashLog(Member member, long price) {
        CashLog cashlog = CashLog.builder()
                .member(member)
                .price(price)
                .build();

        this.cashRepository.save(cashlog);
    }
}
