package com.sierra.poketinder.activity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sierra.poketinder.data.User
import com.sierra.poketinder.databinding.ActivityRegisterBinding
import com.sierra.poketinder.util.SharedPreferenceUtil

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        sharedPreferenceUtil=SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
    }
    fun registerUser(veir: View){
        val user = User(
            id="1",
            name= binding.edtUserName.text.toString(),
            email = binding.edtEmail.text.toString(),
            password = binding.edtPassword.text.toString(),
            confirmpassword =binding.edtPassword2.text.toString())
        val builder = AlertDialog.Builder(this)
        if (binding.edtUserName.text.isEmpty() ){
            builder.setTitle("Notificacion").setMessage("Campo usuario vacio").show()
            Toast.makeText(this, "Ingresar nombre de usuario", Toast.LENGTH_SHORT).show()
        }
        else if(binding.edtEmail.text.isEmpty()){
            builder.setTitle("Notificacion").setMessage("Campo email vacio").show()
            Toast.makeText(this, "Ingresar email", Toast.LENGTH_SHORT).show()
        }
        else if(binding.edtPassword.text.isEmpty()){
            builder.setTitle("Notificacion").setMessage("Campo contraseña vacio").show()
            Toast.makeText(this, "Ingresar contraseña", Toast.LENGTH_SHORT).show()
        }
        else if(binding.edtPassword2.text.isEmpty()){
            builder.setTitle("Notificacion").setMessage("Campo validacion de contraseña vacio").show()
            Toast.makeText(this, "valida contraseña", Toast.LENGTH_SHORT).show()
        }
        else if (binding.edtPassword.text.toString() != binding.edtPassword2.text.toString()){
            builder.setTitle("Notificacion").setMessage("Las oontraseñas no coinciden").show()
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
        }
        else {
            sharedPreferenceUtil.saveFacebookUser(user)

            val intent =Intent(applicationContext, LoginActivity::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }
    }
    fun loginUser(view:View){
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
    }
}