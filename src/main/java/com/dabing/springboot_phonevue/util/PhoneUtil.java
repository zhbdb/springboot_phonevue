package com.dabing.springboot_phonevue.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 大冰
 * @create 2020/5/23 9:47
 */
public class PhoneUtil {
    public static List<Map<String,String>> createTag(String tag){
        String[] tags = tag.split("&");
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map;
        for (String s : tags) {
            map = new HashMap<>();
            map.put("name",s);
            list.add(map);
        }
        return list;
    }
}



















