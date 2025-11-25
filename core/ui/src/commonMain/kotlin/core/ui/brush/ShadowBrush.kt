package core.ui.core.ui.brush

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import core.ui.core.ui.theme.Gray95

internal val ShadowColors =
    listOf(
        _root_ide_package_.core.ui.core.ui.theme.Gray95,
        Color.Transparent,
    )

fun shadowBrush(colors: List<Color> = _root_ide_package_.core.ui.core.ui.brush.ShadowColors) = Brush.verticalGradient(colors)
