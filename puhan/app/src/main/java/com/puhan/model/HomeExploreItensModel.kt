package com.puhan.model

class HomeExploreItensModel(private val imgSrc: Int, private val title: String) {

    fun getImgSrc(): Int {
        return imgSrc
    }

    fun getTitle(): String {
        return title
    }
}