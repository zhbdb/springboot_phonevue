package com.dabing.springboot_phonevue.repository;

import com.dabing.springboot_phonevue.entity.PhoneSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 大冰
 * @create 2020/5/22 15:10
 */
@SpringBootTest
class PhoneSpecsRepositoryTest {

    @Autowired
    private PhoneSpecsRepository repository;

    @Test
    void findAll() {
        List<PhoneSpecs> list = repository.findAll();
        for (PhoneSpecs phoneSpecs : list) {
            System.out.println(phoneSpecs);
        }
    }

    @Test
    void findAllByPhoneId() {
        List<PhoneSpecs> list = repository.findAllByPhoneId(1);
        for (PhoneSpecs phoneSpecs : list) {
            System.out.println(phoneSpecs);
        }
    }
}