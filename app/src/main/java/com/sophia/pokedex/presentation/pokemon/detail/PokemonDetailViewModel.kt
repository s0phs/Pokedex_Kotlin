package com.sophia.pokedex.presentation.pokemon.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sophia.pokedex.domain.common.Resource
import com.sophia.pokedex.domain.model.Pokemon
import com.sophia.pokedex.domain.usecase.GetPokemonByNumberUseCase
import com.sophia.pokedex.presentation.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val getPokemonByNumberUseCase: GetPokemonByNumberUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<Pokemon>>(
        UiState.Initial
    )
    val uiState: StateFlow<UiState<Pokemon>> = _uiState

    fun getPokemonByNumber(number: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            when (val result = getPokemonByNumberUseCase(number)) {
                is Resource.Success -> {
                    _uiState.value = UiState.Success(result.data)
                }

                is Resource.Error -> {
                    _uiState.value = UiState.Error(result.message)
                }

                Resource.Loading -> {
                    _uiState.value = UiState.Loading
                }
            }
        }
    }

}