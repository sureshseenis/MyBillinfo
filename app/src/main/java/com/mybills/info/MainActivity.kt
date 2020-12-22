package com.mybills.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mybills.info.dependency.DependencyUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DependencyUtils.setAppContext(this)
    }
}