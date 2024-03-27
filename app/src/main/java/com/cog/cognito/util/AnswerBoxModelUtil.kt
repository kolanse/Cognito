package com.cog.cognito.util

import com.cog.cognito.data.model.AnswerBoxModel
import com.cog.cognito.data.model.AnswerTextBoxState


fun String.toAnswerBoxModel(currentAnswer: String): List<AnswerBoxModel>{

    val answerBoxes = mutableListOf<AnswerBoxModel>()


    for (position in 0 until currentAnswer.length){
        if (currentAnswer[position].equals(this.getOrNull(position))){
            answerBoxes.add(
                AnswerBoxModel(
                    input = this[position].toString(),
                    answerTextBoxState = AnswerTextBoxState.FILLED_CORRECT
                )
            )
        } else if (currentAnswer[position].equals(this.getOrNull(position)) && this.getOrNull(position) == null){
            answerBoxes.add(
                AnswerBoxModel(
                    input = "",
                    answerTextBoxState = AnswerTextBoxState.EMPTY
                )
            )
        }else if (currentAnswer[position].equals(this.getOrNull(position)) && this.getOrNull(position) != null){
            answerBoxes.add(
                AnswerBoxModel(
                    input = this[position].toString(),
                    answerTextBoxState = AnswerTextBoxState.FILLED_ERROR
                )
            )
        }
    }



   return  answerBoxes
}