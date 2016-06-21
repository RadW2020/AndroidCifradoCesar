package com.radw.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    // Call onSendMessage() when the button is clicked
    public void onSendMessage(View view) {

        // recogida de la fase seleccionada
        Spinner faseView =(Spinner)findViewById(R.id.fase);
        String faseNumber = (faseView.getSelectedItem().toString());


        // recogida del mensaje a cifrar
        EditText messageView = (EditText)findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        Intent intent = new Intent(this, ReceiveMessageActivity.class);

        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);

        intent.putExtra(ReceiveMessageActivity.EXTRA_FASE, faseNumber);
        startActivity(intent);
    }

}
