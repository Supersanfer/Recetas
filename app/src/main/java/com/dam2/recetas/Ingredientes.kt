package com.dam2.recetas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dam2.recetas.databinding.ActivityDescripcionRecetaBinding
import com.dam2.recetas.databinding.ActivityIngredientesBinding

class Ingredientes : AppCompatActivity() {
    private lateinit var binding: ActivityIngredientesBinding
    private lateinit var listaIngredientes: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIngredientesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaIngredientes = mutableListOf();
    }

    fun cbClicked(view: View){
        val checkBox = view as CheckBox
        val textoCb: String = checkBox.text.toString()
        if(checkBox.isChecked){
            if(!listaIngredientes.contains(textoCb)){
                listaIngredientes.add(textoCb)
            }
        }
        else{
            listaIngredientes.remove(textoCb)
        }
    }

    fun btnSiguienteClicked(view: View){
        val intent  = Intent(this, ResumenReceta::class.java)
        intent.putStringArrayListExtra("listaIngredientesEscogidos", ArrayList(listaIngredientes) )
        startActivity(intent)
    }
}