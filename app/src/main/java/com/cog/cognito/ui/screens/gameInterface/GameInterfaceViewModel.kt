package com.cog.cognito.ui.screens.gameInterface

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cog.cognito.data.countries
import com.cog.cognito.data.model.AnswerBoxModel
import com.cog.cognito.data.model.GameCategory
import com.cog.cognito.data.model.GameQuestion
import com.cog.cognito.util.shuffleString
import com.cog.cognito.util.toAnswerBoxModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

sealed interface GameInterfaceUiState {

    data class Success(
        val successMessage: String,
    ) : GameInterfaceUiState

    data class GamePlay(
        val title: String,
        val hints: List<String>,
        val options: List<String>,
        val answerBoxModel: List<AnswerBoxModel>,
    ) : GameInterfaceUiState
}
private data class GameInterfaceViewModelState(
    val selectedCategory: GameCategory = GameCategory.COUNTRY,
    val gameQuestions: List<GameQuestion> = listOf(),
    val currentIndex: Int = 0,
    val score: Int = 0,
    val currentAnswer: String = "",
) {

    fun toUiState(): GameInterfaceUiState =
        if (gameQuestions.getOrNull(currentIndex)?.answer.equals(currentAnswer, ignoreCase = true)) {
            GameInterfaceUiState.Success(
                successMessage = "You Guessed the ${GameCategory.COUNTRY.name} `${gameQuestions.getOrNull(currentIndex)?.answer}` correctly",
            )
        } else {
            GameInterfaceUiState.GamePlay(
                title = "Guess What ${selectedCategory.name}",
                hints = gameQuestions.getOrNull(currentIndex)?.hint.orEmpty(),
                answerBoxModel = currentAnswer.toAnswerBoxModel(gameQuestions.getOrNull(currentIndex)?.answer.orEmpty()),
                options = gameQuestions.getOrNull(currentIndex)?.answer.orEmpty().shuffleString(),
            )
        }
}

class GameInterfaceViewModel() : ViewModel() {

    private val viewModelState = MutableStateFlow(
        GameInterfaceViewModelState(),
    )

    // UI state exposed to the UI
    val uiState = viewModelState
        .map(GameInterfaceViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState(),
        )

    init {
        viewModelScope.let {
            viewModelState.update {
                it.copy(
                    selectedCategory = GameCategory.COUNTRY,
                    gameQuestions = countries,
                    currentIndex = 0,
                    score = 0,
                )
            }
        }
    }

    fun onOptionSelected(option: String) {
        viewModelState.update {
            it.copy(
                currentAnswer = it.currentAnswer + option,
            )
        }
    }

    fun onNextClicked (){
        viewModelState.update {
            it.copy(
                currentIndex = it.currentIndex + 1
            )
        }

    }
}
