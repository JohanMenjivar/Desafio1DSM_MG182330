package com.example.desafio_mg182330

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PromedioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio)

        val inputNombre = findViewById<EditText>(R.id.inputNombre)
        val inputNota1 = findViewById<EditText>(R.id.inputNota1)
        val inputNota2 = findViewById<EditText>(R.id.inputNota2)
        val inputNota3 = findViewById<EditText>(R.id.inputNota3)
        val inputNota4 = findViewById<EditText>(R.id.inputNota4)
        val inputNota5 = findViewById<EditText>(R.id.inputNota5)
        val btnCalcularPromedio = findViewById<Button>(R.id.btnCalcular)
        val txtResultadoPromedio = findViewById<TextView>(R.id.txtResultado)

        btnCalcularPromedio.setOnClickListener {
            val nombre = inputNombre.text.toString()
            val notas = listOf(
                inputNota1.text.toString().toDoubleOrNull() ?: -1.0,
                inputNota2.text.toString().toDoubleOrNull() ?: -1.0,
                inputNota3.text.toString().toDoubleOrNull() ?: -1.0,
                inputNota4.text.toString().toDoubleOrNull() ?: -1.0,
                inputNota5.text.toString().toDoubleOrNull() ?: -1.0
            )

            if (notas.any { it < 0.0 || it > 10.0 }) {
                Toast.makeText(this, "Las notas deben estar entre 0 y 10", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val pesos = listOf(0.15, 0.15, 0.20, 0.25, 0.25)
            val promedio = notas.zip(pesos) { nota, peso -> nota * peso }.sum()

            val estado = if (promedio >= 6.0) "Aprobado" else "Reprobado"
            txtResultadoPromedio.text = "$nombre, tu promedio es: %.2f\nEstado: $estado".format(promedio)
        }
    }
}
