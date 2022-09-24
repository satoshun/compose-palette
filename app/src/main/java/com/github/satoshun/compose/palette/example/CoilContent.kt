package com.github.satoshun.compose.palette.example

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.github.satoshun.compose.palette.coil.rememberCoilPaletteState

@ExperimentalCoilApi
@Composable
fun CoilContent() {
  Column {
    Text(text = "Coil")

    val url =
      "https://i.picsum.photos/id/612/200/300.jpg?hmac=vJ35AV5-TQa5ET5az0aESTnI3zaFCjRYD9OnYaiYIYc"
    AsyncImage(
      model = url,
      modifier = Modifier.size(180.dp),
      contentScale = ContentScale.Crop,
      contentDescription = "Image"
    )

    val paletteState = rememberCoilPaletteState(data = url)
    PaletteBox(paletteState = paletteState)
  }
}
