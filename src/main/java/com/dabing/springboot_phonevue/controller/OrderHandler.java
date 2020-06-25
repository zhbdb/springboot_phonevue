package com.dabing.springboot_phonevue.controller;

import com.dabing.springboot_phonevue.dto.OrderDTO;
import com.dabing.springboot_phonevue.exception.PhoneException;
import com.dabing.springboot_phonevue.form.OrderForm;
import com.dabing.springboot_phonevue.service.OrderService;
import com.dabing.springboot_phonevue.util.ResultVoUtil;
import com.dabing.springboot_phonevue.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 大冰
 * @create 2020/5/25 9:50
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderHandler {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVo create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数错误,orderForm={}", orderForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getTel());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setSpecsId(orderForm.getSpecsId());
        orderDTO.setPhoneQuantity(orderForm.getQuantity());

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());

        return ResultVoUtil.success(map);
    }

    @GetMapping("/detail/{orderId}")
    public ResultVo findOrederDetail(
            @PathVariable("orderId") String orderId) {
        return ResultVoUtil.success(orderService.findOrderDetailByOrderId(orderId));
    }

    @PutMapping("/pay/{orderId}")
    public ResultVo pay(
            @PathVariable("orderId") String orderId) {
        Map<String, String> map = new HashMap<>();
        map.put("orderId", orderService.pay(orderId));
        return ResultVoUtil.success(map);
    }
}
