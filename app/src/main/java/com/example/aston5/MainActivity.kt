package com.example.aston5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var contactsList = ContactsList()

        supportFragmentManager.beginTransaction()
            .add(R.id.frame, contactsList).commit()
    }

}