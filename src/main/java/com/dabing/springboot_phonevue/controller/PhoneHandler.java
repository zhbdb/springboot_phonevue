package com.dabing.springboot_phonevue.controller;

import com.dabing.springboot_phonevue.service.PhoneService;
import com.dabing.springboot_phonevue.util.ResultVoUtil;
import com.dabing.springboot_phonevue.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大冰
 * @create 2020/5/25 8:38
 */
@RestController
@RequestMapping("/phone")
public class PhoneHandler {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/index")
    public ResultVo index(){
    return ResultVoUtil.success(phoneService.findDataVo());
    }

    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVo findByCategoryType(@PathVariable("categoryType") Integer categoryType){
      return ResultVoUtil.success(phoneService.findPhoneInfoVOByCategoryType(categoryType));
    }

    @GetMapping("/findSpecsByPhoneId/{phoneId}")
    public ResultVo findSpecsByPhoneId(
            @PathVariable("phoneId") Integer phoneId) {
        return ResultVoUtil.success(phoneService.findSpecsByPhoneId(phoneId));
    }
}
