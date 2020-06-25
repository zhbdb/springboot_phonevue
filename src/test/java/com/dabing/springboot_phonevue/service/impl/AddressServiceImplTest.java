package com.dabing.springboot_phonevue.service.impl;

import com.dabing.springboot_phonevue.form.AddressForm;
import com.dabing.springboot_phonevue.service.AddressService;
import com.dabing.springboot_phonevue.vo.AddressVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 大冰
 * @create 2020/5/24 10:55
 */
@SpringBootTest
class AddressServiceImplTest {
    @Autowired
    private AddressService addressService;

    @Test
    void findAll() {
        List<AddressVo> list = addressService.findAll();
        int id = 0;
    }

    @Test
    void saveOrUpdate() {
        AddressForm addressForm = new AddressForm();
        addressForm.setId(54);
        addressForm.setName("王五");
        addressForm.setTel("13612344321");
        addressForm.setProvince("北京市");
        addressForm.setCity("北京市");
        addressForm.setCounty("东城区");
        addressForm.setAreaCode("110101");
        addressForm.setAddressDetail("168号606室");
        addressService.saveOrUpdate(addressForm);
    }
}