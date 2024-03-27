package com.cog.cognito.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cog.cognito.data.model.AnswerTextBoxState
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.luckyGuyFont
import com.cog.cognito.ui.theme.size.Elevation

@Composable
fun CognitoTextBoxSingleBorder(
    text: String,
    answerTextBoxState: AnswerTextBoxState,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(
        topStartPercent = 20,
        bottomEndPercent = 20,
        topEndPercent = 20,
        bottomStartPercent = 20,
    )

    val border = BorderStroke(
        width = 1.2.dp,
        color = answerTextBoxState.getBorderColor(),
    )


    Surface(
        modifier = modifier
            .width(46.dp)
            .height(56.dp),
        shape = shape,
        shadowElevation = Elevation.MEDIUM.size,
        border = border,

    ) {
        Surface(
            modifier = Modifier
                .width(40.dp)
                .height(50.dp)
                .padding(5.dp),
            color = answerTextBoxState.getBackgroundColor(),
            shape = shape,
        ) {
            Text(
                text = text,
                color = CognitoColors.Neutral_dark,
                fontWeight = FontWeight.W400,
                fontSize = 24.sp,
                fontFamily = luckyGuyFont,
                modifier = Modifier
                    .wrapContentSize(),
            )
        }
    }
}

@Composable
fun CognitoTextBoxOptions(
    text: String,
    onClick: () -> Unit,
) {
    val shape = RoundedCornerShape(
        topStartPercent = 20,
        bottomEndPercent = 20,
        topEndPercent = 20,
        bottomStartPercent = 20,
    )

    Surface(
        onClick = onClick,
        modifier = Modifier
            .width(46.dp)
            .height(52.dp)
            .shadow(
                ambientColor = CognitoColors.Black_shadow,
                spotColor = CognitoColors.Black_shadow,
                elevation = Elevation.HIGH.size,
            ),
        color = CognitoColors.Primary_main,
        shape = shape,
        shadowElevation = Elevation.HIGH.size,
    ) {
        Text(
            text = text,
            color = CognitoColors.Neutral_dark,
            fontWeight = FontWeight.W400,
            fontSize = 24.sp,
            fontFamily = luckyGuyFont,
            modifier = Modifier.wrapContentSize(),
        )
    }
}

private fun AnswerTextBoxState.getBackgroundColor(): Color {
    return when (this) {
        AnswerTextBoxState.EMPTY -> Color.Transparent
        AnswerTextBoxState.FILLED_CORRECT -> CognitoColors.Orange_main
        AnswerTextBoxState.FILLED_ERROR -> CognitoColors.Error_light
        AnswerTextBoxState.SUCCESS -> CognitoColors.Success_light
    }
}

private fun AnswerTextBoxState.getBorderColor(): Color {
    return when (this) {
        AnswerTextBoxState.EMPTY -> CognitoColors.Empty_textbox_single_border
        AnswerTextBoxState.FILLED_CORRECT -> CognitoColors.Orange_main
        AnswerTextBoxState.FILLED_ERROR -> CognitoColors.Error_main
        AnswerTextBoxState.SUCCESS -> CognitoColors.Secondary_main
    }
}
