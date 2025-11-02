package com.dam2.recetas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dam2.recetas.databinding.ActivityDescripcionRecetaBinding
import com.dam2.recetas.databinding.ActivityMainBinding

class DescripcionReceta : AppCompatActivity() {
    private lateinit var binding: ActivityDescripcionRecetaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescripcionRecetaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onPagPrincipal_Clicked(view: View){
        val intent  = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onResumenRecetas_clicked(view: View){
        val intent  = Intent(this, ResumenReceta::class.java)
        startActivity(intent)
    }

}