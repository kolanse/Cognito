package com.cog.cognito.data.model

data class GameQuestion(
    val answer: String,
    val hint: List<String>,
    val difficulty: Difficulty
)
