package com.example.examensegunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examensegunda.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val peli=intent.getSerializableExtra("PELI") as Movies
        botones(peli)
    }

    fun botones(peli:Movies){
        if (intent.getBooleanExtra("FLAG", false)){
            binding.nombreDirector.setText(peli.getDirector())
            binding.releaseDate.setText(peli.getLanzamiento().toString())
        }

        binding.botonDisplay.setOnClickListener {
            if (verificacion()){
                peli.setDirector(binding.nombreDirector.text.toString())
                peli.setLanzamiento(binding.releaseDate.text.toString().toInt())
                val intent= Intent(this, MovieDisplayActivity::class.java)
                intent.putExtra("PELI",peli)
                startActivity(intent)
            }
        }
        binding.botonTitle.setOnClickListener {
            val intent=Intent(this, MovieTitleActivity::class.java)
            intent.putExtra("PELI",peli)
            intent.putExtra("FLAG", true)
            startActivity(intent)
        }
    }

    fun verificacion():Boolean{
        var flag=false
        if (binding.nombreDirector.text.isEmpty()&&binding.releaseDate.text.isEmpty()){
            flag=false
            Toast.makeText(this, "Director y/o año vacíos", Toast.LENGTH_LONG).show()
        }else if (binding.releaseDate.text.toString().toInt()<1000){
            flag=false
            Toast.makeText(this, "Año no válido", Toast.LENGTH_LONG).show()
        }else{
            flag=true
        }
        return flag
    }
}