package com.puhan.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.puhan.R
import kotlinx.android.synthetic.main.activity_pinyin.*

class PinyinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pinyin)

        setUpToolbar()
    }

    private fun setUpToolbar() {
        val toolbar = toolbar_pinyin
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setTitle(R.string.pinyin_title)
    }
}
