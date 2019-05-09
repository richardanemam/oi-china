package com.puhan.activity

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.puhan.R
import com.puhan.adapter.CharacterAdapter
import com.puhan.model.CharacterDao
import com.puhan.model.CharacterModel
import com.puhan.model.ItemClickListener

class WhatsYourNameActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var characters: RecyclerView
    private lateinit var progressBar: ProgressBar
    lateinit var listUpdated: ArrayList<CharacterModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whats_your_name)
        buildToolbar()
        initializeViews()
        readCharactersData()

    }

    private fun buildToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setTitle("Frases simples")
    }

    private fun initializeViews() {
        characters = findViewById(R.id.rv_wiyn_character)
        progressBar = findViewById(R.id.progressBar_id)
        listUpdated = arrayListOf()
    }

    private fun initializeRecyclerView(list: ArrayList<CharacterModel>) {
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        characters.layoutManager = layoutManager
        characters.adapter = CharacterAdapter(list, this)
        characters.setHasFixedSize(true)

        PagerSnapHelper().attachToRecyclerView(characters)
        progressBar.visibility = GONE
        setList(list)

    }

    private fun setList(list: ArrayList<CharacterModel>) {
        listUpdated = list
    }

    private fun getList(): ArrayList<CharacterModel> {
        return listUpdated
    }

    private fun readCharactersData() {
        CharacterDao().readLessonsDataFromFirestore(this::initializeRecyclerView)
    }

    override fun onItemClick(item: View, position: Int) {
        CharacterDao.setItem(getList()[position])
        Toast.makeText(this, "Caracter adicionado", Toast.LENGTH_SHORT).show()
    }
}

