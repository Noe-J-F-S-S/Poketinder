package com.sierra.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sierra.poketinder.databinding.ActivityRegisterBinding
import com.sierra.poketinder.ui.viewmodel.RegisterViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {

    private lateinit var registerViewModel: RegisterViewModel
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        registerViewModel = RegisterViewModel(this)
        registerViewModel.onCreate()
        registerViewModel.emptyFields.observe(this) {
            Toast.makeText(this, "Los campos estan vacios",
                Toast.LENGTH_SHORT).show()
        }
        registerViewModel.emptyName.observe(this) {
            Toast.makeText(this, "Campo name vacio",
                Toast.LENGTH_SHORT).show()
        }
        registerViewModel.emptyEmail.observe(this) {
            Toast.makeText(this, "Campo email vacio",
                Toast.LENGTH_SHORT).show()
        }
        registerViewModel.emptyPassword.observe(this) {
            Toast.makeText(this, "Campo password vacio",
                Toast.LENGTH_SHORT).show()
        }
        registerViewModel.emptyConfirmPassword.observe(this) {
            Toast.makeText(this, "Campo confirmpassword vacio",
                Toast.LENGTH_SHORT).show()
        }
        registerViewModel.passwordComparacion.observe(this) {
            Toast.makeText(this, "Las contraseñas son diferentes",
                Toast.LENGTH_SHORT).show()
        }
        registerViewModel.goSuccessActivity.observe(this){
            val intent =Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
    fun registerUser(veiw: View){
        registerViewModel.validateInput(binding.edtUserName.text.toString(),
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString(),
            binding.edtPassword2.text.toString())
    }
    fun loginUser(view:View){
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
    }
}