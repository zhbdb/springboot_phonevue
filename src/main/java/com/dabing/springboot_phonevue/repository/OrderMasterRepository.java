package com.dabing.springboot_phonevue.repository;



import com.dabing.springboot_phonevue.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
