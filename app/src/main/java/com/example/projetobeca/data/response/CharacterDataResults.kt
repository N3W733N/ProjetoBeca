package com.example.projetobeca.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class CharacterDataResults(
    @Json(name = "data")
    val data: CharacterResultsResponse
)