package com.example.richard.oichina.activity

import android.app.DialogFragment
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View.GONE
import android.widget.ProgressBar
import com.example.richard.oichina.R
import com.example.richard.oichina.adapter.ViewPagerAdapter
import com.example.richard.oichina.fragments.BasicLessonFragment
import com.example.richard.oichina.fragments.ErrorDialogFragment
import com.example.richard.oichina.fragments.IntermediateLessonFragment
import com.example.richard.oichina.model.LessonModel
import com.example.richard.oichina.model.LessonsDao
import kotlinx.android.synthetic.main.lessons.*

/**
 * Created by Richard on 9/23/2018.
 */

class LessonsActivity : AppCompatActivity(), ErrorDialogFragment.ErrorDialogListener {

    private lateinit var tabLayout: TabLayout
    private lateinit var toolBar: Toolbar
    private lateinit var viewPager: ViewPager
    private lateinit var progressBar: ProgressBar

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
        progressBar = progressBar_id
    }

    private fun setUpToolBar() {
        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun addListToView(list: ArrayList<LessonModel>) {
        try {
            val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
            viewPagerAdapter.addFragment(BasicLessonFragment().newInstance(list), "Básico")
            viewPagerAdapter.addFragment(IntermediateLessonFragment(), "Intermediário") //TODO add list to intermediate fragment
            setUpAdapter(viewPagerAdapter)
        } catch (e: Exception) {
            showErrorDialog()
        }
    }

    private fun setUpAdapter(viewPagerAdapter: ViewPagerAdapter) {
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        progressBar.visibility = GONE
    }

    private fun addingFragments() {
        LessonsDao().readDataFromFirestore(this::addListToView)
    }

    private fun showErrorDialog() {
        val dialog = ErrorDialogFragment().newInstance(getString(R.string.dialog_title), getString(R.string.error_fragment),
                getString(R.string.try_again_button))
        dialog.show(fragmentManager, "NoticeDialogFragment")
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        val intent = Intent(this@LessonsActivity, MainActivity::class.java)
        startActivity(intent)
    }
}