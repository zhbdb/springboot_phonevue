package com.dabing.springboot_phonevue.service.impl;

import com.dabing.springboot_phonevue.dto.OrderDTO;
import com.dabing.springboot_phonevue.entity.OrderMaster;
import com.dabing.springboot_phonevue.entity.PhoneInfo;
import com.dabing.springboot_phonevue.entity.PhoneSpecs;
import com.dabing.springboot_phonevue.enums.PayStatusEnum;
import com.dabing.springboot_phonevue.enums.ResultEnum;
import com.dabing.springboot_phonevue.exception.PhoneException;
import com.dabing.springboot_phonevue.repository.OrderMasterRepository;
import com.dabing.springboot_phonevue.repository.PhoneInfoRepository;
import com.dabing.springboot_phonevue.repository.PhoneSpecsRepository;
import com.dabing.springboot_phonevue.service.OrderService;
import com.dabing.springboot_phonevue.service.PhoneService;
import com.dabing.springboot_phonevue.util.KeyUtil;
import com.dabing.springboot_phonevue.vo.OrderDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author 大冰
 * @create 2020/5/24 16:55
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private PhoneService phoneService;
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);

        PhoneSpecs phoneSpecs = phoneSpecsRepository.findById(orderDTO.getSpecsId()).get();
        if (phoneSpecs == null) {
            log.error("【创建订单】规格不存在,phoneSpecs={}", phoneSpecs);
            throw new PhoneException(ResultEnum.SPECS_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneSpecs,orderMaster);


        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        if (phoneInfo == null) {
            log.error("【创建订单】手机不存在,phoneInfo={}", phoneInfo);
            throw new PhoneException(ResultEnum.PHONE_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneInfo, orderMaster);

        //计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = phoneSpecs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getPhoneQuantity()))
                .add(orderAmount)
                .add(new BigDecimal(10));
        orderMaster.setOrderAmount(orderAmount);
        //orderId
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());

        //payStatus
        orderMaster.setPayStatus(PayStatusEnum.UNPIAD.getCode());

        orderMasterRepository.save(orderMaster);

        phoneService.subStock(orderDTO.getSpecsId(), orderDTO.getPhoneQuantity());

        return orderDTO;
    }

    @Override
    public OrderDetailVo findOrderDetailByOrderId(String orderId) {
        OrderDetailVo orderDetailVO = new OrderDetailVo();

        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();
        if (orderMaster == null) {
            log.error("【查询订单】订单不存在,orderMaster={}", orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }

        BeanUtils.copyProperties(orderMaster, orderDetailVO);
        orderDetailVO.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100)) + ".00");

        return orderDetailVO;
    }

    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        if (orderMaster == null) {
            log.error("【支付订单】订单不存在,orderMaster={}", orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (orderMaster.getPayStatus().equals(PayStatusEnum.UNPIAD.getCode())) {
            orderMaster.setPayStatus(PayStatusEnum.PAID.getCode());
            orderMasterRepository.save(orderMaster);
        } else {
            log.error("【支付订单】订单已支付,orderMaster={}", orderMaster);
        }
        return orderId;
    }
}
