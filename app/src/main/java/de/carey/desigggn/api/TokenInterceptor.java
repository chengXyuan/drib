package de.carey.desigggn.api;

import java.io.IOException;

import de.carey.desigggn.app.Cons;
import de.carey.desigggn.util.SPUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by XiaoXin on 2017/10/11.
 * 描述：通过拦截器向请求头中添加token
 */

class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        String token = SPUtils.getString(Cons.SP_ACCESS_TOKEN, Cons.CLIENT_ACCESS_TOKEN);
        builder.header("Authorization", "Bearer " + token);
        return chain.proceed(builder.build());
    }
}
