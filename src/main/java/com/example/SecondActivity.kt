package com.example.android

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android.core.logLifecycle
import com.example.android.core.onClick
import com.example.android.core.shareText

// import com.example.android.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Second Screen"


        logLifecycle()


        val tvMessage = findViewById<TextView>(R.id.tvSecondMessage)
        val btnShare = findViewById<Button>(R.id.btnShare)
        val btnBack = findViewById<Button>(R.id.btnBack)


        val msg = intent.getStringExtra("greeting") ?: "Hello from SecondActivity!"
        tvMessage.text = msg


        btnShare.onClick {
            shareText("Check this message: $msg", "Share via")
        }


        btnBack.onClick { finish() }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
