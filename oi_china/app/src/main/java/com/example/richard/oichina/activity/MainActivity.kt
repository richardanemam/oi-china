package com.example.richard.oichina.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.richard.oichina.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var btnLicoes: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpVariables()
        setUpClickHandle()
    }

    private fun setUpVariables() {
        btnLicoes = btn_licoes
    }

    private fun setUpClickHandle() {
        btnLicoes.setOnClickListener {
            val intent = Intent(this@MainActivity, LessonsActivity::class.java)
            startActivity(intent)
        }
    }
}