package com.example.richard.oichina.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.richard.oichina.R
import com.example.richard.oichina.model.LessonModel
import kotlinx.android.synthetic.main.item_lesson.view.*

class LessonAdapter(private val lessonList: ArrayList<LessonModel>,
                    private val context: Context) : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.lessonTitle.text = lessonList.get(position).getTitle()
        holder.lessonDescription.text = lessonList.get(position).getDescription()
        holder.lessonNumber.text = lessonList.get(position).getLessonNumber()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder(LayoutInflater.from(context).inflate(R.layout.item_lesson, parent, false))
    }

    override fun getItemCount(): Int {
        return lessonList.size
    }

    class LessonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lessonTitle = view.tv_lesson_title
        val lessonDescription = view.tv_lesson_description
        val lessonNumber = view.tv_lesson_number
    }
}
