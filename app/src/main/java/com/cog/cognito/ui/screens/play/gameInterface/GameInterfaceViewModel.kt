package com.cog.cognito.ui.screens.play.gameInterface

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cog.cognito.data.questions.countries
import com.cog.cognito.data.model.AnswerBoxModel
import com.cog.cognito.data.model.Difficulty
import com.cog.cognito.data.model.GameCategory
import com.cog.cognito.data.model.GameQuestion
import com.cog.cognito.data.questions.moviesList
import com.cog.cognito.util.removeCharacters
import com.cog.cognito.util.shuffleString
import com.cog.cognito.util.toAnswerBoxModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class GameInterfaceUiState(
    val title: String,
    val hints: List<String>,
    val options: List<String>,
    val answerBoxModels: List<AnswerBoxModel>,
    val score: String,
    val showHint: Boolean,
    val showSuccessDialog: Boolean,
    val successMessage: String,
    val questionPoint: String,
)

private data class GameInterfaceViewModelState(
    val selectedCategory: GameCategory = GameCategory.COUNTRY,
    val gameQuestions: List<GameQuestion> = listOf(),
    val currentIndex: Int = 0,
    val score: Int = 0,
    val currentAnswer: String = "",
    val showHint: Boolean = true,
    val shuffleString: Boolean = true,
    val options: List<String> = listOf(),
    val currentWrong: Boolean = false,
) {

    fun toUiState(): GameInterfaceUiState =
        GameInterfaceUiState(
            title = "Guess What ${selectedCategory.name}",
            hints = gameQuestions.getOrNull(currentIndex)?.hint.orEmpty(),
            answerBoxModels = currentAnswer.toUpperCase().toAnswerBoxModel(gameQuestions.getOrNull(currentIndex)?.answer?.toUpperCase().orEmpty()),
            options = options.removeCharacters(currentAnswer.toList().map { it.toString() }),
            score = score.toString(),
            showHint = showHint,
            showSuccessDialog = currentAnswer.equals(gameQuestions.getOrNull(currentIndex)?.answer, true),
            successMessage = "You Guessed the Country `${gameQuestions.getOrNull(currentIndex)?.answer}` correctly",
            questionPoint = when (gameQuestions.getOrNull(currentIndex)?.difficulty) {
                Difficulty.EASY -> {
                    "2"
                }
                Difficulty.MEDIUM -> {
                    "5"
                }
                Difficulty.HARD -> {
                    "10"
                }

                else -> {
                    "0"
                }
            },
        )
}

@HiltViewModel
class GameInterfaceViewModel @Inject constructor() : ViewModel() {

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
                    selectedCategory = GameCategory.MOVIE,
                    gameQuestions = moviesList,
                    currentIndex = 0,
                    score = 0,
                    options = countries.getOrNull(0)?.answer.orEmpty().shuffleString(),
                )
            }
        }
    }

    fun onOptionSelected(option: String) {
        viewModelState.update {
            it.copy(
                currentAnswer = if (it.currentWrong) {
                    it.currentAnswer
                } else {
                    it.currentAnswer + option
                },
                currentWrong = it.gameQuestions.get(it.currentIndex).answer.contains((it.currentAnswer + option), true).not(),
                score = if (it.currentWrong) {
                    it.score
                } else if ((it.currentAnswer + option).equals(it.gameQuestions.get(it.currentIndex).answer, ignoreCase = true)) {
                    it.score + when (it.gameQuestions.get(it.currentIndex).difficulty) {
                        Difficulty.EASY -> {
                            2
                        }
                        Difficulty.MEDIUM -> {
                            5
                        }
                        else -> {
                            10
                        }
                    }
                } else {
                    it.score
                },

            )
        }
    }

    fun onNextClicked() {
        viewModelState.update {
            it.copy(
                currentIndex = it.currentIndex + 1,
                currentAnswer = "",
                options = countries.getOrNull(it.currentIndex + 1)?.answer.orEmpty().shuffleString(),
            )
        }
    }

    fun onHintClicked() {
        viewModelState.update {
            it.copy(
                showHint = !it.showHint,
            )
        }
    }

    fun removeLastWrongLetter() {
        viewModelState.update {
            it.copy(
                currentAnswer = it.currentAnswer.dropLast(1),
                currentWrong = false,
            )
        }
    }
}
