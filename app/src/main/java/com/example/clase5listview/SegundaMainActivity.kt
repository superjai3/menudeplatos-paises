package com.example.clase5listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clase5listview.R.id

class SegundaMainActivity : AppCompatActivity() {

    private lateinit var tvPlato: TextView
    private lateinit var tvNacion: TextView
    private lateinit var btnVolver: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_main)

        recyclerView = findViewById(R.id.recycler_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        recyclerView.adapter = adapter

        val result = intent.extras
        val plato = result?.getString("plato") ?: "sin plato"
        val nacion = result?.getString("nacion") ?: "sin nación"
        val listaComida = getComidas()
        adapter.submitList(listaComida)

        tvPlato = findViewById(id.textViewPlato)
        tvNacion = findViewById(id.textViewNacion)
        btnVolver = findViewById(id.buttonVolver)

        tvPlato.text = plato
        tvNacion.text = nacion

        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }

    private fun getComidas(): MutableList <Comida> {
        return mutableListOf(
            Comida(1, "Medialunas", 5, Bandera.ARGENTINA, "Harina, Manteca, Azúcar, Levadura, Leche", ComidaTipo.DESAYUNO, "https://assets.elgourmet.com/wp-content/uploads/2011/09/shutterstock_1366373012-1024x683.jpg.webp"),
            Comida(2, "Facturas", 4, Bandera.ARGENTINA, "Harina, Manteca, Azúcar, Levadura, Crema pastelera", ComidaTipo.DESAYUNO, "https://pampadirect.com/product_images/uploaded_images/facturas-de-argentina-para-la-merienda.jpg"),
            Comida(3, "Churros", 5, Bandera.ARGENTINA, "Harina, Agua, Sal, Aceite, Azúcar", ComidaTipo.DESAYUNO, "https://d1kxxrc2vqy8oa.cloudfront.net/wp-content/uploads/2020/09/28221827/RFB-1208-1-churrosrellenos.jpg"),
            Comida(4, "Mate Cocido", 3,Bandera.ARGENTINA, "Yerba mate, Agua caliente, Leche (opcional), Azúcar (opcional)", ComidaTipo.DESAYUNO, "https://www.noticiasagropecuarias.com/wp-content/uploads/2021/03/mate-cocido-el.jpg"),
            Comida(5, "Tostadas con Dulce de Leche", 4, Bandera.ARGENTINA, "Pan, Dulce de leche", ComidaTipo.DESAYUNO, "https://cdn7.kiwilimon.com/recetaimagen/24737/19978.jpg"),
            Comida(6, "Arepas", 4, Bandera.VENEZUELA, "Harina de Maíz, Agua, Sal, Rellenos varios", ComidaTipo.DESAYUNO, "https://i.blogs.es/8ad4da/arepas/450_1000.jpg"),
            Comida(7, "Cachapas", 5, Bandera.VENEZUELA, "Maíz tierno, Harina de maíz, Leche, Azúcar, Queso", ComidaTipo.DESAYUNO, "https://i.ytimg.com/vi/4W4z6eFOMwQ/maxresdefault.jpg"),
            Comida(8, "Tequeños", 5, Bandera.VENEZUELA, "Masa para empanadas, Queso blanco, Aceite para freír", ComidaTipo.DESAYUNO, null),
            Comida(9, "Mandocas", 4, Bandera.VENEZUELA, "Harina de maíz, Papelón (panela), Anís en grano, Canela en polvo", ComidaTipo.DESAYUNO, null),
            Comida(10, "Bollos Pelones", 4, Bandera.VENEZUELA, "Harina de maíz, Carne de res desmechada, Cebolla, Pimentón", ComidaTipo.DESAYUNO, null),
            Comida(11, "Tamales", 4, Bandera.PERU, "Masa de maíz, Rellenos de pollo o cerdo, Aliños", ComidaTipo.DESAYUNO, null),
            Comida(12, "Pan con Chicharrón", 5, Bandera.PERU, "Pan francés, Chicharrón, Camote, Ají", ComidaTipo.DESAYUNO, null),
            Comida(13, "Sánguche de Pavo", 3, Bandera.PERU, "Pan francés, Pavo asado, Salsa criolla, Lechuga", ComidaTipo.DESAYUNO, null),
            Comida(14, "Tortilla de Huevo", 3, Bandera.PERU, "Huevos, Aceite, Sal, Pimienta, Queso (opcional)", ComidaTipo.DESAYUNO, null),
            Comida(15, "Quinoa Atamalada", 4, Bandera.PERU, "Quinoa, Leche, Azúcar, Pasas, Canela", ComidaTipo.DESAYUNO, null),
            Comida(16, "Marraquetas con Palta", 3, Bandera.CHILE, "Marraqueta, Palta (aguacate), Sal, Limón", ComidaTipo.DESAYUNO, null),
            Comida(17, "Sopaipillas Pasadas", 4, Bandera.CHILE, "Sopaipillas, Chancaca (jarabe de caña), Agua, Canela en rama", ComidaTipo.DESAYUNO, null),
            Comida(18, "Berlines", 5, Bandera.CHILE, "Masa de pan, Rellenos de crema pastelera o manjar, Azúcar glass", ComidaTipo.DESAYUNO, null),
            Comida(19, "Colaciones", 4, Bandera.CHILE, "Maicena, Leche, Azúcar, Esencia de vainilla", ComidaTipo.DESAYUNO, null),
            Comida(20, "Caldillo de Congrio", 4, Bandera.CHILE, "Congrio, Cebolla, Zanahoria, Papas, Pimentón", ComidaTipo.DESAYUNO, null),
            Comida(21, "Asado", 5, Bandera.ARGENTINA, "Carne de res, Chimichurri, Asador", ComidaTipo.ALMUERZO, null),
            Comida(22, "Milanesa a la Napolitana", 5, Bandera.ARGENTINA, "Carne de res, Pan rallado, Huevo, Jamón, Salsa de tomate, Queso", ComidaTipo.ALMUERZO, null),
            Comida(23, "Locro", 5, Bandera.ARGENTINA, "Maíz, Porotos (judías), Carne de res, Chorizo, Calabaza", ComidaTipo.ALMUERZO, null),
            Comida(24, "Matambre a la Pizza", 4, Bandera.ARGENTINA, "Matambre de res, Masa para pizza, Salsa de tomate, Queso", ComidaTipo.ALMUERZO, null),
            Comida(25, "Empanadas Criollas", 5, Bandera.ARGENTINA, "Masa para empanadas, Carne molida, Cebolla, Huevo duro, Aceitunas", ComidaTipo.ALMUERZO, null),
            Comida(26, "Pabellón Criollo", 5, Bandera.VENEZUELA, "Carne mechada, Arroz, Caraotas negras, Tajadas de plátano", ComidaTipo.ALMUERZO, null),
            Comida(27, "Asado Negro", 5, Bandera.VENEZUELA, "Carne de res, Cebolla caramelizada, Vino tinto, Caldo de res", ComidaTipo.ALMUERZO, null),
            Comida(28, "Hallaca", 5, Bandera.VENEZUELA, "Masa de maíz rellena con guiso de carne de res, pollo, cerdo, aceitunas, pasas y alcaparras", ComidaTipo.ALMUERZO, null),
            Comida(29, "Cazón en Ajo", 4, Bandera.VENEZUELA, "Cazón (pez), Ajo, Limón, Aceite, Sal", ComidaTipo.ALMUERZO, null),
            Comida(30, "Pescado a la Margariteña", 4, Bandera.VENEZUELA, "Pargo rojo, Tomate, Cebolla, Pimientos, Aceitunas", ComidaTipo.ALMUERZO, null),
            Comida(31, "Ceviche", 5, Bandera.PERU, "Pescado fresco, Limón, Cilantro, Cebolla roja, Ají", ComidaTipo.ALMUERZO, null),
            Comida(32, "Lomo Saltado", 5, Bandera.PERU, "Filete de res, Tomate, Cebolla, Ají amarillo, Papas fritas", ComidaTipo.ALMUERZO, null),
            Comida(33, "Anticuchos", 5, Bandera.PERU, "Corazón de res, Ají panca, Comino, Ajo, Papas cocidas", ComidaTipo.ALMUERZO, null),
            Comida(34, "Seco de Cordero", 4, Bandera.PERU, "Cordero, Cilantro, Ají amarillo, Cerveza negra, Arroz", ComidaTipo.ALMUERZO, null),
            Comida(35, "Ajiaco de Papa", 4, Bandera.PERU, "Papas, Queso fresco, Ají amarillo, Leche, Huevos", ComidaTipo.ALMUERZO, null),
            Comida(36, "Pastel de Choclo", 4, Bandera.CHILE, "Choclo, Carne de res, Cebolla, Huevo duro, Aceitunas", ComidaTipo.ALMUERZO, null),
            Comida(37, "Charquicán", 4, Bandera.CHILE, "Carne de res seca, Papas, Calabaza, Cebolla, Maíz", ComidaTipo.ALMUERZO, null),
            Comida(38, "Arrollado Huaso", 4, Bandera.CHILE, "Carne de cerdo, Tocino, Pepinillos, Zanahoria, Huevo duro", ComidaTipo.ALMUERZO, null),
            Comida(39, "Caldillo de Congrio", 5, Bandera.CHILE, "Congrio, Cebolla, Zanahoria, Papas, Pimentón", ComidaTipo.ALMUERZO, null),
            Comida(40, "Curanto", 5, Bandera.CHILE, "Mariscos, Carnes, Papas, Milcaos, Chapaleles", ComidaTipo.ALMUERZO, null),
            Comida(41, "Dulce de Leche con Facturas", 5, Bandera.ARGENTINA, "Dulce de leche, Facturas (masa dulce)", ComidaTipo.MERIENDA, null),
            Comida(42, "Chocotorta", 5, Bandera.ARGENTINA, "Galletas de chocolate, Queso crema, Dulce de leche, Chocolate rallado", ComidaTipo.MERIENDA, null),
            Comida(43, "Torta Rogel", 5, Bandera.ARGENTINA, "Masa para empanadas, Dulce de leche, Merengue italiano", ComidaTipo.MERIENDA, null),
            Comida(44, "Alfajores", 5, Bandera.ARGENTINA, "Maicena, Dulce de leche, Coco rallado, Glaseado de chocolate", ComidaTipo.MERIENDA, null),
            Comida(45, "Vigilantes", 4, Bandera.ARGENTINA, "Queso y dulce, Dulce de membrillo o batata", ComidaTipo.MERIENDA, null),
            Comida(46, "Quesillo", 5, Bandera.VENEZUELA, "Huevos, Leche condensada, Azúcar", ComidaTipo.MERIENDA, null),
            Comida(47, "Bienmesabe", 5, Bandera.VENEZUELA, "Coco rallado, Azúcar, Mantequilla, Leche condensada", ComidaTipo.MERIENDA, null),
            Comida(48, "Cocada", 5, Bandera.VENEZUELA, "Coco rallado, Azúcar, Agua", ComidaTipo.MERIENDA, null),
            Comida(49, "Besitos de Coco", 4, Bandera.VENEZUELA, "Coco rallado, Clara de huevo, Azúcar", ComidaTipo.MERIENDA, null),
            Comida(50, "Torta de Jojoto", 4, Bandera.VENEZUELA, "Maíz tierno, Harina de trigo, Azúcar, Queso", ComidaTipo.MERIENDA, null),
            Comida(51, "Picarones", 4, Bandera.PERU, "Zapallo, Harina, Anís, Chancaca (jarabe de caña)", ComidaTipo.MERIENDA, null),
            Comida(52, "Turrón de Doña Pepa", 5, Bandera.PERU, "Harina, Anís, Manteca, Mielle", ComidaTipo.MERIENDA, null),
            Comida(53, "Alfajores Peruanos", 5, Bandera.PERU, "Maicena, Dulce de leche, Coco rallado", ComidaTipo.MERIENDA, null),
            Comida(54, "King Kong", 5, Bandera.PERU, "Bizcochuelo, Manjar blanco, Glaseado de chocolate", ComidaTipo.MERIENDA, null),
            Comida(55, "Mazamorra Morada", 4, Bandera.PERU, "Maíz morado, Piña, Cáscara de manzana, Azúcar, Canela", ComidaTipo.MERIENDA, null),
            Comida(56, "Sopaipillas", 4, Bandera.CHILE, "Zapallo, Harina, Levadura, Sal", ComidaTipo.MERIENDA, null),
            Comida(57, "Berlines", 5, Bandera.CHILE, "Masa de pan, Rellenos de crema pastelera o manjar, Azúcar glass", ComidaTipo.MERIENDA, null),
            Comida(58, "Torta de Mil Hojas", 5, Bandera.CHILE, "Masa filo, Crema pastelera, Merengue italiano", ComidaTipo.MERIENDA, null),
            Comida(59, "Kuchen", 4, Bandera.CHILE, "Masa quebrada, Frutas frescas, Crema pastelera, Merengue italiano", ComidaTipo.MERIENDA, null),
            Comida(60, "Leche Asada", 4, Bandera.CHILE, "Leche, Huevos, Azúcar, Esencia de vainilla", ComidaTipo.MERIENDA, null),
            Comida(61, "Milanesa a la Napolitana", 5, Bandera.ARGENTINA, "Carne de res, Pan rallado, Huevo, Jamón, Salsa de tomate, Queso", ComidaTipo.CENA, null),
            Comida(62, "Matambre a la Pizza", 4, Bandera.ARGENTINA, "Matambre de res, Masa para pizza, Salsa de tomate, Queso", ComidaTipo.CENA, null),
            Comida(63, "Locro", 5, Bandera.ARGENTINA, "Maíz, Porotos (judías), Carne de res, Chorizo, Calabaza", ComidaTipo.CENA, null),
            Comida(64, "Tarta de Carne", 4, Bandera.ARGENTINA, "Masa para tarta, Carne molida, Cebolla, Pimiento, Huevo", ComidaTipo.CENA, null),
            Comida(65, "Empanadas Criollas", 5, Bandera.ARGENTINA, "Masa para empanadas, Carne molida, Cebolla, Huevo duro, Aceitunas", ComidaTipo.CENA, null),
            Comida(66, "Hallaca", 5, Bandera.VENEZUELA, "Masa de maíz rellena con guiso de carne de res, pollo, cerdo, aceitunas, pasas y alcaparras", ComidaTipo.CENA, null),
            Comida(67, "Pabellón Criollo", 5, Bandera.VENEZUELA, "Carne mechada, Arroz, Caraotas negras, Tajadas de plátano", ComidaTipo.CENA, null),
            Comida(68, "Cazón en Ajo", 4, Bandera.VENEZUELA, "Cazón (pez), Ajo, Limón, Aceite, Sal", ComidaTipo.CENA, null),
            Comida(69, "Pescado a la Margariteña", 4, Bandera.VENEZUELA, "Pargo rojo, Tomate, Cebolla, Pimientos, Aceitunas", ComidaTipo.CENA, null),
            Comida(70, "Sancocho", 5, Bandera.VENEZUELA, "Pollo, Yuca, Papa, Maíz, Ajo", ComidaTipo.CENA, null),
            Comida(71, "Ceviche", 5, Bandera.PERU, "Pescado fresco, Limón, Cilantro, Cebolla roja, Ají", ComidaTipo.CENA, null),
            Comida(72, "Lomo Saltado", 5, Bandera.PERU, "Filete de res, Tomate, Cebolla, Ají amarillo, Papas fritas", ComidaTipo.CENA, null),
            Comida(73, "Anticuchos", 5, Bandera.PERU, "Corazón de res, Ají panca, Comino, Ajo, Papas cocidas", ComidaTipo.CENA, null),
            Comida(74, "Seco de Cordero", 4, Bandera.PERU, "Cordero, Cilantro, Ají amarillo, Cerveza negra, Arroz", ComidaTipo.CENA, null),
            Comida(75, "Ajiaco de Papa", 4, Bandera.PERU, "Papas, Queso fresco, Ají amarillo, Leche, Huevos", ComidaTipo.CENA, null),
            Comida(76, "Pastel de Choclo", 4, Bandera.CHILE, "Choclo, Carne de res, Cebolla, Huevo duro, Aceitunas", ComidaTipo.CENA, null),
            Comida(77, "Charquicán", 4, Bandera.CHILE, "Carne de res seca, Papas, Calabaza, Cebolla, Maíz", ComidaTipo.CENA, null),
            Comida(78, "Arrollado Huaso", 4, Bandera.CHILE, "Carne de cerdo, Tocino, Pepinillos, Zanahoria, Huevo duro", ComidaTipo.CENA, null),
            Comida(79, "Estofado de Pollo", 4, Bandera.CHILE, "Pollo, Cebolla, Zanahoria, Pimiento, Papas", ComidaTipo.CENA, null),
            Comida(80, "Cazuela de Ave", 4, Bandera.CHILE, "Pollo, Choclo, Papa, Calabaza, Zapallo", ComidaTipo.CENA, null)

        )
    }
}
