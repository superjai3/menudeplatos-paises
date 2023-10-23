package com.example.clase5listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var listView: ListView
    private lateinit var button: Button
    private var plato: String? = null
    private var nacion: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R. id.spinner)
        listView = findViewById(R.id.listview)
        button = findViewById(R.id.button)

        val platos = listOf("Desayuno", "Almuerzo", "Cena")
        //platos.add("Postre")

        val paises = listOf("Venezuela", "Chile", "Argentina", "Peru")

        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, platos)
        spinner.adapter = adapterSpinner

        val adapterListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, paises)
        listView.adapter = adapterListView

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                plato = platos [position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        listView.setOnItemClickListener { adapterView, view, position, l ->
            nacion = paises[position]
        }

        button.setOnClickListener {
            if(nacion !=null){

                val intent = Intent(this, SegundaMainActivity::class.java)
                intent.putExtra("plato", plato)
                intent.putExtra("nacion", nacion)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Debe seleccionar un pais", Toast.LENGTH_LONG).show()
            }
        }
    }
}