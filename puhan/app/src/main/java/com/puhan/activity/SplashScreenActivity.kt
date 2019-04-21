package com.puhan.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

import com.puhan.R

/**
 * Created by Richard on 9/16/2018.
 */

class SplashScreenActivity : AppCompatActivity() {


    private val USER_KEY = "user"
    private val USER_PREFERENCES = "preferences"
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initVariables()
        userPreferences()
    }

    private fun initVariables() {
        preferences = getSharedPreferences(USER_KEY, Context.MODE_PRIVATE)
    }

    private fun userPreferences() {
        if (preferences.contains(USER_PREFERENCES)) {
            startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
        } else {
            addPreferences()
            showSplashScreen()
        }
    }

    private fun addPreferences() {
        val editor = preferences.edit()
        editor.putBoolean(USER_PREFERENCES, true)
        editor.apply()
    }

    private fun showSplashScreen() {
        val secondsDelayed = 3
        Handler().postDelayed({
            startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
            finish()
        }, (secondsDelayed * 1000).toLong())
    }
}