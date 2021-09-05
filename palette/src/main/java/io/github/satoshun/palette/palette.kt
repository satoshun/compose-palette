package io.github.satoshun.palette

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.palette.graphics.Palette

@Composable
fun palette(
  bitmap: Bitmap,
  mayInterruptIfRunning: Boolean = false
): State<Palette?> {
  val palette = remember(bitmap) {
    mutableStateOf<Palette?>(null)
  }

  DisposableEffect(bitmap) {
    val task = Palette.from(bitmap).generate {
      palette.value = it
    }
    onDispose { task.cancel(mayInterruptIfRunning) }
  }

  return palette
}

@Composable
fun palette(
  imageBitmap: ImageBitmap,
  mayInterruptIfRunning: Boolean = false
): State<Palette?> =
  palette(
    bitmap = imageBitmap.asAndroidBitmap(),
    mayInterruptIfRunning = mayInterruptIfRunning
  )
