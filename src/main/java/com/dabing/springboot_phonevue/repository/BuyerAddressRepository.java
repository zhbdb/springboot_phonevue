package com.dabing.springboot_phonevue.repository;



import com.dabing.springboot_phonevue.entity.BuyerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerAddressRepository extends JpaRepository<BuyerAddress, Integer> {
}
