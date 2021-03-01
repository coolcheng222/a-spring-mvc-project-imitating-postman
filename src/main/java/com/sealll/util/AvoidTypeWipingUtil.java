package com.sealll.util;

import com.google.gson.internal.LinkedTreeMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sealll
 * @time 2021/1/28 18:00
 */
public class AvoidTypeWipingUtil {
    public static Map<String,? super String> wipe(Map ori){
        Map<String,String> res = new LinkedTreeMap<>();
        for ( Object o:ori.entrySet()) {
            res.put(((Map.Entry) o).getKey().toString(),((Map.Entry) o).getValue().toString());
        }
        return res;
    }
}
