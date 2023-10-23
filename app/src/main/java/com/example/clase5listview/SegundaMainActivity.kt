package com.example.clase5listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SegundaMainActivity : AppCompatActivity() {

    private lateinit var tvPlato: TextView
    private lateinit var tvNacion: TextView
    private lateinit var btnVolver: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_main)

        val result = intent.extras
        val plato = result?.getString("plato") ?: "sin plato"
        val nacion = result?.getString("nacion") ?: "sin nación"

        tvPlato = findViewById(R.id.textViewPlato)
        tvNacion = findViewById(R.id.textViewNacion)
        btnVolver = findViewById(R.id.buttonVolver)


        tvPlato.text = plato
        tvNacion.text = nacion

        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}