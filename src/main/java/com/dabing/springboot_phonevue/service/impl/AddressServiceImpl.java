package com.dabing.springboot_phonevue.service.impl;

import com.dabing.springboot_phonevue.entity.BuyerAddress;
import com.dabing.springboot_phonevue.form.AddressForm;
import com.dabing.springboot_phonevue.repository.BuyerAddressRepository;
import com.dabing.springboot_phonevue.service.AddressService;
import com.dabing.springboot_phonevue.vo.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 大冰
 * @create 2020/5/24 10:48
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private BuyerAddressRepository buyerAddressRepository;

    @Override
    public List<AddressVo> findAll() {

        List<AddressVo> list = buyerAddressRepository.findAll().stream()
                .map(e -> new AddressVo(
                        e.getAddressId(),
                        e.getAreaCode(),
                        e.getBuyerName(),
                        e.getBuyerPhone(),
                        e.getBuyerAddress()
                )).collect(Collectors.toList());

        return list;
    }

    @Override
    public void saveOrUpdate(AddressForm addressForm) {
        BuyerAddress buyerAddress;
        if (addressForm.getId() == null){
            buyerAddress = new BuyerAddress();
        }else {
            buyerAddress = buyerAddressRepository.findById(addressForm.getId()).get();
        }
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());
        buyerAddress.setBuyerAddress(stringBuffer.toString());
        buyerAddress.setAreaCode(addressForm.getAreaCode());

        buyerAddressRepository.save(buyerAddress);
    }
}
