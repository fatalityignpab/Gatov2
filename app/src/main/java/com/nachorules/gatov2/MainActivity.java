package com.nachorules.gatov2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    EditText txtCuadro1,txtCuadro2,txtCuadro3,txtCuadro4,txtCuadro5,txtCuadro6,txtCuadro7,txtCuadro8,txtCuadro9;
    Button btnX,btnO,btnReinicio, btnHistorial;
    TextView lblNombre;
    private String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    private int puntX = 0, puntO = 0; // Para los puntajes (Primero se lee y luego se escribe)
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botones
        btnX = (Button) findViewById(R.id.btnX);
        btnO = (Button) findViewById(R.id.btnO);
        btnReinicio = (Button) findViewById(R.id.btnReinicio);
        btnHistorial = (Button) findViewById(R.id.btnHist);

        // Campos de texto
        txtCuadro1 = (EditText) findViewById(R.id.txtCuadro1);
        txtCuadro2 = (EditText) findViewById(R.id.txtCuadro2);
        txtCuadro3 = (EditText) findViewById(R.id.txtCuadro3);
        txtCuadro4 = (EditText) findViewById(R.id.txtCuadro4);
        txtCuadro5 = (EditText) findViewById(R.id.txtCuadro5);
        txtCuadro6 = (EditText) findViewById(R.id.txtCuadro6);
        txtCuadro7 = (EditText) findViewById(R.id.txtCuadro7);
        txtCuadro8 = (EditText) findViewById(R.id.txtCuadro8);
        txtCuadro9 = (EditText) findViewById(R.id.txtCuadro9);

        //Labels
        lblNombre = (TextView) findViewById(R.id.lblNombre);

        //Acciones de los botones
        btnO.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnClicko(1);
                }
            }
        );

        btnX.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnClicko(2);
                }
            }
        );

        btnReinicio.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnReinicio_click();
                }
            }
        );

        //Shared (dice que se guarda en el data/data)
        final SharedPreferences hist = getSharedPreferences("HistorialPuntaje", Context.MODE_PRIVATE);

        btnHistorial.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    puntX = hist.getInt("PuntajeX", 0); // Revisar en como obtener el puntaje del XML
                    puntO = hist.getInt("PuntajeO", 0); // Revisar en como obtener el puntaje del XML
                    Toast.makeText(MainActivity.this, "Total: O:"+Integer.toString(puntO)+" X:"+Integer.toString(puntX),Toast.LENGTH_LONG).show();
                }
            }
        );

        // Nombre de los 2
        lblNombre.setText("Ignacio Orozco");
    }

    public String[] captTexto(){ // Tratar de eliminar xq no se usara (creo q no :v)
        s1 = txtCuadro1.getText().toString();
        s2 = txtCuadro2.getText().toString();
        s3 = txtCuadro3.getText().toString();
        s4 = txtCuadro4.getText().toString();
        s5 = txtCuadro5.getText().toString();
        s6 = txtCuadro6.getText().toString();
        s7 = txtCuadro7.getText().toString();
        s8 = txtCuadro8.getText().toString();
        s9 = txtCuadro9.getText().toString();

        String[] s = {s1,s2,s3,s4,s5,s6,s7,s8,s9};
        for (int i = 0; i < 9; i++){
            if (s[i].equals("")) {
                s[i] = String.valueOf(i+1);
            }
        }
        return s;
    }

    public void btnReinicio_click(){
        txtCuadro1.setText("");
        txtCuadro2.setText("");
        txtCuadro3.setText("");
        txtCuadro4.setText("");
        txtCuadro5.setText("");
        txtCuadro6.setText("");
        txtCuadro7.setText("");
        txtCuadro8.setText("");
        txtCuadro9.setText("");

        btnO.setVisibility(View.VISIBLE);
        btnX.setVisibility(View.VISIBLE);
        btnReinicio.setVisibility(View.INVISIBLE);
    }

    public void cambioColor(String letra, String[] o){ // Revisar el porque se detiene la app
        String color = "000000";
        switch (letra){
            case "O":
                color = "C31111";
                if (o[0].equals("O"))
                    txtCuadro1.setTextColor(Integer.parseInt(color));
                if (o[1].equals("O"))
                    txtCuadro2.setTextColor(Integer.parseInt(color));
                if (o[2].equals("O"))
                    txtCuadro3.setTextColor(Integer.parseInt(color));
                if (o[3].equals("O"))
                    txtCuadro4.setTextColor(Integer.parseInt(color));
                if (o[4].equals("O"))
                    txtCuadro5.setTextColor(Integer.parseInt(color));
                if (o[5].equals("O"))
                    txtCuadro6.setTextColor(Integer.parseInt(color));
                if (o[6].equals("O"))
                    txtCuadro7.setTextColor(Integer.parseInt(color));
                if (o[7].equals("O"))
                    txtCuadro8.setTextColor(Integer.parseInt(color));
                if (o[8].equals("O"))
                    txtCuadro9.setTextColor(Integer.parseInt(color));
                break;
            case "X":
                color = "4049FE";
                if (o[0].equals("X"))
                    txtCuadro1.setTextColor(Integer.parseInt(color));
                if (o[1].equals("X"))
                    txtCuadro2.setTextColor(Integer.parseInt(color));
                if (o[2].equals("X"))
                    txtCuadro3.setTextColor(Integer.parseInt(color));
                if (o[3].equals("X"))
                    txtCuadro4.setTextColor(Integer.parseInt(color));
                if (o[4].equals("X"))
                    txtCuadro5.setTextColor(Integer.parseInt(color));
                if (o[5].equals("X"))
                    txtCuadro6.setTextColor(Integer.parseInt(color));
                if (o[6].equals("X"))
                    txtCuadro7.setTextColor(Integer.parseInt(color));
                if (o[7].equals("X"))
                    txtCuadro8.setTextColor(Integer.parseInt(color));
                if (o[8].equals("X"))
                    txtCuadro9.setTextColor(Integer.parseInt(color));
                break;
        }


    }

    public void btnClicko(int cond){
        String[] arr = captTexto();

        String op;
        //Shared (dice que se guarda en el data/data)
        SharedPreferences hist = getSharedPreferences("HistorialPuntaje", Context.MODE_PRIVATE);
        SharedPreferences.Editor histEdit = hist.edit();
        //int puntaje = 0;

        switch (cond){
            case 1:
                op = "O";
                if ((arr[0].equals(op) && arr[1].equals(op) && arr[2].equals(op))
                        || (arr[3].equals(op) && arr[4].equals(op) && arr[5].equals(op))
                        || (arr[6].equals(op) && arr[7].equals(op) && arr[8].equals(op))
                        || (arr[0].equals(op) && arr[3].equals(op) && arr[6].equals(op))
                        || (arr[1].equals(op) && arr[4].equals(op) && arr[7].equals(op))
                        || (arr[2].equals(op) && arr[5].equals(op) && arr[8].equals(op))
                        || (arr[0].equals(op) && arr[4].equals(op) && arr[8].equals(op))
                        || (arr[2].equals(op) && arr[4].equals(op) && arr[6].equals(op))){
                    Toast.makeText(this, "Gana el jugador 1 (O)", Toast.LENGTH_SHORT).show();
                    btnO.setVisibility(View.INVISIBLE);
                    btnX.setVisibility(View.INVISIBLE);
                    btnReinicio.setVisibility(View.VISIBLE);
                    histEdit.putInt("PuntajeO", puntO + 1); // Probar
                    histEdit.commit();
                } else {
                    Toast.makeText(this, "Sigue el jugador 2 (X)", Toast.LENGTH_SHORT).show();
                    btnO.setVisibility(View.INVISIBLE);
                    btnX.setVisibility(View.VISIBLE);
                }
                break;
            case 2:
                op = "X";
                if ((arr[0].equals(op) && arr[1].equals(op) && arr[2].equals(op))
                        || (arr[3].equals(op) && arr[4].equals(op) && arr[5].equals(op))
                        || (arr[6].equals(op) && arr[7].equals(op) && arr[8].equals(op))
                        || (arr[0].equals(op) && arr[3].equals(op) && arr[6].equals(op))
                        || (arr[1].equals(op) && arr[4].equals(op) && arr[7].equals(op))
                        || (arr[2].equals(op) && arr[5].equals(op) && arr[8].equals(op))
                        || (arr[0].equals(op) && arr[4].equals(op) && arr[8].equals(op))
                        || (arr[2].equals(op) && arr[4].equals(op) && arr[6].equals(op))){
                    Toast.makeText(this, "Gana el jugador 2 (X)", Toast.LENGTH_SHORT).show();
                    btnO.setVisibility(View.INVISIBLE);
                    btnX.setVisibility(View.INVISIBLE);
                    btnReinicio.setVisibility(View.VISIBLE);
                    histEdit.putInt("PuntajeX", puntX + 1); // Probar
                    histEdit.commit();
                } else {
                    Toast.makeText(this, "Sigue el jugador 1 (O)", Toast.LENGTH_SHORT).show();
                    btnO.setVisibility(View.VISIBLE);
                    btnX.setVisibility(View.INVISIBLE);
                }
                break;
            default:
                Toast.makeText(this,"Hay un error de caracter", Toast.LENGTH_SHORT);
                break;
        }
    }
}
