package com.cog.cognito

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cog.cognito.ui.component.CognitoCheckbox
import com.cog.cognito.ui.component.CognitoDropDown
import com.cog.cognito.ui.screens.play.gameInterface.GameInterfaceScreen
import com.cog.cognito.ui.screens.play.gameInterface.GameInterfaceViewModel
import com.cog.cognito.ui.screens.setup.gameoption.GameOptionScreen
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.CognitoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: GameInterfaceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CognitoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CognitoColors.Background_screen_dark,
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        GameOptionScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CognitoTheme {
        Greeting("Android")
    }
}
