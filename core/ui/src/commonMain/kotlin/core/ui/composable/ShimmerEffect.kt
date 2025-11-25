package core.ui.core.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import core.ui.core.ui.brush.shimmerBrush

@Composable
fun ShimmerEffect(
    modifier: Modifier,
    shape: Shape = RoundedCornerShape(5.dp),
) {
    Box(
        modifier =
        modifier
            .clip(shape)
            .background(brush = _root_ide_package_.core.ui.core.ui.brush.shimmerBrush()),
    )
}
