 package com.dam2.recetas

import android.content.Intent
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumenRecetaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mapaRecetas = inicializarRecetas()
        //calcularPorcentajesBarrasProgreso(mapaRecetas)
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
         val intent  = Intent(this, DescripcionReceta::class.java)
         startActivity(intent)
     }
}