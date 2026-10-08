package com.sophia.pokedex.data.remote

import com.sophia.pokedex.domain.model.PokemonResponse

class PokemonRemoteDataSourceImpl(
    private val api: PokemonApi
) : PokemonRemoteDataSource {

    override suspend fun getPokemonByNumber(number: Int): PokemonResponse {
        return api.getPokemonByNumber(number)
    }
}