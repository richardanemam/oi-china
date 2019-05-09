package com.puhan.model

import com.google.firebase.firestore.FirebaseFirestore

class CharacterDao(val db: FirebaseFirestore = FirebaseFirestore.getInstance()) {

    private val listOfCharacters = arrayListOf<CharacterModel>()

    companion object {
        private val listOfCharactersToReturn = arrayListOf<CharacterModel>()

        fun getList(): ArrayList<CharacterModel> {
            return this.listOfCharactersToReturn
        }

        fun setItem(c: CharacterModel) {
            this.listOfCharactersToReturn.add(c)
        }
    }

    fun readLessonsDataFromFirestore(onResult: (ArrayList<CharacterModel>) -> Unit) {
        db.collection("characters")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result!!) {
                            val characterInfo = CharacterModel(document.data["character"].toString(),
                                    document.data["pinyin"].toString(),
                                    document.data["translation"].toString())
                            listOfCharacters.add(characterInfo)
                        }
                        onResult(listOfCharacters)
                    }
                }

    }


}