package com.calculadoradefaltas;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DonationFragment extends Fragment {

    private TextView pixCode;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar o layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_donation, container, false);

        // Inicializar os componentes do layout
        pixCode = view.findViewById(R.id.pixCode);
        Button copyButton = view.findViewById(R.id.copyButton);
        ImageView qrCodeImage = view.findViewById(R.id.qrCodeImage);

        // Exibir o QR Code (certifique-se de ter a imagem correta no drawable)
        qrCodeImage.setImageResource(R.drawable.zeroum);

        // Configurar o botão de copiar o código Pix
        copyButton.setOnClickListener(v -> copiarCodigoPix());

        return view;
    }

    private void copiarCodigoPix() {
        // Obter o código Pix
        String codigoPix = pixCode.getText().toString();

        // Usar o ClipboardManager para copiar o código Pix
        ClipboardManager clipboard = (ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Código Pix", codigoPix);
        clipboard.setPrimaryClip(clip);

        // Exibir uma mensagem de feedback ao usuário
        Toast.makeText(getActivity(), "Código Pix copiado!", Toast.LENGTH_SHORT).show();
    }
}
