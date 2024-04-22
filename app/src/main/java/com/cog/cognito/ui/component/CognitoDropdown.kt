package com.cog.cognito.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.cog.cognito.R
import com.cog.cognito.ui.theme.CognitoColors
import com.cog.cognito.ui.theme.comicSansFont
import com.cog.cognito.ui.theme.size.Elevation

@Composable
fun CognitoDropDown(
    strings: List<String>,
    selected: String,
    onItemClick: (string: String) -> Unit,
) {
    var showDropdown by rememberSaveable { mutableStateOf(true) }
    val shape = RoundedCornerShape(
        topStartPercent = 50,
        bottomEndPercent = 50,
        topEndPercent = 50,
        bottomStartPercent = 50,
    )

    Box {
        Box {
            PlaceHolderShadow(
                selected = selected,
                shape = shape,
            )
            Surface(
                modifier = Modifier
                    .wrapContentSize()
                    .wrapContentHeight(),

                color = CognitoColors.Green_main,
                shape = shape,
                shadowElevation = Elevation.HIGH.size,
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(
                            vertical = 10.dp,
                            horizontal = 20.dp,
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = selected,
                        fontFamily = comicSansFont,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = CognitoColors.white,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Image(
                        painter = painterResource(id = R.drawable.arrow_down),
                        contentDescription = "",
                    )
                }
            }
        }
    }
}

@Composable
private fun DropDownList(
    showDropdown: Boolean,
    strings: List<String>,
    selected: String,
    onDismissRequest: (() -> Unit),
    onItemClick: (string: String) -> Unit,
) {
    val scrollState = rememberScrollState()

    if (showDropdown) {
        Popup(
            alignment = Alignment.TopCenter,
            properties = PopupProperties(
                excludeFromSystemGesture = true,
            ),
            // to dismiss on click outside
            onDismissRequest = { onDismissRequest() },
        ) {
            Column(
                modifier = Modifier
                    .heightIn(max = 90.dp)
                    .verticalScroll(state = scrollState)
                    .border(width = 1.dp, color = Color.Gray),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                strings.onEachIndexed { index, item ->
                    if (index != 0) {
                        Divider(thickness = 1.dp, color = Color.LightGray)
                    }
                    Box(
                        modifier = Modifier
                            .background(Color.Green)
                            .fillMaxWidth()
                            .clickable {
                                onItemClick(item)
                                onDismissRequest()
                            },
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(text = item)
                    }
                }
            }
        }
    }
}

@Composable
private fun PlaceHolderShadow(
    selected: String,
    shape: RoundedCornerShape,
) {
    Surface(
        modifier = Modifier
            .wrapContentSize()
            .wrapContentHeight()
            .offset(
                x = 0.dp,
                y = 4.dp,
            ),

        color = CognitoColors.Green_dark,
        shape = shape,
        shadowElevation = Elevation.HIGH.size,
    ) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(
                    vertical = 10.dp,
                    horizontal = 20.dp,
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = selected,
                fontFamily = comicSansFont,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = CognitoColors.white,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Image(
                painter = painterResource(id = R.drawable.arrow_down),
                contentDescription = "",
            )
        }
    }
}
