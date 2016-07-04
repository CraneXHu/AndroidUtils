package me.pkhope.androidutils;

import android.content.Context;
import android.os.Process;

/**
 * Created by pkhope on 2016/7/3.
 */
public class CrashHandler  implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "CrashHandler";

    private static CrashHandler instance = null;

    private Dumper dumper = null;
    private Uploader uploader = null;

    private Thread.UncaughtExceptionHandler defaultCrashHandler;

    private CrashHandler(){
        defaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static CrashHandler getInstance(){

        if (instance == null){
            synchronized (CrashHandler.class){
                if (instance == null){
                    instance = new CrashHandler();
                }
            }
        }
        return instance;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

        try {
            if (dumper != null){
                dumper.dump(ex);
            }

            if (uploader != null){
                uploader.upload(ex);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        ex.printStackTrace();

        if (defaultCrashHandler != null){
            defaultCrashHandler.uncaughtException(thread,ex);
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    public void setDumper(Dumper dumper){
        this.dumper = dumper;
    }

    public void setUploader(Uploader uploader){
        this.uploader = uploader;
    }

    public interface Dumper {
        public void dump(Throwable ex);
    }

    public interface Uploader{
        public void upload(Throwable ex);
    }
}
