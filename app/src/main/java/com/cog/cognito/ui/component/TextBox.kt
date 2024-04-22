package com.cog.cognito.ui.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cog.cognito.data.model.AnswerTextBoxState
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.luckyGuyFont
import com.cog.cognito.ui.theme.size.Elevation
import kotlinx.coroutines.delay

@Composable
fun CognitoTextBoxSingleBorder(
    text: String,
    answerTextBoxState: AnswerTextBoxState,
    modifier: Modifier = Modifier,
    removeLastWrongLetter: () -> Unit,
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
        onClick = {
            if (answerTextBoxState == AnswerTextBoxState.FILLED_ERROR) {
                removeLastWrongLetter()
            }
        },
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

@Composable
fun CognitoTextBoxSplashBorder(
    text: String,
    modifier: Modifier = Modifier,
    count: Double = 1.0,
) {
    var targetState by remember { mutableStateOf(false) }
    var bounceStart by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState, label = "transition")
    val infiniteTransition = rememberInfiniteTransition()
    var rateOfChange = 0f
    var lastEasingValue = 0f
    var desiredEasing = 0f

    val shape = RoundedCornerShape(
        topStartPercent = 20,
        bottomEndPercent = 20,
        topEndPercent = 20,
        bottomStartPercent = 20,
    )
    LaunchedEffect(Unit) {
        delay((count * 1000).toLong())
        targetState = true
        delay(300)
        bounceStart = true
        delay(200)
        bounceStart = false
    }
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.7f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 200,
            ),

            repeatMode = RepeatMode.Reverse,
        ),
        label = "",
    )

    val borderColor by transition.animateColor(label = "color") { state ->
        when (state) {
            false -> CognitoColors.Primary_main
            true -> CognitoColors.Orange_main
        }
    }

    val backgroundColor by transition.animateColor(label = "color") { state ->
        when (state) {
            false -> CognitoColors.Primary_main
            true -> CognitoColors.Orange_main
        }
    }

    val paddingvalue by transition.animateDp(label = "padding") { state ->
        when (state) {
            false -> 0.dp
            true -> 5.dp
        }
    }

    val border = BorderStroke(
        width = 1.2.dp,
        color = borderColor,
    )

    Surface(
        onClick = {
        },
        modifier = modifier
            .width(39.dp)
            .height(45.dp),
        shape = shape,
        shadowElevation = Elevation.MEDIUM.size,
        border = border,

    ) {
        Surface(
            modifier = Modifier
                .width(36.dp)
                .height(43.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessVeryLow,
                    ),
                ).scale(if (bounceStart) scale else 1f)
                .padding(
                    paddingvalue,
                ),
            color = backgroundColor,
            shape = shape,
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,

            ) {
                Text(
                    text = text,
                    color = CognitoColors.Neutral_dark,
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    fontFamily = luckyGuyFont,
                    modifier = Modifier,
                    textAlign = TextAlign.Center,
                )
            }
        }
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
