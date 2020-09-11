package com.example.projetobeca.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.Query

@JsonClass(generateAdapter = true)

data class CharacterThumbnail(
    @Json(name = "path")
    val path : String,
    @Json(name = "extension")
    val extension : String
)