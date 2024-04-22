package com.cog.cognito.ui.screens.setup.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cog.cognito.ui.component.CognitoLongFormButton

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CognitoLongFormButton(
            text = "Play",
            onClick = {},
        )

        Spacer(modifier = Modifier.height(30.dp))
        CognitoLongFormButton(
            text = "Mode",
            onClick = {},
        )
    }
}
