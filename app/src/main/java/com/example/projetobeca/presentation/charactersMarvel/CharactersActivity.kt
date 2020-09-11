package com.example.projetobeca.presentation.charactersMarvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetobeca.R
import com.example.projetobeca.data.model.Hero
import com.example.projetobeca.data.response.CharacterResponse
import com.example.projetobeca.presentation.details.CharacterDetailsActivity
import kotlinx.android.synthetic.main.activity_characters.*

class CharactersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        toobarMain.title = getString(R.string.character_title)
        setSupportActionBar(toobarMain)

        val viewModel: CharactersViewModel =
            ViewModelProviders.of(this).get(CharactersViewModel::class.java)


        viewModel.charactersLiveData.observe(this, Observer {
            it?.let { characters ->
                with(recyclerCharacters) {
                    layoutManager = LinearLayoutManager(this@CharactersActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)

                    adapter = CharactersAdapter(it){
                        val intent = CharacterDetailsActivity.getStartIntent(this@CharactersActivity,it.name,it.description,it.thumbnail.path,it.thumbnail.extension)
                        this@CharactersActivity.startActivity(intent)
                    }
                }
            }
        })
        viewModel.getCharacters()
    }
}