package com.dabing.springboot_phonevue.repository;

import com.dabing.springboot_phonevue.entity.PhoneCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 大冰
 * @create 2020/5/22 15:02
 */
public interface PhoneCategoryRepository extends JpaRepository<PhoneCategory,Integer> {
    public PhoneCategory findByCategoryType(Integer categoryType);
}
