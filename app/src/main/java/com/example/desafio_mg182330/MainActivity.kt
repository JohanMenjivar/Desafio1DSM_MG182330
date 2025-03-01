package com.example.desafio_mg182330

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEjercicio1 = findViewById<Button>(R.id.btnEjercicio1)
        val btnEjercicio2 = findViewById<Button>(R.id.btnEjercicio2)
        val btnEjercicio3 = findViewById<Button>(R.id.btnEjercicio3)

        btnEjercicio1.setOnClickListener {
            startActivity(Intent(this, PromedioActivity::class.java))
        }

        btnEjercicio2.setOnClickListener {
            startActivity(Intent(this, DescuentoActivity::class.java))
        }

        btnEjercicio3.setOnClickListener {
            startActivity(Intent(this, CalcuActivity::class.java))
        }
    }
}
