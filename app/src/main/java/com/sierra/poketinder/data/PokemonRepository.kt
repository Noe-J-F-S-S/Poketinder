package com.sierra.poketinder.data

import com.sierra.poketinder.data.model.PokemonListModel
import com.sierra.poketinder.data.model.PokemonModel
import com.sierra.poketinder.data.network.PokemonService
import com.sierra.poketinder.domain.model.Pokemon
import com.sierra.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel=pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }

    }
}