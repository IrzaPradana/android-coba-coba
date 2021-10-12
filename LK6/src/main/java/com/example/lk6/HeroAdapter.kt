package com.example.lk6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HeroAdapter: RecyclerView.Adapter <HeroAdapter.HeroViewHolder> (){
    class HeroViewHolder (val view: View): RecyclerView.ViewHolder (view) {
        fun bind(hero: Hero) {
            val image = itemView.findViewById<ImageView>(R.id.photo_heroes)
            Glide.with(itemView.context)
                .load(hero.image)
                .centerCrop()
                .into(image)
            val name = itemView.findViewById<TextView>(R.id.name_heroes)
            name.text = hero.name
            image.setOnClickListener {
                Toast.makeText(itemView.context, hero.name, Toast.LENGTH_SHORT).show()
            }
            val desc = itemView.findViewById<TextView>(R.id.desc_heroes)
            desc.text = hero.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_heroes, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(DataDummy.getListOfHeroes()[position])
    }

    override fun getItemCount(): Int {
        return DataDummy.getListOfHeroes().size
    }
}