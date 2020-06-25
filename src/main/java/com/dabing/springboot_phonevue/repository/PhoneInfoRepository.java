package com.dabing.springboot_phonevue.repository;


import com.dabing.springboot_phonevue.entity.PhoneInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 大冰
 * @create 2020/5/22 8:57
 */
public interface PhoneInfoRepository extends JpaRepository<PhoneInfo,Integer> {
    public List<PhoneInfo> findAllByCategoryType(Integer categoryType);
}
