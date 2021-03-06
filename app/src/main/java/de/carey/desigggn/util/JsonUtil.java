package de.carey.desigggn.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JsonUtil {

    /**
     * json转对象
     *
     * @param json  json字符串
     * @param clazz 目标对象的class类型
     * @return 目标对象
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);


    }

    public static <T> T json2List(String json, Type type) {
        return new Gson().fromJson(json, type);
    }

    /**
     * 对象转json
     *
     * @param object 待转为json的对象
     * @return json字符串
     */
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
}
