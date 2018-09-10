package com.example.richard.oichina;

/**
 * Created by Richard on 9/8/2018.
 */

public class Lesson {

    private String lessonTitle;
    private int thumbnail;
    private String description;

    public Lesson(){}

    public Lesson(int thumbnail, String lessonTitle, String description){
        this.setLessonTitle(lessonTitle);
        this.setThumbnail(thumbnail);
        this.setDescription(description);
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }


    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getLessonTitle(){
        return this.lessonTitle;
    }

    public int getThumbnail(){
        return this.thumbnail;
    }

    public String getDescription(){
        return this.description;
    }
}
