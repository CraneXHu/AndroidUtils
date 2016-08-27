package me.pkhope.androidutils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by pkhope on 2016/8/20.
 */

public class FileLogUtils {

    private static File localFile = null;
    private static OutputStreamWriter streamWriter = null;
    private static DateFormat dateFormat = null;

    private static void createLogFile(Context context){

        if (localFile == null){
            dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
            try {
                File sdCard = context.getExternalFilesDir(null);
                if (sdCard == null) {
                    return;
                }
                File dir = new File(sdCard.getAbsolutePath() + "/logs");
                dir.mkdirs();
                localFile = new File(dir, dateFormat.format(System.currentTimeMillis()) + ".txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {

                FileOutputStream stream = new FileOutputStream(localFile);
                streamWriter = new OutputStreamWriter(stream);
                streamWriter.write("-----start log " + dateFormat.format(System.currentTimeMillis()) + "-----\n");
                streamWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void e(Context context, final String tag, final String message, final Throwable exception) {

        if (localFile == null){
            createLogFile(context);
        }

        Log.e(tag, message, exception);
        if (streamWriter != null) {
            try {
                streamWriter.write(dateFormat.format(System.currentTimeMillis()) + " E/" + tag + "﹕ " + message + "\n");
                streamWriter.write(exception.toString());
                streamWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void e(Context context, final String tag, final String message) {

        if (localFile == null){
            createLogFile(context);
        }

        Log.e(tag, message);
        if (streamWriter != null) {
            try {
                streamWriter.write(dateFormat.format(System.currentTimeMillis()) + " E/" + tag + "﹕ " + message + "\n");
                streamWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void e(Context context, final String tag, final Throwable e) {

        if (localFile == null){
            createLogFile(context);
        }

        e.printStackTrace();
        if (streamWriter != null) {
            try {
                streamWriter.write(dateFormat.format(System.currentTimeMillis()) + " E/" + tag + "﹕ " + e + "\n");
                StackTraceElement[] stack = e.getStackTrace();
                for (int a = 0; a < stack.length; a++) {
                    streamWriter.write(dateFormat.format(System.currentTimeMillis()) + " E/" + tag + "﹕ " + stack[a] + "\n");
                }
                streamWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            e.printStackTrace();
        }

    }

    public static void d(Context context, final String tag, final String message) {

        if (localFile == null){
            createLogFile(context);
        }

        Log.d(tag, message);
        if (streamWriter != null) {
            try {
                streamWriter.write(dateFormat.format(System.currentTimeMillis()) + " D/" + tag + "﹕ " + message + "\n");
                streamWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void w(Context context, final String tag, final String message) {

        if (localFile == null){
            createLogFile(context);
        }

        Log.w(tag, message);
        if (streamWriter != null) {
            try {
                streamWriter.write(dateFormat.format(System.currentTimeMillis()) + " W/" + tag + ": " + message + "\n");
                streamWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void cleanLogs(Context context) {

        File sdCard = context.getExternalFilesDir(null);
        if (sdCard == null) {
            return;
        }
        File dir = new File (sdCard.getAbsolutePath() + "/logs");
        File[] files = dir.listFiles();
        if (files != null) {
            for (int a = 0; a < files.length; a++) {
                File file = files[a];
                if (localFile != null && file.getAbsolutePath().equals(localFile.getAbsolutePath())) {
                    continue;
                }
                file.delete();
            }
        }

    }
}


