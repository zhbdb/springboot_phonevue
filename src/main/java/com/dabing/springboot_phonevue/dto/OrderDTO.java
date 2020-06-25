package com.dabing.springboot_phonevue.dto;

import lombok.Data;

/**
 * @author 大冰
 * @create 2020/5/24 16:54
 */
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private Integer specsId;
    private Integer phoneQuantity;
}
