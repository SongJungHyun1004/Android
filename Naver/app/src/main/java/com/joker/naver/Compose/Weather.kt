package com.joker.naver.Compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Weather(
    colorMode: Color
) {
    Box(
        modifier = Modifier
            .height(81.dp)
            .fillMaxWidth(),
    ) {
        LazyRow (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
        ) {
            items(3) { index ->
                Box(
                    modifier = Modifier
                        .width(186.dp)
                        .fillMaxHeight()
                        .shadow(elevation = 1.dp, RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = colorMode)
                ) {
                    Text(text = "Temperature")
                }
            }
        }
    }
}
