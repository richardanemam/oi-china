package com.example.richard.oichina.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.richard.oichina.R
import com.example.richard.oichina.adapter.LessonAdapter
import com.example.richard.oichina.model.LessonModel
import kotlinx.android.synthetic.main.basic_fragment.*

/**
 * Created by Richard on 9/23/2018.
 */

class BasicLessonFragment : Fragment(), LessonAdapter.ItemClickListener {

    fun newInstance(infoBasicLessonList: ArrayList<LessonModel>): BasicLessonFragment {
        val basicLessonFragment = BasicLessonFragment()

        val args = Bundle()
        args.putSerializable("listOfBasicLessonsInfo", infoBasicLessonList)
        basicLessonFragment.arguments = args

        return basicLessonFragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.basic_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val lessonsList = arguments?.getSerializable("listOfBasicLessonsInfo")
        setRecyclerView(lessonsList as ArrayList<LessonModel>)
        arguments?.remove("listOfBasicLessonsInfo")
    }

    private fun setRecyclerView(lesson: ArrayList<LessonModel>) {
        val recyclerView = rv_basic_lessons
        val layout = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layout
        recyclerView.adapter = LessonAdapter(lesson, this.context!!, this)
    }

    override fun onItemClick(item: View, position: Int) {
        Toast.makeText(context, "Item Clicked:" + position.toString(), Toast.LENGTH_LONG).show()
    }
}
