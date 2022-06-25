package com.sierra.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sierra.poketinder.data.FirebaseRemoteConfigRepository

class InfoViewModel : ViewModel() {
    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init {
        firebaseRemoteConfigRepository.init()
    }
    fun getUrlPokemon(): MutableLiveData<String>{
        return firebaseRemoteConfigRepository.getUrlPokemonLiveData
    }
}