package com.sophia.pokedex.presentation.pokemon.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
    onSearchClick: () -> Unit,
    onPokemonClick: (Int) -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Pokémons")},
                actions = {
                    IconButton(onClick = onSearchClick) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar Pokémon"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
        ){

        }
    }
    
}