package core.ui.core.ui.painter

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.painterResource
import gnix_kmp_pokedex.core.ui.generated.resources.Res
import gnix_kmp_pokedex.core.ui.generated.resources.baseline_star_border
import gnix_kmp_pokedex.core.ui.generated.resources.baseline_star_fill

@Composable
fun starPainter(): Painter = painterResource(Res.drawable.baseline_star_fill)

@Composable
fun starOutlinePainter(): Painter = painterResource(Res.drawable.baseline_star_border)
