package com.cog.cognito.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.comicSansFont
import com.cog.cognito.ui.theme.size.Elevation

@Composable
fun CognitoHintBox(
    hints: List<String>,
) {
    val shape = RoundedCornerShape(
        topStartPercent = 12,
        bottomEndPercent = 12,
        topEndPercent = 12,
        bottomStartPercent = 0,
    )

    Box {
        Surface(
            modifier = Modifier
                .width(172.dp)
                .wrapContentHeight()
                .offset(
                    x = 6.dp,
                    y = 10.dp,
                ),
            color = CognitoColors.Secondary_main,
            shape = shape,
            shadowElevation = Elevation.HIGH.size,
        ) {
            HintText(hints = hints)
        }

        Surface(
            modifier = Modifier
                .width(178.dp)
                .wrapContentHeight()
                .padding(5.dp),
            color = CognitoColors.white,
            shape = shape,
            shadowElevation = Elevation.HIGH.size,
        ) {
            HintText(hints = hints)
        }
    }
}

@Composable
private fun HintText(
    hints: List<String>,
) {
    Column(
        modifier = Modifier.padding(10.dp),
    ) {
        Text(
            text = "Hint:",
            color = CognitoColors.Orange_main,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            fontFamily = comicSansFont,
            modifier = Modifier
                .wrapContentSize(),
        )
        Spacer(modifier = Modifier.height(6.dp))
        hints.map { hint ->
            Text(
                text = hint,
                color = CognitoColors.Neutral_dark,
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                fontFamily = comicSansFont,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(bottom = 5.dp),
            )
        }
    }
}
