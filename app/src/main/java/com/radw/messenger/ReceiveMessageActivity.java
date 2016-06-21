package com.radw.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class ReceiveMessageActivity extends Activity {

    public static final String EXTRA_MESSAGE = "mensage";
    public static final String EXTRA_FASE = "0";
    private static final String base = "abcdefghijklmnopqrstuvwxyz";
    String messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        // recogida del texto del mensaje
        Intent intent = getIntent();
        messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView) findViewById(R.id.message);
        // recogida de la fase de encriptado
        int fase = Integer.parseInt(intent.getStringExtra(EXTRA_FASE));

        messageView.setText(cifrar(fase));
    }

    public String cifrar(int delta) {
        String textoCifrado = "";
        for (int i = 0; i < messageText.length(); i++) {
            // obtenemos la letra
            char letraEstudiada = messageText.charAt(i);
            // obtenemos el indice de esa letra en la base
            // Si no está, tomará el valor -1
            int lugarEnBase = base.indexOf(letraEstudiada);
            // calculamos el nuevo indice en la base con el mod.
            int indiceLetraModificada = lugarEnBase + delta;
            // calculo para iterar sobre las 25 letras

            if ((indiceLetraModificada) >= base.length()) {
                indiceLetraModificada -= base.length();
            }

            char nuevaLetra = base.charAt(indiceLetraModificada);
            //condicional para cambiar solo los caracteres que están en la base
            if (lugarEnBase == -1) {
                textoCifrado += letraEstudiada;
            } else {
                textoCifrado += nuevaLetra;
            }
        }
        return textoCifrado;
    }
}
