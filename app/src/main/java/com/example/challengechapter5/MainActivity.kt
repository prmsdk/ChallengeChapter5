package com.example.challengechapter5

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.bumptech.glide.Glide

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
        val ivVsPlayer: ImageView = findViewById(R.id.iv_vs_player)

        tvVsPlayer.text = valName + " VS Pemain"
        tvVsCom.text = valName + " VS Komputer"

        Glide.with(this).load("https://lh3.googleusercontent.com/W6Gz9Qx5y6xHXNVMpM1OkhuxJS_IrLP627ZecWJ-d19VzEkXFHLPCrtboFjt4uctO6xo6BtQPKdlpbNTAOstravMNgd9a3La7LamCjtXyDx5UbmswEdnqCJFkho_H5VFPgDp0oMxRNMp8ojT5_G23IlTxU4UuGhVY0oxY8iGydvXIjVo-oxQfKKN_CQO5n4FkHfyh_lLcZBvbPCeCDQ3qRJiWZpXMoExLu90NOHQNAaJe-P98E2boOElr34o5UYYjQbSsIj5W8yvdQ1HJqxBipCOEnYAAFbRuEUvGnACyFI_oSP4Xq5k59AqB4MKExBSWjq4BrJp7WnszwFX_RyYE8v8WaIi3tkfZQBBeb2fHNzKlm5b0kNlfAnwFSrOSGV-7H9VLCiL7B1cc561qeJm-k_w-plG-bEG0Epu4pSSvnd_ydYRF0ywALTBKIHmt2I0Emx2y8Sl-5daym_nYqmxgeu8Re8VKEo_4XURpA-Rs87U116fK_fe6RgmxJOBKMEfwGmATenVvsnGn2kn3Ft3obL_-Kx1z7x7ChseYfDmC893M41_rgZkgEkQ7hJgluoVxe7QyQwCZsei5k57nEXWLpLj0mEosGo0vmLy4ZjD5rNJ9jtZbT52t9ZPUiuC2qdb46XqfeLQsc7wgs_tQLherbOnX2sadzWuzYbQPzv9MbXXB_deSrjPQhoMW3OZq-YT4Cp_bevH1H9HHToLRBZLAsgLcRAMNMFDBh2dueNc-wP90J4cef_ei1kAg_SspFKjtlLsDUnW_ZZ9N4vDPxNobukAXD7BaIdXUGIEqT7bdP4WcfCUPc-qWlKubKAUVdh4Xwt3EJ9omYY55BCXThSuUfyRQCTsEEOtgX3XQHx4Ak7FIq-GoKRcVrobTFsxa6VDbq_Gn-XU0jan17PLvP7Ma0RffqXuc_m5-hvHPC1voKTgtKZ-mxE-QzYaYfFets5UtoLzjK_2bCVU_DBpkngAP6z1y-yjR7No94tHcALrVU3Xu332PtmM19apRN5jSkt_Yk_-oRDV7qgZ75bpd451SscpEABPZKXZw7ak2bOXaR5f0SSs1Q8sZ0E=s512-no?authuser=0")
            .into(ivVsPlayer)

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