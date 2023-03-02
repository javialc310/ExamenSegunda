package com.example.examensegunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examensegunda.databinding.ActivityMovietitleBinding

class MovieTitleActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovietitleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMovietitleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        botones()
    }

    fun botones(){
        val nonuevaPeli= intent.getBooleanExtra("FLAG", false)
        val peli:Movies
        if (nonuevaPeli){
            peli= intent.getSerializableExtra("PELI") as Movies
            binding.tituloPeli.setText(peli.getTitulo())
            binding.duracionPelicula.setText(peli.getDuracion().toString())
        }else{
            peli= Movies()
        }
        binding.botonDetails.setOnClickListener {
            if (verificacion()){
                peli.setTitulo(binding.tituloPeli.text.toString())
                peli.setDuracion(binding.duracionPelicula.text.toString().toInt())
                val intent= Intent(this, MovieDetailsActivity::class.java)
                intent.putExtra("PELI",peli)
                startActivity(intent)
            }
        }
    }

    fun verificacion():Boolean{
        var flag=false
        if (binding.tituloPeli.text.isEmpty()&&binding.duracionPelicula.text.isEmpty()){
            flag=false
            Toast.makeText(this, "Película y/o duración vacíos", Toast.LENGTH_LONG).show()
        }else if (binding.duracionPelicula.text.toString().toInt()<60){
            flag=false
            Toast.makeText(this, "Duración para un largometraje inválida", Toast.LENGTH_LONG).show()
        }else{
            flag=true
        }
        return flag
    }
}