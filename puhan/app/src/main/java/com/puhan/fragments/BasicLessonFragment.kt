package com.puhan.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puhan.R
import com.puhan.activity.PinyinActivity
import com.puhan.adapter.LessonAdapter
import com.puhan.model.LessonModel
import kotlinx.android.synthetic.main.fragment_basic_lesson.*

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_basic_lesson, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val lessonsList = arguments?.getSerializable("listOfBasicLessonsInfo")
        setRecyclerView(lesson = lessonsList as ArrayList<LessonModel>)
        arguments?.remove("listOfBasicLessonsInfo")
    }

    private fun setRecyclerView(lesson: ArrayList<LessonModel>) {
        val recyclerView = rv_basic_lessons
        val layout = LinearLayoutManager(this.context, RecyclerView.VERTICAL,
                false)
        recyclerView.layoutManager = layout
        recyclerView.adapter = LessonAdapter(lesson, this)
    }

    override fun onItemClick(item: View, position: Int) {

        when (position) {
            0 -> {
                val intent = Intent(context, PinyinActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
