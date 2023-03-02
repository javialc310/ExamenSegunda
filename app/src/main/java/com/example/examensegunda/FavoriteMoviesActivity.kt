package com.example.examensegunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examensegunda.databinding.ActivityFavoriteMoviesBinding

class FavoriteMoviesActivity : AppCompatActivity() {
    lateinit var binding: ActivityFavoriteMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFavoriteMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val peli= intent.getSerializableExtra("PELI") as Movies
        mostrarDatosFav(peli)
        botones(peli)
    }

    fun mostrarDatosFav(peli:Movies){
        if (peli.getFav()){
            binding.datosPeli2.text="Título: ${peli.getTitulo()}\n" +
                    "Duración: ${peli.getDuracion()}\n" +
                    "Director: ${peli.getDirector()}\n" +
                    "Año de lanzamiento: ${peli.getLanzamiento()}"
        }else
            binding.datosPeli2.text="No hay pelis favoritas"

    }

    fun botones(peli:Movies){
        binding.volverDisplay.setOnClickListener {
            val intent=Intent(this, MovieTitleActivity::class.java)
            intent.putExtra("PELI", peli)
            startActivity(intent)
        }

        binding.nuevapeli2.setOnClickListener {
            val intent= Intent(this, MovieTitleActivity::class.java)
            startActivity(intent)
        }

    }
}