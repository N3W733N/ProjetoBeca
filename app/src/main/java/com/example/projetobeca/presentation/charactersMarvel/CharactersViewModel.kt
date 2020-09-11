package com.example.projetobeca.presentation.charactersMarvel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetobeca.data.ApiService
import com.example.projetobeca.data.model.Hero
import com.example.projetobeca.data.response.CharacterDataResults
import com.example.projetobeca.data.response.CharacterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersViewModel : ViewModel() {
    val _charactersLiveData = MutableLiveData<List<CharacterResponse>>()
    val charactersLiveData: LiveData<List<CharacterResponse>> = _charactersLiveData

    fun getCharacters() {
        //charactersLiveData.value = createFakeCharacters()x'
        ApiService.service.listcharacters().enqueue(object : Callback<CharacterDataResults> {
            override fun onResponse(
                call: Call<CharacterDataResults>,
                response: Response<CharacterDataResults>
            ) {
                if (response.isSuccessful) {
                    val characters: MutableList<Hero> = mutableListOf()

                    response.body()?.let { heroResponse ->
                        _charactersLiveData.value = heroResponse.data.results
                        for (result in heroResponse.data.results) {
                            Log.i("Testes", heroResponse.data.results[0].thumbnail.path)
                            val character = Hero(
                                name = result.name,
                                description = result.description,
                                thumbnail = result.thumbnail.path + "/standard_amazing." + result.thumbnail.extension
                            )
                            characters.add(character)
                        }
                    }
                } else {
                    Log.e("error", response.message())
                }
            }

            override fun onFailure(call: Call<CharacterDataResults>, t: Throwable) {
                Log.e("onFailure", t.message.toString())
            }

        }
        )
    }
}