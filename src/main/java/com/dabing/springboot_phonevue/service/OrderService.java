package com.dabing.springboot_phonevue.service;

import com.dabing.springboot_phonevue.dto.OrderDTO;
import com.dabing.springboot_phonevue.vo.OrderDetailVo;

/**
 * @author 大冰
 * @create 2020/5/24 16:55
 */
public interface OrderService {
    public OrderDTO create(OrderDTO orderDTO);
    public OrderDetailVo findOrderDetailByOrderId(String orderId);
    public String pay(String orderId);
}
