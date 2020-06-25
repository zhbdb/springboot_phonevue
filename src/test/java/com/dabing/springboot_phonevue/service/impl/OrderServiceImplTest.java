package com.dabing.springboot_phonevue.service.impl;

import com.dabing.springboot_phonevue.dto.OrderDTO;
import com.dabing.springboot_phonevue.service.OrderService;
import com.dabing.springboot_phonevue.vo.OrderDetailVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 大冰
 * @create 2020/5/24 17:05
 */
@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("大双");
        orderDTO.setBuyerPhone("13678787878");
        orderDTO.setBuyerAddress("广东省深圳市罗湖区科技路123号456室");
        orderDTO.setSpecsId(1);
        orderDTO.setPhoneQuantity(1);

        OrderDTO result = orderService.create(orderDTO);
        System.out.println(result);
    }

    @Test
    void findDetail() {
        OrderDetailVo orderDetailVo = orderService.findOrderDetailByOrderId("1590216563104349883");
        int id = 10;
    }

    @Test
    void pay(){
        System.out.println(orderService.pay("1590216563104349883"));

    }

}