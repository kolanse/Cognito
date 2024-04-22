package com.cog.cognito.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cog.cognito.data.model.AnswerBoxModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AnswerBoxComponent(
    answerBoxModels: List<AnswerBoxModel>,
    removeLastWrongLetter: () -> Unit,
) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center,
        maxItemsInEachRow = 6,
    ) {
        answerBoxModels.map { answerBoxModel ->
            Box(modifier = Modifier.padding(5.dp)) {
                CognitoTextBoxSingleBorder(
                    answerTextBoxState = answerBoxModel.answerTextBoxState,
                    text = answerBoxModel.input,
                    removeLastWrongLetter = {
                        removeLastWrongLetter()
                    }
                )
            }
        }
    }
}
