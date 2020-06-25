package com.dabing.springboot_phonevue.vo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import java.util.List;

/**
 * @author 大冰
 * @create 2020/5/23 14:44
 */
@Data
public class SkuVo {
    private List<TreeVo> tree;
    private List<PhoneSpecsCasVo> list;
    private String price;
    private Integer stock_num;
    private Boolean none_sku = false;
    private Boolean hide_stock = false;
}
