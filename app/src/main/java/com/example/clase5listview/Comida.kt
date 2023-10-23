package com.example.clase5listview

data class Comida (
    val id: Int,
    val name: String,
    val nivel_de_sabrosura: Int,
    val origen: Bandera,
    val ingredientes: String,
    val type: ComidaTipo,
    val image: String?
)

enum class ComidaTipo{
    DESAYUNO, ALMUERZO, MERIENDA, CENA
}

enum class Bandera{
    VENEZUELA, CHILE, PERU, ARGENTINA
}
