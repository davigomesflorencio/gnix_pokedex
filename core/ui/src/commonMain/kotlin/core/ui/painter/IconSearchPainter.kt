package core.ui.core.ui.painter

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import gnix_kmp_pokedex.core.ui.generated.resources.Res
import gnix_kmp_pokedex.core.ui.generated.resources.ic_search
import org.jetbrains.compose.resources.painterResource

@Composable
fun iconSearchPainter(): Painter = painterResource(Res.drawable.ic_search)
