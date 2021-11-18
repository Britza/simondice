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

    //definir variables
    //val random =(0..3).random()
    //val cuatroColores= arrayOf("amarillo", "rojo", "verde", "azul")
    //val todosColores = arrayListOf(cuatroColores[random])


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
    var indice: Int = 1
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
            val text = getString(R.string.val_text)
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()

            mostrarRonda()
            ejecutarSecuencia()


        }
        green?.setOnClickListener {
            Toast.makeText(this, "verde", Toast.LENGTH_SHORT).show()


            if(indice==1) {
                comprobar = arrayListOf()
                indice++
            }
            comprobar.add(0)

            /*if(indice !=0){
                indice--
                resultado = comprobar[indice] == secuencia[indice]
            }else {
                indice++
                resultado = comprobar[indice] == secuencia[indice]
            }*/
            if(comprobar.size==secuencia.size) {
                indice=1
                comprobarSecuencia()
            }
        }

        yellow?.setOnClickListener {
            Toast.makeText(this, "amarillo", Toast.LENGTH_SHORT).show()
            if(indice==1) {
                comprobar = arrayListOf()
                indice++
            }
            comprobar.add(1)

            /*if(indice !=0){
                indice--
                resultado = comprobar[indice] == secuencia[indice]
            }else {
                indice++
                resultado = comprobar[indice] == secuencia[indice]
            }*/
            if(comprobar.size==secuencia.size) {
                indice=1
                comprobarSecuencia()
            }

        }

        blue?.setOnClickListener {
            Toast.makeText(this, "azul", Toast.LENGTH_SHORT).show()
            if(indice==1) {
                comprobar = arrayListOf()
                indice++
            }
            comprobar.add(2)

            /*if(indice !=0){
                indice--
                resultado = comprobar[indice] == secuencia[indice]
            }else {
                indice++
                resultado = comprobar[indice] == secuencia[indice]
            }*/
            if(comprobar.size==secuencia.size) {
                indice=1
                comprobarSecuencia()
            }
        }

        red?.setOnClickListener {
            Toast.makeText(this, "rojo", Toast.LENGTH_SHORT).show()
            if(indice==1) {
                comprobar = arrayListOf()
                indice++
            }
            comprobar.add(3)

            /*if(indice !=0){
                indice--
                resultado = comprobar[indice] == secuencia[indice]
            }else {
                indice++
                resultado = comprobar[indice] == secuencia[indice]
            }*/
            if(comprobar.size==secuencia.size) {

                indice=1
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

        //green:Button, yellow:Button, blue:Button, red:Button
        val job = GlobalScope.launch(Dispatchers.Main) {
            secuenciaBotones()
            //delay(3000L)
        }
        Log.d("estado", "Secuencia ejecutada")

    }

    suspend fun secuenciaBotones() {

        // val secuencia = ronda +1
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

    private fun mensajeUsuario() {

        Log.d("estado", "Muestra un mensaje")
    }

    private fun comprobarSecuencia() {
    Log.d("Estado", "Comprobando secuencia")
        var n=0
        for (s in secuencia){
            if(s==comprobar.get(n))
                n++
            else
                resultado=false
        }

    if(!resultado){
        Toast.makeText(this,"Fin del juego",Toast.LENGTH_SHORT).show()
        ronda =0
        empezarJugar?.visibility = Button.VISIBLE
        comprobar= arrayListOf()
        secuencia = arrayListOf()
        resultado=true
        n=0
    }else{
        ronda++
        Ronda?.setText("Ronda " + ronda).toString()
        ejecutarSecuencia()
        n=0

    }
    Log.d("Estado", "Secuencia comprobada")

}




}

