package io.github.satoshun.palette

import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette

val Palette.vibrantColor: Color
  get() = vibrantColorOrNull!!

val Palette.vibrantColorOrNull: Color?
  get() = vibrantSwatch?.rgb?.let { Color(it) }

val Palette.darkVibrantColor: Color
  get() = darkVibrantColorOrNull!!

val Palette.darkVibrantColorOrNull: Color?
  get() = darkVibrantSwatch?.rgb?.let { Color(it) }

val Palette.lightVibrantColor: Color
  get() = lightVibrantColorOrNull!!

val Palette.lightVibrantColorOrNull: Color?
  get() = lightVibrantSwatch?.rgb?.let { Color(it) }

val Palette.mutedColor: Color
  get() = mutedColorOrNull!!

val Palette.mutedColorOrNull: Color?
  get() = mutedSwatch?.rgb?.let { Color(it) }

val Palette.darkMutedColor: Color
  get() = darkMutedColorOrNull!!

val Palette.darkMutedColorOrNull: Color?
  get() = darkMutedSwatch?.rgb?.let { Color(it) }

val Palette.lightMutedColor: Color
  get() = lightMutedColorOrNull!!

val Palette.lightMutedColorOrNull: Color?
  get() = lightMutedSwatch?.rgb?.let { Color(it) }

val Palette.dominantColor: Color
  get() = dominantColorOrNull!!

val Palette.dominantColorOrNull: Color?
  get() = dominantSwatch?.rgb?.let { Color(it) }
