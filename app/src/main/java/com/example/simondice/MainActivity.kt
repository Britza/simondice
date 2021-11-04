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

    val green:Button? = null
    val yellow:Button? = null
    val blue:Button? = null
    val red:Button? = null
    var listrandom:Array<Int> = arrayOf()
    val secuencia: MutableList<Int> = listrandom.toMutableList()

    var ronda:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val empezaraJugar:Button = findViewById(R.id.jugar)

        empezaraJugar.setOnClickListener{
            Log.d("estado","Empieza la partida")

            //Toast llamado desde los Strings
            val text=getString(R.string.val_text)
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()

            mostrarRonda()
            ejecutarSecuencia()


        }


    }
    private fun mostrarRonda(){

        val Ronda:TextView = findViewById(R.id.ronda)

        ronda++
        Ronda.setText("Ronda " + ronda).toString()

        Log.d("estado", "Muestra la ronda")
    }

   private fun ejecutarSecuencia(){

        Log.d("estado", "Ejecuta la secuencia")

        //green:Button, yellow:Button, blue:Button, red:Button
        val job = GlobalScope.launch(Dispatchers.Main){
            secuenciaBotones()
            delay(3000L)
        }
       Log.d("estado", "Secuencia ejecutada")

   }

    suspend fun secuenciaBotones() {

       // val secuencia = ronda +1
        val Colores = arrayOf("#008000","#FFFF00","#3498DB","#EC4849")
        var arrayBotones = hashMapOf<Int,Button>()
        arrayBotones[0]= findViewById(R.id.verde)
        arrayBotones[1]= findViewById(R.id.amarillo)
        arrayBotones[2] = findViewById(R.id.azul)
        arrayBotones[3] = findViewById(R.id.rojo)


        var random = (0..3).random()
        secuencia.add(random)
        val tamano = ronda -1
        for(i in 0..tamano) {
            delay(500L)
            arrayBotones[secuencia[i]]?.setBackgroundColor(Color.WHITE)
            delay(500L)
            arrayBotones[secuencia[i]]?.setBackgroundColor(Color.parseColor(Colores[secuencia[i]]))
            //var todosColores = arrayListOf(cuatroColores[random])
            //val b: Button = arrayBotones[random]!!
            //delay(1000L)
            //arrayBotones[ramdon]?.setBackgroundColor()
            //b.foregroundTintList = ColorStateList.valueOf(Color.WHITE)
        }
        //return secuencia
    }

    private fun mensajeUsuario(){

        Log.d("estado", "Muestra un mensaje")
    }

    private fun comprobarSecuencia(){

        Log.d("estado", "Comprobar la secuencia")
    }


}