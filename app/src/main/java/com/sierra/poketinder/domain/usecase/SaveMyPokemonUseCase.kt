package com.sierra.poketinder.domain.usecase

import com.sierra.poketinder.data.PokemonRepository
import com.sierra.poketinder.data.database.entities.toDatabase
import com.sierra.poketinder.domain.model.MyPokemon
import javax.inject.Inject

class SaveMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(myPokemon:MyPokemon){
        pokemonRepository.insertMyPokemon(myPokemon.toDatabase())
    }

}