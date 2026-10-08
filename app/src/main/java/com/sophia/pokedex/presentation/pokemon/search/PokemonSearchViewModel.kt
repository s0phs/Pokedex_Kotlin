package com.sophia.pokedex.presentation.pokemon.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PokemonSearchViewModel : ViewModel() {
    private val _pokemonNumber = MutableStateFlow("")
    val pokemonNumber: StateFlow<String> = _pokemonNumber

    fun onPokemonNumberChanged(value: String) {
        _pokemonNumber.value = value.filter { it.isDigit() }
    }

    fun getPokemonNumberOrNull(): Int? {
        return _pokemonNumber.value.toIntOrNull()
    }
}