package com.github.satoshun.compose.palette.example

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.github.satoshun.compose.palette.coil.rememberCoilPaletteState

@ExperimentalCoilApi
@Composable
fun CoilContent2() {
  Column {
    Text(text = "Coil2")

    val request = ImageRequest.Builder(LocalContext.current)
      .data("https://i.picsum.photos/id/612/200/300.jpg?hmac=vJ35AV5-TQa5ET5az0aESTnI3zaFCjRYD9OnYaiYIYc")
      .bitmapConfig(config = Bitmap.Config.RGB_565)
      .size(Size.ORIGINAL)
      .build()
    val painter = rememberAsyncImagePainter(request)
    Image(
      painter = painter,
      modifier = Modifier.size(180.dp),
      contentScale = ContentScale.Crop,
      contentDescription = "Image"
    )

    val paletteState = rememberCoilPaletteState(painter = painter)
    PaletteBox(paletteState = paletteState)
  }
}
