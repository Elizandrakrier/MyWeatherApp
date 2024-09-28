package br.com.elizandrakrier.myweatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.elizandrakrier.myweatherapp.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}