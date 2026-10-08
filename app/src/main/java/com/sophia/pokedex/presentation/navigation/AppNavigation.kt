package com.sophia.pokedex.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sophia.pokedex.presentation.pokemon.detail.PokemonDetailScreen
import com.sophia.pokedex.presentation.pokemon.list.PokemonListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.POKEMON_LIST
    ){
        composable(AppRoutes.POKEMON_LIST){
            PokemonListScreen(
                onSearchClick = {
                    navController.navigate(AppRoutes.POKEMON_SEARCH)
                },
                onPokemonClick = { pokemonNumber ->
                    navController.navigate(
                        AppRoutes.pokemonDetail(pokemonNumber)
                    )
                }
            )
        }

        composable (
            route = AppRoutes.POKEMON_DETAIL,
            arguments = listOf(
                navArgument("pokemonNumber"){
                    type = NavType.IntType
                }
            )
        ){  backStackEntry ->
            val pokemonNumber = backStackEntry.arguments?.getInt("pokemonNumber") ?: 1

            PokemonDetailScreen(
                pokemonNumber = pokemonNumber,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}