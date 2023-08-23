package com.cojar.market.cash.repository;

import com.cojar.market.cash.entity.CashLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRepository extends JpaRepository<CashLog, Long> {
}
