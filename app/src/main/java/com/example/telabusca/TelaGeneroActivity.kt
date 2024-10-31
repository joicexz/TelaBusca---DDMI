package com.example.telabusca

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.telabusca.databinding.ActivityTelaGeneroBinding

class TelaGeneroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaGeneroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaGeneroBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val nomeGenero = intent.getStringExtra("GENERO_NAME")
        binding.genero.text = nomeGenero

        binding.setaVoltar.setOnClickListener {
            val voltarTelaBusca = Intent(this, MainActivity::class.java)
            startActivity(voltarTelaBusca)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}