package com.rururi.weather

import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rururi.weather.ui.theme.WeatherTheme
import kotlinx.coroutines.sync.Mutex

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
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.tenki0),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 120.dp)
                .size(360.dp)
                .aspectRatio(1f)
        )
        Button(
            onClick = {},
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
