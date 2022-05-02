package com.sierra.poketinder.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.util.prefs.PreferencesFactory

abstract class BaseActivity<B : ViewBinding>(val bindingFactory: (LayoutInflater)->B): AppCompatActivity() {

    lateinit var binding: B
    override  fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }
}