package com.example.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        title = "Contact Manager"
    }
}
