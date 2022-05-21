package com.sierra.poketinder.domain.usecase

import com.sierra.poketinder.data.PokemonRepository
import com.sierra.poketinder.domain.model.Pokemon
import java.security.PrivilegedExceptionAction
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val repository: PokemonRepository){
    suspend operator fun invoke():List<Pokemon>{
        return repository.getAllPokemonFromApi()
    }

}