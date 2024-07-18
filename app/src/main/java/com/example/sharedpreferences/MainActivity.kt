package com.example.sharedpreferences

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val preferences: SharedPreferences = getSharedPreferences("my_prefs",Activity.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("NAME","Paras")
        editor.putInt("code",1234)
        editor.commit()

        val name = preferences.getString("NAME","NA")
        val code = preferences.getInt("code",-1)
        Log.d("Tag","$name -- $code")

        UserData.storeToken(this,"ABCD@1234")
        Log.d("Tag",UserData.getToken(this)!!)

    }
}