package core.ui.core.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.ui.core.ui.painter.iconFavoriteFullPainter
import core.ui.core.ui.painter.iconFavoritePainter
import core.ui.core.ui.painter.starOutlinePainter
import core.ui.core.ui.painter.starPainter

@Composable
fun BookmarkIconButton(
    isBookmarked: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val iconPainter =
        if (isBookmarked) {
            iconFavoriteFullPainter()
        } else {
            iconFavoritePainter()
        }

    val iconTint = if (isBookmarked) {
            Color.Red
        } else {
            Color.LightGray
        }

    AppIconButton(
        modifier = modifier,
        painter = iconPainter,
        tint = iconTint,
        size = 32.dp,
        onClick = onClick,
    )
}
