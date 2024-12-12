package com.calculadoradefaltas

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ReleaseNotesDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        val isDarkTheme = (requireContext().resources.configuration.uiMode
                and android.content.res.Configuration.UI_MODE_NIGHT_MASK) == android.content.res.Configuration.UI_MODE_NIGHT_YES

        val style = if (isDarkTheme) {
            R.style.CustomAlertDialog_Dark
        } else {
            R.style.CustomAlertDialog
        }

        return AlertDialog.Builder(requireContext(), style)
            .setTitle("Notas de Versão")
            .setMessage("Versão: 1.0.0\nNovidades:\n- Duas Novas funcionalidades\n- Novo design\n- Correções de bugs\n- Melhorias de desempenho")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .create()
    }
}

