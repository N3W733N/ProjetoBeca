package com.example.projetobeca.data

import java.util.*


const val PUBLIC_KEY = "YOUR PUBLIC KEY HERE"
const val PRIVATE_KEY = "YOUR PRIVATE KEY HERE"
val TS = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
val HASH = "$TS$PRIVATE_KEY$PUBLIC_KEY"