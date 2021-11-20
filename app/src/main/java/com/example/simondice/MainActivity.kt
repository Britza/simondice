package com.example.simondice

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.math.RoundingMode.valueOf

class MainActivity : AppCompatActivity() {

    //Botones
    var empezarJugar: Button? = null
    var Ronda:TextView? = null
    var green: Button? = null
    var yellow: Button? = null
    var blue: Button? = null
    var red: Button? = null

    var arrayBotones = hashMapOf<Int, Button>()
    var secuencia: MutableList<Int> = arrayListOf<Int>()
    var comprobar: MutableList<Int> = arrayListOf<Int>()

    var ronda: Int = 0
    var indice: Int = 0
    var resultado: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        empezarJugar= findViewById(R.id.jugar)
        Ronda= findViewById(R.id.ronda)

        green = findViewById(R.id.verde)
        yellow = findViewById(R.id.amarillo)
        blue = findViewById(R.id.azul)
        red = findViewById(R.id.rojo)
        arrayBotones[0] = findViewById(R.id.verde)
        arrayBotones[1] = findViewById(R.id.amarillo)
        arrayBotones[2] = findViewById(R.id.azul)
        arrayBotones[3] = findViewById(R.id.rojo)


        empezarJugar?.setOnClickListener {
            Log.d("estado", "Empieza la partida")

            //Toast llamado desde los Strings
            mensajeUsuario(1)

            mostrarRonda()
            ejecutarSecuencia()


        }
        green?.setOnClickListener {

            comprobar.add(0)
            indice=comprobar.size-1
            resultado = comprobar[indice] == secuencia[indice]

            if(comprobar.size == ronda){
                comprobarSecuencia()
            }

            if(!resultado){
                comprobarSecuencia()
            }
        }

        yellow?.setOnClickListener {

            comprobar.add(1)
            indice=comprobar.size-1
            resultado = comprobar[indice] == secuencia[indice]

            if(comprobar.size == ronda){
                comprobarSecuencia()
            }

            if(!resultado){
                comprobarSecuencia()
            }
        }

        blue?.setOnClickListener {

            comprobar.add(2)
            indice=comprobar.size-1
            resultado = comprobar[indice] == secuencia[indice]

            if(comprobar.size == ronda){
                comprobarSecuencia()
            }

            if(!resultado){
                comprobarSecuencia()
            }
        }

        red?.setOnClickListener {

            comprobar.add(3)
            indice=comprobar.size-1
            resultado = comprobar[indice] == secuencia[indice]

            if(comprobar.size == ronda){
                comprobarSecuencia()
            }

            if(!resultado){
                comprobarSecuencia()
            }
        }
    }


    private fun mostrarRonda() {


        empezarJugar?.visibility = Button.INVISIBLE
        ronda++
        Ronda?.setText("Ronda " + ronda).toString()


        Log.d("estado", "Muestra la ronda")
    }

    private fun ejecutarSecuencia() {

        Log.d("estado", "Ejecuta la secuencia")


        val job = GlobalScope.launch(Dispatchers.Main) {
            secuenciaBotones()
        }
        Log.d("estado", "Secuencia ejecutada")

    }

    suspend fun secuenciaBotones() {

        val Colores = arrayOf("#008000", "#FFFF00", "#3498DB", "#EC4849")
        var random = (0..3).random()
        secuencia.add(random)
        var tamano = ronda - 1
        for (i in 0..tamano) {
            delay(500L)
            arrayBotones[secuencia[i]]?.setBackgroundColor(Color.WHITE)
            delay(500L)
            arrayBotones[secuencia[i]]?.setBackgroundColor(Color.parseColor(Colores[secuencia[i]]))

        }

    }

    private fun mensajeUsuario(key:Int) {

        Log.d("estado", "Muestra un mensaje al usuario")

        when(key){
            1->{
                val text = getString(R.string.val_empieza)
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }

            2->{
                val text = getString(R.string.val_acaba)
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }
    }

    private fun comprobarSecuencia() {
    Log.d("Estado", "Comprobando secuencia")

    if(!resultado){
        mensajeUsuario(2)
        ronda =0
        empezarJugar?.visibility = Button.VISIBLE
        comprobar= arrayListOf()
        secuencia = arrayListOf()
        resultado=true

    }else{
        ronda++
        comprobar= arrayListOf()
        Ronda?.setText("Ronda " + ronda).toString()
        ejecutarSecuencia()
    }
    Log.d("Estado", "Secuencia comprobada")

}




}

