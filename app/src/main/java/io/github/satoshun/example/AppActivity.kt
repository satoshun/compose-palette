package io.github.satoshun.example

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import coil.compose.rememberImagePainter

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

@Composable
fun MyBox(palette: Palette?) {
  val dominant = palette?.dominantSwatch?.rgb
  if (dominant != null) {
    Box(
      modifier = Modifier
        .size(120.dp)
        .background(Color(dominant))
    )
  }
}
