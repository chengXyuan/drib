package de.carey.desigggn.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import de.carey.desigggn.BuildConfig;
import de.carey.desigggn.app.Cons;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiClient {

    private static Retrofit sOAuthRetrofit;
    private static Retrofit sRestRetrofit;
    private static Retrofit sJsoupRetrofit;

    synchronized static ApiStore getRestStore() {
        if (sRestRetrofit == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                    : HttpLoggingInterceptor.Level.NONE);

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(Cons.TIME_OUT_SECONDS, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .addNetworkInterceptor(new TokenInterceptor())
                    .build();
             /*
             * Gson默认处理Date对象的序列化/反序列化是通过一个SimpleDateFormat对象来实现的，
             * 会通过代码：DateFormat.getDateTimeInstance() 去获取实例
             * 在不同的locale环境中，这样获取到的SimpleDateFormat的模式字符串会不一样。
             * 为了避免使用Gson时遇到locale影响Date格式的问题，使用GsonBuilder来创建Gson对象，
             * 在创建过程中调用GsonBuilder.setDateFormat(String)指定一个固定的格式即可。
             */
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();

            sRestRetrofit = new Retrofit.Builder()
                    .client(httpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(Cons.Url.BASE_URL)
                    .build();
        }
        return sRestRetrofit.create(ApiStore.class);
    }

    synchronized static ApiStore getOAuthStore() {
        if (sOAuthRetrofit == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                    : HttpLoggingInterceptor.Level.NONE);

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(Cons.TIME_OUT_SECONDS, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .addNetworkInterceptor(new TokenInterceptor())
                    .build();
             /*
             * Gson默认处理Date对象的序列化/反序列化是通过一个SimpleDateFormat对象来实现的，
             * 会通过代码：DateFormat.getDateTimeInstance() 去获取实例
             * 在不同的locale环境中，这样获取到的SimpleDateFormat的模式字符串会不一样。
             * 为了避免使用Gson时遇到locale影响Date格式的问题，使用GsonBuilder来创建Gson对象，
             * 在创建过程中调用GsonBuilder.setDateFormat(String)指定一个固定的格式即可。
             */
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();

            sOAuthRetrofit = new Retrofit.Builder()
                    .client(httpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(Cons.Url.OAUTH_URL)
                    .build();
        }
        return sOAuthRetrofit.create(ApiStore.class);
    }
}
