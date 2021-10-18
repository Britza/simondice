package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val empezaraJugar:Button = findViewById(R.id.jugar)

        empezaraJugar.setOnClickListener{
            Log.INFO

            mostrarRonda()
            ejecutarSecuencia()
        }


    }
    private fun mostrarRonda(){

    }

    private fun ejecutarSecuencia(){

    }

    private fun mensajeUsuario(){

    }

    private fun comprobarSecuencia(){

    }


}