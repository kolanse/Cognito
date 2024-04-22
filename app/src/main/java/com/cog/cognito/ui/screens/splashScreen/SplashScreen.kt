package com.cog.cognito.ui.screens.splashScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cog.cognito.ui.component.CognitoTextBoxSplashBorder

@Composable
fun SplashScreen() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CognitoTextBoxSplashBorder(
            text = "C",
            modifier = Modifier,
        )
        Spacer(modifier = Modifier.width(10.dp))
        CognitoTextBoxSplashBorder(
            text = "O",
            modifier = Modifier.offset(x = 0.dp, y = -7.dp),
            count = 1.5,
        )
        Spacer(modifier = Modifier.width(10.dp))
        CognitoTextBoxSplashBorder(
            text = "G",
            modifier = Modifier.offset(x = 0.dp, y = -12.dp),
            count = 2.0,
        )
        Spacer(modifier = Modifier.width(10.dp))

        CognitoTextBoxSplashBorder(
            text = "N",
            modifier = Modifier.offset(x = 0.dp, y = -6.dp),
            count = 2.5,
        )
        Spacer(modifier = Modifier.width(10.dp))

        CognitoTextBoxSplashBorder(
            text = "I",
            modifier = Modifier.offset(x = 0.dp, y = -13.dp),
            count = 3.0,
        )
        Spacer(modifier = Modifier.width(10.dp))

        CognitoTextBoxSplashBorder(
            text = "T",
            modifier = Modifier.offset(x = 0.dp, y = -6.dp),
            count = 3.5,
        )
        Spacer(modifier = Modifier.width(10.dp))

        CognitoTextBoxSplashBorder(
            text = "0",
            modifier = Modifier,
            count = 4.0,
        )
    }
}
