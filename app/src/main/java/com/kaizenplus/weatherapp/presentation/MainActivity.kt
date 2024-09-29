package com.kaizenplus.weatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kaizenplus.weatherapp.R
import com.kaizenplus.weatherapp.presentation.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val itemsList: List<NavigationItemData> = listOf(
        NavigationItemData(ImageVector.vectorResource(id = R.drawable.home),
            stringResource(R.string.home)),
        NavigationItemData(ImageVector.vectorResource(id = R.drawable.search),
            stringResource(R.string.search)),
        NavigationItemData(ImageVector.vectorResource(id = R.drawable.daily),
            stringResource(R.string.daily)),
        NavigationItemData(ImageVector.vectorResource(id = R.drawable.settings),
            stringResource(R.string.settings)),
    )
    WeatherAppTheme {


        Box(
            Modifier
                .background(Color(0xFF1E2734))
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Column(Modifier.background(Color(0xFF1E2734)).align(Alignment.Center)) {

                ToggleTabBar(modifier = Modifier.weight(1f).align(Alignment.CenterHorizontally),
                    listOf("Today", "Tomorrow"),
                    defaultSelectedIndex = 0,
                    itemSelected = {
                        index, reselected ->
                    }
                )
                Box(Modifier.weight(14f).align(Alignment.CenterHorizontally)) {

                }
                BottomNavigationBar(navItems = itemsList,
                    modifier = Modifier.weight(1f),
                    selectedBackgroundTint = Color(0xFF43A2FD),
                    navigationBarColor = Color(0xFF252F39),
                    defaultSelectedIndex = 0,
                    itemSelected = { index, reselected ->
                        {
                            println("index: $index, reselected: $reselected")
                        }
                    }
                )
            }
        }


    }
}