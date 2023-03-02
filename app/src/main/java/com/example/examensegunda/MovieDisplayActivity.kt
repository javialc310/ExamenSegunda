package com.example.examensegunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import com.example.examensegunda.databinding.ActivityMovieDisplayBinding

class MovieDisplayActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieDisplayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMovieDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val peli= intent.getSerializableExtra("PELI") as Movies
        Movies.addPeli(peli)
        mostrarDatos(peli)
        botones(peli)
    }

    fun mostrarDatos(peli:Movies){
        val arrayPelis=ArrayList<String>()
        Movies.peliculas.forEach {
            arrayPelis.add(it.getTitulo())
        }
        binding.datosPeli.text="Título: ${peli.getTitulo()}\n" +
                "Duración: ${peli.getDuracion()}\n" +
                "Director: ${peli.getDirector()}\n" +
                "Año de lanzamiento: ${peli.getLanzamiento()}"
        binding.checkBoxFav.isChecked=peli.getFav()
    }

    fun botones(peli:Movies){
        binding.Favoritos.setOnClickListener {
            if (binding.checkBoxFav.isChecked){
                peli.setFav(true)
            }
            val intent= Intent(this, FavoriteMoviesActivity::class.java)
            intent.putExtra("PELI", peli)
            startActivity(intent)
        }

        binding.nuevaPeli.setOnClickListener {
            val intent=Intent(this, MovieTitleActivity::class.java)
            startActivity(intent)
        }

        binding.volver.setOnClickListener {
            val intent= Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("PELI", peli)
            intent.putExtra("FLAG", true)
            startActivity(intent)
        }
    }
}