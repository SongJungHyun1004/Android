package com.joker.naver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Paid
import androidx.compose.material.icons.outlined.Sms
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joker.naver.ui.theme.GreenDot_Gradient
import com.joker.naver.ui.theme.GreenDot_Green
import com.joker.naver.ui.theme.NaverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NaverTheme {
                // A surface container using the 'background' color from the theme
                val colorMode = MaterialTheme.colorScheme.surface
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(colorMode)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    colorMode: Color
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Column {
                TopBar()
                Spacer(modifier = Modifier.height(65.dp))
                SearchBar(colorMode)
                Spacer(modifier = Modifier.height(20.dp))
                Menu(colorMode)
                Spacer(modifier = Modifier.height(65.dp))
                BannerAds()
                Spacer(modifier = Modifier.height(7.dp))
                Weather()
            }
        }
        items(5) { index ->
            Content(text = "content $index")
        }
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterStart,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            val iconSize = 40.dp
            Row(
                modifier = Modifier.padding(start = 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = "menu",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(horizontal = 5.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.Paid,
                    contentDescription = "pay",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(horizontal = 5.dp)
                )
            }
            Row(
                modifier = Modifier.padding(end = 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Sms,
                    contentDescription = "talk",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(horizontal = 5.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "notify",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(horizontal = 5.dp)
                )
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "account",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(horizontal = 5.dp)
                )
            }
        }
    }
}

@Composable
fun SearchBar(
    colorMode: Color
) {
    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .height(55.dp)
                .width(370.dp)
                .border(
                    BorderStroke(1.dp, SolidColor(GreenDot_Green)),
                    shape = RoundedCornerShape(30.dp),
                )
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(30.dp))
                .background(colorMode, RoundedCornerShape(30.dp)),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Row {
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.naver_logo),
                        contentDescription = "naver logo",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
                Button(
                    modifier = Modifier
                        .width(260.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Gray.copy(alpha = 0.7f)
                    ),
                    contentPadding = PaddingValues(start = 0.dp)
                ) {
                    Text(
                        text = "검색어를 입력해주세요.",
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start,
                    )
                }
                val brush = Brush.linearGradient(GreenDot_Gradient)
                Canvas(
                    modifier = Modifier
                        .size(30.dp),
                    onDraw = {
                        drawCircle(brush)
                        drawCircle(color = colorMode, radius = 18f)
                    }
                )
            }
        }
    }
}

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
                .background(color = colorMode) // colorMode
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

@Composable
fun Weather() {
    Box(
        modifier = Modifier
            .height(81.dp)
            .fillMaxWidth()
            .background(color = Color.Green),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .fillMaxHeight()
                    .background(color = Color.LightGray)
            ) {
                Text(text = "Temperature")
            }
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .fillMaxHeight()
                    .background(color = Color.LightGray)
            ) {
                Text(text = "Dust")
            }
        }
    }
}

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
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NaverTheme {
//        Greeting("Android")
//    }
//}