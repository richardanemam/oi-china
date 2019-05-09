package com.puhan.model

class CharacterModel(private val character: String, private val pinyin: String,
                     private val translation: String) {

    fun getCharacter(): String {
        return character
    }

    fun getPinyin(): String {
        return pinyin
    }

    fun getTranslation(): String {
        return translation
    }
}