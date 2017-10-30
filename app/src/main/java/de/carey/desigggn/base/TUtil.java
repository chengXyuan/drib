package de.carey.desigggn.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class TUtil {

    @SuppressWarnings("unchecked")
    static <T> T getT(Object obj, int i) {
        Type[] types = ((ParameterizedType) (obj.getClass().getGenericSuperclass())).getActualTypeArguments();
        if (types.length > i) {
            Class<T> type = (Class<T>) types[0];
            try {
                return type.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
