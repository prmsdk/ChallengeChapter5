package com.example.challengechapter5

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val parentLayout = findViewById<View>(android.R.id.content)

        supportActionBar?.hide()

        val valName: String = intent.getStringExtra("valName").toString()

        val tvMainNama: TextView = findViewById(R.id.tv_main_name)
        val tvVsPlayer: TextView = findViewById(R.id.tv_vs_player)
        val tvVsCom: TextView = findViewById(R.id.tv_vs_com)

        tvVsPlayer.text = valName + " VS Pemain"
        tvVsCom.text = valName + " VS Komputer"

        val snackbar = Snackbar.make(parentLayout, "Selamat Datang " + valName, Snackbar.LENGTH_LONG)
        snackbar.setAction("Tutup"){
            snackbar.dismiss()
        }
        snackbar.show()
    }

    fun vsPlayer(view: View){
        val valName: String = intent.getStringExtra("valName").toString()
        startActivity(Intent(this, VsPlayerActivity::class.java).putExtra("valName", valName))
        finish()
    }

    fun vsCom(view: View){
        val valName: String = intent.getStringExtra("valName").toString()
        startActivity(Intent(this, VsComActivity::class.java).putExtra("valName", valName))
        finish()
    }
}