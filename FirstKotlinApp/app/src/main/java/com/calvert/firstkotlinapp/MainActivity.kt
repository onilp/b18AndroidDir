package com.calvert.firstkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatDialog
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.calvert.firstkotlinapp.model.User
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    private val log = AnkoLogger(this.javaClass)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ancient way
//        val email = find<EditText>(R.id.email_et)
//        val pass = findViewById<EditText>(R.id.password_et)

        submit_btn.setOnClickListener {
            var email = email_et.text
            var password = password_et.text

//            Toast.makeText(this, "$email --- $password", Toast.LENGTH_LONG).show()

//            val secondActivityIntent = Intent(this, SecondActivity::class.java)
//            secondActivityIntent.putExtra("name", "Cal")
//            startActivity(secondActivityIntent)

//            startActivity(intentFor<SecondActivity>("name" to "Cal").singleTop())

            //alert dialog - msg, yes, no
//            alert("Alert dialog") {
//                yesButton { toast("Yes") }
//                noButton { toast("No") }
//            }.show()

//            val dialog = progressDialog(message = "Loading...", title = "Progress Dialog")
//            dialog.progress = 50
//            dialog.show()
            //dialog.cancel()

            // verbose, debug, info, warn, error
            // extends AnkoLogger
            debug { "debug" }
            verbose { "verbose" }
            info { "info" }
            warn { "warn" }
            error { "error" }

            log.warn ( email )
        }

        var user = User("Cal", "1234")
        var email = user.email
        var password = user.password

        longToast(email)
        longToast(password)
    }
}
