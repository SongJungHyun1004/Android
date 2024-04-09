package com.joker.naver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joker.naver.Compose.BannerAds
import com.joker.naver.Compose.Content
import com.joker.naver.Compose.Menu
import com.joker.naver.Compose.SearchBar
import com.joker.naver.Compose.TopBar
import com.joker.naver.Compose.Weather
import com.joker.naver.ui.theme.NaverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NaverTheme {
                // A surface container using the 'background' color from the theme
                val colorMode = MaterialTheme.colorScheme.surface
                val colorModeSearchBar = MaterialTheme.colorScheme.secondary
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(colorMode, colorModeSearchBar)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    colorMode: Color,
    colorModeSearchBar: Color,
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
                SearchBar(colorModeSearchBar)
                Spacer(modifier = Modifier.height(20.dp))
                Menu(colorMode)
                Spacer(modifier = Modifier.height(65.dp))
                BannerAds()
                Spacer(modifier = Modifier.height(7.dp))
                Weather(colorMode)
            }
        }
        items(5) { index ->
            Content(text = "content $index")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NaverTheme {
//        Greeting("Android")
//    }
//}