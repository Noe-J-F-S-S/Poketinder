package com.sierra.poketinder.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding>(val bindingFactory: (LayoutInflater)->B): AppCompatActivity() {

    lateinit var binding: B
    override  fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }
}