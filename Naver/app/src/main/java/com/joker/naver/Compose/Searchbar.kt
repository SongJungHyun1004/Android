package com.joker.naver.Compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joker.naver.R
import com.joker.naver.ui.theme.GreenDot_Gradient
import com.joker.naver.ui.theme.GreenDot_Green

@Composable
fun SearchBar(
    colorModeSearchBar: Color
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
                .background(colorModeSearchBar, RoundedCornerShape(30.dp)),
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
                        drawCircle(color = colorModeSearchBar, radius = 18f)
                    }
                )
            }
        }
    }
}