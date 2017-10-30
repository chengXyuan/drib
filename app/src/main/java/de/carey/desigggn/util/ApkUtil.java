package de.carey.desigggn.util;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import java.util.Iterator;
import java.util.List;

/**
 * Apk工具类
 */

public class ApkUtil {

    /**
     * 获取程序的包名
     */
    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    /**
     * 获取PackageInfo对象
     */
    public static PackageInfo getPackageInfo(Context context)
            throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(
                getPackageName(context), PackageManager.GET_ACTIVITIES);
    }

    /**
     * 获取程序的版本名
     */
    public static String getAppVersionName(Context context) {
        try {
            return getPackageInfo(context).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取程序的版本号
     */
    public static int getAppVersionCode(Context context) {
        try {
            return getPackageInfo(context).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取程序的相关信息
     */
    public static String getAppInfo(Context context) {
        String appInfo = ("包名:" + getPackageName(context) + "；") +
                "版本号:" + getAppVersionCode(context) + "；" +
                "版本名:" + getAppVersionName(context);
        return appInfo.trim();
    }

    /**
     * 获取设备的相关信息
     */
    public static String getDeviceInfo() {
        String deviceInfo = ("手机厂商:" + Build.MANUFACTURER + "；") +
                "手机型号:" + Build.MODEL + "；" +
                "系统版本号:" + Build.VERSION.SDK_INT + "；" +
                "系统版本名:" + Build.VERSION.RELEASE;
        return deviceInfo.trim();
    }

    public static boolean isMainProcess(Context context) {
        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = context.getPackageName();
        int myPid = android.os.Process.myPid();
        List appProcesses = am.getRunningAppProcesses();
        if(appProcesses == null) {
            Log.i("ApkUtil", "isMainProcess get getRunningAppProcesses null");
            List runningServices = am.getRunningServices(Integer.MAX_VALUE);
            if(runningServices == null) {
                Log.i("ApkUtil", "isMainProcess get getRunningServices null");
                return false;
            } else {
                Iterator iterator = runningServices.iterator();

                ActivityManager.RunningServiceInfo runningServiceInfo;
                do {
                    if(!iterator.hasNext()) {
                        return false;
                    }

                    runningServiceInfo = (ActivityManager.RunningServiceInfo)iterator.next();
                } while(runningServiceInfo.pid != myPid || !packageName.equals(runningServiceInfo.service.getPackageName()));

                return true;
            }
        } else {
            Iterator iterator = appProcesses.iterator();

            ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
            do {
                if(!iterator.hasNext()) {
                    return false;
                }

                runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)iterator.next();
            } while(runningAppProcessInfo.pid != myPid || !packageName.equals(runningAppProcessInfo.processName));

            return true;
        }
    }

    /**
     * 获取当前进程名字
     *
     * @param cxt 上下文对象
     * @param pid 当前进程
     * @return 当前进程的名字
     */
    public static String getProcessName(Context cxt, int pid) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps != null) {
            for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
                if (procInfo.pid == pid) {
                    return procInfo.processName;
                }
            }
        }
        return null;
    }

    /**
     * 安装APK文件 - 通过Intent安装APK文件
     */
    public static void installApk(Context context, String filePath, Dialog dialog) {
        final Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse("file://" + filePath), "application/vnd.android.package-archive");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(i);
        dialog.dismiss();
    }
}
