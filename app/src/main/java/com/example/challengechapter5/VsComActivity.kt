package com.example.challengechapter5

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import kotlinx.coroutines.delay

class VsComActivity : AppCompatActivity() {
    var PILIHAN_PLAYER_1 = "PILIHAN_PLAYER_1"
    var PILIHAN_COMPUTER = "PILIHAN_COMPUTER"
    var HASIL_GAME = "HASIL_GAME"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vs_com)

        supportActionBar?.hide()

        val cvBatuKiri = findViewById<CardView>(R.id.cardBatu1)
        val cvGuntingKiri = findViewById<CardView>(R.id.cardGunting1)
        val cvKertasKiri = findViewById<CardView>(R.id.cardKertas1)
        val cvBatuKanan = findViewById<CardView>(R.id.cardBatu2)
        val cvGuntingKanan = findViewById<CardView>(R.id.cardGunting2)
        val cvKertasKanan = findViewById<CardView>(R.id.cardKertas2)

        val ivRefresh = findViewById<ImageView>(R.id.iv_refresh)
        val textMiddle = findViewById<TextView>(R.id.textMiddle)
        val tvPlayer1 = findViewById<TextView>(R.id.tv_player_1)

        val valName: String = intent.getStringExtra("valName").toString()

        tvPlayer1.text = valName

        cvBatuKiri.setOnClickListener(View.OnClickListener {
            Log.d(PILIHAN_PLAYER_1, "Batu")
            cvBatuKiri.setCardBackgroundColor(Color.parseColor("#eeeeee"))
            cvGuntingKiri.isEnabled = false
            cvKertasKiri.isEnabled = false
            oneVsComputer("batu")
        })

        cvGuntingKiri.setOnClickListener(View.OnClickListener {
            Log.d(PILIHAN_PLAYER_1, "Gunting")
            cvGuntingKiri.setCardBackgroundColor(Color.parseColor("#eeeeee"))
            cvBatuKiri.isEnabled = false
            cvKertasKiri.isEnabled = false
            oneVsComputer("gunting")
        })

        cvKertasKiri.setOnClickListener(View.OnClickListener {
            Log.d(PILIHAN_PLAYER_1, "Kertas")
            cvKertasKiri.setCardBackgroundColor(Color.parseColor("#eeeeee"))
            cvGuntingKiri.isEnabled = false
            cvBatuKiri.isEnabled = false
            oneVsComputer("kertas")
        })

        ivRefresh.setOnClickListener(View.OnClickListener {
            cvBatuKiri.isEnabled = true
            cvGuntingKiri.isEnabled = true
            cvKertasKiri.isEnabled = true
            cvBatuKiri.setCardBackgroundColor(Color.parseColor("#ffffff"))
            cvGuntingKiri.setCardBackgroundColor(Color.parseColor("#ffffff"))
            cvKertasKiri.setCardBackgroundColor(Color.parseColor("#ffffff"))
            cvBatuKanan.setCardBackgroundColor(Color.parseColor("#ffffff"))
            cvGuntingKanan.setCardBackgroundColor(Color.parseColor("#ffffff"))
            cvKertasKanan.setCardBackgroundColor(Color.parseColor("#ffffff"))

            textMiddle.text = "VS"
            textMiddle.setTextColor(Color.parseColor("#E82E2E"))
            textMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 44F);
        })
    }

    fun oneVsComputer(pilihan1: String) {
        val list = listOf("gunting", "batu", "kertas")
        val pilihan2 = list.asSequence().shuffled().find { true }
        Log.d(PILIHAN_COMPUTER, pilihan2.toString())

        val cvBatuKanan = findViewById<CardView>(R.id.cardBatu2)
        val cvGuntingKanan = findViewById<CardView>(R.id.cardGunting2)
        val cvKertasKanan = findViewById<CardView>(R.id.cardKertas2)
        val textMiddle = findViewById<TextView>(R.id.textMiddle)
        val valName: String = intent.getStringExtra("valName").toString()

        when (pilihan2) {
            "batu" -> cvBatuKanan.setCardBackgroundColor(Color.parseColor("#eeeeee"))
            "gunting" -> cvGuntingKanan.setCardBackgroundColor(Color.parseColor("#eeeeee"))
            "kertas" -> cvKertasKanan.setCardBackgroundColor(Color.parseColor("#eeeeee"))
        }

        Toast.makeText(this, valName + " memilih " + pilihan1 + "\nCPU memilih " + pilihan2, Toast.LENGTH_LONG).show()

        if (pilihan1 == pilihan2) {
            Log.d(HASIL_GAME, "player 1 dan player 2 Draw")
            textMiddle.text = "DRAW"
            textMiddle.setTextColor(Color.parseColor("#1C8EDA"))
            textMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36F);
            showDialog("SERI!", valName)
        } else if (pilihan1 == "gunting" && pilihan2 == "kertas") {
            Log.d(HASIL_GAME, "player 1 MENANG")
            textMiddle.text = "Player 1 Menang"
            textMiddle.setTextColor(Color.parseColor("#4CAF50"))
            textMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F);
            showDialog(valName + "\n Menang!", valName)
        } else if (pilihan1 == "gunting" && pilihan2 == "batu") {
            Log.d(HASIL_GAME, "player 2 MENANG")
            textMiddle.text = "Player 2 Menang"
            textMiddle.setTextColor(Color.parseColor("#4CAF50"))
            textMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F);
            showDialog("CPU \n Menang!", valName)
        } else if (pilihan1 == "batu" && pilihan2 == "kertas") {
            Log.d(HASIL_GAME, "player 2 MENANG")
            textMiddle.text = "Player 2 Menang"
            textMiddle.setTextColor(Color.parseColor("#4CAF50"))
            textMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F);
            showDialog("CPU \n Menang!", valName)
        } else if (pilihan1 == "batu" && pilihan2 == "gunting") {
            Log.d(HASIL_GAME, "player 1 MENANG")
            textMiddle.text = "Player 1 Menang"
            textMiddle.setTextColor(Color.parseColor("#4CAF50"))
            textMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F);
            showDialog(valName + "\n Menang!", valName)
        } else if (pilihan1 == "kertas" && pilihan2 == "gunting") {
            Log.d(HASIL_GAME, "player 2 MENANG")
            textMiddle.text = "Player 2 Menang"
            textMiddle.setTextColor(Color.parseColor("#4CAF50"))
            textMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F);
            showDialog("CPU \n Menang!", valName)
        } else if (pilihan1 == "kertas" && pilihan2 == "batu") {
            Log.d(HASIL_GAME, "player 1 MENANG")
            textMiddle.text = "Player 1 Menang"
            textMiddle.setTextColor(Color.parseColor("#4CAF50"))
            textMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F);
            showDialog(valName + "\n Menang!", valName)
        }
    }

    fun showDialog(deskripsi: String, valName: String){
        val title: String = "Hasil Permainan"

        val cvBatuKiri = findViewById<CardView>(R.id.cardBatu1)
        val cvGuntingKiri = findViewById<CardView>(R.id.cardGunting1)
        val cvKertasKiri = findViewById<CardView>(R.id.cardKertas1)
        val cvBatuKanan = findViewById<CardView>(R.id.cardBatu2)
        val cvGuntingKanan = findViewById<CardView>(R.id.cardGunting2)
        val cvKertasKanan = findViewById<CardView>(R.id.cardKertas2)
        val textMiddle = findViewById<TextView>(R.id.textMiddle)

        val dialog = AlertDialog.Builder(this).create()
        val view = layoutInflater.inflate(R.layout.custom_dialog, null)
        val btn_positive = view.findViewById<Button>(R.id.btn_dialog_positive)
        val btn_negative = view.findViewById<Button>(R.id.btn_dialog_negative)
        val tv_title_dialog = view.findViewById<TextView>(R.id.tv_title_dialog)
        val tv_message_dialog = view.findViewById<TextView>(R.id.tv_message_dialog)

        dialog.setView(view)
        tv_title_dialog.setText(title)
        tv_message_dialog.setText(deskripsi)
        dialog.setIcon(R.drawable.splash_screen1)

        dialog.setCancelable(false)

        btn_positive.setOnClickListener(View.OnClickListener {
            cvBatuKiri.isEnabled = true
            cvGuntingKiri.isEnabled = true
            cvKertasKiri.isEnabled = true
            cvBatuKiri.setCardBackgroundColor(Color.parseColor("#ffffff"))
            cvGuntingKiri.setCardBackgroundColor(Color.parseColor("#ffffff"))
            cvKertasKiri.setCardBackgroundColor(Color.parseColor("#ffffff"))
            cvBatuKanan.setCardBackgroundColor(Color.parseColor("#ffffff"))
            cvGuntingKanan.setCardBackgroundColor(Color.parseColor("#ffffff"))
            cvKertasKanan.setCardBackgroundColor(Color.parseColor("#ffffff"))

            textMiddle.text = "VS"
            textMiddle.setTextColor(Color.parseColor("#E82E2E"))
            textMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 44F);
            dialog.dismiss()
        })

        btn_negative.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MainActivity::class.java).putExtra("valName", valName))
            finish()
        })

        dialog.show()
    }
}