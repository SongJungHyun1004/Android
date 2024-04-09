package com.joker.naver.Compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Content(
    text: String
) {
    Box(
        modifier = Modifier
            .height(130.dp)
            .fillMaxWidth()
            .background(color = Color.Green),
    ) {
        Text(text = text)
    }
}