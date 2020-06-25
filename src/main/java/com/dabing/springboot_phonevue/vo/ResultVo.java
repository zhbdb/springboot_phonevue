package com.dabing.springboot_phonevue.vo;

import lombok.Data;

/**
 * @author 大冰
 * @create 2020/5/25 8:43
 */
@Data
public class ResultVo<T> {
    private Integer code;
    private String msg;
    private T data;
}
