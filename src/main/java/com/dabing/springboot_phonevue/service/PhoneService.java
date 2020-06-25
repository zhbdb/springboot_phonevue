package com.dabing.springboot_phonevue.service;

import com.dabing.springboot_phonevue.vo.DataVo;
import com.dabing.springboot_phonevue.vo.PhoneInfoVo;
import com.dabing.springboot_phonevue.vo.SpecsPackageVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 大冰
 * @create 2020/5/22 16:28
 */
@Service
public interface PhoneService {
    //首页数据
    public DataVo findDataVo();

    //根据类型查询手机
    public List<PhoneInfoVo> findPhoneInfoVOByCategoryType(Integer categoryType);

//    查询手机规格
    public SpecsPackageVo findSpecsByPhoneId(Integer phoneId);

    //库存
    public void subStock(Integer specsId, Integer quantity);
}
