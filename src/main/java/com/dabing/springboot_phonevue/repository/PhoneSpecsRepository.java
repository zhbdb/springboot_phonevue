package com.dabing.springboot_phonevue.repository;



import com.dabing.springboot_phonevue.entity.PhoneSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneSpecsRepository extends JpaRepository<PhoneSpecs, Integer> {
    public List<PhoneSpecs> findAllByPhoneId(Integer phoneId);
}
