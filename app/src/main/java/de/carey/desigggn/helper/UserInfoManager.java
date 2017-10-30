package de.carey.desigggn.helper;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

import de.carey.desigggn.entity.UserEntity;
import de.carey.desigggn.util.JsonUtil;
import de.carey.desigggn.util.SPUtils;

public class UserInfoManager {

    public static final String KEY_CURRENT_USER = "current_user";

    private static Map<String, UserEntity> sUserMap = new HashMap<>();

    public static UserEntity getCurrentUser() {
        UserEntity currentUser = sUserMap.get(KEY_CURRENT_USER);
        if (currentUser != null) {
            return currentUser;
        }

        String userJson = SPUtils.getString(KEY_CURRENT_USER, "");
        if (TextUtils.isEmpty(userJson)) {
            return null;
        }

        UserEntity user = JsonUtil.fromJson(userJson, UserEntity.class);
        sUserMap.put(KEY_CURRENT_USER, user);
        return user;
    }

    public static void setUserInfo(UserEntity user) {
        sUserMap.put(KEY_CURRENT_USER, user);
        SPUtils.putString(KEY_CURRENT_USER, JsonUtil.toJson(user));
    }

    public static void clearUserInfo() {
        sUserMap.clear();
        SPUtils.putString(KEY_CURRENT_USER, "");
    }
}
