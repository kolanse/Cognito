package com.cog.cognito.ui.screens.setup.gameoption

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cog.cognito.ui.component.CognitoSelector
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.comicSansFont

@Composable
fun GameOptionScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GameOptionSelector(
            text = "Category",
            options = listOf("Country", "Music", "Music"),
            selectedOption = "Country",
            onOptionSelected = {},
        )
    }
}

@Composable
private fun GameOptionSelector(
    text: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
) {
    val shape = RoundedCornerShape(percent = 20)

    Surface(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(70.dp),
        shape = shape,
        color = CognitoColors.Black_20_percent_transparency,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Category",
                color = CognitoColors.white,
                fontWeight = FontWeight.W700,
                fontSize = 24.sp,
                fontFamily = comicSansFont,
                modifier = Modifier.padding(horizontal = 10.dp),
            )

            CognitoSelector(
                strings = options,
                selected = selectedOption,
                onOptionSelected = onOptionSelected,
            )
        }
    }
}
