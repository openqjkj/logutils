> qjkj/logutils

# logutils

这个库是用来封装android日志打印的库。主要封装了安装的`Log`类。

主要功能是方便日志打印，将日志写入到文件中。

# 1.引用

在`app`的`build.gradle`中加入引用
```
    implementation 'com.qjkj:logutils:1.0.0'
```

在`AndroidManifest.xml`中加入权限

```
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
```

# 2.日志文件存储路径

默认的存储路径是`/mnt/sdcard/qjkj/log/yyyy-MM-dd.txt`

设置日志文件路径

```java
    LogUtils.setFileLogPath(xxxx);
```

日志文件存储路径 `xxxx/yyyy-MM-dd.txt`

# 3.常用用法

日志方法默认采用调用的类名作为日志的`TAG`,并且打印调用的行号及方法名。

```
LogUtils.d()
```

这种一般加载方法的第一行，或者最后一行。

```java
LogUtils.d("msgId:" + msgId);
```

带参数的输出。


# 4.日志的打开与关闭

在`LogUtils`类中定义了两个静态变量，用来控制是否输出日志，是否在`LogCat中输出` <++>

- 默认：`LogUtils.ISDEBUG=true;` and `LogUtils.ISLOGCAT=true;`:
输出日志到文件中，并且在LogCat中输出
- `LogUtils.ISDEBUG=true;` and
`LogUtils.ISLOGCAT=false;`:日志写文件，但是不会在`LogCat`中输出
- `LogUtils.ISDEBUG=false;`:关闭日志，既不输出到文件，也不输出到`LogCat`中。


