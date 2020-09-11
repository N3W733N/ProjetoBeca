package com.example.projetobeca.presentation.charactersMarvel

import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetobeca.R
import com.example.projetobeca.data.model.Hero
import com.example.projetobeca.data.response.CharacterResponse
import kotlinx.android.synthetic.main.item_character.view.*

class CharactersAdapter(
    private val characters: List<CharacterResponse>,
    val onItemClickListener: ((hero: CharacterResponse) -> Unit)


) : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharactersViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount() = characters.count()

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bindView(characters[position])
    }

    class CharactersViewHolder(
        itemView: View,
        val onItemClickListener: ((hero: CharacterResponse) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {
        private val nomePersonagem = itemView.nomePersonagem
        private val imgHeroes = itemView.heroThumbnail

        fun bindView(character: CharacterResponse) {

            nomePersonagem.text = character.name

            val img =
                (character.thumbnail.path + "/standard_amazing." + character.thumbnail.extension).split(
                    ":"
                )

            //Glide.with(itemView).load(img)
            Glide.with(itemView).load("https:" + img[1]).into(imgHeroes)
            itemView.setOnClickListener {
                onItemClickListener.invoke(character)
            }
        }
    }
}
