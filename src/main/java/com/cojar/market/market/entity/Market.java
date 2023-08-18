package com.cojar.market.market.entity;

import com.cojar.market.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
public class Market extends BaseEntity {
    private String email;
    private String name;
    private String info;
}
