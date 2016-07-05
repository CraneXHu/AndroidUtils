package me.pkhope.androidutils;

import android.content.Context;

/**
 * Created by pkhope on 2016/7/4.
 */
public class DisplayUtils {

    public static int dp2px(Context context, float dpVal){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpVal*scale + 0.5f);
    }

    public static int px2dp(Context context, float pxVal){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxVal/scale + 0.5f);
    }

    public static int sp2px(Context context, float spVal){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(spVal*scale + 0.5f);
    }

    public static int px2sp(Context context, float pxVal){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxVal/scale + 0.5f);
    }
}
