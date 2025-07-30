package com.example.android

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.android.core.logLifecycle
import com.example.android.core.navigate
import com.example.android.core.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        title = "Main Screen"

        logLifecycle()

        val btnGoSecond = findViewById<Button>(R.id.btnGoSecond)
        btnGoSecond.onClick {
            navigate<SecondActivity>("greeting" to "Hello from MainActivity!")
        }
    }
}
