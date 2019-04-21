package com.puhan.activity

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction
import com.puhan.R
import com.puhan.fragments.BasicLessonFragment
import com.puhan.fragments.ErrorDialogFragment
import com.puhan.model.LessonModel
import com.puhan.model.LessonsDao
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
        readLessonsData()
    }

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
            turnOffProgressBarVisibility()
        } catch (e: Exception) {
            showErrorDialog()
        }
    }

    private fun turnOffProgressBarVisibility() {
        progressBar.visibility = GONE
    }

    private fun readLessonsData() {
        LessonsDao().readDataFromFirestore(this::addListToView)
    }

    private fun showErrorDialog() {
        val dialog = ErrorDialogFragment().newInstance(getString(R.string.dialog_title), getString(R.string.error_fragment),
                getString(R.string.try_again_button))
        dialog.show(supportFragmentManager, "NoticeDialogFragment")
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        val intent = Intent(this@LessonsActivity, HomeActivity::class.java)
        startActivity(intent)
    }
}