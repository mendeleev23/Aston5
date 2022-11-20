package com.example.aston5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.FrameLayout
import androidx.core.view.contains


var contactsList = ContactsList()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, contactsList).commit()
    }

    override fun onBackPressed() {
        if (findViewById<FrameLayout>(R.id.frame).contains(findViewById(R.id.Contact))){
            supportFragmentManager.popBackStack()
        }
    }

}
