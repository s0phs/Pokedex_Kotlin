package com.sophia.pokedex.presentation.navigation

object AppRoutes {
    const val POKEMON_LIST = "pokemon_list"
    const val POKEMON_SEARCH = "pokemon_search"
    const val POKEMON_DETAIL = "pokemon_detail/{pokemonNumber}"

    fun pokemonDetail(pokemonNumber: Int): String {
        return "pokemon_detail/$pokemonNumber"
    }
}