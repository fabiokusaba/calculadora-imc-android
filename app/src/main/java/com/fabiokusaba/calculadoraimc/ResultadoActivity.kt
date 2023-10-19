package com.fabiokusaba.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {
    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)
        btnVoltar = findViewById(R.id.btn_voltar)

        val bundle = intent.extras

        if (bundle != null) {
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado $peso kg"
            textAltura.text = "Altura informada $altura m"

            val imc = calcularImc(peso, altura)

            val resultadoImc = statusImc(imc)

            textResultado.text = resultadoImc
        }

        btnVoltar.setOnClickListener {
            finish()
        }
    }

    fun calcularImc(peso: Double, altura: Double) : Double {
        return peso / (altura * altura)
    }

    fun statusImc(imc: Double) : String {
        if (imc <= 18.5) {
            return "Abaixo do peso"
        } else if (imc <= 24.9) {
            return "Peso normal"
        } else if (imc <= 29.9) {
            return "Sobrepeso"
        } else if (imc <= 34.9) {
            return "Obesidade grau I"
        } else if (imc <= 39.9) {
            return "Obesidade grau II"
        } else {
            return "Obesidade grau III"
        }
    }
}