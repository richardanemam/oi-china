package com.puhan.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.puhan.R
import com.puhan.adapter.CharacterAdapter
import com.puhan.model.CharacterDao
import com.puhan.model.ItemClickListener


class FlashcardActivity : AppCompatActivity(), ItemClickListener {

    override fun onItemClick(item: View, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)
        buildToolbar()
        initializeRecyclerView()

    }

    private fun buildToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setTitle("Flashcard")
    }

    private fun initializeRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.rv_rv_flashcard_item)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = CharacterAdapter(CharacterDao.getList(), this)
        recyclerView.setHasFixedSize(true)

        PagerSnapHelper().attachToRecyclerView(recyclerView)
    }

}