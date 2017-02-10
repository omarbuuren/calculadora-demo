package com.buuharen.megakalc;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements MainLista {

    // Ui
    RadioGroup contenedorRadios;
    
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contenedorRadios = (RadioGroup) findViewById(R.id.radiosOperaciones);
        contenedorRadios.check(R.id.radioSuma);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /*
    crea un metodo de chequeo y aplica un swicht para cambiar el operador.
     */

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        TextView operador = (TextView) findViewById(R.id.textOperador1);

        switch (contenedorRadios.getCheckedRadioButtonId()) {
            case R.id.radioSuma:
                operador.setText("+");
                break;
            case R.id.radioResta:
                operador.setText("-");
                break;
            case R.id.radioMultiplicacion:
                operador.setText("*");
                break;
            case R.id.radioDivision:
                operador.setText("/");
                break;
        }
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing.Builder builder = new Thing.Builder();
        builder.setName("Main Page");
        builder.setUrl(Uri.parse("http://[omarbuuren.com]"));
        Thing object = builder.build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public void OnclickOperar(View view) {
        // Variables locales
        EditText NumeroX, NumeroY;
        int X, Y, resultado = 0;

        // Obtener los campos de edición
        NumeroX = (EditText) findViewById(R.id.NumeroX);
        NumeroY = (EditText) findViewById(R.id.NumeroY);


        // Convertir el texto a enteros
        X = Integer.parseInt(NumeroX.getText().toString());
        Y = Integer.parseInt(NumeroY.getText().toString());

        // Calcular resultado
        switch (contenedorRadios.getCheckedRadioButtonId()) {
            case R.id.radioSuma:
                resultado = X + Y;
                break;
            case R.id.radioResta:
                resultado = X - Y;
                break;
            case R.id.radioMultiplicacion:
                resultado = X * Y;
                break;
            case R.id.radioDivision:
                resultado = X / Y;
                break;
        }

        // Asignar el resultado
        ((TextView) findViewById(R.id.textResultado))
                .setText(String.valueOf(resultado));
    }
    }


