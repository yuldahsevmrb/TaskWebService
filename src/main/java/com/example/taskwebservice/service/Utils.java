package com.example.taskwebservice.service;

import com.example.taskwebservice.dto.GenericParam;

import java.util.List;

public class Utils {

    public static String getValueByKey(List<GenericParam> list, String key){
        for (GenericParam param: list){
            if(param.getParamKey().equalsIgnoreCase(key)){
                return param.getParamValue();
            }
        }
        return null;
    }

}
