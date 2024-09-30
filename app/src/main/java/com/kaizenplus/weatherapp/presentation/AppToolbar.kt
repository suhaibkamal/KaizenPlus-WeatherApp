package com.kaizenplus.weatherapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kaizenplus.weatherapp.R

@Composable
fun AppToolbar(title: String) {

  Row (Modifier.fillMaxWidth().padding(8.dp)){
      IconButton(modifier = Modifier.background(Color(0xFF252F39),shape= RoundedCornerShape(5.dp)).align(Alignment.CenterVertically), onClick = { /*TODO*/ }
      ) {
          Icon(
              tint = MaterialTheme.colorScheme.onSurfaceVariant,
              imageVector = ImageVector.vectorResource(id = R.drawable.back),
              contentDescription =title,
              modifier = androidx.compose.ui.Modifier.size(24.dp),
          )
      }

      Text(text = title,
          color = Color.White,
          fontWeight = FontWeight.Bold,
          textAlign = TextAlign.Center,
          fontSize = 16.sp,
          modifier = Modifier.weight(1f).align(Alignment.CenterVertically))

      IconButton(modifier = Modifier.background(Color(0xFF252F39),shape= RoundedCornerShape(5.dp)).align(Alignment.CenterVertically),onClick = { /*TODO*/ }
      ) {
          Icon(
              tint = MaterialTheme.colorScheme.onSurfaceVariant,
              imageVector = ImageVector.vectorResource(id = R.drawable.more),
              contentDescription =title,
              modifier = androidx.compose.ui.Modifier.size(24.dp),
          )
      }
  }
}

@Preview
@Composable
fun AppToolbarPreview() {
  AppToolbar(title = "Weather App")
}