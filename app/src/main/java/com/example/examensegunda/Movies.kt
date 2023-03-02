package com.example.examensegunda

class Movies ():java.io.Serializable{
    companion object{
        val peliculas=ArrayList<Movies>()

        fun addPeli(peli:Movies){
            this.peliculas.add(peli)
        }
    }
    private var titulo=""
    private var duracion=0
    private var director=""
    private var lanzamiento=0
    private var favorita=false

    fun getTitulo():String{
        return titulo
    }

    fun setTitulo(titulo:String){
        this.titulo=titulo
    }

    fun getDuracion():Int{
        return duracion
    }

    fun setDuracion(duracion:Int){
        this.duracion=duracion
    }

    fun getDirector():String{
        return director
    }

    fun setDirector(director:String){
        this.director=director
    }

    fun getLanzamiento():Int{
        return lanzamiento
    }

    fun setLanzamiento(lanzamiento:Int){
        this.lanzamiento=lanzamiento
    }

    fun setFav(favorita:Boolean){
        this.favorita=favorita
    }

    fun getFav():Boolean{
        return favorita
    }

}