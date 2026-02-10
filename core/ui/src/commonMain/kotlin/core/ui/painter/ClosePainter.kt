package core.ui.core.ui.painter

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import gnix_kmp_pokedex.core.ui.generated.resources.Res
import gnix_kmp_pokedex.core.ui.generated.resources.baseline_clear
import org.jetbrains.compose.resources.painterResource

@Composable
fun closePainter(): Painter = painterResource(Res.drawable.baseline_clear)
