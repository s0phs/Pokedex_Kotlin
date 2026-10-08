package com.sophia.pokedex.data.repository

import com.sophia.pokedex.data.remote.PokemonRemoteDataSource
import com.sophia.pokedex.domain.common.Resource
import com.sophia.pokedex.domain.model.Pokemon
import com.sophia.pokedex.domain.model.toDomain
import com.sophia.pokedex.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val remoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    override suspend fun getPokemonByNumber(number: Int): Resource<Pokemon> {
        return try {
            val response = remoteDataSource.getPokemonByNumber(number)
            Resource.Success(response.toDomain())
        } catch (exception: Exception) {
            Resource.Error("Não foi possível buscar o Pokémon.")
        }
    }
}