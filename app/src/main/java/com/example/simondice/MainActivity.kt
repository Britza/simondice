package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.math.RoundingMode.valueOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var contador=0

        //definir variables
        val random =(0..3).random()
        val cuatroColores= arrayOf("amarillo", "rojo", "verde", "azul")
        val todosColores = arrayListOf(cuatroColores[random])

        //Botones

        val green = findViewById<Button>(R.id.verde)
        val yellow = findViewById<Button>(R.id.amarillo)
        val blue = findViewById<Button>(R.id.azul)
        val red = findViewById<Button>(R.id.rojo)


        val empezaraJugar:Button = findViewById(R.id.jugar)

        empezaraJugar.setOnClickListener{
            Log.d("estado","Empieza la partida")

            mostrarRonda()
            ejecutarSecuencia()
        }


    }
    private fun mostrarRonda(){

        val Ronda:TextView = findViewById(R.id.ronda)
        var ronda = 0
        var contador= ronda + 1
        Ronda.setText("Ronda " + contador)
        contador ++

        Log.d("estado", "Muestra la ronda")
    }

    private fun ejecutarSecuencia(){



        Log.d("estado", "Ejecuta la secuencia")
    }

    private fun mensajeUsuario(){

        Log.d("estado", "Muestra un mensaje")
    }

    private fun comprobarSecuencia(){

        Log.d("estado", "Comprobar la secuencia")
    }


}