package com.qjkj.logutils.utils;

import java.io.File;

/**
 * @Author: pix
 * @Version: 1.0
 * @Date 20-4-10
 * @Description:
 */
public class Utils {

    public static void createDirs(File path) {
        if (path != null && !path.exists()) {
            path.mkdirs();
        }
    }
}
