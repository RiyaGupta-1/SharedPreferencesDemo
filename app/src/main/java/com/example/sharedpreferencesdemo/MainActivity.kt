package com.example.sharedpreferencesdemo

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.CheckBox

class MainActivity : AppCompatActivity() {

    lateinit var pref:SharedPreferences
    var isRemembered= false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null)
            supportActionBar?.hide()

        var handler: Handler = Handler()

        handler.postDelayed(Runnable{

            pref= getSharedPreferences("login", MODE_PRIVATE)
            isRemembered= pref.getBoolean("flag", false)

            var intent:Intent
            if(isRemembered){
                 intent= Intent(this, HomeActivity::class.java)
            }
            else{
                 intent= Intent(this, LoginActivity::class.java)
                Log.d("Splash", "new activity")
            }

            startActivity(intent)
            Log.d("activity", "started")

        }, 4000)

    }
}