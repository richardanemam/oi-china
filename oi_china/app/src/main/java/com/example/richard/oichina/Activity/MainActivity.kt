package com.example.richard.oichina.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.richard.oichina.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnLicoes: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpVariables()
        setUpClickHandle()
    }

    private fun setUpVariables() {
        btnLicoes = findViewById(R.id.btn_licoes)
    }

    private fun setUpClickHandle() {
        btnLicoes.setOnClickListener {
            val intent = Intent(this@MainActivity, LessonsActivity::class.java)
            startActivity(intent)
        }
    }
}