package com.cog.cognito.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cog.cognito.data.model.ImagePlacement
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.comicSansFont
import com.cog.cognito.ui.theme.luckyGuyFont
import com.cog.cognito.ui.theme.size.Elevation

@Composable
fun CognitoLongFormButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val colors = listOf(CognitoColors.Button_bottom_gradient, CognitoColors.Button_bottom_gradient)
    val brush = Brush.verticalGradient(colors)
    val border = RoundedCornerShape(
        topStartPercent = 10,
        bottomEndPercent = 10,
        topEndPercent = 30,
        bottomStartPercent = 30,
    )

    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(64.dp)
            .shadow(
                ambientColor = CognitoColors.Orange_shadow,
                spotColor = CognitoColors.Orange_shadow,
                elevation = Elevation.MEDIUM.size,
            ),
        color = CognitoColors.Button_bottom_gradient,
        shape = border,
        shadowElevation = Elevation.MEDIUM.size,
    ) {
        Text(
            text = text,
            color = CognitoColors.white,
            fontWeight = FontWeight.W400,
            fontSize = 32.sp,
            fontFamily = luckyGuyFont,
            modifier = Modifier.wrapContentSize(),
            style = MaterialTheme.typography.headlineLarge.copy(
                shadow = Shadow(
                    color = CognitoColors.Orange_shadow,
                    offset = Offset(4f, 4f),
                    blurRadius = 8f,
                ),
            ),

        )
    }
}

@Composable
fun CognitoShortFormButton(
    modifier: Modifier = Modifier,
    imagePlacement: ImagePlacement,
    text: String,
    imageResource: Int,
    color: Color,
    onClick: () -> Unit,
) {
    val border = RoundedCornerShape(
        topStartPercent = 10,
        bottomEndPercent = 10,
        topEndPercent = 30,
        bottomStartPercent = 30,
    )
    Surface(
        onClick = onClick,
        modifier = modifier
            .wrapContentSize(),
        color = color,
        shape = border,
        shadowElevation = Elevation.MEDIUM.size,
    ) {
        when (imagePlacement) {
            ImagePlacement.START -> {
                Row(
                    modifier = Modifier
                        .padding(
                            vertical = 10.dp,
                            horizontal = 7.dp,
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = "",
                    )
                    Spacer(modifier = Modifier.width(9.dp))
                    Text(
                        text = text,
                        color = CognitoColors.white,
                        fontWeight = FontWeight.W400,
                        fontSize = 12.sp,
                        fontFamily = comicSansFont,
                        modifier = Modifier.wrapContentSize(),

                    )
                }
            }

            ImagePlacement.END -> {
                Row(
                    modifier = Modifier
                        .padding(
                            vertical = 10.dp,
                            horizontal = 7.dp,
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = text,
                        color = CognitoColors.white,
                        fontWeight = FontWeight.W400,
                        fontSize = 12.sp,
                        fontFamily = comicSansFont,
                        modifier = Modifier.wrapContentSize(),
                    )
                    Spacer(modifier = Modifier.width(9.dp))

                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = "",
                    )
                }
            }
        }
    }
}
