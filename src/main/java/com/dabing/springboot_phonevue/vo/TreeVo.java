package com.dabing.springboot_phonevue.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 大冰
 * @create 2020/5/23 14:49
 */
@Data
public class TreeVo {
    private String k = "规格";
    private List<PhoneSpecsVo> v;
    private String k_s = "s1";
}
