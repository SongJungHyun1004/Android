package com.joker.naver.Compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joker.naver.R


@Composable
fun InfoCard(
    colorMode: Color,
    title: String,
    titleColor: Color? = null,
    descript: String,
    subTxt: @Composable (() -> Unit)? = null,
    img: @Composable (() -> Unit)? = null,
) {
    Box(
        modifier = Modifier
            .width(186.dp)
            .fillMaxHeight()
            .shadow(elevation = 1.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(color = colorMode),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(text = title, color = titleColor ?: Color.Unspecified, fontWeight = FontWeight.Bold)
                Row {
                    Text(text = descript, fontSize = 12.sp)
                    subTxt?.invoke()
                }
            }
            img?.invoke()
        }
    }
}

@Composable
fun Weather(
    colorMode: Color
) {
    Box(
        modifier = Modifier
            .height(81.dp)
            .fillMaxWidth(),
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
        ) {
            item {
                InfoCard(
                    colorMode,
                    title = "20.9° 대전",
                    descript = "어제보다 2.4° 낮아요",
                    img = {
                        Image(
                            painter = painterResource(id = R.drawable.sunny),
                            contentDescription = "sunny",
                            modifier = Modifier.size(40.dp),
                        )
                    },
                )
                Spacer(modifier = Modifier.width(7.dp))
                InfoCard(
                    colorMode,
                    title = "47보통",
                    titleColor = Color(0xFF0DC624),
                    descript = "미세먼지",
                    img = {
                        Image(
                            painter = painterResource(id = R.drawable.fine_dust),
                            contentDescription = "fine dust",
                            modifier = Modifier.size(40.dp),
                        )
                    },
                )
                Spacer(modifier = Modifier.width(7.dp))
                InfoCard(
                    colorMode,
                    title = "1,355.00",
                    descript = "환율 USD", // ▲▼
                    subTxt = {
                        Text(text = "▼0.04%", fontSize = 12.sp, color = Color(0xFF4283F6))
                    },
                )
            }
        }
    }
}
