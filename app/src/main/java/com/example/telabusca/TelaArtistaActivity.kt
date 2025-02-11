package com.example.telabusca

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.telabusca.databinding.ActivityTelaArtistaBinding

class TelaArtistaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaArtistaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaArtistaBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val nomeArtista = intent.getStringExtra("ARTIST_NAME")
        binding.artista.text = nomeArtista

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