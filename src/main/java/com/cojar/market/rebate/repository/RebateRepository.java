package com.cojar.market.rebate.repository;

import com.cojar.market.rebate.entity.RebateOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebateRepository extends JpaRepository<RebateOrderItem, Long> {

}
