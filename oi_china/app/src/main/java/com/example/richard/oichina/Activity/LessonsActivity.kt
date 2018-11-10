package com.example.richard.oichina.Activity

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.richard.oichina.Adapter.ViewPagerAdapter
import com.example.richard.oichina.R
import com.example.richard.oichina.fragments.FragmentBasic
import com.example.richard.oichina.fragments.FragmentIntermediate

/**
 * Created by Richard on 9/23/2018.
 */

class LessonsActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lessons)

        setUpViews()
        addingFragments()
    }

    private fun setUpViews() {
        tabLayout = findViewById(R.id.tabLayout_id)
        appBarLayout = findViewById(R.id.appbar_id)
        viewPager = findViewById(R.id.viewpager_id)
    }

    private fun addingFragments() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.addFragment(FragmentBasic(), "Básico")
        viewPagerAdapter.addFragment(FragmentIntermediate(), "Intermediário")
        //viewPagerAdapter.addFragment(FragmentAdvanced(), "先进")
        setUpAdapter(viewPagerAdapter)
    }

    private fun setUpAdapter(viewPagerAdapter: ViewPagerAdapter) {
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}