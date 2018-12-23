package com.example.richard.oichina.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.example.richard.oichina.R
import com.example.richard.oichina.adapter.ViewPagerAdapter
import com.example.richard.oichina.fragments.BasicLessonFragment
import com.example.richard.oichina.fragments.FragmentIntermediate
import com.example.richard.oichina.model.LessonModel
import com.example.richard.oichina.model.LessonsDao
import kotlinx.android.synthetic.main.lessons.*

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

        setUpVariables()
        setUpToolBar()
        addingFragments()
    }

    private fun setUpVariables() {
        tabLayout = tabLayout_id
        toolBar = toolbar_id
        viewPager = viewpager_id
    }

    private fun setUpToolBar() {
        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun addListToView(list: ArrayList<LessonModel>) {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(BasicLessonFragment().newInstance(list), "Básico")
        viewPagerAdapter.addFragment(FragmentIntermediate(), "Intermediário") //TODO add list to intermediate fragment
        setUpAdapter(viewPagerAdapter)
    }

    private fun setUpAdapter(viewPagerAdapter: ViewPagerAdapter) {
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun addingFragments() {
        LessonsDao().readDataFromFirestore(this::addListToView)
    }
}