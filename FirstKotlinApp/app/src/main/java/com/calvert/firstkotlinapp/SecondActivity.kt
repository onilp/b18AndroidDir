package com.calvert.firstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var receivedName = intent.getStringExtra("name")
        Toast.makeText(this, receivedName, Toast.LENGTH_LONG).show()
    }
}
