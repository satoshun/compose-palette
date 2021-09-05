package io.github.satoshun.example

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import coil.compose.rememberImagePainter
import io.github.satoshun.palette.palette

class AppActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      AppContent()
    }
  }
}

@Composable
fun AppContent() {
  Column {
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

    Spacer(modifier = Modifier.height(16.dp))

    Text(text = "Coil")
    Row {
      val url = "https://pbs.twimg.com/profile_images/1376441709135941633/B3YYh5io_400x400.jpg"
      Image(
        modifier = Modifier.size(120.dp),
        painter = rememberImagePainter(data = url),
        contentDescription = "Image"
      )

      val palette by io.github.satoshun.palette.coil.palette(data = url)
      println("palette $palette")
      MyBox(palette = palette)
    }
  }
}

@Composable
fun MyBox(palette: Palette?) {
  val dominant = palette?.dominantSwatch?.rgb
  if (dominant != null) {
    Box(
      modifier = Modifier
        .size(120.dp)
        .background(Color(dominant))
    )
  }
}
