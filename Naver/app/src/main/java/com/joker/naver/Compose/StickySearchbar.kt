package com.joker.naver.Compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joker.naver.R
import com.joker.naver.ui.theme.GreenDot_Gradient
import kotlinx.coroutines.launch

@Composable
fun StickySearchBar (
    colorMode: Color
) {
    val items = listOf("fashionbeauty", "presentshop", "d2c", "shoppinglive", "shopping", "home", "news", "entertainment", "sports", "shoppingtoday", "economy")
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var doAnimate by remember { mutableStateOf(false) }
    val density = LocalDensity.current
    LaunchedEffect(key1 = true) {
        doAnimate = true
        coroutineScope.launch {
//            listState.scrollToItem(items.indexOf("home"))
            val additionalOffset = with(density) { 175.dp.roundToPx() }
            listState.scrollBy(additionalOffset.toFloat())
        }
    }

    Box(
        modifier = Modifier
            .height(112.dp)
            .fillMaxWidth()
            .background(colorMode),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Row(
                modifier = Modifier
                    .height(57.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                AnimatedVisibility(
                    visible = doAnimate,
                    enter = scaleIn(
                        animationSpec = tween(durationMillis = 300)
                    ),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.naver_logo),
                        contentDescription = "naver logo",
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
                if (!doAnimate) {
                    Box(modifier = Modifier.size(25.dp))
                }

                Button(
                    modifier = Modifier
                        .width(290.dp),
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Gray.copy(alpha = 0.5f)
                    ),
                    contentPadding = PaddingValues(start = 0.dp)
                ) {
                    Text(
                        text = "검색어를 입력해주세요.",
                        fontSize = 19.sp,
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
            val menuTxtColor = Color(0xFF80E5BD)
            AnimatedVisibility(
                visible = doAnimate,
                enter = slideInVertically() + fadeIn(),
                exit = slideOutVertically() + fadeOut()
            ) {
                LazyRow (
                    modifier = Modifier
                        .height(55.dp)
                        .fillMaxWidth()
                        .background(Color(0xFF03CB7B)),
                    state = listState,
                    horizontalArrangement = Arrangement.spacedBy(17.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
                ) {
                    itemsIndexed(items) {index, item ->
                        when(item) {
                            "fashionbeauty" -> Text("패션뷰티", color = menuTxtColor, fontWeight = FontWeight.Bold)
                            "presentshop" -> Text("선물샵", color = menuTxtColor, fontWeight = FontWeight.Bold)
                            "d2c" -> Text("도착보장", color = menuTxtColor, fontWeight = FontWeight.Bold)
                            "shoppinglive" -> Text("쇼핑라이브", color = menuTxtColor, fontWeight = FontWeight.Bold)
                            "shopping" -> Text("쇼핑", color = menuTxtColor, fontWeight = FontWeight.Bold)
                            "home" -> Text("홈", color = Color.White, fontWeight = FontWeight.Bold)
                            "news" -> Text("뉴스", color = menuTxtColor)
                            "entertainment" -> Text("연예", color = menuTxtColor, fontWeight = FontWeight.Bold)
                            "sports" -> Text("스포츠", color = menuTxtColor, fontWeight = FontWeight.Bold)
                            "shoppingtoday" -> Text("쇼핑투데이", color = menuTxtColor, fontWeight = FontWeight.Bold)
                            "economy" -> Text("경제", color = menuTxtColor, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}