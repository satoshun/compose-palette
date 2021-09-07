package io.github.satoshun.palette

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.palette.graphics.Palette

@Composable
fun rememberPaletteState(
  bitmap: Bitmap,
  mayInterruptIfRunning: Boolean = false
): PaletteState {
  val palette = remember(bitmap) {
    MutablePaletteState()
  }

  DisposableEffect(bitmap) {
    val task = Palette.from(bitmap).generate {
      palette.updatePalette(it)
    }
    onDispose { task.cancel(mayInterruptIfRunning) }
  }

  return palette
}

@Composable
fun rememberPaletteState(
  imageBitmap: ImageBitmap,
  mayInterruptIfRunning: Boolean = false
): PaletteState =
  rememberPaletteState(
    bitmap = imageBitmap.asAndroidBitmap(),
    mayInterruptIfRunning = mayInterruptIfRunning
  )
