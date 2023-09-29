package com.fabiokusaba.calculadoraimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fabiokusaba.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener {
            val peso = binding.editPeso.text.toString().trim().toDouble()
            val altura = binding.editAltura.text.toString().trim().toDouble()

            val i = Intent(this, ResultadoActivity::class.java)
            i.putExtra("peso", peso)
            i.putExtra("altura", altura)
            startActivity(i)

            binding.editAltura.setText("")
            binding.editPeso.setText("")
        }
    }
}