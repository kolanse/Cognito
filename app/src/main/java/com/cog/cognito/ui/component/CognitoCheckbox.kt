package com.cog.cognito.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.comicSansFont
import com.cog.cognito.ui.theme.size.Elevation

@Composable
fun CognitoCheckbox(
    onCheckBoxClicked: (Boolean) -> Unit,
    initValue: Boolean
) {
    var isEnabled by rememberSaveable { mutableStateOf(initValue) }
    val shape = RoundedCornerShape(
        topStartPercent = 50,
        bottomEndPercent = 50,
        topEndPercent = 50,
        bottomStartPercent = 50,
    )

    val backgroundColor = if (isEnabled) CognitoColors.Green_main else CognitoColors.Secondary_light
    val shadowColor = if (isEnabled) CognitoColors.Green_dark else CognitoColors.Secondary_dark

    val knobBackgroundColor = if (isEnabled) CognitoColors.Green_dark else CognitoColors.Secondary_dark
    val knobShadowColor = if (isEnabled) CognitoColors.Green_light else CognitoColors.Secondary_light

    val text = if (isEnabled) "ON" else "OFF"
    Box(
        modifier = Modifier.clickable {
            isEnabled = !isEnabled
        },
    ) {
        PlaceHolderShadow(
            shape = shape,
            backgroundColor = shadowColor,
        )
        Surface(
            modifier = Modifier
                .width(110.dp)
                .height(45.dp),

            color = backgroundColor,
            shape = shape,
            shadowElevation = Elevation.HIGH.size,
        ) {
            Row(
                modifier = Modifier
                    .matchParentSize()
                    .padding(
                        vertical = 2.dp,
                        horizontal = 4.dp,
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (isEnabled) {
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = text,
                        fontFamily = comicSansFont,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = CognitoColors.white,
                    )
                    Knob(
                        backgroundColor = knobBackgroundColor,
                        outerColor = knobShadowColor,
                    )
                } else {
                    Knob(
                        backgroundColor = knobBackgroundColor,
                        outerColor = knobShadowColor,
                    )
                    Text(
                        text = text,
                        fontFamily = comicSansFont,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = CognitoColors.white,
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
    }
}

@Composable
private fun PlaceHolderShadow(
    shape: RoundedCornerShape,
    backgroundColor: Color,
) {
    Surface(
        modifier = Modifier
            .width(110.dp)
            .height(45.dp)
            .offset(
                x = 0.dp,
                y = 4.dp,
            ),

        color = backgroundColor,
        shape = shape,
        shadowElevation = Elevation.HIGH.size,
    ) {
    }
}

@Composable
private fun Knob(
    backgroundColor: Color,
    outerColor: Color,
) {
    Surface(
        modifier = Modifier
            .width(32.dp)
            .height(32.dp)
            .shadow(
                ambientColor = CognitoColors.Black_shadow,
                spotColor = CognitoColors.Black_shadow,
                elevation = Elevation.MEDIUM.size,
            ),

        color = outerColor,
        shape = CircleShape,
        shadowElevation = Elevation.HIGH.size,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Surface(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),

                color = backgroundColor,
                shape = CircleShape,
                shadowElevation = 0.dp,
            ) {
            }
        }
    }
}
