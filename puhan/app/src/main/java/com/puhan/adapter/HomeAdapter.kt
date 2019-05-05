package com.puhan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.puhan.R
import com.puhan.model.HomeExploreItensModel
import com.puhan.model.ItemClickListener


class HomeAdapter(val homeItens: List<HomeExploreItensModel>,
                  val listener: ItemClickListener) : RecyclerView.Adapter<HomeAdapter.HomeItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_home_explore,
                parent, false)
        return HomeItemHolder(itemView)
    }

    override fun getItemCount(): Int {
        return homeItens.size
    }

    override fun onBindViewHolder(holder: HomeItemHolder, position: Int) {
        holder.imgSrc.setImageResource(homeItens[position].getImgSrc())
        holder.title.text = homeItens[position].getTitle()
    }


    inner class HomeItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imgSrc: ImageView = itemView.findViewById(R.id.iv_home_placeholder)
        val title: TextView = itemView.findViewById(R.id.tv_home_explore_titlo)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(itemView: View) {
            listener.onItemClick(itemView, adapterPosition)
        }
    }
}
