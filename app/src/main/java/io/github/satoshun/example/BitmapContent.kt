package io.github.satoshun.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import io.github.satoshun.compose.palette.rememberPaletteState

@Composable
fun BitmapContent() {
  Text(text = "Bitmap")
  val bitmap = ImageBitmap.imageResource(id = R.drawable.image1)

  Image(
    modifier = Modifier.size(180.dp),
    bitmap = bitmap,
    contentScale = ContentScale.Crop,
    contentDescription = "Bitmap Image"
  )

  val paletteState = rememberPaletteState(imageBitmap = bitmap)
  PaletteBox(paletteState = paletteState)
}
