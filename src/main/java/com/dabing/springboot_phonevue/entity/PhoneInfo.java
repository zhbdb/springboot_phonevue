package com.dabing.springboot_phonevue.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 大冰
 * @create 2020/5/22 8:49
 */
@Data
@Entity
public class PhoneInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer phoneId;
    private String phoneName;
    private BigDecimal phonePrice;
    private String phoneDescription;
    private Integer phoneStock;
    private String phoneIcon;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
    private String phoneTag;
}