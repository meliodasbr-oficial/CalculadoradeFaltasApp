package com.calculadoradefaltas

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonCalculadora = view.findViewById<Button>(R.id.button_calculadora)
        val buttonCalculadoraFundamental = view.findViewById<Button>(R.id.button_calculadora_fundamental)

        buttonCalculadora.setOnClickListener {
            findNavController().navigate(R.id.calculadoraFaltasFragment)
        }

        buttonCalculadoraFundamental.setOnClickListener {
            findNavController().navigate(R.id.calculadoraFaltasEfFragment)
        }
    }
}
