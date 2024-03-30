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
                Spacer(modifier = Modifier.height(70.dp))
                SearchBar(colorMode)
                Spacer(modifier = Modifier.height(20.dp))
                Menu()
                Spacer(modifier = Modifier.height(70.dp))
                BannerAds()
                Spacer(modifier = Modifier.height(10.dp))
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
                .width(380.dp)
                .border(
                    BorderStroke(1.dp, SolidColor(GreenDot_Green)),
                    shape = RoundedCornerShape(30.dp),
                )
                .background(Color.Transparent, RoundedCornerShape(30.dp)),
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
//                Button(onClick = { /* 버튼 클릭 시 수행할 작업 */ },
//                    modifier = Modifier.width(200.dp).background(color = Color.Cyan), // 버튼을 최대 너비로 설정
//                    contentPadding = PaddingValues(end = 16.dp) // 버튼의 오른쪽 패딩 조절
//                ) {
//                    Text("버튼",
//                        modifier = Modifier.fillMaxWidth(), // 텍스트를 최대 너비로 설정
//                        textAlign = TextAlign.Start // 텍스트를 오른쪽 정렬
//                    )
//                }
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
fun Menu() {
    Box(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .background(color = Color.Green),
    ) {
        Text(text = "Menu")
    }
}

@Composable
fun BannerAds() {
    Box(
        modifier = Modifier
            .height(110.dp)
            .fillMaxWidth()
            .background(color = Color.Green),
    ) {
        Text(text = "Banner Ad")
    }
}

@Composable
fun Weather() {
    Box(
        modifier = Modifier
            .height(85.dp)
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