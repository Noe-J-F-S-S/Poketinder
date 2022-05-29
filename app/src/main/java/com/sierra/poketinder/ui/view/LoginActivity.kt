package com.sierra.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sierra.poketinder.databinding.ActivityLoginBinding
import com.sierra.poketinder.ui.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        loginViewModel = LoginViewModel(this)
        loginViewModel.onCreate()
        loginViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this, "Ingrese los datos de Usuario",
                Toast.LENGTH_SHORT).show()
        }
        loginViewModel.fieldsAuthenticateError.observe(this){
            Toast.makeText(this, "Error de usuario",
                Toast.LENGTH_SHORT).show()
        }
        loginViewModel.goSuccessActivity.observe(this){
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun startLogin(view: View){
        loginViewModel.validateInputs(binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString())
    }
    fun registrar(view: View){
        val intent =Intent(applicationContext,RegisterActivity::class.java)
        startActivity(intent)
    }
}