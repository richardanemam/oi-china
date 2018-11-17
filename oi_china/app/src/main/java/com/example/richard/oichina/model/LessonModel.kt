package com.example.richard.oichina.model

class LessonModel(private val title: String,
                  private val description: String,
                  private val lessonNumber: String) {

    fun getTitle(): String {
        return this.title
    }

    fun getDescription(): String {
        return this.description
    }

    fun getLessonNumber(): String {
        return this.lessonNumber
    }
}