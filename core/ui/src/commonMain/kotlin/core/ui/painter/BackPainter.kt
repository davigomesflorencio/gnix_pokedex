package core.ui.core.ui.painter

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import gnixpokedex.core.ui.generated.resources.Res
import gnixpokedex.core.ui.generated.resources.baseline_arrow_back
import org.jetbrains.compose.resources.painterResource

@Composable
fun backPainter(): Painter = painterResource(Res.drawable.baseline_arrow_back)
