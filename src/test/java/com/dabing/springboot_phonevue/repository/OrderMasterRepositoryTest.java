package com.dabing.springboot_phonevue.repository;

import com.dabing.springboot_phonevue.entity.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 大冰
 * @create 2020/5/22 15:22
 */
@SpringBootTest
class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    @Test
    void findAll(){
        List<OrderMaster> all = repository.findAll();
        for (OrderMaster orderMaster : all) {
            System.out.println(orderMaster);
        }
    }

    @Test
    void findById(){
        Optional<OrderMaster> byId = repository.findById("123456");
        System.out.println(byId);
    }

    @Test
    void pay(){
        OrderMaster orderMaster = repository.findById("123546").get();
        orderMaster.setPayStatus(1);
        repository.save(orderMaster);
    }
}