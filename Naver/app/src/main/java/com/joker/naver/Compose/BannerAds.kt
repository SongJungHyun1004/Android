package com.joker.naver.Compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.joker.naver.R

@Composable
fun BannerAds() {
    Box(
        modifier = Modifier
            .height(110.dp)
            .fillMaxWidth()
            .padding(top = 5.dp, start = 5.dp),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "banner ad",
            modifier = Modifier
                .fillMaxHeight()
                .width(400.dp),
        )
    }
}