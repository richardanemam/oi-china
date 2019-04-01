package com.example.richard.oichina.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.richard.oichina.R
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private lateinit var btnLicoes: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setUpVariables()
        setUpClickHandle()
    }

    private fun setUpVariables() {
        btnLicoes = btn_licoes
    }

    private fun setUpClickHandle() {
        btnLicoes.setOnClickListener {
            val intent = Intent(this@HomeActivity, LessonsActivity::class.java)
            startActivity(intent)
        }
    }
}