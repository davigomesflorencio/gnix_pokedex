package feature.home.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import core.ui.core.ui.painter.closePainter
import core.ui.core.ui.painter.iconSearchPainter

object AppSearchBarHeight {
    val BasicHeight: Dp = 50.dp
    val WideHeight: Dp = 60.dp
}
@Composable
fun AppSearchBar(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onSearch: (String) -> Unit,
    hint: String = "Search Pokemon",
) {
    Surface(
        modifier = modifier.clip(RoundedCornerShape(24.dp)),
        color = Color.White,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextField(
                value = searchQuery,
                onValueChange = onSearch,
                placeholder = { Text(hint) },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                leadingIcon = {
                    Icon(
                        iconSearchPainter(),
                        contentDescription = "Icon Search",
                        tint = Color.Gray,
                    )
                },
                modifier = Modifier.weight(1f),
            )
            if (searchQuery.isNotEmpty()) {
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = { onSearch("") }) {
                    Icon(
                        painter = closePainter(),
                        contentDescription = "Clear Search",
                        tint = Color.Gray,
                    )
                }
            }
        }
    }
}
