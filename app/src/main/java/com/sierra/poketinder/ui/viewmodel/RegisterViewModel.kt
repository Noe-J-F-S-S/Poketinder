package com.sierra.poketinder.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sierra.poketinder.data.model.User
import com.sierra.poketinder.util.SharedPreferenceUtil

class RegisterViewModel(private val context: Context): ViewModel() {
    private lateinit var sharedPreferencesUtil: SharedPreferenceUtil
    val emptyFields = MutableLiveData<Boolean>()
    val emptyName = MutableLiveData<Boolean>()
    val emptyEmail = MutableLiveData<Boolean>()
    val emptyPassword = MutableLiveData<Boolean>()
    val emptyConfirmPassword = MutableLiveData<Boolean>()
    val passwordComparacion = MutableLiveData<Boolean>()
    val goSuccessActivity = MutableLiveData<Boolean>()

    fun onCreate() {
        sharedPreferencesUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }
    fun validateInput(name:String,email:String, password:String,confirmpassword:String){
        val user = User(
            id="1",
            name= name,
            email = email,
            password = password,
            confirmpassword =confirmpassword)
        sharedPreferencesUtil.saveFacebookUser(user)

        if((password == confirmpassword) && name.isNotEmpty()
            && email.isNotEmpty() && password.isNotEmpty()
            && confirmpassword.isNotEmpty()){
            goSuccessActivity.postValue(true)
        }else{
            if(name.isEmpty()&& email.isEmpty() && password.isEmpty()
                && confirmpassword.isEmpty()){
                emptyFields.postValue(true)
            }
            else if(name.isEmpty()){
                emptyName.postValue(true)
            }
            else if(email.isEmpty()){
                emptyEmail.postValue(true)
            }
            else if(password.isEmpty()){
                emptyPassword.postValue(true)
            }
            else if(confirmpassword.isEmpty()){
                emptyConfirmPassword.postValue(true)
            }
            else if(password != confirmpassword){
                passwordComparacion.postValue(true)
            }
        }
    }
}