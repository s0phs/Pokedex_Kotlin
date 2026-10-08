package com.sophia.pokedex.data.remote

import com.sophia.pokedex.domain.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon/{number}")
    suspend fun getPokemonByNumber(
        @Path("number") number: Int
    ): PokemonResponse
}