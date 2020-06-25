package com.dabing.springboot_phonevue.form;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
/**
 * @author 大冰
 * @create 2020/5/24 16:20
 */
@Data
public class AddressForm {
    private Integer id;
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "电话不能为空")
    private String tel;
    @NotEmpty(message = "省不能为空")
    private String province;
    @NotEmpty(message = "市不能为空")
    private String city;
    @NotEmpty(message = "区不能为空")
    private String county;
    @NotEmpty(message = "编码不能为空")
    private String areaCode;
    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;
}
