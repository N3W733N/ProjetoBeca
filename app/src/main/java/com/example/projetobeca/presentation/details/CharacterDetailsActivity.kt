package com.example.projetobeca.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.projetobeca.R
import kotlinx.android.synthetic.main.activity_character_details.*
import kotlinx.android.synthetic.main.activity_characters.*

class CharacterDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        setToobarConfig()
        initViewComponents()

        val detailViewModel: DetailsViewModel =
            ViewModelProviders.of(this).get(DetailsViewModel::class.java)

        val id = intent.getStringExtra("CHAR_ID")
        id?.let { detailViewModel.getCharById(it) }

        setCharacterData(detailViewModel)
    }

    private fun initViewComponents() {
        characterDescription.movementMethod = ScrollingMovementMethod()
    }

    private fun setToobarConfig() {
        toobarDetails.title = getString(R.string.character_title)
        setSupportActionBar(toobarMain)
    }

    private fun setCharacterData(detailViewModel: DetailsViewModel) {
        detailViewModel.heroesLiveData.observe(this, Observer {
            nomeHero.text = it.name
            characterDescription.text = it.description
            idHero.text = "ID: ${it.id}"

            val img = "${it.thumbnail.path}/standard_amazing.${it.thumbnail.extension}"
                .split(":")
            Glide.with(this).load("https:" + img[1]).into(characterImg)
        })
    }

    companion object {
        fun getStartIntent(
            context: Context, charId: String
        ): Intent {
            return Intent(context, CharacterDetailsActivity::class.java).apply {
                putExtra("CHAR_ID", charId)
            }
        }
    }
}