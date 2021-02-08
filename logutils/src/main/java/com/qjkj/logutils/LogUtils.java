package com.qjkj.logutils;

import android.os.Environment;
import android.util.Log;


import com.qjkj.logutils.utils.CloseUtils;
import com.qjkj.logutils.utils.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


/**
 * Copyright (C), 2020-2020, openqjkj
 * Author: pix
 * Date: 20-4-10 下午5:09
 * Version: 1.0
 * Description: B
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class LogUtils {
    private static final String TAG = "LogUtils";
    private static final String COMPANY_NAME = "qjkj";
    private static final String APP_NAME     = "log";

    public static final  String BASE_PATH   = COMPANY_NAME + File.separator + APP_NAME + File.separator;
    //是否输出日志的开关
    public static boolean ISDEBUG = true;
    public static boolean ISLOGCAT = true;

    public static void i(String TAG, String msg) {
        if (ISDEBUG) {
            if (msg == null) msg = "msg = null";
            if(ISLOGCAT) {
                Log.i(TAG, msg);
            }
            FileLogger.getInstance().addLog(TAG, msg);
        }
    }

    /**
     * 直接输出，不用再传入TAG，默认使用调用处类名作为TAG，并且默认在消息里拼接了方法名和行号
     */
    public static void i() {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String tag = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String msg = s.getLineNumber() + ", " + s.getMethodName() + "()";
        LogUtils.i(tag, msg);
    }

    /**
     * 直接输出，不用再传入TAG，默认使用调用处类名作为TAG，并且默认在消息里拼接了方法名和行号
     * @param msg
     */
    public static void i(String msg) {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        LogUtils.i(s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1),s.getLineNumber() + ", " + s.getMethodName() + "(), " + msg);
    }

    public static void i(String TAG, String msg, Throwable e) {
        if (ISDEBUG) {
            if (msg == null) msg = "msg = null";
            if(ISLOGCAT) {
                Log.i(TAG, msg, e);
            }
            FileLogger.getInstance().addLog(TAG, msg, e);
        }
    }

    public static void i(Throwable e) {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "()";
        LogUtils.i(t, m, e);
    }

    public static void i(String msg, Throwable e) {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "(), " + msg;
        LogUtils.i(t, m, e);
    }


    public static void e(String TAG, String msg) {
        if (ISDEBUG) {
            if (msg == null) msg = "msg = null";
            if(ISLOGCAT) {
                Log.e(TAG, msg);
            }
            FileLogger.getInstance().addLog(TAG, msg);
        }
    }

    public static void e(String msg) {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "(), " + msg;
        if (ISDEBUG) {
            if(ISLOGCAT) {
                Log.e(t, m);
            }
            FileLogger.getInstance().addLog(t, m);
        }
    }

    public static void e(String TAG, String msg, Throwable e) {
        if (ISDEBUG) {
            if (msg == null) msg = "msg = null";
            if(ISLOGCAT) {
                Log.e(TAG, msg, e);
            }
            FileLogger.getInstance().addLog(TAG, msg, e);
        }
    }

    public static void e(String msg, Throwable e) {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "(), " + msg;
        if (ISDEBUG) {
            if(ISLOGCAT) {
                Log.e(t, m, e);
            }
            FileLogger.getInstance().addLog(t, m, e);
        }
    }

    public static void e(Throwable e) {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "()";
        if (ISDEBUG) {
            if(ISLOGCAT) {
                Log.e(t, m, e);
            }
            FileLogger.getInstance().addLog(t,m, e);
        }
    }

    public static void d(String TAG, String msg) {
        if (ISDEBUG) {
            if (msg == null) msg = "msg = null";
            if(ISLOGCAT) {
                Log.d(TAG, msg);
            }
            FileLogger.getInstance().addLog(TAG, msg);
        }
    }


    /**
     * 打印被调用处的方法
     */
    public static void d() {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "()";
        LogUtils.d(t, m);
    }

    /**
     * 直接输出，不用再传入TAG，默认使用调用处类名作为TAG，并且默认在消息里拼接了方法名和行号
     * @param msg
     */
    public static void d(String msg) {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "(), " + msg;
        LogUtils.d(t, m);
    }

    /**
     * 重载一个带日志开关的DEBUG打印方法，这样方便控制模块日志的开关
     *
     * @param isOpen
     * @param TAG
     * @param msg
     */
    public static void d(Boolean isOpen, String TAG, String msg) {
        if (ISDEBUG && isOpen) {
            if (msg == null) msg = "msg = null";
            if(ISLOGCAT) {
                Log.d(TAG, msg);
            }
            FileLogger.getInstance().addLog(TAG, msg);
        }
    }

    public static void d(String TAG, String msg, Throwable e) {
        if (ISDEBUG) {
            if (msg == null) msg = "msg = null";
            if(ISLOGCAT) {
                Log.d(TAG, msg, e);
            }
            FileLogger.getInstance().addLog(TAG, msg, e);
        }
    }

    public static void v(String TAG, String msg) {
        if (ISDEBUG) {
            if (msg == null) msg = "msg = null";
            if(ISLOGCAT) {
                Log.v(TAG, msg);
            }
            FileLogger.getInstance().addLog(TAG, msg);
        }
    }

    public static void v() {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "()";
        if (ISDEBUG) {
            if(ISLOGCAT) {
                Log.v(t, m);
            }
            FileLogger.getInstance().addLog(t, m);
        }
    }

    public static void v(String msg) {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "(), " + msg;
        if (ISDEBUG) {
            if(ISLOGCAT) {
                Log.v(t, m);
            }
            FileLogger.getInstance().addLog(t, m);
        }
    }

    public static void v(String TAG, String msg, Throwable e) {
        if (ISDEBUG) {
            if (msg == null) msg = "msg = null";
            if(ISLOGCAT) {
                Log.v(TAG, msg, e);
            }
            FileLogger.getInstance().addLog(TAG, msg, e);
        }
    }


    public static void v(Throwable e) {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "()";
        if (ISDEBUG) {
            if(ISLOGCAT) {
                Log.v(t, m, e);
            }
            FileLogger.getInstance().addLog(t, m, e);
        }
    }

    public static void w(String TAG, String msg) {
        if (ISDEBUG) {
            if (msg == null) msg = "msg = null";
            if(ISLOGCAT) {
                Log.w(TAG, msg);
            }
            FileLogger.getInstance().addLog(TAG, msg);
        }
    }


    public static void w(String msg) {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "(), " + msg;
        if (ISDEBUG) {
            if(ISLOGCAT) {
                Log.w(t, m);
            }
            FileLogger.getInstance().addLog(t, m);
        }
    }


    public static void w() {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "()";
        if (ISDEBUG) {
            if(ISLOGCAT) {
                Log.w(t, m);
            }
            FileLogger.getInstance().addLog(t, m);
        }
    }

    public static void w(String TAG, String msg, Throwable e) {
        if (ISDEBUG) {
            if (msg == null) msg = "msg = null";
            if (ISLOGCAT) {
                Log.w(TAG, msg, e);
            }
            FileLogger.getInstance().addLog(TAG, msg, e);
        }
    }


    public static void w(Throwable e) {
        StackTraceElement s = (new Throwable()).getStackTrace()[1];
        String t = s.getClassName().substring(s.getClassName().lastIndexOf(".") + 1);
        String m = s.getLineNumber() + ", " + s.getMethodName() + "()";
        if (ISDEBUG) {
            if (ISLOGCAT) {
                Log.w(t, m, e);
            }
            FileLogger.getInstance().addLog(t, m, e);
        }
    }

    public static void println() {
        if (ISDEBUG) {
            if(ISLOGCAT) {
                System.out.println();
            }
            FileLogger.getInstance().addLog("", "");
        }
    }

    public static void println(Object msg) {
        if (ISDEBUG) {
            if(ISLOGCAT) {
                System.out.println(msg);
            }
            FileLogger.getInstance().addLog("System.out", msg.toString());
        }
    }

    public static void print(Object msg) {
        if (ISDEBUG) {
            if(ISLOGCAT) {
                System.out.print(msg);
            }
            FileLogger.getInstance().addLog("System.out", msg.toString());
        }
    }

    public static void printStackTrace(Throwable e) {
        if (ISDEBUG) {
            if(ISLOGCAT) {
                e.printStackTrace();
            }
            FileLogger.getInstance().addLog("System.out", e);
        }
    }

    public static void stopFileLogger() {
        FileLogger.getInstance().stop();
    }

    /**
     * 设置日志的存放路径
     *
     * @param fileLogPath
     */
    public static void setFileLogPath(String fileLogPath) {
        FileLogger.getInstance().setLogPath(fileLogPath);
    }

    private static class FileLogger implements Runnable {
        private static final int INTERVAL = 200;
        private static final int MAX_FAIL_COUNT = 30000 / INTERVAL;
        private static FileLogger inst = new FileLogger();
        private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
        private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        private String logPath = LogUtils.getDefaultLogPath().getAbsolutePath();//日志存放的路径
        private ArrayList<String> logList = new ArrayList<String>();
        private Thread thread;
        private boolean isRunning;

        public static FileLogger getInstance() {
            return inst;
        }

        public static String getTime() {
            return dateTimeFormat.format(new Date());
        }

        public void setLogPath(String logPath) {
            if (logPath != null && !logPath.endsWith(File.separator)) {
                this.logPath = logPath + File.separator;
            } else {
                this.logPath = logPath;
            }
        }

        private boolean isSDCardAvailable() {
            return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        }

        public void addLog(String TAG, String message) {
            if (!isSDCardAvailable() || logPath == null) {
                return;
            }
            synchronized (this) {
                logList.add("[" + getTime() + "][" + TAG + "]  " + message);


                notifyWrite();
            }
        }

        public void addLog(String TAG, Throwable e) {
            if (!isSDCardAvailable() || logPath == null) {
                return;
            }
            synchronized (this) {
                addLog(TAG, e.toString());
                StackTraceElement[] elements = e.getStackTrace();
                for (int i = 0; i < elements.length; i++) {
                    StackTraceElement element = elements[i];
                    logList.add("    " + element.toString());
                }
                Throwable cause = e.getCause();
                if (cause != null) {
                    logList.add("    Caused by: " + cause.toString());
                    elements = cause.getStackTrace();
                    for (int i = 0; i < elements.length; i++) {
                        StackTraceElement element = elements[i];
                        logList.add("    " + element.toString());
                    }
                }
                notifyWrite();
            }
        }

        public void addLog(String TAG, String message, Throwable e) {
            if (!isSDCardAvailable() || logPath == null) {
                return;
            }
            synchronized (this) {
                addLog(TAG, message);
                addLog(TAG, e);
            }
        }

        private String getLog() {
            synchronized (this) {
                if (logList.size() > 0) {
                    return logList.remove(0);
                }
                return null;
            }
        }

        private void notifyWrite() {
            if (!isRunning && isSDCardAvailable()) {
                isRunning = true;
                thread = new Thread(this);
                thread.start();
            }
        }

        public String getLogFileName() {
            return dateFormat.format(new Date()) + ".txt";
        }

        public void stop() {
            isRunning = false;
        }

        @Override
        public void run() {
            FileOutputStream fos = null;
            BufferedWriter writer = null;
            int count = 0;

            while (true) {
                String log = getLog();
                if (!isRunning) {
                    break;
                }
                if (log == null) {
                    if (count > MAX_FAIL_COUNT) {
                        break;
                    } else {
                        ++count;
                        try {
                            Thread.sleep(INTERVAL);
                        } catch (InterruptedException e) {

                        }
                        continue;
                    }
                }

                if (!isSDCardAvailable() || logPath == null) {
                    break;
                }
                try {
                    String logDir = logPath + File.separator;
                    Utils.createDirs(new File(logDir));
                    File file = new File(logDir + getLogFileName());

                    if (!file.exists()) {
                        Log.i(TAG, "Create new log file, path : " + file.getPath());
                        file.createNewFile();
                    }

                    if (!file.exists())
                        return;

                    fos = new FileOutputStream(file, true);
                    writer = new BufferedWriter(new OutputStreamWriter(fos));
                    //写文件
                    writer.write(log);
                    writer.newLine();

                    Thread.sleep(10);
                } catch (Throwable e) {
                    e.printStackTrace();
                    break;
                } finally {
                    CloseUtils.close(writer);
                    CloseUtils.close(fos);
                }
            }

            isRunning = false;
            thread = null;
        }
    }


    private static File getDefaultLogPath() {
        File    appWorkDir        = null;
        boolean isSDCardAvailable = isSDCardAvailable();
        if (isSDCardAvailable)
            appWorkDir = new File(Environment.getExternalStorageDirectory(), BASE_PATH);
            Log.d(TAG,appWorkDir.getAbsolutePath());
        if (!appWorkDir.exists())
            appWorkDir.mkdirs();
        return appWorkDir;
    }

    private static boolean isSDCardAvailable() {
        boolean result = false;
        try {
            result = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
