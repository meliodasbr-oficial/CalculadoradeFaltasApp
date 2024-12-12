package com.calculadoradefaltas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        val sharedPreferences = requireContext().getSharedPreferences("app_preferences", 0)
        val editor = sharedPreferences.edit()

        val darkModePref = findPreference<SwitchPreferenceCompat>("dark_mode")
        darkModePref?.setOnPreferenceChangeListener { _, newValue ->
            val isDarkMode = newValue as Boolean
            if (isDarkMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean("dark_mode", true)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("dark_mode", false)
            }
            editor.apply()
            true
        }

        // Ajuda e Suporte
        findPreference<Preference>("help_support")?.setOnPreferenceClickListener {
            val url = "https://meliodasbr-oficial.github.io/Suporte-Feedback-Pol-tica-Informa-es-Termos/Ajuda-e-Suporte"
            openWebPage(url)
            true
        }

        // Feedback do Usuário
        findPreference<Preference>("user_feedback")?.setOnPreferenceClickListener {
            val url = "https://meliodasbr-oficial.github.io/Suporte-Feedback-Pol-tica-Informa-es-Termos/Feedback-do-Usuario"
            openWebPage(url)
            true
        }
        // Feedback dos Usuários
        findPreference<Preference>("user_feedbacks")?.setOnPreferenceClickListener {
            val url = "https://meliodasbr-oficial.github.io/Suporte-Feedback-Pol-tica-Informa-es-Termos/Feedback"
            openWebPage(url)
            true
        }

        // Política de Privacidade
        findPreference<Preference>("privacy_policy")?.setOnPreferenceClickListener {
            val url = "https://meliodasbr-oficial.github.io/Suporte-Feedback-Pol-tica-Informa-es-Termos/"
            openWebPage(url)
            true
        }

        // Notas de Versão
        findPreference<Preference>("release_notes")?.setOnPreferenceClickListener {
            val dialog = ReleaseNotesDialogFragment()
            dialog.show(parentFragmentManager, "ReleaseNotesDialog")
            true
        }


        // Informações do Desenvolvedor
        findPreference<Preference>("developer_info")?.setOnPreferenceClickListener {
            val url = "https://meliodasbr-oficial.github.io/Suporte-Feedback-Pol-tica-Informa-es-Termos/Informa%C3%A7%C3%B5es-do-Desenvolvedor"
            openWebPage(url)
            true
        }

        // Termos de Uso
        findPreference<Preference>("terms_of_use")?.setOnPreferenceClickListener {
            val url = "https://meliodasbr-oficial.github.io/Suporte-Feedback-Pol-tica-Informa-es-Termos/Termos-de-Uso"
            openWebPage(url)
            true
        }
    }

    private fun openWebPage(url: String) {
        val webpage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }
}
