package de.carey.desigggn.app;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.Logger;

import de.carey.desigggn.util.ApkUtil;
import de.carey.desigggn.util.SPUtils;

public class App extends Application {

    private static App sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        if (ApkUtil.isMainProcess(this)) {
            //SharedPreference工具
            SPUtils.init(this);
            //日志打印
            Logger.addLogAdapter(new AndroidLogAdapter() {
                @Override
                public boolean isLoggable(int priority, String tag) {
                    //仅在debug模式下打印日志
                    return BuildConfig.DEBUG;
                }
            });
        }
    }

    public static App getAppContext() {
        return sApp;
    }
}
