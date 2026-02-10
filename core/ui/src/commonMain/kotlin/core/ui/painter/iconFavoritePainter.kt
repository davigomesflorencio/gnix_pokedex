package core.ui.core.ui.painter

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import gnix_kmp_pokedex.core.ui.generated.resources.Res
import gnix_kmp_pokedex.core.ui.generated.resources.ic_heart
import gnix_kmp_pokedex.core.ui.generated.resources.ic_heart_full
import org.jetbrains.compose.resources.painterResource

@Composable
fun iconFavoritePainter(): Painter = painterResource(Res.drawable.ic_heart)

@Composable
fun iconFavoriteFullPainter(): Painter = painterResource(Res.drawable.ic_heart_full)
