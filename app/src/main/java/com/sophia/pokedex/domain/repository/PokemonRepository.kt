package com.sophia.pokedex.domain.repository

import com.sophia.pokedex.domain.common.Resource
import com.sophia.pokedex.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemonByNumber(number: Int): Resource<Pokemon>
}