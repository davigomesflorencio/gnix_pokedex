package feature.home.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import core.ui.core.ui.composable.AdaptiveLayout
import core.ui.core.ui.composable.AppBarHeight
import core.ui.core.ui.composable.AppIconButton
import core.ui.core.ui.composable.AppTopBar
import core.ui.core.ui.painter.closePainter
import core.ui.core.ui.painter.iconSearchPainter
import core.ui.core.ui.painter.starPainter
import core.ui.core.ui.theme.AppShape
import gnixpokedex.feature.home.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeBarWithShadow(
    searchQuery: String,
    onSearch: (String) -> Unit,
    onGoFavorite: () -> Unit,
) {
    Column {
        AdaptiveLayout(
            compactContent = {
                CompactHomeBar(
                    searchQuery = searchQuery,
                    onSearch = onSearch,
                    onGoFavorite = onGoFavorite,
                )
            },
            expandedContent = {
                ExpandHomeBar(
                    searchQuery = searchQuery,
                    onSearch = onSearch,
                    onGoFavorite = onGoFavorite,
                )
            },
        )
    }
}

@Composable
private fun CompactHomeBar(
    searchQuery: String,
    onSearch: (String) -> Unit,
    onGoFavorite: () -> Unit,
) {
    AppTopBar(
        modifier = Modifier.height(AppBarHeight.WideHeight),
        shape = AppShape.BottomOnlyRoundedShape,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Spacer(Modifier.size(24.dp))
                Text(
                    text = "Pokedex",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
                AppIconButton(
                    painter = starPainter(),
                    tint = Color(0xFFf1f0f0),
                    size = 32.dp,
                ) {
                    onGoFavorite()
                }
            }
            AppSearchBar(
                modifier = Modifier.fillMaxWidth(),
                searchQuery = searchQuery,
                onSearch = onSearch,
            )
        }
    }
}

@Composable
private fun ExpandHomeBar(
    searchQuery: String,
    onSearch: (String) -> Unit,
    onGoFavorite: () -> Unit,
) {
    AppTopBar(Modifier.height(AppBarHeight.BasicHeight)) {
        Text(
            text = "Pokedex",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
        )
        AppSearchBar(
            modifier = Modifier.weight(1f),
            searchQuery = searchQuery,
            onSearch = onSearch,
        )
        AppIconButton(
            painter = starPainter(),
            tint = Color.White,
            size = 32.dp,
        ) {
            onGoFavorite()
        }
    }
}

