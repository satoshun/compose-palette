package io.github.satoshun.palette.coil

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.Coil
import coil.request.ImageRequest
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine

@Composable
fun palette(request: ImageRequest): State<Palette?> {
  val palette = remember(request) {
    mutableStateOf<Palette?>(null)
  }

  LaunchedEffect(request) {
    val result = Coil.execute(request)
    val bitmap = result.drawable?.toBitmap()
    if (bitmap != null) {
      palette.value = getPalette(bitmap)
    }
  }

  return palette
}

@Composable
fun palette(
  data: Any?,
  config: Bitmap.Config = Bitmap.Config.RGB_565,
  builder: ImageRequest.Builder.() -> Unit = {}
): State<Palette?> {
  val context = LocalContext.current
  val requestBuilder = ImageRequest.Builder(context)
    .data(data)
    .bitmapConfig(config = config)
  requestBuilder.builder()
  return palette(request = requestBuilder.build())
}

private suspend fun getPalette(bitmap: Bitmap): Palette? = suspendCancellableCoroutine { cont ->
  val task = Palette.from(bitmap).generate {
    cont.resume(it)
  }

  cont.invokeOnCancellation {
    task.cancel(false)
  }
}
