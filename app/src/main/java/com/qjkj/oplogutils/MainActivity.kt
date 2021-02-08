package com.qjkj.oplogutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qjkj.logutils.LogUtils

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogUtils.d(TAG, "onCreate()")
        LogUtils.d("run...")
        LogUtils.d()
    }
}

