package com.example.projetobeca.data

import com.example.projetobeca.data.response.CharacterDataResults
import org.w3c.dom.CharacterData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelServices {
    @GET("characters")
    fun listcharacters(
        @Query("limit") limit: Int = 100,
        @Query("ts") ts: String = TS,
        @Query("apikey") apiKey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH.md5()  // md5(TS+Pk+PB)
    ): Call<CharacterDataResults>
}