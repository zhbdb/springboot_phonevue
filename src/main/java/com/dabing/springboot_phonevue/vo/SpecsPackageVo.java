package com.dabing.springboot_phonevue.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author 大冰
 * @create 2020/5/23 14:42
 */
@Data
public class SpecsPackageVo {
    private Map<String,String> goods;
    private SkuVo sku;
}
