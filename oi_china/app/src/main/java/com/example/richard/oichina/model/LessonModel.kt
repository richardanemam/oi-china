package com.example.richard.oichina.model

class LessonModel(private var title: String,
                  private var description: String,
                  private var lessonNumber: String) {

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