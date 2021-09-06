package io.github.satoshun.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import io.github.satoshun.palette.coil.palette

@Composable
fun CoilContent() {
  Text(text = "Coil")
  Row {
    val url = "https://pbs.twimg.com/profile_images/1376441709135941633/B3YYh5io_400x400.jpg"
    Image(
      modifier = Modifier.size(120.dp),
      painter = rememberImagePainter(data = url),
      contentDescription = "Image"
    )

    val palette by palette(data = url)
    MyBox(palette = palette)
  }
}
