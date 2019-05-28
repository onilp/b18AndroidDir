package com.calvert.secondkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    private val log = AnkoLogger(this.javaClass)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //start new intent
        //alert dialog
        //log
        //model
        //toast

//        var secondActivityIntent = Intent(this, SecondActivity::class.java)
//        startActivity(secondActivityIntent)
        button.setOnClickListener {
            //            startActivity(intentFor<SecondActivity>("key" to "value").singleTop())

//            alert("Loading", "Alert Dialog") {
//                yesButton { longToast("Yes") }
//                noButton { longToast("no") }
//            }.show()

            error("error")
//            log.warn("warn")

        }

    }
}
