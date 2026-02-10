package com.davi.dev.gnix_kmp_pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import core.ui.core.ui.theme.Gray95
import core.ui.core.ui.theme.PokemonTheme
import feature.detail.DetailsScreen
import feature.favorite.FavoriteScreen
import feature.home.HomeScreen
import kotlinx.serialization.Serializable
import com.davi.dev.gnix_kmp_pokedex.utils.composableNoAnimation
import com.davi.dev.gnix_kmp_pokedex.utils.composableWithHorizontalSlide
import com.davi.dev.gnix_kmp_pokedex.utils.navigateSingleTop

@Serializable
private sealed interface Routs {
    @Serializable
    data object Home : Routs

    @Serializable
    data class Details(val name: String) : Routs

    @Serializable
    data object Favorite : Routs
}

@Composable
@Preview
fun App() {
    PokemonTheme(darkTheme = false) {
        NavHostMain()
    }
}

@Composable
private fun NavHostMain(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Routs.Home,
        modifier = Modifier.fillMaxSize().background(Gray95),
    ) {
        composableNoAnimation<Routs.Home> {
            HomeScreen(
                onClickItem = { name ->
                    navController.navigateSingleTop(Routs.Details(name = name))
                },
                onGoFavorite = {
                    navController.navigate(Routs.Favorite) {
                        launchSingleTop = true
                    }
                },
            )
        }
        composableWithHorizontalSlide<Routs.Details> { backStackEntry ->
            val details: Routs.Details = backStackEntry.toRoute()
            DetailsScreen(
                name = details.name,
                onBack = navController::navigateUp,
            )
        }
        composableWithHorizontalSlide<Routs.Favorite> {
            FavoriteScreen(
                onClickItem = { name ->
                    navController.navigateSingleTop(Routs.Details(name = name))
                },
                onBack = navController::navigateUp,
            )
        }
    }
}