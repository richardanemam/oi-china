package com.puhan.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puhan.R
import com.puhan.adapter.HomeAdapter
import com.puhan.model.HomeExploreItensModel
import com.puhan.model.ItemClickListener

class HomeActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initializeViews()
    }

    private fun initializeViews() {
        recyclerView = findViewById(R.id.rv_home_explore_itens)
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {

        val homeItensList = arrayListOf<HomeExploreItensModel>()
        homeItensList.add(HomeExploreItensModel(R.drawable.ic_books, getString(R.string.home_licoes)))
        homeItensList.add(HomeExploreItensModel(R.drawable.ic_china, getString(R.string.home_expressoes)))
        homeItensList.add(HomeExploreItensModel(R.drawable.ic_flashcards, getString(R.string.home_flashcards)))

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this.baseContext, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = HomeAdapter(homeItensList, this)
    }

    override fun onItemClick(item: View, position: Int) {
        when (position) {
            0 -> {
                val intent = Intent(this, LessonsActivity::class.java)
                startActivity(intent)
            }
            2 -> {
                val intent = Intent(this, FlashcardActivity::class.java)
                startActivity(intent)
            }
        }
    }

}