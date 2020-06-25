package com.dabing.springboot_phonevue.service.impl;

import com.dabing.springboot_phonevue.entity.PhoneCategory;
import com.dabing.springboot_phonevue.entity.PhoneInfo;
import com.dabing.springboot_phonevue.entity.PhoneSpecs;
import com.dabing.springboot_phonevue.enums.ResultEnum;
import com.dabing.springboot_phonevue.exception.PhoneException;
import com.dabing.springboot_phonevue.repository.PhoneCategoryRepository;
import com.dabing.springboot_phonevue.repository.PhoneInfoRepository;
import com.dabing.springboot_phonevue.repository.PhoneSpecsRepository;
import com.dabing.springboot_phonevue.service.PhoneService;
import com.dabing.springboot_phonevue.util.PhoneUtil;
import com.dabing.springboot_phonevue.vo.*;
import jdk.nashorn.internal.ir.LiteralNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 大冰
 * @create 2020/5/22 16:52
 */
@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneCategoryRepository phoneCategoryRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;
    @Override
    public DataVo findDataVo() {
        DataVo dataVo = new DataVo();
        //类型
        List<PhoneCategory> phoneCategoryList = phoneCategoryRepository.findAll();
//        //常规写法
//        List<PhoneCategoryVo> phoneCategoryVoList = new ArrayList<>();
//        for (PhoneCategory phoneCategory : phoneCategoryList) {
//            PhoneCategoryVo phoneCategoryVo = new PhoneCategoryVo();
//            phoneCategoryVo.setCategoryName(phoneCategory.getCategoryName());
//            phoneCategoryVo.setCategoryType(phoneCategory.getCategoryType());
//            phoneCategoryVoList.add(phoneCategoryVo);
//        }
        //stream
        List<PhoneCategoryVo> phoneCategoryVoList = phoneCategoryList.stream()
                .map(e -> new PhoneCategoryVo(
                        e.getCategoryName(),
                        e.getCategoryType()
                )).collect(Collectors.toList());
        dataVo.setCategories(phoneCategoryVoList);


        List<PhoneInfo> PhoneInfoList = phoneInfoRepository.findAllByCategoryType(phoneCategoryList.get(0).getCategoryType());

        //常规写法
//        List<PhoneInfoVo> phoneInfoVoList = new ArrayList<>();
//        for (PhoneInfo phoneInfo : PhoneInfoList) {
//            PhoneInfoVo phoneInfoVo = new PhoneInfoVo();
////            phoneInfoVo.setPhoneId(phoneInfo.getPhoneId());
//            //springutiles提供的类，(名字一样，类型一样)可以把原有类的数据复制给
////             public static void copyProperties(Object source, Object target)
//            BeanUtils.copyProperties(phoneInfo,phoneInfoVo);
//            //元素中有个tag，因为一个字段可能包含多个属性，所以为了让属性都显示出来，可以分割
//            //了类似这种  1300万像素&Micro USB接口两个属性，创建两个变量比较麻烦
//            // ，所以可以用&连接，到时候只要分割开就可以了 例如这个tag
//            phoneInfoVo.setTag(PhoneUtil.createTag(phoneInfo.getPhoneTag()));
//            phoneInfoVoList.add(phoneInfoVo);
//        }
        List<PhoneInfoVo> phoneInfoVoList = PhoneInfoList.stream()
                .map(e -> new PhoneInfoVo(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice()+".00",
                        e.getPhoneDescription(),
                        PhoneUtil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());
        dataVo.setPhones(phoneInfoVoList);

        return dataVo;

    }

    @Override
    public List<PhoneInfoVo> findPhoneInfoVOByCategoryType(Integer categoryType) {

        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findAllByCategoryType(categoryType);

        List<PhoneInfoVo> phoneInfoVoList = phoneInfoList.stream()
                .map(e -> new PhoneInfoVo(
                    e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice()+".00",
                        e.getPhoneDescription(),
                        PhoneUtil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());
        return phoneInfoVoList;
    }

    @Override
    public SpecsPackageVo findSpecsByPhoneId(Integer phoneId) {
        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneId).get();
        List<PhoneSpecs> phoneSpecsList = phoneSpecsRepository.findAllByPhoneId(phoneId);

        //tree
        List<PhoneSpecsVo> phoneSpecsVoList = new ArrayList<>();
        List<PhoneSpecsCasVo> phoneSpecsCasVoList = new ArrayList<>();
        PhoneSpecsVo phoneSpecsVo;
        PhoneSpecsCasVo phoneSpecsCasVo;
        for (PhoneSpecs phoneSpecs : phoneSpecsList) {
            phoneSpecsVo = new PhoneSpecsVo();
            phoneSpecsCasVo = new PhoneSpecsCasVo();
            BeanUtils.copyProperties(phoneSpecs,phoneSpecsVo);
            BeanUtils.copyProperties(phoneSpecs,phoneSpecsCasVo);
            phoneSpecsVoList.add(phoneSpecsVo);
            phoneSpecsCasVoList.add(phoneSpecsCasVo);
        }
        TreeVo treeVo = new TreeVo();
        treeVo.setV(phoneSpecsVoList);
        List<TreeVo> treeVoList = new ArrayList<>();
        treeVoList.add(treeVo);

        SkuVo skuVo = new SkuVo();
        Integer price = phoneInfo.getPhonePrice().intValue();
        skuVo.setPrice(price + ".00");
        skuVo.setStock_num(phoneInfo.getPhoneStock());
        skuVo.setTree(treeVoList);
        skuVo.setList(phoneSpecsCasVoList);

        SpecsPackageVo specsPackageVo = new SpecsPackageVo();
        specsPackageVo.setSku(skuVo);
        Map<String,String> goods = new HashMap<>();
        goods.put("picture",phoneInfo.getPhoneIcon());
        specsPackageVo.setGoods(goods);

        return specsPackageVo;
    }

    @Override
    public void subStock(Integer specsId, Integer quantity) {
        PhoneSpecs phoneSpecs = phoneSpecsRepository.findById(specsId).get();
        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        Integer result = phoneSpecs.getSpecsStock()-quantity;
        if (result<0){
            log.error("[扣库存]库存不足");
            throw new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        }
        phoneSpecs.setSpecsStock(result);
        phoneSpecsRepository.save(phoneSpecs);

        result = phoneInfo.getPhoneStock() - quantity;
        if (result < 0) {
            log.error("【扣库存】库存不足");
            throw new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        }

        phoneInfo.setPhoneStock(result);
        phoneInfoRepository.save(phoneInfo);
    }
}
