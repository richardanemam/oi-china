package com.example.richard.oichina.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.example.richard.oichina.R
import com.example.richard.oichina.adapter.ViewPagerAdapter
import com.example.richard.oichina.fragments.FragmentBasic
import com.example.richard.oichina.fragments.FragmentIntermediate

/**
 * Created by Richard on 9/23/2018.
 */

class LessonsActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var toolBar: Toolbar
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lessons)

        setUpViews()
        setUpToolBar()
        addingFragments()
    }

    private fun setUpViews() {
        tabLayout = findViewById(R.id.tabLayout_id)
        toolBar = findViewById(R.id.toolbar_id)
        viewPager = findViewById(R.id.viewpager_id)
    }

    private fun setUpToolBar() {
        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun addingFragments() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(FragmentBasic(), "Básico")
        viewPagerAdapter.addFragment(FragmentIntermediate(), "Intermediário")
        setUpAdapter(viewPagerAdapter)
    }

    private fun setUpAdapter(viewPagerAdapter: ViewPagerAdapter) {
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}