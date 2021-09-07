package io.github.satoshun.palette

import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette

@Stable
interface PaletteState {
  val palette: Palette?

  val vibrant: Color?
  val darkVibrant: Color?
  val lightVibrant: Color?

  val muted: Color?
  val darkMuted: Color?
  val lightMuted: Color?

  val dominant: Color?
}

@Stable
class MutablePaletteState : PaletteState {
  override var palette: Palette? by mutableStateOf(null)
    private set

  override val vibrant: Color? by derivedStateOf {
    palette?.vibrantSwatch?.rgb?.let(::Color)
  }

  override val darkVibrant: Color? by derivedStateOf {
    palette?.darkVibrantSwatch?.rgb?.let(::Color)
  }

  override val lightVibrant: Color? by derivedStateOf {
    palette?.lightVibrantSwatch?.rgb?.let(::Color)
  }

  override val muted: Color? by derivedStateOf {
    palette?.mutedSwatch?.rgb?.let(::Color)
  }

  override val darkMuted: Color? by derivedStateOf {
    palette?.darkMutedSwatch?.rgb?.let(::Color)
  }

  override val lightMuted: Color? by derivedStateOf {
    palette?.lightMutedSwatch?.rgb?.let(::Color)
  }

  override val dominant: Color? by derivedStateOf {
    palette?.dominantSwatch?.rgb?.let(::Color)
  }

  fun updatePalette(palette: Palette?) {
    this.palette = palette
  }
}
