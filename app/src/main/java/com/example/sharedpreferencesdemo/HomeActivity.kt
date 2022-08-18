package com.example.sharedpreferencesdemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var logout= findViewById<Button>(R.id.logoutBtn)

        logout.setOnClickListener {

            var pref: SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
            var editor : SharedPreferences.Editor = pref.edit()

            editor.putBoolean("flag", false)
            editor.apply()
        }
    }
}