package com.nachorules.gatov2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    EditText txtCuadro1,txtCuadro2,txtCuadro3,txtCuadro4,txtCuadro5,txtCuadro6,txtCuadro7,txtCuadro8,txtCuadro9;
    Button btnX,btnO,btnReinicio;
    TextView lblNombre;
    private String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnX = (Button) findViewById(R.id.btnX);
        btnO = (Button) findViewById(R.id.btnO);
        btnReinicio = (Button) findViewById(R.id.btnReinicio);
        txtCuadro1 = (EditText) findViewById(R.id.txtCuadro1);
        txtCuadro2 = (EditText) findViewById(R.id.txtCuadro2);
        txtCuadro3 = (EditText) findViewById(R.id.txtCuadro3);
        txtCuadro4 = (EditText) findViewById(R.id.txtCuadro4);
        txtCuadro5 = (EditText) findViewById(R.id.txtCuadro5);
        txtCuadro6 = (EditText) findViewById(R.id.txtCuadro6);
        txtCuadro7 = (EditText) findViewById(R.id.txtCuadro7);
        txtCuadro8 = (EditText) findViewById(R.id.txtCuadro8);
        txtCuadro9 = (EditText) findViewById(R.id.txtCuadro9);
        lblNombre = (TextView) findViewById(R.id.lblNombre);

        btnO.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //btnO_click();
                    btnClicko(1);
                }
            }
        );

        btnX.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //bntX_click();
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

        lblNombre.setText("Ignacio Orozco");
    }

    public String[] captTexto(){
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

    public void cambioColor(String letra, String[] o){
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

    public void btnO_click(){
        String[] o = captTexto();
        //cambioColor("O", o);
        if ((o[0].equals(o[1]) && o[0].equals(o[2])) || (o[3].equals(o[4]) && o[3].equals(o[5])) || (o[6].equals(o[7]) && o[6].equals(o[8]))
                || (o[0].equals(o[3]) && o[0].equals(o[6])) || (o[1].equals(o[4]) && o[1].equals(o[7])) || (o[2].equals(o[5]) && o[2].equals(o[8]))
                || (o[0].equals(o[4]) && o[0].equals(o[8])) || (o[2].equals(o[4]) && o[2].equals(o[6]))){
            Toast.makeText(this, "Gana el jugador 1 (O)", Toast.LENGTH_SHORT).show();
            btnO.setVisibility(View.INVISIBLE);
            btnX.setVisibility(View.INVISIBLE);
            btnReinicio.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "Sigue el jugador 2 (X)", Toast.LENGTH_SHORT).show();
            btnO.setVisibility(View.INVISIBLE);
            btnX.setVisibility(View.VISIBLE);
        }
    }

    public void bntX_click(){
        String[] x = captTexto();
        //cambioColor("X", x);
        if ((x[0].equals(x[1]) && x[0].equals(x[2])) || (x[3].equals(x[4]) && x[3].equals(x[5])) || (x[6].equals(x[7]) && x[6].equals(x[8]))
                || (x[0].equals(x[3]) && x[0].equals(x[6])) || (x[1].equals(x[4]) && x[1].equals(x[7])) || (x[2].equals(x[5]) && x[2].equals(x[8]))
                || (x[0].equals(x[4]) && x[0].equals(x[8])) || (x[2].equals(x[4]) && x[2].equals(x[6]))){
            Toast.makeText(this, "Gana el jugador 2 (X)", Toast.LENGTH_SHORT).show();
            btnO.setVisibility(View.INVISIBLE);
            btnX.setVisibility(View.INVISIBLE);
            btnReinicio.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "Sigue el jugador 1 (O)", Toast.LENGTH_SHORT).show();
            btnO.setVisibility(View.VISIBLE);
            btnX.setVisibility(View.INVISIBLE);
        }
    }
}
