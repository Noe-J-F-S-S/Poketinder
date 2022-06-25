package com.sierra.poketinder.ui.view

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import com.sierra.poketinder.databinding.FragmentInfoBinding
import com.sierra.poketinder.ui.viewmodel.InfoViewModel

class InfoFragment:BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {
    private  val viewModel: InfoViewModel by viewModels()
    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = binding.wvMain
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = PokemonWebClient()
        viewModel.getUrlPokemon().observe(viewLifecycleOwner){
            webView!!.loadUrl(it)
        }

    }
    inner class PokemonWebClient:WebViewClient(){
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            webView!!.loadUrl("javascript:(function(){"+
            "document.getElementsByClassName('navbar top')[0].style.display='none';})()");
        }
    }
}