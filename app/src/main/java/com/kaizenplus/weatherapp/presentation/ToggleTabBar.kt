package com.kaizenplus.weatherapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ToggleTabBar(modifier: Modifier){


    Row(modifier = modifier
        .padding(0.dp)
        .background(Color(0xFF252F39), shape = RoundedCornerShape(10.dp))) {


        Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors((Color(0xFF252F39))) ){
            Text(text = "Tom")
        }
    }

}



@Composable
fun ToggleTabBar(modifier: Modifier,
                 items: List<String>,
                 defaultSelectedIndex: Int = 0,
                 itemSelected: (index: Int, reselected: Boolean) -> Unit){

    var selectedItemIndex by remember {
        mutableIntStateOf(defaultSelectedIndex)
    }
    Row(modifier = modifier
        .padding(0.dp)
        .background(Color(0xFF252F39), shape = RoundedCornerShape(10.dp))) {
        items.forEachIndexed {

                index,item->
            val isSelected = selectedItemIndex == index

            Button(modifier = Modifier.fillMaxHeight(),
                colors = if(isSelected) ButtonDefaults.buttonColors(Color(0xFF43A2FD))else ButtonDefaults.buttonColors(Color(0xFF252F39)),
                shape = RoundedCornerShape(10.dp), onClick = {
                    val reselected = selectedItemIndex == index
                    selectedItemIndex = index
                    itemSelected(index,reselected)
                }) {
                Text(text = item)
            }


        }
    }

}








@Preview
@Composable
fun ToggleTabBarPreview(){
    ToggleTabBar(Modifier.wrapContentHeight(), listOf("Tom","Jerry","Jack"), itemSelected = { index, reselected ->

    })
}