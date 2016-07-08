package me.pkhope.androidutils;

import android.util.Log;

/**
 * Created by pkhope on 2016/7/4.
 */
public class LogUtils {

    public static boolean isDebug = true;

    public static void setDebug(boolean isDebug){
        LogUtils.isDebug = isDebug;
    }

    public static boolean getDebug(){
        return isDebug;
    }

    public static String getClassName(){
        String tag = new Throwable().getStackTrace()[1].getClassName();
        return tag;
    }

    public static void v(String msg){
        if (isDebug){
            Log.v(getClassName(),msg);
        }
    }

    public static void d(String msg){
        if (isDebug){
            Log.d(getClassName(),msg);
        }
    }

    public static void i(String msg){
        if (isDebug){
            Log.i(getClassName(),msg);
        }
    }

    public static void w(String msg){
        if (isDebug){
            Log.w(getClassName(),msg);
        }
    }

    public static void e(String msg){
        if (isDebug){
            Log.e(getClassName(),msg);
        }
    }
}
