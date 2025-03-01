package com.example.desafio_mg182330

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DescuentoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descuento)

        val inputNombre = findViewById<EditText>(R.id.inputNombre)
        val inputSalarioBase = findViewById<EditText>(R.id.inputSalarioBase)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            val nombre = inputNombre.text.toString()
            val salarioBase = inputSalarioBase.text.toString().toDoubleOrNull()

            if (nombre.isNotBlank() && salarioBase != null) {
                val renta = calcularRenta(salarioBase)
                val afp = salarioBase * 0.0725
                val isss = salarioBase * 0.03
                val salarioNeto = salarioBase - renta - afp - isss

                val resultado = """
                    Nombre: $nombre
                    Salario Base: $${"%.2f".format(salarioBase)}
                    Renta: $${"%.2f".format(renta)}
                    AFP: $${"%.2f".format(afp)}
                    ISSS: $${"%.2f".format(isss)}
                    Salario Neto: $${"%.2f".format(salarioNeto)}
                """

                txtResultado.text = resultado
            } else {
                txtResultado.text = "Por favor, ingrese un nombre y salario válidos."
            }
        }
    }

    private fun calcularRenta(salarioBase: Double): Double {
        return when {
            salarioBase <= 472 -> 0.0
            salarioBase <= 895.24 -> (salarioBase - 472) * 0.10 + 17.67
            salarioBase <= 2038.10 -> (salarioBase - 895.24) * 0.20 + 60.00
            else -> (salarioBase - 2038.10) * 0.30 + 288.57
        }
    }
}
