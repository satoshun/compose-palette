package io.github.satoshun.palette.coil

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.Coil
import coil.request.ImageRequest
import io.github.satoshun.palette.MutablePaletteState
import io.github.satoshun.palette.PaletteState
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine

@Composable
fun rememberCoilPaletteState(request: ImageRequest): PaletteState {
  val palette = remember(request) { MutablePaletteState() }

  LaunchedEffect(request) {
    val result = Coil.execute(request)
    val bitmap = result.drawable?.toBitmap()
    if (bitmap != null) {
      palette.updatePalette(getPalette(bitmap))
    }
  }

  return palette
}

@Composable
fun rememberCoilPaletteState(
  data: Any?,
  config: Bitmap.Config = Bitmap.Config.RGB_565,
  builder: ImageRequest.Builder.() -> Unit = {}
): PaletteState {
  val context = LocalContext.current
  val requestBuilder = ImageRequest.Builder(context)
    .data(data)
    .bitmapConfig(config = config)
  requestBuilder.builder()
  return rememberCoilPaletteState(request = requestBuilder.build())
}

private suspend fun getPalette(bitmap: Bitmap): Palette? = suspendCancellableCoroutine { cont ->
  val task = Palette.from(bitmap).generate {
    cont.resume(it)
  }

  cont.invokeOnCancellation { task.cancel(false) }
}
