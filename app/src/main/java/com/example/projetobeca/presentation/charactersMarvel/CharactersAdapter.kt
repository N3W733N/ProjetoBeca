package com.example.projetobeca.presentation.charactersMarvel

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetobeca.R
import com.example.projetobeca.data.model.Hero
import com.example.projetobeca.data.response.CharacterResponse
import kotlinx.android.synthetic.main.item_character.view.*

class CharactersAdapter(
    private val characters: List<CharacterResponse>
) : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharactersViewHolder(itemView)
    }

    override fun getItemCount() = characters.count()

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bindView(characters[position])
    }

    class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nomePersonagem = itemView.nomePersonagem
        private val imgHeroes = itemView.heroThumbnail

        fun bindView(character: CharacterResponse) {

            nomePersonagem.text = character.name


            val img = character.thumbnail.path + "." + character.thumbnail.extension
            Glide.with(itemView).load(img)
            Log.i("tncdessaIMG", img.toString())
        }
    }
}
