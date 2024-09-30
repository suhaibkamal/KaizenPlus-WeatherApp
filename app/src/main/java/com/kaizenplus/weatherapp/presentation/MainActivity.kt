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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.style.TextAlign
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
                Scaffold(modifier = Modifier.fillMaxSize()) {

                    innerPadding ->

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
                    Box(
                        Modifier
                            .background(Color(0xFF1E2734))
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {

                        Column(
                            Modifier
                                .padding(innerPadding)
                                .background(Color(0xFF1E2734))
                                .align(Alignment.Center)) {

                            AppToolbar(title = "Weather")
                            Spacer(modifier = Modifier.height(16.dp))
                            ToggleTabBar(modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterHorizontally),
                                listOf("Today", "Tomorrow"),
                                defaultSelectedIndex = 0,
                                itemSelected = {
                                        index, reselected ->
                                }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Row(modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center) {
                                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.pin),
                                    contentDescription ="pin", tint = Color.White)
                                Text(text = "Amman,Jordan", color = Color.White
                                )
                            }
                            Text(text = "Tue , Mar 2", color = Color(0xFF38424D),
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                modifier = Modifier.fillMaxWidth())
                            Box(
                                Modifier
                                    .weight(12f)
                                    .align(Alignment.CenterHorizontally)) {

                            }

                            Row (
                                Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)
                                    .weight(6f)){
                                HourlyWeatherDisplay(time = "12:00 AM", temperature = "20" , modifier = Modifier
                                    .weight(1f)
                                    .padding(5.dp), color = Color(0xFF252F39) )
                                HourlyWeatherDisplay(time = "12:00 AM", temperature = "20"  , modifier = Modifier
                                    .weight(1f)
                                    .padding(5.dp), color = Color(0xFF43A2FD))
                                HourlyWeatherDisplay(time = "12:00 AM", temperature = "20"  , modifier = Modifier
                                    .weight(1f)
                                    .padding(5.dp), color = Color(0xFF252F39))
                            }
                            Spacer(modifier = Modifier.height(64.dp))

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

    WeatherAppTheme {

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

        Box(
            Modifier
                .background(Color(0xFF1E2734))
                .padding(8.dp)
                .fillMaxSize()
        ) {

                Column(
                    Modifier
                        .background(Color(0xFF1E2734))
                        .align(Alignment.Center)) {

                AppToolbar(title = "Weather")
                Spacer(modifier = Modifier.height(16.dp))
                ToggleTabBar(modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally),
                    listOf("Today", "Tomorrow"),
                    defaultSelectedIndex = 0,
                    itemSelected = {
                        index, reselected ->
                    }
                )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.pin),
                            contentDescription ="pin", tint = Color.White)
                        Text(text = "Amman,Jordan", color = Color.White
                        )
                    }
                    Text(text = "Tue , Mar 2", color = Color(0xFF38424D),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth())
                Box(
                    Modifier
                        .weight(12f)
                        .align(Alignment.CenterHorizontally)) {

                }

                Row (
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .weight(6f)){
                    HourlyWeatherDisplay(time = "12:00 AM", temperature = "20" , modifier = Modifier
                        .weight(1f)
                        .padding(5.dp), color = Color(0xFF252F39) )
                    HourlyWeatherDisplay(time = "12:00 AM", temperature = "20"  , modifier = Modifier
                        .weight(1f)
                        .padding(5.dp), color = Color(0xFF43A2FD))
                    HourlyWeatherDisplay(time = "12:00 AM", temperature = "20"  , modifier = Modifier
                        .weight(1f)
                        .padding(5.dp), color = Color(0xFF252F39))
                }
                    Spacer(modifier = Modifier.height(64.dp))

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