package com.cog.cognito.ui.screens.gameInterface

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cog.cognito.R
import com.cog.cognito.data.model.AnswerBoxModel
import com.cog.cognito.data.model.AnswerTextBoxState
import com.cog.cognito.data.model.ImagePlacement
import com.cog.cognito.ui.component.AnswerBoxComponent
import com.cog.cognito.ui.component.CognitoShortFormButton
import com.cog.cognito.ui.component.OptionsBox
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.comicSansFont
import com.cog.cognito.ui.theme.luckyGuyFont

@Composable
fun GameInterfaceScreen() {
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
                score = "22",
            )
            Spacer(modifier = Modifier.height(20.dp))
            Title(
                title = "Guess what country",
            )
            Spacer(modifier = Modifier.height(10.dp))

            AnswerBoxComponent(
                answerBoxModels = (0..10).map {
                    AnswerBoxModel(
                        input = "P",
                        answerTextBoxState = AnswerTextBoxState.SUCCESS,
                    )
                },
            )
            Spacer(modifier = Modifier.height(20.dp))

            Box {
                OptionsBox(
                    options = (0..10).map {
                        "P"
                    },
                    onClick = {},
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CognitoShortFormButton(
                imagePlacement = ImagePlacement.START,
                text = "Hint",
                imageResource = R.drawable.hint,
                color = CognitoColors.Secondary_main,
                onClick = {},
            )

            CognitoShortFormButton(
                imagePlacement = ImagePlacement.END,
                text = "Next",
                imageResource = R.drawable.next,
                color = CognitoColors.Green_main,
                onClick = {},
            )
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
    ) {
        IconButton(
            modifier = Modifier,
            onClick = onClick,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back Button",
                tint = CognitoColors.white,
            )
        }

        Column(
            modifier = Modifier
                .padding(vertical = 10.dp),
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
