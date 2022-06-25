package com.sierra.poketinder.domain.usecase

import com.sierra.poketinder.data.PokemonRepository
import com.sierra.poketinder.domain.model.Pokemon
import java.security.PrivilegedExceptionAction
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository){
    suspend operator fun invoke():List<Pokemon>{
        val myPokemonList = repository.getMyPokemonsFromDatabase()
        val allPokemon = repository.getAllPokemonFromApi()
        val myPokemonListIds = myPokemonList.map { it.idPokemon }
        return allPokemon.filter {  it.getPokemonId() !in myPokemonListIds }
    }

}