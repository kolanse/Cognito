package com.cog.cognito.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cog.cognito.R
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.comicSansFont
import com.cog.cognito.ui.theme.size.Elevation

@Composable
fun CognitoScore(
    point: String,
) {
    val shape = RoundedCornerShape(
        topStartPercent = 50,
        bottomEndPercent = 50,
        topEndPercent = 50,
        bottomStartPercent = 50,
    )

    Box {
        Surface(
            modifier = Modifier
                .height(28.dp)
                .width(78.dp)
                .offset(x = 0.dp, y = 3.dp),
            color = CognitoColors.Green_dark,
            shape = shape,
            shadowElevation = Elevation.MEDIUM.size,
        ) {}

        Surface(
            modifier = Modifier
                .height(28.dp)
                .width(78.dp),
            color = CognitoColors.Green_main,
            shape = shape,
            shadowElevation = Elevation.MEDIUM.size,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(R.drawable.coin),
                    contentDescription = "",
                )
                Spacer(modifier = Modifier.width(9.dp))
                Text(
                    text = "+$point",
                    color = CognitoColors.white,
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp,
                    fontFamily = comicSansFont,
                    modifier = Modifier.wrapContentSize(),

                )
            }
        }
    }
}
