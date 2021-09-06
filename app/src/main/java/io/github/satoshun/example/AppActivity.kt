package io.github.satoshun.example

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
import androidx.palette.graphics.Palette
import io.github.satoshun.palette.darkMutedColorOrNull
import io.github.satoshun.palette.darkVibrantColorOrNull
import io.github.satoshun.palette.dominantColorOrNull
import io.github.satoshun.palette.lightMutedColorOrNull
import io.github.satoshun.palette.lightVibrantColorOrNull
import io.github.satoshun.palette.mutedColorOrNull
import io.github.satoshun.palette.vibrantColorOrNull

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
fun PaletteBox(palette: Palette?) {
  LazyVerticalGrid(
    modifier = Modifier.fillMaxWidth(),
    cells = GridCells.Fixed(2)
  ) {
    val colors = listOf(
      "vibrant" to palette?.vibrantColorOrNull,
      "darkVibrant" to palette?.darkVibrantColorOrNull,
      "lightVibrant" to palette?.lightVibrantColorOrNull,
      "mutedColor" to palette?.mutedColorOrNull,
      "darkMutedColor" to palette?.darkMutedColorOrNull,
      "lightMutedColor" to palette?.lightMutedColorOrNull,
      "dominantColor" to palette?.dominantColorOrNull
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
