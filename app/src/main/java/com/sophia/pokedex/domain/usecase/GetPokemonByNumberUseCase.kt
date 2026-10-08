package com.sophia.pokedex.domain.usecase

import com.sophia.pokedex.domain.common.Resource
import com.sophia.pokedex.domain.model.Pokemon
import com.sophia.pokedex.domain.repository.PokemonRepository

class GetPokemonByNumberUseCase(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(number: Int): Resource<Pokemon> {
        if (number <= 0) {
            return Resource.Error("Informe um número maior que zero.")
        }

        if (number > 1025) {
            return Resource.Error("Informe um número válido até 1025.")
        }

        return repository.getPokemonByNumber(number)
    }
}