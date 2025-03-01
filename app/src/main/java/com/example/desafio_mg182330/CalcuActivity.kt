package com.example.desafio_mg182330

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class CalcuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcu)

        val inputNumero1 = findViewById<EditText>(R.id.inputNumero1)
        val inputNumero2 = findViewById<EditText>(R.id.inputNumero2)
        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        // Función para realizar operaciones
        fun calcularOperacion(operacion: String) {
            val numero1 = inputNumero1.text.toString().toDoubleOrNull()
            val numero2 = inputNumero2.text.toString().toDoubleOrNull()

            if (numero1 != null && numero2 != null) {
                var resultado: Double? = null

                if (operacion == "+") {
                    resultado = numero1 + numero2
                } else if (operacion == "-") {
                    resultado = numero1 - numero2
                } else if (operacion == "*") {
                    resultado = numero1 * numero2
                } else if (operacion == "/") {
                    if (numero2 == 0.0) {
                        txtResultado.text = "No se puede dividir entre 0"
                        return
                    }
                    resultado = numero1 / numero2
                }

                if (resultado != null) {
                    txtResultado.text = "Resultado: ${"%.2f".format(resultado)}"
                }
            } else {
                txtResultado.text = "Ingrese valores numéricos válidos"
            }
        }

        // Asignar operaciones a los botones
        btnSumar.setOnClickListener { calcularOperacion("+") }
        btnRestar.setOnClickListener { calcularOperacion("-") }
        btnMultiplicar.setOnClickListener { calcularOperacion("*") }
        btnDividir.setOnClickListener { calcularOperacion("/") }
    }
}
