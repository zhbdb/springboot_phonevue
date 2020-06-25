package com.dabing.springboot_phonevue.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 大冰
 * @create 2020/5/22 16:33
 */
@Data
@AllArgsConstructor
public class PhoneCategoryVo {
//    private String name;
//    private String type;不能直接用这个名字，不然和实体类不对应，
//    如果要完成赋值的话，还需要单独写get,set方法比较麻烦，我们希望有一个工具类，
//  有一个工具类，可以把两个类之间相同名字，相同类型，自动完成赋值
//    使用工具类的前提是两个名字完全一致  所以：
//    @JsonProperty(xx)就是PhoneCategoryVo转换成json对象之后的名字
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
}

