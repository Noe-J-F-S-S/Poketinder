package com.sierra.poketinder.data

import android.provider.ContactsContract
import java.io.Serializable

data class User (
    val id: String,
    val name:String,
    val email: String,
    val password:String,
    val confirmpassword:String
        ): Serializable{
            fun getImage()="https://graph.facebook.com/$id/picture?type=large&width=720&height=720"
        }