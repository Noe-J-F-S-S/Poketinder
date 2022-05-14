package com.sierra.poketinder.viewmodel

import android.content.Context

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sierra.poketinder.data.model.User
import com.sierra.poketinder.util.SharedPreferenceUtil

class LoginViewModel(private val context: Context): ViewModel() {
    private lateinit var sharedPreferencesUtil: SharedPreferenceUtil
    val emptyFieldsError = MutableLiveData<Boolean>()
    val fieldsAuthenticateError = MutableLiveData<Boolean>()
    val goSuccessActivity = MutableLiveData<Boolean>()
    fun onCreate(){
        sharedPreferencesUtil= SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }
    fun validateInputs(email:String, password:String){
        if(email.isEmpty() && password.isEmpty()){
            emptyFieldsError.postValue(true)
        }
        val user: User? = sharedPreferencesUtil.getUser()
        if(email.equals(user?.email) && password.equals(user?.password)){
            goSuccessActivity.postValue(true)
        }else{
            fieldsAuthenticateError.postValue(true)
        }
    }
}