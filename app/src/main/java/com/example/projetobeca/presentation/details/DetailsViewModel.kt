package com.example.projetobeca.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetobeca.data.ApiService
import com.example.projetobeca.data.response.CharacterDataResults
import com.example.projetobeca.data.response.CharacterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel : ViewModel() {

    val heroesLiveData = MutableLiveData<CharacterResponse>()

    fun getCharById (id : String){

        ApiService.service.getCharById(id).enqueue(object : Callback<CharacterDataResults> {

            override fun onResponse(call: Call<CharacterDataResults>, response: Response<CharacterDataResults>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        heroesLiveData.value = it.data.results.first()
                    }
                }
            }

            override fun onFailure(call: Call<CharacterDataResults>, t: Throwable) {

            }

        })
    }
}