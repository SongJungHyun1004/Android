package com.joker.naver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joker.naver.ui.theme.NaverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NaverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFA5FF85)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Column {
                TopBar()
                Spacer(modifier = Modifier.height(70.dp))
                SearchBar()
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
            .fillMaxWidth()
            .background(color = Color.Green),
//        contentAlignment = Alignment.CenterStart,
    ) {
        Row (
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(text = "Top Bar")
//            Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
        }
    }
}

@Composable
fun SearchBar() {
    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(color = Color.Green),
    ) {
        Row {
            Text(text = "Search Bar")
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
            Box(modifier = Modifier
                .width(180.dp)
                .fillMaxHeight()
                .background(color = Color.LightGray)
            ) {
                Text(text = "Temperature")
            }
            Box(modifier = Modifier
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