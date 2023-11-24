package com.lq.gbrm.util;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class DataMapUtil {

    public static Map<String, Object> setObjToMap(Object obj) {
        Map<String, Object> dataMap = new HashMap();
        try {
            Class c = Class.forName(obj.getClass().getName());
            Method[] methods = c.getMethods();
            int i = 0;
            for (int l = methods.length; i < l; ++i) {
                String method = methods[i].getName();
                if (method.startsWith("get")) {
                    Object value = methods[i].invoke(obj, new Object[0]);
                    if (value != null) {
                        if (value.getClass().getClassLoader() != null) {
                            setObjToMap(value);
                        }
                        String key = method.substring(3);
                        key = key.substring(0, 1).toLowerCase()
                                + key.substring(1);
                        if ("java.util.Date".equals(value.getClass().getName())) {
                            value = Date.valueOf(value.toString());
                        }
                        dataMap.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataMap;
    }
}
