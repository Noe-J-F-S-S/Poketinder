package com.sierra.poketinder.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.sierra.poketinder.data.Onboarding
import com.sierra.poketinder.databinding.ActivitySplashBinding
import com.sierra.poketinder.util.SharedPreferenceUtil

class SplashActivity :BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)

        sharedPreferenceUtil=SharedPreferenceUtil().also { SharedPreferenceUtil
        it.setSharedPreference(this)
        }
        Handler(Looper.getMainLooper()).postDelayed(
            {
                //Evaluar si mostrar intro o no
                val isIntroAvailable = sharedPreferenceUtil.getIntroShow()
                if(!isIntroAvailable){
                    startActivity(Intent(this,OnboardingActivity::class.java))
                }else{
                    startActivity(Intent( this,LoginActivity::class.java))
                }
                finish()
            },
            3000//value in milliseconds
        )
    }


}


