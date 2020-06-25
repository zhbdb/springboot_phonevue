package com.dabing.springboot_phonevue.repository;

import com.dabing.springboot_phonevue.entity.PhoneCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 大冰
 * @create 2020/5/22 15:03
 */
@SpringBootTest
class PhoneCategoryRepositoryTest {

    @Autowired
    PhoneCategoryRepository repository;

    @Test
    void findAll(){
        List<PhoneCategory> all = repository.findAll();
        for (PhoneCategory phoneCategory : all) {
            System.out.println(phoneCategory);
        }
    }

    @Test
    void findByCategory(){
        PhoneCategory byCategoryType = repository.findByCategoryType(1);
        System.out.println(byCategoryType);
    }
}