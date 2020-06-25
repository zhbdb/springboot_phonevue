package com.dabing.springboot_phonevue.controller;

import com.dabing.springboot_phonevue.exception.PhoneException;
import com.dabing.springboot_phonevue.form.AddressForm;
import com.dabing.springboot_phonevue.service.AddressService;
import com.dabing.springboot_phonevue.util.ResultVoUtil;
import com.dabing.springboot_phonevue.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressHandler {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public ResultVo list() {
        return ResultVoUtil.success(addressService.findAll());
    }

    @PostMapping("/create")
    public ResultVo create(@Valid @RequestBody AddressForm addressForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【添加地址】参数错误,addressForm={}", addressForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressForm);

        return ResultVoUtil.success(null);
    }

    @PutMapping("/update")
    public ResultVo update(@Valid @RequestBody AddressForm addressForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【修改地址】参数错误,addressForm={}", addressForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressForm);

        return ResultVoUtil.success(null);
    }
}
