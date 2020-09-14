package com.example.projetobeca.presentation.charactersMarvel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetobeca.data.ApiService
import com.example.projetobeca.data.response.CharacterDataResults
import com.example.projetobeca.data.response.CharacterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersViewModel : ViewModel() {
    val charactersMutableLD = MutableLiveData<List<CharacterResponse>>()
    val charactersLiveData: LiveData<List<CharacterResponse>> = charactersMutableLD

    fun getCharacters() {
        ApiService.run {
            service.listcharacters().enqueue(object : Callback<CharacterDataResults> {
                override fun onResponse(
                    call: Call<CharacterDataResults>,
                    response: Response<CharacterDataResults>
                ) {
                    if (response.isSuccessful) {

                        response.body()?.let { heroResponse ->
                            charactersMutableLD.value = heroResponse.data.results
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
}