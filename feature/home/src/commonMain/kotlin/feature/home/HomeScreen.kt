package feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import core.ui.core.ui.composable.*
import core.ui.core.ui.painter.menuPainter
import core.ui.core.ui.painter.starPainter
import core.ui.core.ui.state.UIState
import core.ui.core.ui.theme.AppShape
import feature.home.composable.AppSearchBar
import feature.home.composable.PokemonItem
import kotlinx.coroutines.launch
import model.SimplePokemon
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    onClickItem: (name: String) -> Unit,
    onGoFavorite: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val data by viewModel.homeData.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.fetchInitialData()
    }

    PokemonListContent(
        isLoading = uiState is UIState.Loading,
        data = data,
        onClickItem = { onClickItem(it.name) },
        onClickSave = viewModel::bookmark,
        onLoadNext = viewModel::loadNextPage,
        onSearch = viewModel::changeSearchQuery,
        onGoFavorite = onGoFavorite,
    )

    when (val state = uiState) {
        is UIState.Failure -> {
            ErrorDialog(
                throwable = state.throwable,
                onDismiss = viewModel::releaseState,
            )
        }

        else -> {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PokemonListContent(
    isLoading: Boolean,
    data: HomeData,
    onClickItem: (SimplePokemon) -> Unit,
    onClickSave: (SimplePokemon) -> Unit,
    onLoadNext: () -> Unit,
    onSearch: (String) -> Unit,
    onGoFavorite: () -> Unit,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    NavigationDrawer(
        drawerState,
        onGoFavorite
    ) {
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    title = {
                        Text(
                            "What Pokemon are you looking for?",
                            style = MaterialTheme.typography.titleLarge,
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(menuPainter(), contentDescription = "Menu")
                        }
                    }, actions = {
                        AppIconButton(
                            painter = starPainter(),
                            tint = Color.Red,
                            size = 32.dp,
                        ) {
                            onGoFavorite()
                        }
                    }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.TopCenter,
            ) {
                AdaptiveLayout(
                    compactContent = AppBarHeight.WideHeight,
                    expandedContent = AppBarHeight.BasicHeight,
                ) { padding ->
                    if (isLoading && data.pokemonList.isEmpty()) {
                        LoadingGridContent(padding)
                    } else {
                        Column {
                            DataGridContent(
                                data = data,
                                onSearch = onSearch,
                                topPadding = padding,
                                isLoading = isLoading,
                                list = data.pokemonList.search(data.searchQuery),
                                bookmarkIds = data.bookmarkIds,
                                hasNext = data.hasNext == true,
                                onClickItem = onClickItem,
                                onClickSave = onClickSave,
                                onLoadMore = onLoadNext,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun LoadingGridContent(topPadding: Dp) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(
            start = 5.dp,
            end = 5.dp,
            top = topPadding,
            bottom = 20.dp,
        ),
    ) {
        items(12) {
            ShimmerEffect(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = AppShape.MediumRoundedCornerShape,
            )
        }
    }
}

@Composable
private fun DataGridContent(
    data: HomeData,
    onSearch: (String) -> Unit,
    topPadding: Dp,
    isLoading: Boolean,
    list: List<SimplePokemon>,
    bookmarkIds: List<String>,
    hasNext: Boolean,
    onClickItem: (SimplePokemon) -> Unit,
    onClickSave: (SimplePokemon) -> Unit,
    onLoadMore: () -> Unit,
) {
    AppSearchBar(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
        searchQuery = data.searchQuery,
        onSearch = onSearch,
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(
            start = 5.dp,
            end = 5.dp,
            top = topPadding,
            bottom = 20.dp,
        ),
    ) {
        items(list, key = { it.name }) { pokemon ->
            PokemonItem(
                id = pokemon.id,
                name = pokemon.name,
                iconUrl = pokemon.url,
                isBookmarked = bookmarkIds.contains(pokemon.id),
                onClick = { onClickItem(pokemon) },
                onClickSave = { onClickSave(pokemon) },
            )
        }
        item {
            if (!hasNext) return@item

            LaunchedEffect(true) {
                onLoadMore()
            }
            if (isLoading) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator(color = Color.White)
                }
            }
        }
    }
}
