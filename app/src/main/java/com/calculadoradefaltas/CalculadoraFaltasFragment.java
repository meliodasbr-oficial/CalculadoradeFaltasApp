package com.calculadoradefaltas;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CalculadoraFaltasFragment extends Fragment {

    private Spinner[] spinners;
    private TextView textViewResultados;
    private Button buttonCalcular, buttonZerar, buttonZerarResultados;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculadora_faltas, container, false);

        // Inicialização dos componentes
        spinners = new Spinner[]{
                view.findViewById(R.id.spinner_artes),
                view.findViewById(R.id.spinner_biologia),
                view.findViewById(R.id.spinner_educacao_fisica),
                view.findViewById(R.id.spinner_filosofia),
                view.findViewById(R.id.spinner_fisica),
                view.findViewById(R.id.spinner_geografia),
                view.findViewById(R.id.spinner_historia),
                view.findViewById(R.id.spinner_ingles),
                view.findViewById(R.id.spinner_portugues),
                view.findViewById(R.id.spinner_matematica),
                view.findViewById(R.id.spinner_quimica),
                view.findViewById(R.id.spinner_sociologia),
                view.findViewById(R.id.spinner_itinerario_1),
                view.findViewById(R.id.spinner_itinerario_2),
                view.findViewById(R.id.spinner_itinerario_3),
                view.findViewById(R.id.spinner_itinerario_4),
                view.findViewById(R.id.spinner_itinerario_5),
                view.findViewById(R.id.spinner_itinerario_6),
                view.findViewById(R.id.spinner_itinerario_7),
                view.findViewById(R.id.spinner_itinerario_8)
        };

        textViewResultados = view.findViewById(R.id.textview_resultados);
        buttonCalcular = view.findViewById(R.id.button_calcular);
        buttonZerar = view.findViewById(R.id.button_zerar_faltas);
        buttonZerarResultados = view.findViewById(R.id.button_zerar_resultados);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.carga_horaria_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (Spinner spinner : spinners) {
            spinner.setAdapter(adapter);
        }

        buttonCalcular.setOnClickListener(v -> calcularFaltas());
        buttonZerar.setOnClickListener(v -> zerarFaltas());
        buttonZerarResultados.setOnClickListener(v -> zerarResultados());

        return view;
    }

    private void calcularFaltas() {
        int totalFaltas = 0;
        StringBuilder detalhes = new StringBuilder();

        for (Spinner spinner : spinners) {
            String cargaHoraria = spinner.getSelectedItem().toString();
            int faltasPorCarga = calcularFaltasPorCargaHoraria(cargaHoraria);
            totalFaltas += faltasPorCarga;

            // Adiciona detalhes se houver faltas
            if (faltasPorCarga > 0) {
                detalhes.append(cargaHoraria).append(" = ").append(faltasPorCarga).append(" Falta(s)\n");
            }
        }

        // Atualizar a interface com os resultados
        atualizarResultados(totalFaltas, detalhes.toString());
    }

    private int calcularFaltasPorCargaHoraria(String cargaHoraria) {
        switch (cargaHoraria) {
            case "00:00:00": return 0;
            case "00:50:00": return 1;
            case "01:40:00": return 2;
            case "02:30:00": return 3;
            case "03:20:00": return 4;
            case "04:10:00": return 5;
            case "05:00:00": return 6;
            case "05:50:00": return 7;
            case "06:40:00": return 8;
            case "07:30:00": return 9;
            case "08:20:00": return 10;
            case "09:10:00": return 11;
            case "10:00:00": return 12;
            case "10:50:00": return 13;
            case "11:40:00": return 14;
            case "12:30:00": return 15;
            case "13:20:00": return 16;
            case "14:10:00": return 17;
            case "15:00:00": return 18;
            case "15:50:00": return 19;
            case "16:40:00": return 20;
            case "17:30:00": return 21;
            case "18:20:00": return 22;
            case "19:10:00": return 23;
            case "20:00:00": return 24;
            case "20:50:00": return 25;
            case "21:40:00": return 26;
            case "22:30:00": return 27;
            case "23:20:00": return 28;
            case "24:10:00": return 29;
            case "25:00:00": return 30;
            case "25:50:00": return 31;
            case "26:40:00": return 32;
            case "27:30:00": return 33;
            case "28:20:00": return 34;
            case "29:10:00": return 35;
            case "30:00:00": return 36;
            case "30:50:00": return 37;
            case "31:40:00": return 38;
            case "32:30:00": return 39;
            case "33:20:00": return 40;
            case "34:10:00": return 41;
            case "35:00:00": return 42;
            case "35:50:00": return 43;
            case "36:40:00": return 44;
            case "37:30:00": return 45;
            case "38:20:00": return 46;
            case "39:10:00": return 47;
            case "40:00:00": return 48;
            case "40:50:00": return 49;
            case "41:40:00": return 50;
            case "42:30:00": return 51;
            case "43:20:00": return 52;
            case "44:10:00": return 53;
            case "45:00:00": return 54;
            case "45:50:00": return 55;
            case "46:40:00": return 56;
            case "47:30:00": return 57;
            case "48:20:00": return 58;
            case "49:10:00": return 59;
            case "50:00:00": return 60;
            case "50:50:00": return 61;
            case "51:40:00": return 62;
            case "52:30:00": return 63;
            case "53:20:00": return 64;
            case "54:10:00": return 65;
            case "55:00:00": return 66;
            case "55:50:00": return 67;
            case "56:40:00": return 68;
            case "57:30:00": return 69;
            case "58:20:00": return 70;
            case "59:10:00": return 71;
            case "60:00:00": return 72;
            case "60:50:00": return 73;
            case "61:40:00": return 74;
            case "62:30:00": return 75;
            case "63:20:00": return 76;
            case "64:10:00": return 77;
            case "65:00:00": return 78;
            case "65:50:00": return 79;
            case "66:40:00": return 80;
            case "67:30:00": return 81;
            case "68:20:00": return 82;
            case "69:10:00": return 83;
            case "70:00:00": return 84;
            case "70:50:00": return 85;
            case "71:40:00": return 86;
            case "72:30:00": return 87;
            case "73:20:00": return 88;
            case "74:10:00": return 89;
            case "75:00:00": return 90;
            case "75:50:00": return 91;
            case "76:40:00": return 92;
            case "77:30:00": return 93;
            case "78:20:00": return 94;
            case "79:10:00": return 95;
            case "80:00:00": return 96;
            case "80:50:00": return 97;
            case "81:40:00": return 98;
            case "82:30:00": return 99;
            case "83:20:00": return 100;
            case "84:10:00": return 101;
            case "85:00:00": return 102;
            case "85:50:00": return 103;
            case "86:40:00": return 104;
            case "87:30:00": return 105;
            case "88:20:00": return 106;
            case "89:10:00": return 107;
            case "90:00:00": return 108;
            case "90:50:00": return 109;
            case "91:40:00": return 110;
            case "92:30:00": return 111;
            case "93:20:00": return 112;
            case "94:10:00": return 113;
            case "95:00:00": return 114;
            case "95:50:00": return 115;
            case "96:40:00": return 116;
            case "97:30:00": return 117;
            case "98:20:00": return 118;
            case "99:10:00": return 119;
            case "100:00:00": return 120;
            case "100:50:00": return 121;
            case "101:40:00": return 122;
            case "102:30:00": return 123;
            case "103:20:00": return 124;
            case "104:10:00": return 125;
            case "105:00:00": return 126;
            case "105:50:00": return 127;
            case "106:40:00": return 128;
            case "107:30:00": return 129;
            case "108:20:00": return 130;
            case "109:10:00": return 131;
            case "110:00:00": return 132;
            case "110:50:00": return 133;
            case "111:40:00": return 134;
            case "112:30:00": return 135;
            case "113:20:00": return 136;
            case "114:10:00": return 137;
            case "115:00:00": return 138;
            case "115:50:00": return 139;
            case "116:40:00": return 140;
            case "117:30:00": return 141;
            case "118:20:00": return 142;
            case "119:10:00": return 143;
            case "120:00:00": return 144;
            case "120:50:00": return 145;
            case "121:40:00": return 146;
            case "122:30:00": return 147;
            case "123:20:00": return 148;
            case "124:10:00": return 149;
            case "125:00:00": return 150;
            case "125:50:00": return 151;
            case "126:40:00": return 152;
            case "127:30:00": return 153;
            case "128:20:00": return 154;
            case "129:10:00": return 155;
            case "130:00:00": return 156;
            case "130:50:00": return 157;
            case "131:40:00": return 158;
            case "132:30:00": return 159;
            case "133:20:00": return 160;
            case "134:10:00": return 161;
            case "135:00:00": return 162;
            case "135:50:00": return 163;
            case "136:40:00": return 164;
            case "137:30:00": return 165;
            case "138:20:00": return 166;
            case "139:10:00": return 167;
            case "140:00:00": return 168;
            case "140:50:00": return 169;
            case "141:40:00": return 170;
            case "142:30:00": return 171;
            case "143:20:00": return 172;
            case "144:10:00": return 173;
            case "145:00:00": return 174;
            case "145:50:00": return 175;
            case "146:40:00": return 176;
            case "147:30:00": return 177;
            case "148:20:00": return 178;
            case "149:10:00": return 179;
            case "150:00:00": return 180;
            case "150:50:00": return 181;
            case "151:40:00": return 182;
            case "152:30:00": return 183;
            case "153:20:00": return 184;
            case "154:10:00": return 185;
            case "155:00:00": return 186;
            case "155:50:00": return 187;
            case "156:40:00": return 188;
            case "157:30:00": return 189;
            case "158:20:00": return 190;
            case "159:10:00": return 191;
            case "160:00:00": return 192;
            case "160:50:00": return 193;
            case "161:40:00": return 194;
            case "162:30:00": return 195;
            case "163:20:00": return 196;
            case "164:10:00": return 197;
            case "165:00:00": return 198;
            case "165:50:00": return 199;
            case "166:40:00": return 200;
            case "167:30:00": return 201;
            case "168:20:00": return 202;
            case "169:10:00": return 203;
            case "170:00:00": return 204;
            case "170:50:00": return 205;
            case "171:40:00": return 206;
            case "172:30:00": return 207;
            case "173:20:00": return 208;
            case "174:10:00": return 209;
            case "175:00:00": return 210;
            case "175:50:00": return 211;
            case "176:40:00": return 212;
            case "177:30:00": return 213;
            case "178:20:00": return 214;
            case "179:10:00": return 215;
            case "180:00:00": return 216;
            case "180:50:00": return 217;
            case "181:40:00": return 218;
            case "182:30:00": return 219;
            case "183:20:00": return 220;
            case "184:10:00": return 221;
            case "185:00:00": return 222;
            case "185:50:00": return 223;
            case "186:40:00": return 224;
            case "187:30:00": return 225;
            case "188:20:00": return 226;
            case "189:10:00": return 227;
            case "190:00:00": return 228;
            case "190:50:00": return 229;
            case "191:40:00": return 230;
            case "192:30:00": return 231;
            case "193:20:00": return 232;
            case "194:10:00": return 233;
            case "195:00:00": return 234;
            case "195:50:00": return 235;
            case "196:40:00": return 236;
            case "197:30:00": return 237;
            case "198:20:00": return 238;
            case "199:10:00": return 239;
            case "200:00:00": return 240;
            case "200:50:00": return 241;
            case "201:40:00": return 242;
            case "202:30:00": return 243;
            case "203:20:00": return 244;
            case "204:10:00": return 245;
            case "205:00:00": return 246;
            case "205:50:00": return 247;
            case "206:40:00": return 248;
            case "207:30:00": return 249;
            case "208:20:00": return 250;
            case "209:10:00": return 251;
            case "210:00:00": return 252;
            case "210:50:00": return 253;
            case "211:40:00": return 254;
            case "212:30:00": return 255;
            case "213:20:00": return 256;
            case "214:10:00": return 257;
            case "215:00:00": return 258;
            case "215:50:00": return 259;
            case "216:40:00": return 260;
            case "217:30:00": return 261;
            case "218:20:00": return 262;
            case "219:10:00": return 263;
            case "220:00:00": return 264;
            case "220:50:00": return 265;
            case "221:40:00": return 266;
            case "222:30:00": return 267;
            case "223:20:00": return 268;
            case "224:10:00": return 269;
            case "225:00:00": return 270;
            case "225:50:00": return 271;
            case "226:40:00": return 272;
            case "227:30:00": return 273;
            case "228:20:00": return 274;
            case "229:10:00": return 275;
            case "230:00:00": return 276;
            case "230:50:00": return 277;
            case "231:40:00": return 278;
            case "232:30:00": return 279;
            case "233:20:00": return 280;
            case "234:10:00": return 281;
            case "235:00:00": return 282;
            case "235:50:00": return 283;
            case "236:40:00": return 284;
            case "237:30:00": return 285;
            case "238:20:00": return 286;
            case "239:10:00": return 287;
            case "240:00:00": return 288;
            case "240:50:00": return 289;
            case "241:40:00": return 290;
            case "242:30:00": return 291;
            case "243:20:00": return 292;
            case "244:10:00": return 293;
            case "245:00:00": return 294;
            case "245:50:00": return 295;
            case "246:40:00": return 296;
            case "247:30:00": return 297;
            case "248:20:00": return 298;
            case "249:10:00": return 299;
            case "250:00:00": return 300;
            default: return -1; // Carga horária inválida
        }

    }

    private void atualizarResultados(int totalFaltas, String detalhes) {
        String mensagem;
        int cor;

        if (totalFaltas <= 0) {
            mensagem = "Está tranquilo!";
            cor = Color.GREEN; // Verde
        } else if (totalFaltas <= 100) {
            mensagem = "Está tranquilo!";
            cor = Color.GREEN; // Verde
        } else if (totalFaltas <= 200) {
            mensagem = "Cuidado com as faltas!!";
            cor = Color.rgb(255, 165, 0); // Amarelo
        } else {
            mensagem = "Pare de faltar!!!";
            cor = Color.RED; // Vermelho
        }

        textViewResultados.setText("Total de faltas: " + totalFaltas + "\n\n" + mensagem + "\n\nDetalhes:\n" + detalhes);
        textViewResultados.setTextColor(cor);
        textViewResultados.setGravity(View.TEXT_ALIGNMENT_CENTER);
    }

    private void zerarFaltas() {
        for (Spinner spinner : spinners) {
            spinner.setSelection(0); // Reseta a seleção para o primeiro item
        }
        textViewResultados.setText("");
        Toast.makeText(getContext(), "Faltas zeradas!", Toast.LENGTH_SHORT).show();
    }

    private void zerarResultados() {
        for (Spinner spinner : spinners) {
            spinner.setSelection(0); // Reseta a seleção para o primeiro item
        }
        textViewResultados.setText("");
        Toast.makeText(getContext(), "Faltas zeradas!", Toast.LENGTH_SHORT).show();
    }
}
