package com.dabing.springboot_phonevue.service.impl;

import com.dabing.springboot_phonevue.service.PhoneService;
import com.dabing.springboot_phonevue.vo.DataVo;
import com.dabing.springboot_phonevue.vo.PhoneInfoVo;
import com.dabing.springboot_phonevue.vo.SpecsPackageVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 大冰
 * @create 2020/5/23 10:03
 */
@SpringBootTest
class PhoneServiceImplTest {

    @Autowired
    private PhoneService phoneService;

    @Test
    void findDataVo(){
        DataVo dataVo = phoneService.findDataVo();
        int id=0;
    }

    @Test
    void findPhoneInfoVOByCategoryType(){
        List<PhoneInfoVo> phoneInfoVOByCategoryType = phoneService.findPhoneInfoVOByCategoryType(2);
        int i = 0;
    }


    @Test
    void findSku(){
        SpecsPackageVo packageVo = phoneService.findSpecsByPhoneId(1);
        int i = 0;
    }

    @Test
    void findStock(){
        phoneService.subStock(1,5);
    }
}