package com.example.richard.oichina.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction
import com.example.richard.oichina.R
import com.example.richard.oichina.fragments.BasicLessonFragment
import com.example.richard.oichina.fragments.ErrorDialogFragment
import com.example.richard.oichina.model.LessonModel
import com.example.richard.oichina.model.LessonsDao
import kotlinx.android.synthetic.main.activity_lessons.*

/**
 * Created by Richard on 9/23/2018.
 */

class LessonsActivity : AppCompatActivity(), ErrorDialogFragment.ErrorDialogListener {

    private lateinit var toolBar: Toolbar
    private lateinit var progressBar: ProgressBar
    private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons)

        setUpVariables()
        setUpToolBar()
        addingFragments()
    }

    @SuppressLint("CommitTransaction")
    private fun setUpVariables() {
        toolBar = toolbar_id
        progressBar = progressBar_id
        fragmentTransaction = supportFragmentManager.beginTransaction()
    }

    private fun setUpToolBar() {
        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun addListToView(list: ArrayList<LessonModel>) {
        try {
            fragmentTransaction
                    .add(R.id.fl_place_holder, BasicLessonFragment().newInstance(list))
                    .commit()
            setUpProgressBarVisibility()
        } catch (e: Exception) {
            showErrorDialog()
        }
    }

    private fun setUpProgressBarVisibility() {
        progressBar.visibility = GONE
    }

    private fun addingFragments() {
        LessonsDao().readDataFromFirestore(this::addListToView)
    }

    private fun showErrorDialog() {
        val dialog = ErrorDialogFragment().newInstance(getString(R.string.dialog_title), getString(R.string.error_fragment),
                getString(R.string.try_again_button))
        dialog.show(supportFragmentManager, "NoticeDialogFragment")
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        val intent = Intent(this@LessonsActivity, MainActivity::class.java)
        startActivity(intent)
    }
}