package me.pkhope.androidutils;


import android.content.Context;
import android.widget.Toast;

/**
 * Created by pkhope on 2016/7/3.
 */
public class ToastUtils {

    public static void showShort(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    public static void showShort(Context context, int resId){
        Toast.makeText(context,resId,Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }

    public static void showLong(Context context, int resId){
        Toast.makeText(context,resId,Toast.LENGTH_LONG).show();
    }
}
