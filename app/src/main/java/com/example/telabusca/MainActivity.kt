package com.example.telabusca

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.telabusca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val artistas = listOf(
            Pair(binding.art1, getString(R.string.art1)),
            Pair(binding.art2, getString(R.string.art2)),
            Pair(binding.art3, getString(R.string.art3)),
            Pair(binding.art4, getString(R.string.art4)),
            Pair(binding.art5, getString(R.string.art5)),
            Pair(binding.art6, getString(R.string.art6))
        )

        artistas.forEach { (view, nomeArtista) ->
            view.setOnClickListener {
                val navegarTelaArtista = Intent(this, TelaArtistaActivity::class.java)
                navegarTelaArtista.putExtra("ARTIST_NAME", nomeArtista)
                startActivity(navegarTelaArtista)
            }
        }
        
        binding.hiphop.setOnClickListener {
            val navegarTelaGenero = Intent(this, TelaGeneroActivity::class.java)
            startActivity(navegarTelaGenero)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
