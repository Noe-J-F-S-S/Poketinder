package com.sierra.poketinder.domain.usecase

import com.sierra.poketinder.data.PokemonRepository
import javax.inject.Inject

class DeleteAllMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(){
        pokemonRepository.deleteAllMyPokemon()
    }
}