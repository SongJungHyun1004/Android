@file:OptIn(ExperimentalComposeUiApi::class)

package com.joker.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.joker.compose.ui.theme.ComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
class MainActivity : ComponentActivity() {
//    private val viewModel by viewModels<MainViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // val isFavorite = remember 로 했을 때 .value를 계속 써야함 => by 키워드로 직접 값을 얻고 저장함 (getValue, setValue import 해야함)
            // remember 사용했을 때 (가로,세로 회전 시) Activity가 초기화 됨 => rememberSaveable 사용
            var isFavorite by rememberSaveable {
                mutableStateOf(false)
            }

            val (text, setValue) = remember {
                mutableStateOf("")
            }
            val snackbarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()
            val keyboardController = LocalSoftwareKeyboardController.current

            val navController = rememberNavController()


            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Basic()
//                    List()
//                    LazyList() // LazyColumn()
//                    ImageCard(
//                        isFavorite = isFavorite,
//                    ) { favorite ->
//                        isFavorite = favorite
//                    }
//                    TextValue(text, setValue, snackbarHostState, scope, keyboardController)
//                    NavHost(
//                        navController = navController,
//                        startDestination = "first",
//                    ) {
//                        composable("first") {
//                            FirstScreen(navController)
//                        }
//                        composable("second") {
//                            SecondScreen(navController)
//                        }
//                        composable("third/{value}") { backStackEntry ->
//                            ThirdScreen(
//                                navController = navController,
//                                value = backStackEntry.arguments?.getString("value") ?: "",
//                            )
//                        }
//                    }
//                    val data = remember { mutableStateOf("Hello") } // remember없이 viewmodel 사용하기
                    val viewModel by viewModels<MainViewModel> ()
//                    Viewmodel(viewModel)
                    HomeScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Basic() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(color = Color.Green)
            .padding(8.dp)
    ) {
        Text(text = "Hello")
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "World")
        Box(modifier = Modifier.background(color = Color.Blue)) {
            Text(text = "afsd", color = Color.White)
        }
    }
}

@Composable
fun List() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
//            .background(color = Color.Green)
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        for (i in 1..50) {
            Text(text = "num $i")
        }
    }
}

@Composable
fun LazyList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item {
            Text(text = "Header")
        }
        items(50) { index ->
            Text(text = "number $index")
        }
        item {
            Text(text = "Footer")
        }
    }
}

@Composable
fun ImageCard(
    isFavorite: Boolean,
    onTabFavorite: (Boolean) -> Unit,
) {
    Card(
        modifier = Modifier
            .wrapContentSize(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .background(color = Color.LightGray)
                .padding(8.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painter = painterResource(id = R.drawable.movie_poster),
                contentDescription = "poster",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(0.5f)
            )
            IconButton(onClick = {
                onTabFavorite(!isFavorite)
            }) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "favorite",
                    tint = Color.Red,
                )
            }
        }
    }
}

@Composable
fun TextValue(
    text: String,
    setValue: (String) -> Unit,
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope,
    keyboardController: SoftwareKeyboardController?,
) {
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextField(
                value = text,
                onValueChange = setValue,
                colors = TextFieldDefaults.colors()
            )
            Button(onClick = {
                keyboardController?.hide()
                scope.launch {
                    snackbarHostState.showSnackbar("Hello $text")
                }
            }) {
                Text(text = "Click!!")
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    val (value, setValue) = remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("첫 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("second")
        }) {
            Text(text = "두 번째!")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = value, onValueChange = setValue)
        Button(onClick = {
            if (value.isNotEmpty()) {
                navController.navigate("third/$value")
            }
        }) {
            Text(text = "세 번째!")
        }
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("두 번째 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigateUp()
//            navController.popBackStack()
        }) {
            Text(text = "뒤로 가기!")
        }
    }
}

@Composable
fun ThirdScreen(navController: NavController, value: String) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("세 번째 화면")
        Spacer(modifier = Modifier.height(16.dp))
        Text(value)
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "뒤로 가기!")
        }
    }
}

class MainViewModel : ViewModel() {
    private val _data = mutableStateOf("Hello")
    val data: State<String> = _data

    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveData

    fun setValue(newData: String) {
        _data.value = newData
    }
}

@Composable
fun Viewmodel(viewModel: MainViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = viewModel.data.value,
            fontSize = 30.sp,
        )
        Button(onClick = {
            viewModel.setValue("World")
        }) {
            Text(text = "변경")
        }
    }
}

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val txt = remember {    // txt: MutableState<String>
        mutableStateOf("Hello World")
    }
    var txt2 by remember {  // txt2: String
        mutableStateOf("Hello World")
    }
    val (text, setText) = remember {    // text: String, setText: (String) -> Unit
        mutableStateOf("Hello World")
    }
    val state: State<String> = viewModel.liveData.observeAsState(initial = "Hello World") // state로 변환해 주는 기능

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(text = txt.value)
            Text(text = txt2)
            Text(text = text)
            Text(text = viewModel.data.value)
        }
        Button(onClick = { 
            txt.value = "변경"
            txt2 = "변경2"
            viewModel.setValue("변경4")
        }) {
            Text(text = "Click")
        }
        TextField(value = text, onValueChange = setText)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTheme {
        Greeting("Android")
    }
}
//@Preview(showBackground = true)
//@Composable
//fun TextValuePreview() {
//    ComposeTheme {
//        val (text, setValue) = remember {
//            mutableStateOf("")
//        }
//        val snackbarHostState = remember { SnackbarHostState() }
//        val scope = rememberCoroutineScope()
//        val keyboardController = LocalSoftwareKeyboardController.current
//        TextValue(text, setValue, snackbarHostState, scope, keyboardController)
//    }
//}