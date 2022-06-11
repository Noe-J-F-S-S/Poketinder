package com.sierra.poketinder.domain.usecase

import com.sierra.poketinder.data.PokemonRepository
import com.sierra.poketinder.data.model.PokemonDetailModel
import javax.inject.Inject

class GetMyPokemonDetailUseCase @Inject constructor(private val repository: PokemonRepository){
    suspend operator fun invoke(idPokemon: String): PokemonDetailModel{
        return repository.getPokemonDetailFromApi(idPokemon)
    }
}