package com.kaizenplus.weatherapp.presentation

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class NavigationItemData(
    val icon: ImageVector,
    val title: String,
)
@Composable
fun BottomNavigationBar(
    navItems: List<NavigationItemData>,
    modifier: Modifier = Modifier,
    internalPadding: Dp = 11.dp,
    iconSize: Dp = 24.dp,
    fontSize: TextUnit = 12.sp,
    defaultSelectedIndex: Int = 0,
    selectedItemOffset: Dp = 8.dp,
    shape: Shape = RoundedCornerShape(8.dp),
    navigationBarColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    itemTint: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    selectedItemTint: Color = MaterialTheme.colorScheme.onPrimary,
    backgroundTint: Color = Color.Transparent,
    selectedBackgroundTint: Color = MaterialTheme.colorScheme.primary,
    itemSelected: (index: Int, reselected: Boolean) -> Unit
) {

    Box(
        modifier = Modifier
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
            .background(navigationBarColor, shape)
            .then(modifier),
    ) {

        var selectedItemIndex by remember {
            mutableIntStateOf(defaultSelectedIndex)
        }

        Row(
            modifier = Modifier.wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            navItems.forEachIndexed { index, item ->

                val isSelected = selectedItemIndex == index

                Box(
                    Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .clickable {
                            val reselected = selectedItemIndex == index
                            selectedItemIndex = index
                            itemSelected(selectedItemIndex, reselected)
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        modifier = Modifier
                            .wrapContentHeight(unbounded = true)
                            .then(
                                if (isSelected) {
                                    Modifier.offset(y = selectedItemOffset * (-2))
                                } else {
                                    Modifier
                                }
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Box(
                            Modifier
                                .clip(CircleShape)
                                .background(
                                    if (isSelected) selectedBackgroundTint else backgroundTint
                                )
                                .padding(2.dp)
                        ) {
                            Box(
                                Modifier
                                    .clip(CircleShape)
                                    .background(
                                        if (isSelected) Color.White else backgroundTint
                                    )
                                    .padding(2.dp)
                            ) {
                                Box(
                                    Modifier
                                        .clip(CircleShape)
                                        .background(
                                            if (isSelected) selectedBackgroundTint else backgroundTint
                                        )
                                        .padding(internalPadding)
                                ) {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = item.title,
                                        modifier = Modifier.size(iconSize),
                                        tint = if (isSelected) selectedItemTint else itemTint
                                    )
                                }

                            }

                        }


                        AnimatedVisibility(visible = isSelected) {
                            Text(
                                text = item.title,
                                fontWeight = FontWeight.Bold,
                                color = if(isSelected) selectedItemTint else itemTint,
                                fontSize = fontSize
                            )
                        }

                    }

                }

            }

        }

    }
}
