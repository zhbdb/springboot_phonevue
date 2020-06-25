package com.dabing.springboot_phonevue.repository;

import com.dabing.springboot_phonevue.entity.PhoneInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 大冰
 * @create 2020/5/22 15:08
 */
@SpringBootTest
class PhoneInfoRepositoryTest {

    @Autowired
    private PhoneInfoRepository repository;

    @Test
    void findAll(){
        List<PhoneInfo> all = repository.findAll();
        for (PhoneInfo phoneInfo : all) {
            System.out.println(phoneInfo);
        }
    }
    @Test
    void findAllByCategoryType(){
        List<PhoneInfo> list = repository.findAllByCategoryType(1);
        for (PhoneInfo phoneInfo : list) {
            System.out.println(phoneInfo);
        }
    }
}