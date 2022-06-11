package com.sierra.poketinder.domain.model

import com.google.gson.annotations.SerializedName
import com.sierra.poketinder.data.model.PokemonDetailModel

data class PokemonDetail(val id: Int,
                         val name: String,
                         val base_experience: Int,
                         val height: Int,
                         val weight: Int,
                         val stats: List<Stats>,
                         val types: List<Types>,
                         val abilities: List<Abilities>) {
    fun PokemonDetailModel.ToDomain() = PokemonDetail(id = id,
        name=name,
        base_experience = base_experience,
        height = height,
        weight = weight,
        stats = stats,
        types = types,
        abilities = abilities)
}