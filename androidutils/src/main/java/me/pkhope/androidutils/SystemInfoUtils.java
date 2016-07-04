package me.pkhope.androidutils;

import android.os.Build;

/**
 * Created by pkhope on 2016/7/4.
 */
public class SystemInfoUtils {

    public static String getBuildBoard(){
        return Build.BOARD;
    }

    public static String getBuildBrand(){
        return Build.BRAND;
    }

    public static String getBuildDevice(){
        return Build.DEVICE;
    }

    public static String getBuildDisplay(){
        return Build.DISPLAY;
    }

    public static String getBuildFingerPrint(){
        return Build.FINGERPRINT;
    }

    public static String getBuildSerial(){
        return Build.SERIAL;
    }

    public static String getBuildId(){
        return Build.ID;
    }

    public static String getBuildManufacturer(){
        return Build.MANUFACTURER;
    }

    public static String getBuildModel(){
        return Build.MODEL;
    }

    public static String getBuildHardware(){
        return Build.HARDWARE;
    }

    public static String getBuildProduct(){
        return Build.PRODUCT;
    }

    public static String getBuildType(){
        return Build.TYPE;
    }

    public static String getBuildVersionCodeName(){
        return Build.VERSION.CODENAME;
    }

    public static String getBuildVersionIncremental(){
        return Build.VERSION.INCREMENTAL;
    }

    public static String getBuildVersionRelease(){
        return Build.VERSION.RELEASE;
    }

    public static int getBuildVersionSDKINT(){
        return Build.VERSION.SDK_INT;
    }

    public static long getBuildTime(){
        return Build.TIME;
    }

    public static String getOSVersion(){
        return System.getProperty("os.version");
    }

    public static String getOSName(){
        return System.getProperty("os.name");
    }

    public static String getOSArch(){
        return System.getProperty("os.arch");
    }
}
