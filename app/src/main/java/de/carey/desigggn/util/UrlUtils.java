package de.carey.desigggn.util;

import java.util.HashMap;
import java.util.Map;

import de.carey.desigggn.app.Cons;

public class UrlUtils {

    /**
     * 获取登录链接
     */
    public static String getAuthorizeUrl() {
        Map<String, String> params = new HashMap<>();
        params.put(Cons.Param.CLIENT_ID, Cons.CLIENT_ID);
        params.put(Cons.Param.REDIRECT_URI, Cons.REDIRECT_URI);
        params.put(Cons.Param.SCOPE, Cons.SCOPE);
        params.put(Cons.Param.STATE, Cons.STATE);

        return formatToUrl(Cons.Url.OAUTH_URL + Cons.Path.AUTHORIZE, params);
    }

    public static String formatToUrl(String url, Map<String, String> params) {
        StringBuilder sb = null;

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (sb == null) {
                sb = new StringBuilder(url + "?");
            } else {
                sb.append("&");
            }

            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }

        return sb.toString();
    }
}
