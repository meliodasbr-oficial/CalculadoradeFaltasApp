package com.calculadoradefaltas

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var loadingGif: ImageView
    private lateinit var welcomeText: TextView
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        // Carrega o tema salvo antes de configurar o layout
        loadThemeFromPreferences()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadingGif = findViewById(R.id.loadingGif)
        welcomeText = findViewById(R.id.welcomeText)

        // Carregar o GIF usando Glide
        loadGif()

        // Simular carregamento com atraso
        simulateLoading()
    }

    private fun loadThemeFromPreferences() {
        val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val darkModeEnabled = preferences.getBoolean("dark_mode", false)

        if (darkModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun loadGif() {
        Glide.with(this)
            .asGif()
            .load(R.drawable.loading) // Substitua pelo nome do seu arquivo GIF
            .into(loadingGif)
    }

    private fun simulateLoading() {
        val totalLoadingTime = 4000L // 3 segundos de carregamento

        handler.postDelayed({
            loadingGif.visibility = ImageView.GONE
            welcomeText.visibility = TextView.VISIBLE
        }, totalLoadingTime)

        handler.postDelayed({
            navigateToHomeActivity()
        }, totalLoadingTime + 1000L)
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish() // Finaliza a com.calculadoradefaltas.MainActivity
    }
}
