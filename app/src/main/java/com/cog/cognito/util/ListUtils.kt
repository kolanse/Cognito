package com.cog.cognito.util

fun List<String>.removeCharacters(chars: List<String>): List<String> {
    val characters = this.toMutableList()

    chars.map { char ->
        characters.remove(char)
    }

    return characters
}
