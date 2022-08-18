package com.example.sharedpreferencesdemo

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var loginBtn = findViewById<Button>(R.id.loginBtn)
        var userName= findViewById<EditText>(R.id.userName).text.toString()
        var password= findViewById<EditText>(R.id.password).text.toString()
        var checkBox= findViewById<CheckBox>(R.id.checked).isChecked

        loginBtn.setOnClickListener {

           var pref:SharedPreferences= getSharedPreferences("login", MODE_PRIVATE)
           var editor : SharedPreferences.Editor = pref.edit()

            editor.putString("Name", userName)
            editor.putString("Password", password)
            editor.putBoolean("flag",true)
            editor.apply()

            Toast.makeText(this, "Login successfully", Toast.LENGTH_LONG).show()

            var intent:Intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}