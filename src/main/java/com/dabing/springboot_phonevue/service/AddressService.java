package com.dabing.springboot_phonevue.service;

import com.dabing.springboot_phonevue.form.AddressForm;
import com.dabing.springboot_phonevue.vo.AddressVo;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.List;

public interface AddressService {
    public List<AddressVo> findAll();

    public void saveOrUpdate(AddressForm addressForm);

}