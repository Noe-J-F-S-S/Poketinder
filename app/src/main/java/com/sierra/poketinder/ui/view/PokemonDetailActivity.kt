package com.sierra.poketinder.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.sierra.poketinder.R
import com.sierra.poketinder.databinding.ActivityPokemonDetailBinding
import com.sierra.poketinder.ui.viewmodel.HomeViewModel
import com.sierra.poketinder.ui.viewmodel.PokemonDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailActivity : BaseActivity<ActivityPokemonDetailBinding> (ActivityPokemonDetailBinding::inflate){
    private val pokemonDetailViewModel: PokemonDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokemonDetailViewModel.isLoading.observe(this) {
            binding.progressBar2.isVisible = it
        }
        pokemonDetailViewModel.pokemonDetailModel.observe(this){
            binding.tvName.text = it.name
        }

        val pokemonId = intent?.extras?.getString("ID_POKEMON", null)

        if (pokemonId != null) {
            Toast.makeText(this, "PokemonId: $pokemonId", Toast.LENGTH_SHORT).show()
        }
    }
}