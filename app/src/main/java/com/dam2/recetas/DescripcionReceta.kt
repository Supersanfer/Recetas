package com.dam2.recetas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dam2.recetas.databinding.ActivityDescripcionRecetaBinding

class DescripcionReceta : AppCompatActivity() {

    private lateinit var binding: ActivityDescripcionRecetaBinding
    private var ingredientesEscogidos: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescripcionRecetaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombreReceta = intent.getStringExtra("nombreReceta")
        ingredientesEscogidos = intent.getStringArrayListExtra("listaIngredientesEscogidos")

        val titulo: String
        val descripcion: String
        val ingredientesRequeridos: List<String>

        when (nombreReceta) {
            "Tostadas de aguacate" -> {
                titulo = "Tostadas de aguacate"
                descripcion = "Tuesta el pan y aplasta el aguacate con el zumo de limón, sal y pimienta. Unta la mezcla sobre las tostadas y sirve inmediatamente."
                ingredientesRequeridos = listOf(
                    "2 rebanadas de pan integral",
                    "1 aguacate maduro",
                    "Zumo de medio limón",
                    "Sal",
                    "Pimienta negra"
                )
            }
            "Ensalada caprese" -> {
                titulo = "Ensalada caprese"
                descripcion = "Corta los tomates y la mozzarella en rodajas. Alterna en un plato con hojas de albahaca. Rocía con aceite de oliva, sal y pimienta al gusto."
                ingredientesRequeridos = listOf(
                    "2 tomates grandes",
                    "125 g de mozzarella fresca",
                    "Hojas de albahaca",
                    "Aceite de oliva virgen extra",
                    "Sal",
                    "Pimienta"
                )
            }
            "Huevos revueltos con espinacas" -> {
                titulo = "Huevos revueltos con espinacas"
                descripcion = "Saltea las espinacas en aceite de oliva. Añade los huevos batidos, sal y pimienta. Cocina removiendo hasta que estén listos."
                ingredientesRequeridos = listOf(
                    "2 huevos",
                    "1 taza de espinacas frescas",
                    "1 cucharada de aceite de oliva",
                    "Sal",
                    "Pimienta"
                )
            }
            "Sándwich caliente de espinacas y huevo" -> {
                titulo = "Sándwich caliente de espinacas y huevo"
                descripcion = "Saltea las espinacas en aceite de oliva. Cocina el huevo al gusto (revuelto o frito). Tuesta el pan integral y arma el sándwich con las espinacas y el huevo. Añade sal y pimienta al gusto antes de servir."
                ingredientesRequeridos = listOf(
                    "2 rebanadas de pan integral",
                    "1 huevo",
                    "1 taza de espinacas frescas",
                    "1 cucharada de aceite de oliva",
                    "Sal",
                    "Pimienta"
                )
            }
            else -> {
                titulo = "Error"
                descripcion = "Receta no encontrada"
                ingredientesRequeridos = emptyList()
            }
        }

        binding.tvTituloReceta.text = titulo
        binding.tvReceta.text = descripcion

        if (ingredientesRequeridos.isNotEmpty()) {
            var textoParaIngredientes = ""
            for (ingrediente in ingredientesRequeridos) {
                textoParaIngredientes = textoParaIngredientes + "=> " + ingrediente + "\n"
            }

            binding.tvIngredientes.text = textoParaIngredientes.trim()

        } else {
            binding.tvIngredientes.text = "Receta no encontrada"
        }
    }

    fun onPagPrincipal_Clicked(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onResumenRecetas_clicked(view: View) {
        val intent = Intent(this, ResumenReceta::class.java)
        intent.putExtra("listaIngredientesEscogidos", ingredientesEscogidos)
        startActivity(intent)
        finish()
    }
}

