package com.joker.naver.Compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.joker.naver.R

@Composable
fun Content(
    colorMode: Color,
) {
    Box(
        modifier = Modifier
            .height(130.dp)
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .shadow(elevation = 1.dp, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(color = colorMode),
            contentAlignment = Alignment.Center,
        ) {
            Row (
                modifier = Modifier.padding(15.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column (
                    modifier = Modifier.width(200.dp),
                ) {
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(3.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bbom_icon),
                            contentDescription = "content icon",
                            modifier = Modifier.size(25.dp)
                        )
                        Text(text = "베스트 뿜", fontWeight = FontWeight.SemiBold)
                        Box(
                            modifier = Modifier
                                .width(0.8.dp)
                                .height(11.dp)
                                .background(Color.LightGray)
                        )
                        Text(text = "3일 전", color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "의외로 헌혈 전에 먹으면 안되는 음식", fontWeight = FontWeight.SemiBold)
                }
                Image(
                    painter = painterResource(id = R.drawable.bbom_content),
                    contentDescription = "content image",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}