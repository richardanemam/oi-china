package com.example.richard.oichina.model

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class LessonsDao(val db: FirebaseFirestore = FirebaseFirestore.getInstance()) {

    private val TAG = "WARN MESSAGE"
    private val TAG2 = "DEBBUG MESSAGE"
    private val listOfLessons = arrayListOf<LessonModel>()

    fun readDataFromFirestore(onResult: (ArrayList<LessonModel>) -> Unit) {
        db.collection("lessons")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result!!) {
                            val lessonInfo = LessonModel(document.data["title"].toString(),
                                    document.data["description"].toString(),
                                    document.data["lessonNumber"].toString())
                            listOfLessons.add(lessonInfo)
                            Log.d(TAG2, document.id + "=>" + document.data)
                        }

                        onResult(listOfLessons)
                    } else {
                        Log.w(TAG, "Error getting documents.", task.exception)
                    }
                }
    }
}