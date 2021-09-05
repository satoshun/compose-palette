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
fun palette(data: String): State<Palette?> {
  val context = LocalContext.current
  val palette = remember(data) {
    mutableStateOf<Palette?>(null)
  }

  LaunchedEffect(data) {
    val request = ImageRequest.Builder(context)
      .bitmapConfig(config = Bitmap.Config.RGB_565)
      .data(data)
      .build()
    val result = Coil.execute(request)
    val bitmap = result.drawable?.toBitmap()
    if (bitmap != null) {
      palette.value = getPalette(bitmap)
    }
  }

  return palette
}

private suspend fun getPalette(bitmap: Bitmap): Palette = suspendCancellableCoroutine { cont ->
  val task = Palette.from(bitmap).generate {
    if (it == null) {
      // TODO null?
    } else {
      cont.resume(it)
    }
  }

  cont.invokeOnCancellation {
    task.cancel(false)
  }
}
