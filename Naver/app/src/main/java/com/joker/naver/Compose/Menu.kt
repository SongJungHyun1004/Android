package com.joker.naver.Compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joker.naver.R


@Composable
fun MenuIcon(
    colorMode: Color,
    img: @Composable () -> Unit,
    txt: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(45.dp)
                .shadow(elevation = 1.dp, RoundedCornerShape(15.dp))
                .clip(RoundedCornerShape(15.dp))
                .background(colorMode),
            contentAlignment = Alignment.Center,
        ) {
            img()
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = txt, fontSize = 11.sp)
    }
}

@Composable
fun Menu(
    colorMode: Color
) {
    Box(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .width(280.dp)
                .fillMaxHeight()
                .padding(start = 8.dp, top = 2.dp, bottom = 2.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    MenuIcon(
                        colorMode = colorMode,
                        img = {
                            Image(
                                painter = painterResource(id = R.drawable.news_pan),
                                contentDescription = "news_pan icon",
                                modifier = Modifier.size(30.dp),
                            )
                        },
                        txt = "뉴스판",
                    )
                    MenuIcon(
                        colorMode = colorMode,
                        img = {
                            Image(
                                painter = painterResource(id = R.drawable.showping_pan),
                                contentDescription = "showping_pan icon",
                                modifier = Modifier.size(30.dp),
                            )
                        },
                        txt = "쇼핑판",
                    )
                    MenuIcon(
                        colorMode = colorMode,
                        img = {
                            Image(
                                painter = painterResource(id = R.drawable.economy_pan),
                                contentDescription = "economy_pan icon",
                                modifier = Modifier.size(30.dp),
                            )
                        },
                        txt = "경제판",
                    )
                    MenuIcon(
                        colorMode = colorMode,
                        img = {
                            Image(
                                painter = painterResource(id = R.drawable.clip_pan),
                                contentDescription = "clip_pan icon",
                                modifier = Modifier.size(30.dp),
                            )
                        },
                        txt = "클립판",
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    MenuIcon(
                        colorMode = colorMode,
                        img = {
                            Image(
                                painter = painterResource(id = R.drawable.mail),
                                contentDescription = "mail icon",
                                modifier = Modifier.size(30.dp),
                            )
                        },
                        txt = "메일",
                    )
                    MenuIcon(
                        colorMode = colorMode,
                        img = {
                            Image(
                                painter = painterResource(id = R.drawable.cafe),
                                contentDescription = "cafe icon",
                                modifier = Modifier.size(30.dp),
                            )
                        },
                        txt = "카페",
                    )
                    MenuIcon(
                        colorMode = colorMode,
                        img = {
                            Image(
                                painter = painterResource(id = R.drawable.blog),
                                contentDescription = "blog icon",
                                modifier = Modifier.size(30.dp),
                            )
                        },
                        txt = "블로그",
                    )
                    MenuIcon(
                        colorMode = colorMode,
                        img = {
                            Image(
                                painter = painterResource(id = R.drawable.more),
                                contentDescription = "more icon",
                                modifier = Modifier.size(30.dp),
                            )
                        },
                        txt = "",
                    )
                }
            }
        }
    }
}