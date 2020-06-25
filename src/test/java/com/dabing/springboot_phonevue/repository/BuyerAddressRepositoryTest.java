package com.dabing.springboot_phonevue.repository;

import com.dabing.springboot_phonevue.entity.BuyerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 大冰
 * @create 2020/5/22 15:15
 */
@SpringBootTest
class BuyerAddressRepositoryTest {

    @Autowired
    private BuyerAddressRepository repository;

    @Test
    void findAll(){
        List<BuyerAddress> all = repository.findAll();
        for (BuyerAddress buyerAddress : all) {
            System.out.println(buyerAddress);
        }
    }
    @Test
    void save() {
        BuyerAddress buyerAddress = new BuyerAddress();
        buyerAddress.setAreaCode("330104");
        buyerAddress.setBuyerAddress("广东省深圳市罗湖区科技路123号456室");
        buyerAddress.setBuyerName("小红");
        buyerAddress.setBuyerPhone("13678787878");
        repository.save(buyerAddress);
    }
    @Test
    void update() {
        BuyerAddress buyerAddress = repository.findById(35).get();
        buyerAddress.setBuyerName("小明");
        repository.save(buyerAddress);
    }

}