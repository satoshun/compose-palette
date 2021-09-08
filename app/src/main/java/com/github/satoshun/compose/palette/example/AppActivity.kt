package com.github.satoshun.compose.palette.example

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.satoshun.compose.palette.PaletteState

class AppActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      AppContent()
    }
  }
}

@Composable
fun AppContent() {
  Column {
    BitmapContent()
    Spacer(modifier = Modifier.height(16.dp))
    CoilContent()
  }
}

@ExperimentalFoundationApi
@Composable
fun PaletteBox(paletteState: PaletteState) {
  LazyVerticalGrid(
    modifier = Modifier.fillMaxWidth(),
    cells = GridCells.Fixed(2)
  ) {
    val colors = listOf(
      "vibrant" to paletteState.vibrant,
      "darkVibrant" to paletteState.darkVibrant,
      "lightVibrant" to paletteState.lightVibrant,
      "mutedColor" to paletteState.muted,
      "darkMutedColor" to paletteState.darkMuted,
      "lightMutedColor" to paletteState.lightMuted,
      "dominantColor" to paletteState.dominant
    ).filter { it.second != null }

    items(colors) {
      MyBoxItem(text = it.first, color = it.second!!)
    }
  }
}

@Composable
fun MyBoxItem(text: String, color: Color) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .background(color)
        .height(40.dp)
        .padding(8.dp),
      contentAlignment = Alignment.Center
    ) {
      Text(text = text)
    }
  }
}
