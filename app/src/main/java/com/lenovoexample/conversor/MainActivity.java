package com.lenovoexample.conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner sP1, sP2;
    private EditText eCantidad;
    private TextView tMostrar;
    private Button bConvertir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eCantidad = findViewById(R.id.eCantidad);
        tMostrar = findViewById(R.id.tMostrar);
        bConvertir = findViewById(R.id.bConvertir);
        sP1 = (Spinner) findViewById(R.id.sDesde);
        sP2 = (Spinner) findViewById(R.id.sHacia);
        sP1.setOnItemSelectedListener(this);
        sP2.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.sP1, R.layout.spinner_uno);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.sP2, R.layout.spinner_uno);
        sP1.setAdapter(adapter1);
        sP2.setAdapter(adapter2);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void convertir(View view) {
        Double cantidad;
        if(!eCantidad.getText().toString().isEmpty()) {
            cantidad = (Double.parseDouble(eCantidad.getText().toString()));
        }
        else {
            cantidad = 0.0;
        }
        Double Conversion = 0.0;
        int indice1 = sP1.getSelectedItemPosition();
        int indice2 = sP2.getSelectedItemPosition();

        switch (indice1){
            case 0:
                if(indice2 == 0){Conversion = cantidad * 0.00030;}
                else if(indice2 == 1){Conversion = cantidad * 0.00034;}
                else if(indice2 == 2){Conversion = cantidad * 0.00027;}
                else if(indice2 == 3){Conversion = cantidad;}
                else if(indice2 == 4){Conversion = cantidad * 0.038;}
                break;
            case 1:
                if(indice2 == 0){Conversion = cantidad;}
                else if(indice2 == 1){Conversion = cantidad * 1.14;}
                else if(indice2 == 2){Conversion = cantidad * 0.89;}
                else if(indice2 == 3){Conversion = cantidad * 3362.78;}
                else if(indice2 == 4){Conversion = cantidad * 126.65;}
                break;
            case 2:
                if(indice2 == 0){Conversion = cantidad * 0.88;}
                else if(indice2 == 1){Conversion = cantidad;}
                else if(indice2 == 2){Conversion = cantidad * 0.78;}
                else if(indice2 == 3){Conversion = cantidad * 2944;}
                else if(indice2 == 4){Conversion = cantidad * 110.88;}
                break;
            case 3:
                if(indice2 == 0){Conversion = cantidad * 1.12;}
                else if(indice2 == 1){Conversion = cantidad * 1.28;}
                else if(indice2 == 2){Conversion = cantidad ;}
                else if(indice2 == 3){Conversion = cantidad * 3759.18;}
                else if(indice2 == 4){Conversion = cantidad * 141.55;}
                break;
            case 4:
                if(indice2 == 0){Conversion = cantidad * 0.0079;}
                else if(indice2 == 1){Conversion = cantidad * 0.009;}
                else if(indice2 == 2){Conversion = cantidad * 0.0071;}
                else if(indice2 == 3){Conversion = cantidad * 26.55;}
                else if(indice2 == 4){Conversion = cantidad ;}
                break;
                default:
                    Conversion = 0.0;
                    break;
        }
        if(Conversion != 0) {
            tMostrar.setText(String.valueOf(Conversion));
        }else if(cantidad ==0 && Conversion == 0){
            tMostrar.setText(String.valueOf("Ingresar Valor"));
        }
    }
}
