package com.sierra.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import com.sierra.poketinder.databinding.ActivitySplashBinding
import com.sierra.poketinder.ui.viewmodel.SplashViewModel
import com.sierra.poketinder.util.SharedPreferenceUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    private val splashViewModel: SplashViewModel by viewModels()
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            SharedPreferenceUtil
            it.setSharedPreference(this)
        }
        splashViewModel.getIsUnderMaintenance().observe(this) {
            if (it) {
                Toast.makeText(this, "Bajo Mantenimiento", Toast.LENGTH_SHORT).show()
            } else {
                showAnimation()
            }
        }
    }
    fun showAnimation() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                //Evaluar si mostrar intro o no
                val isIntroAvailable = sharedPreferenceUtil.getIntroShow()
                if (!isIntroAvailable) {
                    startActivity(Intent(this, OnboardingActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
                finish()
            },
            3000//value in milliseconds
        )
    }
}




