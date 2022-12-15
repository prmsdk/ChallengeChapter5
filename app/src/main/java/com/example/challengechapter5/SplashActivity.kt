package com.example.challengechapter5

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val SPLASH_SCREEN = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash)

        supportActionBar?.hide()

        //splash
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, LandingPage::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN.toLong())
    }
}
