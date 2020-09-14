package com.example.projetobeca.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.projetobeca.R
import kotlinx.android.synthetic.main.activity_character_details.*
import kotlinx.android.synthetic.main.activity_characters.*


class CharacterDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        toobarDetails.title = getString(R.string.character_title)
        setSupportActionBar(toobarMain)

        val path = intent.getStringExtra(EXTRA_PATH)
        val extension = intent.getStringExtra(EXTRA_EXTENTION)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        nomeHero.text = intent.getStringExtra(EXTRA_NAME)
        characterDescription.movementMethod = ScrollingMovementMethod()

        if (description == null || description == "") {
            characterDescription.text = "Sem Descrição"
        } else {
            characterDescription.text = description
        }
        val img =
            ("$path/standard_amazing.$extension").split(
                ":"
            )
        Glide.with(this).load("https:" + img[1]).into(characterImg)

    }

    companion object {
        private const val EXTRA_NAME = "EXTRA_NAME"
        private const val EXTRA_DESCRIPTION = "DESCRIPTION"
        private const val EXTRA_PATH = "path"
        private const val EXTRA_EXTENTION = "extention"

        fun getStartIntent(
            context: Context,
            name: String,
            description: String,
            path: String,
            extension: String
        ): Intent {
            return Intent(context, CharacterDetailsActivity::class.java).apply {
                putExtra(EXTRA_NAME, name)
                putExtra(EXTRA_DESCRIPTION, description)
                putExtra(EXTRA_PATH, path)
                putExtra(EXTRA_EXTENTION, extension)
            }
        }
    }
}