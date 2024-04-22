package com.cog.cognito.util


fun String.shuffleString(): List<String>{

    val charactersAdded = (this + getRandomString(4)).toUpperCase()

   return charactersAdded.toList().shuffled().map {
        it.toString()
    }
}

fun getRandomString(length: Int) : String {
    val allowedChars = ('A'..'Z')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}