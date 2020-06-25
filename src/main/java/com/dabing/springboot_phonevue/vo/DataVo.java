package com.dabing.springboot_phonevue.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 大冰
 * @create 2020/5/22 16:30
 */
@Data
public class DataVo {
    private List<PhoneCategoryVo> categories;
    private List<PhoneInfoVo> phones;
}
