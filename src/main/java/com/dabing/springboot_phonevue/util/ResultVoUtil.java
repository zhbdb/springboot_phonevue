package com.dabing.springboot_phonevue.util;

import com.dabing.springboot_phonevue.vo.ResultVo;

/**
 * @author 大冰
 * @create 2020/5/25 8:44
 */
public class ResultVoUtil {
    public static ResultVo success(Object data){

        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(data);
        return resultVo;
    }
    public static ResultVo error(String error) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(1);
        resultVo.setMsg(error);
        resultVo.setData(null);
        return resultVo;
    }
}
