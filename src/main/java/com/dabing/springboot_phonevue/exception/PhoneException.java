package com.dabing.springboot_phonevue.exception;

import com.dabing.springboot_phonevue.enums.ResultEnum;

/**
 * @author 大冰
 * @create 2020/5/23 16:31
 */
public class PhoneException extends RuntimeException{
    public PhoneException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
    }
    public PhoneException(String error) {
        super(error);
    }
}
