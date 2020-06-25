package com.dabing.springboot_phonevue.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author 大冰
 * @create 2020/5/22 16:45
 */
@Data
@AllArgsConstructor
public class PhoneInfoVo {
    @JsonProperty("id")
    private Integer phoneId;
    @JsonProperty("title")
    private String phoneName;
    @JsonProperty("price")
    private String phonePrice;
    @JsonProperty("desc")
    private String phoneDescription;
    //可以不写，因为本来就叫tag
    private List<Map<String,String>> tag;
    @JsonProperty("thumb")
    private String phoneIcon;
}
