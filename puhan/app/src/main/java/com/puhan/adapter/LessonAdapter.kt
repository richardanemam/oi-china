package com.puhan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.puhan.R
import com.puhan.model.ItemClickListener
import com.puhan.model.LessonModel
import kotlinx.android.synthetic.main.item_lesson.view.*

class LessonAdapter(private val lessonList: ArrayList<LessonModel>,
                    private val listener: ItemClickListener) :
        RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {


    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.lessonTitle.text = lessonList[position].getTitle()
        holder.lessonDescription.text = lessonList[position].getDescription()
        holder.lessonNumber.text = lessonList[position].getLessonNumber()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lesson, parent, false))
    }

    override fun getItemCount(): Int {
        return lessonList.size
    }

    inner class LessonViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        val lessonTitle: TextView = view.tv_lesson_title
        val lessonDescription: TextView = view.tv_lesson_description
        val lessonNumber: TextView = view.tv_lesson_number

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            listener.onItemClick(view, adapterPosition)
        }
    }
}