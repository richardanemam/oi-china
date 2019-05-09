package com.puhan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.puhan.R
import com.puhan.model.CharacterModel
import com.puhan.model.ItemClickListener

class CharacterAdapter(private val characterList: List<CharacterModel>,
                       private val listener: ItemClickListener) :
        RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(
                R.layout.item_character, parent, false)
        return CharacterHolder(itemView)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.character.text = characterList[position].getCharacter()
        holder.pinyin.text = characterList[position].getPinyin()
        holder.translation.text = characterList[position].getTranslation()
    }


    inner class CharacterHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val character: TextView = itemView.findViewById(R.id.tv_character)
        val pinyin: TextView = itemView.findViewById(R.id.tv_pinyin)
        val translation: TextView = itemView.findViewById(R.id.tv_translation_pt)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(itemView: View) {
            listener.onItemClick(itemView, adapterPosition)
        }

    }
}