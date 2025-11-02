package com.dam2.recetas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dam2.recetas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun resumenRecetas_Clicked(view: View) {
        val intent  = Intent(this, ResumenReceta::class.java)
        startActivity(intent)
    }

    fun ingredientes_clicked(view: View) {
        val intent  = Intent(this, Ingredientes::class.java)
        startActivity(intent)
    }
}