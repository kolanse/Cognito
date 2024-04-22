package com.cog.cognito.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.comicSansFont

@Composable
fun CognitoSelector(
    strings: List<String>,
    selected: String,
    onOptionSelected: (string: String) -> Unit,
) {
    Row(
        modifier = Modifier
            .wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier.size(30.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_arrow_vector),
                contentDescription = "Selector",
                tint = CognitoColors.Green_main,
            )
        }
        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = selected,
            fontFamily = comicSansFont,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            color = CognitoColors.Primary_main,
        )
        Spacer(modifier = Modifier.width(5.dp))
        IconButton(
            onClick = {},
            modifier = Modifier.size(30.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.forward_arrow_vector),
                contentDescription = "Selector",
                tint = CognitoColors.Green_main,

            )
        }
    }
}
