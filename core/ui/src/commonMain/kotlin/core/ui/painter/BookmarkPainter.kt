package core.ui.core.ui.painter

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import gnix_kmp_pokedex.core.ui.generated.resources.Res
import gnix_kmp_pokedex.core.ui.generated.resources.baseline_bookmark
import gnix_kmp_pokedex.core.ui.generated.resources.baseline_bookmark_border
import org.jetbrains.compose.resources.painterResource

@Composable
fun bookmarkPainter(): Painter = painterResource(Res.drawable.baseline_bookmark)

@Composable
fun bookmarkBorderPainter(): Painter = painterResource(Res.drawable.baseline_bookmark_border)
