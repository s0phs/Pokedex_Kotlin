package com.sophia.pokedex.data.remote

import com.sophia.pokedex.domain.model.PokemonResponse


interface PokemonRemoteDataSource {
    suspend fun getPokemonByNumber(number: Int): PokemonResponse
}