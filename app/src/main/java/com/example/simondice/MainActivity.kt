package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.math.RoundingMode.valueOf

class MainActivity : AppCompatActivity() {
    var ronda:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



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

        ronda++
        Ronda.setText("Ronda " + ronda).toString()

        Log.d("estado", "Muestra la ronda")
    }

    private fun ejecutarSecuencia(){

        Log.d("estado", "Ejecuta la secuencia")

        val green = findViewById<Button>(R.id.verde)
        val yellow = findViewById<Button>(R.id.amarillo)
        val blue = findViewById<Button>(R.id.azul)
        val red = findViewById<Button>(R.id.rojo)

        //green:Button, yellow:Button, blue:Button, red:Button
        val bgreen = GlobalScope.launch(Dispatchers.Main){
            suspendingTask(green)
        }

    }

    private fun suspendingTask(bgreen: Any) {

    }

    private fun mensajeUsuario(){

        Log.d("estado", "Muestra un mensaje")
    }

    private fun comprobarSecuencia(){

        Log.d("estado", "Comprobar la secuencia")
    }


}