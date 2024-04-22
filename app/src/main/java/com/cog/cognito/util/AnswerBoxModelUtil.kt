package com.cog.cognito.util

import com.cog.cognito.data.model.AnswerBoxModel
import com.cog.cognito.data.model.AnswerTextBoxState

fun String.toAnswerBoxModel(establishedAnswer: String): List<AnswerBoxModel> {
    val answerBoxes = mutableListOf<AnswerBoxModel>()

    for (position in 0 until establishedAnswer.length) {
        if (establishedAnswer[position].equals(this.getOrNull(position))) {
            answerBoxes.add(
                AnswerBoxModel(
                    input = this[position].toString(),
                    answerTextBoxState = AnswerTextBoxState.FILLED_CORRECT,
                ),
            )
        } else if (this.getOrNull(position) == null) {
            answerBoxes.add(
                AnswerBoxModel(
                    input = "",
                    answerTextBoxState = AnswerTextBoxState.EMPTY,
                ),
            )
        } else if (establishedAnswer[position] != this.getOrNull(position) && this.getOrNull(position) != null) {
            answerBoxes.add(
                AnswerBoxModel(
                    input = this[position].toString(),
                    answerTextBoxState = AnswerTextBoxState.FILLED_ERROR,
                ),
            )
        }
    }

    return answerBoxes
}
