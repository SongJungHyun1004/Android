package com.joker.naver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joker.naver.Compose.BannerAds
import com.joker.naver.Compose.Content
import com.joker.naver.Compose.Menu
import com.joker.naver.Compose.SearchBar
import com.joker.naver.Compose.StickySearchBar
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    colorMode: Color,
    colorModeSearchBar: Color,
) {
    val listState = rememberLazyListState()
    val items = listOf("topbar", "spacer1", "searchbar", "spacer2", "menu", "spacer3", "banner", "spacer4", "weather")
    var showStickyHeader by remember { mutableStateOf(false) }

    LaunchedEffect(listState) {
        snapshotFlow {
            listState.firstVisibleItemIndex
        }.collect { visibleIndex ->
            showStickyHeader = visibleIndex >= items.indexOf("spacer2")
        }
    }

    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            state = listState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            if (showStickyHeader) {
                stickyHeader { StickySearchBar(colorMode) }
            }
            itemsIndexed(items) {index, item ->
                when(item) {
                    "topbar" -> TopBar()
                    "spacer1" -> Spacer(modifier = Modifier.height(65.dp))
                    "searchbar" -> SearchBar(colorModeSearchBar)
                    "spacer2" -> Spacer(modifier = Modifier.height(20.dp))
                    "menu" -> Menu(colorMode)
                    "spacer3" -> Spacer(modifier = Modifier.height(65.dp))
                    "banner" -> BannerAds()
                    "spacer4" -> Spacer(modifier = Modifier.height(7.dp))
                    "weather" -> Weather(colorMode)
                }
            }
            items(5) { index ->
                Content(colorMode)
            }
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