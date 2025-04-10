package com.rururi.weather

import android.R.attr.onClick
import android.R.attr.visible
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rururi.weather.ui.theme.WeatherTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import java.lang.System.exit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherTheme {
                WeatherApp()    //実行したい関数を呼び出す
            }
        }
    }
}

@Composable
fun WeatherApp() {
    HomeScreen()
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) { //引数にmodifierを設定
    //画像を表示するリストを作成
    val images = listOf(
        R.drawable.tenki1,
        R.drawable.tenki2,
        R.drawable.tenki3,
        R.drawable.tenki4,
        R.drawable.tenki5,
        R.drawable.tenki6,
    )
    var randomImage by remember { mutableStateOf(R.drawable.tenki0) } //画像リストからランダムに画像を表示
    var isShowImage by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AnimatedVisibility(
            visible = isShowImage,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Image(
                painter = painterResource(id = randomImage),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 120.dp)
                    .size(360.dp)
                    .aspectRatio(1f)
            )
        }
        Button(
            onClick = {
                isShowImage = false //画像をいったん非表示に
                scope.launch {
                    delay(300)
                    randomImage = images.random()
                    isShowImage = true //画像を表示
                }
            },
            modifier= Modifier
                .padding(top = 100.dp)
                .size(width = 200.dp, height = 64.dp)
        ){
            Text(text="明日の天気は？",fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true) //プレビュー画面に表示
@Composable
fun TestAppPreview() {
    HomeScreen()                //プレビューしたい関数を呼び出す
}
