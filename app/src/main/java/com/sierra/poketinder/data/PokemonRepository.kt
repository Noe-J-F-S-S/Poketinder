package com.sierra.poketinder.data

import com.sierra.poketinder.data.database.dao.PokemonDao
import com.sierra.poketinder.data.database.entities.MyPokemonEntity
import com.sierra.poketinder.data.model.PokemonDetailModel
import com.sierra.poketinder.data.model.PokemonListModel
import com.sierra.poketinder.data.model.PokemonModel
import com.sierra.poketinder.data.network.PokemonService
import com.sierra.poketinder.domain.model.MyPokemon
import com.sierra.poketinder.domain.model.Pokemon
import com.sierra.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
    private val pokemonDao: PokemonDao
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel = pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }
    }
    suspend fun getPokemonDetailFromApi(idPokemon: String):PokemonDetailModel{
        return pokemonService.getPokemonById(idPokemon)
    }

    suspend fun getMyPokemonsFromDatabase(): List<MyPokemon> {
        val response:List<MyPokemonEntity> = pokemonDao.getAllPokemons()
        return response.map{it.toDomain()}
    }
    suspend fun insertMyPokemon(myPokemon: MyPokemonEntity){
        pokemonDao.insert(myPokemon)
    }
    suspend fun deleteAllMyPokemon(){
        pokemonDao.deleteTable()
    }
}