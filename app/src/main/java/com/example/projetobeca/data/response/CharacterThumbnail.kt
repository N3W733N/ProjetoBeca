package com.example.projetobeca.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class CharacterThumbnail(
    @Json(name = "path")
    val path: String,
    @Json(name = "extension")
    val extension: String
)