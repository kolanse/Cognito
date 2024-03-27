package com.cog.cognito.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.size.Elevation

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OptionsBox(
    options: List<String>,
    onClick: (String) -> Unit,
) {
    val shape = RoundedCornerShape(
        topStartPercent = 10,
        bottomEndPercent = 10,
        topEndPercent = 10,
        bottomStartPercent = 10,
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
        color = CognitoColors.Tile_Bg_color,
        shape = shape,
        shadowElevation = Elevation.HIGH.size,
    ) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalArrangement = Arrangement.Center,
            maxItemsInEachRow = 6,
        ) {
            options.map { option ->
                Box(modifier = Modifier.padding(8.dp)) {
                    CognitoTextBoxOptions(
                        text = option,
                        onClick = {
                            onClick(option)
                        },
                    )
                }
            }
        }
    }
}
