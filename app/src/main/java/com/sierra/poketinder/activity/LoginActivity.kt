package com.sierra.poketinder.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sierra.poketinder.data.User
import com.sierra.poketinder.databinding.ActivityLoginBinding
import com.sierra.poketinder.databinding.AlertdialogBinding
import com.sierra.poketinder.util.SharedPreferenceUtil
import android.app.AlertDialog

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        sharedPreferenceUtil=SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
    }
    fun startLogin(view: View){
        //validateInput()
        val user: User? = sharedPreferenceUtil.getUser()
        val builder = AlertDialog.Builder(this)
        if(user?.email.equals(binding.edtEmail.text.toString()) &&
            user?.password.equals(binding.edtPassword.text.toString())){
            val intent=Intent( this, MainActivity::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }
        else if(binding.edtEmail.text.isEmpty() ){
            builder.setTitle("Notificacion").setMessage("Campo email vacio").show()
            //Toast.makeText(this, "Los campos estan vacios", Toast.LENGTH_SHORT).show()
        }else if (binding.edtPassword.text.isEmpty()){
            builder.setTitle("Notificacion").setMessage("Campo contraseña vacio").show()
        }
        else{
            builder.setTitle("Notificacion").setMessage("Usuario incorrecto").show()
            Toast.makeText(this, "Error Usuario", Toast.LENGTH_SHORT).show()
        }
    }
}