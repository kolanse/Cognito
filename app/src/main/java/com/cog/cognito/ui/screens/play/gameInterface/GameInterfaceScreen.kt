package com.cog.cognito.ui.screens.play.gameInterface

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.cog.cognito.R
import com.cog.cognito.data.model.ImagePlacement
import com.cog.cognito.ui.component.AnswerBoxComponent
import com.cog.cognito.ui.component.CognitoHintBox
import com.cog.cognito.ui.component.CognitoLongFormButton
import com.cog.cognito.ui.component.CognitoScore
import com.cog.cognito.ui.component.CognitoShortFormButton
import com.cog.cognito.ui.component.OptionsBox
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.comicSansFont
import com.cog.cognito.ui.theme.luckyGuyFont
import com.cog.cognito.ui.theme.size.Elevation

@Composable
fun GameInterfaceScreen(
    viewModel: GameInterfaceViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()
    Log.d("THEANSS", "THE BOX ${uiState.answerBoxModels}")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 15.dp,
                end = 15.dp,
                bottom = 15.dp,

            ),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
        ) {
            TopBar(
                onClick = { },
                score = uiState.score,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Title(
                title = uiState.title,
            )
            Spacer(modifier = Modifier.height(10.dp))

            AnswerBoxComponent(
                answerBoxModels = uiState.answerBoxModels,
                removeLastWrongLetter = {
                    viewModel.removeLastWrongLetter()
                },
            )
            Spacer(modifier = Modifier.height(20.dp))

            Box {
                OptionsBox(
                    options = uiState.options,
                    onClick = { option ->
                        viewModel.onOptionSelected(option)
                    },

                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd),
        ) {
            if (uiState.showHint) {
                Row {
                    Spacer(modifier = Modifier.width(30.dp))
                    CognitoHintBox(
                        hints = uiState.hints,
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CognitoShortFormButton(
                    imagePlacement = ImagePlacement.START,
                    text = "Hint",
                    imageResource = R.drawable.hint,
                    color = CognitoColors.Secondary_main,
                    onClick = {
                        viewModel.onHintClicked()
                    },
                )

                CognitoShortFormButton(
                    imagePlacement = ImagePlacement.END,
                    text = "Next",
                    imageResource = R.drawable.next,
                    color = CognitoColors.Green_main,
                    onClick = {
                        viewModel.onNextClicked()
                    },
                )
            }
        }
        if (uiState.showSuccessDialog) {
            Dialog(onDismissRequest = { }) {
                SuccessDialog(
                    modifier = Modifier.align(Alignment.Center),
                    successMessage = uiState.successMessage,
                    point = uiState.questionPoint,
                    onContinueClicked = { viewModel.onNextClicked() },
                )
            }
        }
    }
}

@Composable
private fun TopBar(
    onClick: () -> Unit,
    score: String,
) {
    Row(
        modifier =
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Score",
                fontFamily = comicSansFont,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                color = CognitoColors.Green_main,
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.sun),
                    contentDescription = "",
                )

                Text(
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    text = score,
                    fontFamily = luckyGuyFont,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W400,
                    color = CognitoColors.white,
                )
                Image(
                    painter = painterResource(R.drawable.info),
                    contentDescription = "",
                )
            }
        }
    }
}

@Composable
private fun Title(
    title: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 10.dp),
            text = title,
            fontFamily = comicSansFont,
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
            color = CognitoColors.white,
        )
        Image(
            painter = painterResource(R.drawable.flag),
            contentDescription = "",
        )
    }
}

@Composable
private fun SuccessDialog(
    modifier: Modifier,
    successMessage: String,
    point: String,
    onContinueClicked: () -> Unit,
) {
    val shape = RoundedCornerShape(
        topStartPercent = 10,
        bottomEndPercent = 10,
        topEndPercent = 10,
        bottomStartPercent = 10,
    )

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            color = CognitoColors.Tile_Bg_color,
            shape = shape,
            shadowElevation = Elevation.HIGH.size,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Awesome!",
                    color = CognitoColors.Orange_main,
                    fontWeight = FontWeight.W400,
                    fontSize = 24.sp,
                    fontFamily = luckyGuyFont,
                    modifier = Modifier.wrapContentSize(),
                    style = MaterialTheme.typography.headlineLarge.copy(
                        shadow = Shadow(
                            color = CognitoColors.Black,
                            offset = Offset(0f, 5f),
                            blurRadius = 6f,
                        ),
                    ),
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = successMessage,
                    color = CognitoColors.white,
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    fontFamily = comicSansFont,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(15.dp))

                CognitoScore(
                    point = point,
                )

                Spacer(modifier = Modifier.height(20.dp))
                CognitoLongFormButton(
                    text = "Continue",
                    onClick = { onContinueClicked() },
                )
            }
        }
    }
}
