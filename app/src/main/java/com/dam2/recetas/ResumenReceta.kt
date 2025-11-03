 package com.dam2.recetas

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dam2.recetas.databinding.ActivityIngredientesBinding
import com.dam2.recetas.databinding.ActivityResumenRecetaBinding

 class ResumenReceta : AppCompatActivity() {
    private lateinit var binding: ActivityResumenRecetaBinding
    private lateinit var ingredientesEscogidos: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumenRecetaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mapaRecetas = inicializarRecetas()
        ingredientesEscogidos = intent.getStringArrayListExtra("listaIngredientesEscogidos") ?: arrayListOf()
        calcularPorcentajesBarrasProgreso(mapaRecetas)

    }

     private fun calcularPorcentajesBarrasProgreso(mapaRecetas: Map<String, List<String>>) {

         for(entrada in mapaRecetas.entries){
             var coincidencias = 0
             var nombreReceta = entrada.key
             var ingredientesReceta = entrada.value
             for(ingrediente in ingredientesReceta){
                 if(ingredientesEscogidos.contains(ingrediente)){
                     coincidencias++
                 }
             }

             val porcentaje: Double
             if(ingredientesReceta.isNotEmpty()){
                 porcentaje = (coincidencias.toDouble() / ingredientesReceta.size.toDouble()) * 100.0
             }
             else{
                porcentaje = 0.0
             }

             val color: Int
             if(porcentaje.toInt() >= 90){
                color = Color.GREEN
             }
             else if (porcentaje.toInt()<90 && porcentaje.toInt() >= 50){
                 color = Color.YELLOW
             }
             else{
                 color = Color.RED
             }

             when(nombreReceta){
                 "Tostadas de aguacate" ->{
                     binding.pbTostadasAguacate.progress = porcentaje.toInt()
                     binding.pbTostadasAguacate.progressTintList = ColorStateList.valueOf(color)
                 }
                 "Ensalada caprese" -> {
                     binding.pbEnsaladaCaprese.progress = porcentaje.toInt()
                     binding.pbEnsaladaCaprese.progressTintList = ColorStateList.valueOf(color)
                 }
                 "Huevos revueltos con espinacas" -> {
                     binding.pbHuevosRevueltosEspinacas.progress = porcentaje.toInt()
                     binding.pbHuevosRevueltosEspinacas.progressTintList = ColorStateList.valueOf(color)
                 }
                 "Sándwich caliente de espinacas y huevo" -> {
                     binding.pbSandwichEspinacasHuevo.progress = porcentaje.toInt()
                     binding.pbSandwichEspinacasHuevo.progressTintList = ColorStateList.valueOf(color)
                 }
             }
         }
     }

     private fun inicializarRecetas():Map<String, List<String>> = mapOf(

         // Tostadas de aguacate
         "Tostadas de aguacate" to listOf(
             "Rebanadas de pan integral",
             "Aguacate",
             "Zumo de medio limón",
             "Sal",
             "Pimienta"
         ),
         // Ensalada Caprese
         "Ensalada caprese" to listOf(
             "Tomates grandes",
             "Mozzarella fresca",
             "Hojas de Albahaca",
             "Aceite de oliva virgen extra",
             "Sal",
             "Pimienta"
         ),
         // Huevos revueltos con espinacas
         "Huevos revueltos con espinacas" to listOf(
             "Huevos",
             "Espinacas frescas",
             "Aceite de oliva virgen extra",
             "Sal",
             "Pimienta"
         ),
         // Sandwich de espinacas y huevo
         "Sándwich caliente de espinacas y huevo" to listOf(
             "Rebanadas de pan integral",
             "Huevos",
             "Espinacas frescas",
             "Aceite de oliva virgen extra",
             "Sal",
             "Pimienta"
         )
     )


     fun onClicked(view : View){
         val nombreReceta: String? = when (view) {
             binding.btnTostadaAguacate -> "Tostadas de aguacate"
             binding.btnEnsaladaCaprese -> "Ensalada caprese"
             binding.btnHuevosRevueltosEspinacas -> "Huevos revueltos con espinacas"
             binding.btnSanwitchEspinacasHuevo -> "Sándwich caliente de espinacas y huevo"
             else -> null
         }

         if (nombreReceta != null) {
             abrirDescripcion(nombreReceta)
         }
     }

     private fun abrirDescripcion(nombreReceta: String) {
         val intent = Intent(this, DescripcionReceta::class.java)
         intent.putExtra("nombreReceta", nombreReceta)
         intent.putExtra("listaIngredientesEscogidos", ingredientesEscogidos)
         startActivity(intent)
     }
}