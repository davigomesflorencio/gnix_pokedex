package core.ui.core.ui.painter

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.painterResource
import gnixpokedex.core.ui.generated.resources.Res
import gnixpokedex.core.ui.generated.resources.baseline_bookmark
import gnixpokedex.core.ui.generated.resources.baseline_bookmark_border

@Composable
fun bookmarkPainter(): Painter = painterResource(Res.drawable.baseline_bookmark)

@Composable
fun bookmarkBorderPainter(): Painter = painterResource(Res.drawable.baseline_bookmark_border)
