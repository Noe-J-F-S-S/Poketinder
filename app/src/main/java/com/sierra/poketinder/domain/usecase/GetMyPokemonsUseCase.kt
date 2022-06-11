package com.sierra.poketinder.domain.usecase

import com.sierra.poketinder.data.PokemonRepository
import com.sierra.poketinder.domain.model.MyPokemon
import javax.inject.Inject

class GetMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository){
    suspend operator fun invoke(): List<MyPokemon>{
        return pokemonRepository.getMyPokemonsFromDatabase()
    }
}