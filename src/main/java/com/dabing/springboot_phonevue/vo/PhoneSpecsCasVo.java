package com.dabing.springboot_phonevue.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 大冰
 * @create 2020/5/23 14:52
 */
@Data
public class PhoneSpecsCasVo {
    @JsonProperty("s1")
    private Integer specsId;
    @JsonProperty("price")
    private BigDecimal specsPrice;
    @JsonProperty("stock_num")
    private Integer specsStock;
}
