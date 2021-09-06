package io.github.satoshun.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import io.github.satoshun.palette.palette

@Composable
fun BitmapContent() {
  Text(text = "bitmap")
  Row {
    val bitmap = ImageBitmap.imageResource(
      id = R.drawable.image1
    )
    Image(
      modifier = Modifier.size(120.dp),
      bitmap = bitmap,
      contentDescription = "Bitmap Image"
    )

    val palette by palette(imageBitmap = bitmap)
    MyBox(palette = palette)
  }
}
