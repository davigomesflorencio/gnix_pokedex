package feature.home.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.ui.core.ui.composable.AppImage
import core.ui.core.ui.composable.BookmarkIconButton
import core.ui.core.ui.theme.AppShape

@Composable
fun PokemonItem(
    id: String,
    name: String,
    iconUrl: String,
    onClick: () -> Unit,
    onClickSave: () -> Unit,
    isBookmarked: Boolean,
) {
    Surface(
        shape = AppShape.MediumRoundedCornerShape,
    ) {
        Column(
            modifier = Modifier
                .clickable { onClick() }
                .fillMaxWidth().padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                BookmarkIconButton(isBookmarked) {
                    onClickSave()
                }
            }
            AppImage(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                imageUrl = iconUrl,
                contentDescription = name,
                contentScale = ContentScale.FillHeight,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                modifier = Modifier.height(30.dp),
                text = name,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "#$id",
                style = MaterialTheme.typography.labelLarge,
            )
            Spacer(Modifier.height(10.dp))
        }
    }
}
