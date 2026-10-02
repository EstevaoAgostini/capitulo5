package com.example.capitulo5

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.capitulo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //instanciando a tela
        binding = ActivityMainBinding.inflate(layoutInflater)

        //renderizar a tela instanciada
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initListeners()
    }

    private fun initListeners() {
        binding.button.setOnClickListener {
            //Passagem dos dados de usuário
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("user", User("Estevão Agostini", 18))
            startActivity(intent)
        }
    }
}