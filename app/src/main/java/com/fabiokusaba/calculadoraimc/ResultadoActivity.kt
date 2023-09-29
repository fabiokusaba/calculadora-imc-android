package com.fabiokusaba.calculadoraimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fabiokusaba.calculadoraimc.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val peso = i.getDoubleExtra("peso", 0.0)
        val altura = i.getDoubleExtra("altura", 0.0)

        val imc = calcularImc(peso, altura)
        val status = statusImc(imc)

        binding.textResultado.setText("Seu nível de IMC é: ${String.format("%.1f", imc)}, classificação: $status")

        binding.buttonVoltar.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

    fun calcularImc(peso: Double, altura: Double) : Double {
        return peso / (altura * altura)
    }

    fun statusImc(imc: Double) : String {
        if (imc <= 18.5) {
            return "abaixo do peso"
        } else if (imc <= 24.9) {
            return "peso ideal"
        } else if (imc <= 29.9) {
            return "acima do peso"
        } else if (imc <= 34.9) {
            return "obesidade grau I"
        } else if (imc <= 39.9) {
            return "obesidade grau II"
        } else {
            return "obesidade grau III"
        }
    }
}