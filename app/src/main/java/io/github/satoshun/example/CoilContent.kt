package io.github.satoshun.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import io.github.satoshun.palette.coil.rememberCoilPaletteState

@ExperimentalCoilApi
@Composable
fun CoilContent() {
  Text(text = "Coil")

  val url =
    "https://lh3.googleusercontent.com/KMXxFedRjNHx267mUYr4IIzNRYnMQM9fuFli0C-3hDDZ9cyhgpMmrhYJvfJwtoXE2zFacHKN95htO8WCx1u0rYzockavFL86g965Qzxm1JkyNYxv95D_X5_plxQd4f6_htscreOmKo6G8n9UPLOw7qjHC9c87vsOHTXqJc6JROGjcNrV9p6xpKIsjGrDpJrSIQ_rBXq_aBsX2m8QFBh9PAl9MzrDCIYl5WvRW7fgkcThRHqyUNC0R6HUpQldc763Oddt27bnUwXh4mjGx6DPXCbA0kWH84EQsP5Ue304zyhjVifJzDHGdS_B6hyI0SV52NMY6ermfEVAxUAxRil58dIdbTJOOryGVuDPywn3eTsxZMkJhAo9VNhqGvbOz21fj1XzjK8tUg7ijzvlJhK8JFcsxZJvf4K1pRTX4qnnet71yozyky9nFtumsa0tRuPOyWe47QUbUp6H91gLWrIU2x2Km4LhzYmCNRT5wMv8HHYyAhu48wDJlnkGGZlK93D4MFC6nyY_xgRRT9z4OsLOEA-THMDYkyqRUUxyl8C411ACqi51YiabQdflPZIOEypUdi3fMzoA_SIdRvND5UjvaxDwCkcqguIEAMYyJbSA_jl-BS96XsNADwJc4py6QG6w9AJLdmHFk_2L_UW0JOmBdN6EPQ2IKwzxnR02fRdVz7WakvlHXdHzjdPONiA1fRphJFbRki-n7O0GvqukvQQ3mvJy=w708-h944-no?authuser=0"
  Image(
    modifier = Modifier.size(180.dp),
    painter = rememberImagePainter(data = url),
    contentScale = ContentScale.Crop,
    contentDescription = "Image"
  )

  val paletteState = rememberCoilPaletteState(data = url)
  PaletteBox(paletteState = paletteState)
}
