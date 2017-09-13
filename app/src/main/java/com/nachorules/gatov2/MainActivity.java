package com.nachorules.gatov2;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Se pone focusable para que no muestre el teclado
    EditText txtCuadro1,txtCuadro2,txtCuadro3,txtCuadro4,txtCuadro5,txtCuadro6,txtCuadro7,txtCuadro8,txtCuadro9;
    Button btnX,btnO,btnReinicio, btnHistorial;
    TextView lblNombre, lblTitulo;

    private String s1,s2,s3,s4,s5,s6,s7,s8,s9, jugadorO, jugadorX;
    private int puntX = 0, puntO = 0, turno = 0, numCasillas = 0; // Para los puntajes (Primero se lee y luego se escribe)
    
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

        // Evita que los EditText se ponga en teclado
        txtCuadro1.setFocusable(false);
        txtCuadro2.setFocusable(false);
        txtCuadro3.setFocusable(false);
        txtCuadro4.setFocusable(false);
        txtCuadro5.setFocusable(false);
        txtCuadro6.setFocusable(false);
        txtCuadro7.setFocusable(false);
        txtCuadro8.setFocusable(false);
        txtCuadro9.setFocusable(false);

        // Evita que los EditText se ponga antes de poner el boton
        txtCuadro1.setVisibility(View.INVISIBLE);
        txtCuadro2.setVisibility(View.INVISIBLE);
        txtCuadro3.setVisibility(View.INVISIBLE);
        txtCuadro4.setVisibility(View.INVISIBLE);
        txtCuadro5.setVisibility(View.INVISIBLE);
        txtCuadro6.setVisibility(View.INVISIBLE);
        txtCuadro7.setVisibility(View.INVISIBLE);
        txtCuadro8.setVisibility(View.INVISIBLE);
        txtCuadro9.setVisibility(View.INVISIBLE);

        // Para que los EditText esten habilitados
        txtCuadro1.setEnabled(true);
        txtCuadro2.setEnabled(true);
        txtCuadro3.setEnabled(true);
        txtCuadro4.setEnabled(true);
        txtCuadro5.setEnabled(true);
        txtCuadro6.setEnabled(true);
        txtCuadro7.setEnabled(true);
        txtCuadro8.setEnabled(true);
        txtCuadro9.setEnabled(true);

        //Colores
        txtCuadro1.setTextColor(Color.BLACK);
        txtCuadro2.setTextColor(Color.BLACK);
        txtCuadro3.setTextColor(Color.BLACK);
        txtCuadro4.setTextColor(Color.BLACK);
        txtCuadro5.setTextColor(Color.BLACK);
        txtCuadro6.setTextColor(Color.BLACK);
        txtCuadro7.setTextColor(Color.BLACK);
        txtCuadro8.setTextColor(Color.BLACK);
        txtCuadro9.setTextColor(Color.BLACK);

        //Labels
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblTitulo = (TextView) findViewById(R.id.lblTitulo);

        //Shared (dice que se guarda en el data/data)
        final SharedPreferences hist = getSharedPreferences("HistorialPuntaje", Context.MODE_PRIVATE);
        puntX = hist.getInt("PuntajeX", 0); // Revisar en como obtener el puntaje del XML
        puntO = hist.getInt("PuntajeO", 0); // Revisar en como obtener el puntaje del XML

        //Acciones de los botones
        btnO.setOnClickListener( // Ya solo serviria para los turnos
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //btnClicko(1);
                    inicioTurno(1);
                }
            }
        );

        btnX.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //btnClicko(2);
                    inicioTurno(2);
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

        btnHistorial.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    puntX = hist.getInt("PuntajeX", 0); // Doble afirmacion
                    puntO = hist.getInt("PuntajeO", 0); // Doble afirmacion
                    Toast.makeText(MainActivity.this, "Total: O:"+Integer.toString(puntO)+" ganados X:"+Integer.toString(puntX)+" ganados",Toast.LENGTH_LONG).show();
                }
            }
        );

        txtCuadro1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        turnoJugada(turno, txtCuadro1);
                        btnClicko(turno);
                    }
                }
        );
        txtCuadro2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        turnoJugada(turno, txtCuadro2);
                        btnClicko(turno);
                    }
                }
        );
        txtCuadro3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        turnoJugada(turno, txtCuadro3);
                        btnClicko(turno);
                    }
                }
        );
        txtCuadro4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        turnoJugada(turno, txtCuadro4);
                        btnClicko(turno);
                    }
                }
        );
        txtCuadro5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        turnoJugada(turno, txtCuadro5);
                        btnClicko(turno);
                    }
                }
        );
        txtCuadro6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        turnoJugada(turno, txtCuadro6);
                        btnClicko(turno);
                    }
                }
        );
        txtCuadro7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        turnoJugada(turno, txtCuadro7);
                        btnClicko(turno);
                    }
                }
        );
        txtCuadro8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        turnoJugada(turno, txtCuadro8);
                        btnClicko(turno);
                    }
                }
        );
        txtCuadro9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        turnoJugada(turno, txtCuadro9);
                        btnClicko(turno);
                    }
                }
        );

        lblNombre.setText("");
        lblTitulo.setText("Selecciona quien jugará");

        jugadorO = "Ignacio Orozco"; //Nombres
        jugadorX = "Kevin Olivares";
    }

    public void turnoJugada(int cond, EditText text){
        switch (cond){
            case 1:
                text.setText("O");
                lblNombre.setText(jugadorO);
                break;
            case 2:
                text.setText("X");
                lblNombre.setText(jugadorX);
                break;
        }
        lblTitulo.setText("Jugador: ");
        text.setEnabled(false);
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

        // Para que los EditText esten habilitados
        txtCuadro1.setEnabled(true);
        txtCuadro2.setEnabled(true);
        txtCuadro3.setEnabled(true);
        txtCuadro4.setEnabled(true);
        txtCuadro5.setEnabled(true);
        txtCuadro6.setEnabled(true);
        txtCuadro7.setEnabled(true);
        txtCuadro8.setEnabled(true);
        txtCuadro9.setEnabled(true);

        btnO.setVisibility(View.VISIBLE);
        btnX.setVisibility(View.VISIBLE);
        btnReinicio.setVisibility(View.INVISIBLE);

        txtCuadro1.setVisibility(View.INVISIBLE);
        txtCuadro2.setVisibility(View.INVISIBLE);
        txtCuadro3.setVisibility(View.INVISIBLE);
        txtCuadro4.setVisibility(View.INVISIBLE);
        txtCuadro5.setVisibility(View.INVISIBLE);
        txtCuadro6.setVisibility(View.INVISIBLE);
        txtCuadro7.setVisibility(View.INVISIBLE);
        txtCuadro8.setVisibility(View.INVISIBLE);
        txtCuadro9.setVisibility(View.INVISIBLE);

        txtCuadro1.setTextColor(Color.BLACK);
        txtCuadro2.setTextColor(Color.BLACK);
        txtCuadro3.setTextColor(Color.BLACK);
        txtCuadro4.setTextColor(Color.BLACK);
        txtCuadro5.setTextColor(Color.BLACK);
        txtCuadro6.setTextColor(Color.BLACK);
        txtCuadro7.setTextColor(Color.BLACK);
        txtCuadro8.setTextColor(Color.BLACK);
        txtCuadro9.setTextColor(Color.BLACK);

        lblNombre.setText("");
        lblTitulo.setText("Selecciona quien jugará");
    }

    public void cambioColor(int cond, String[] arr){
        String color = "#000000", op = "";

        if (cond == 1){
            color = "#C31111";
            op = "O";
        } else {
            color = "#4049FE";
            op = "X";
        }

        if (arr[0].equals(op) && arr[1].equals(op) && arr[2].equals(op)){
            txtCuadro1.setTextColor(Color.parseColor(color));
            txtCuadro2.setTextColor(Color.parseColor(color));
            txtCuadro3.setTextColor(Color.parseColor(color));
        }

        if (arr[3].equals(op) && arr[4].equals(op) && arr[5].equals(op)){
            txtCuadro4.setTextColor(Color.parseColor(color));
            txtCuadro5.setTextColor(Color.parseColor(color));
            txtCuadro6.setTextColor(Color.parseColor(color));
        }

        if (arr[6].equals(op) && arr[7].equals(op) && arr[8].equals(op)){
            txtCuadro7.setTextColor(Color.parseColor(color));
            txtCuadro8.setTextColor(Color.parseColor(color));
            txtCuadro9.setTextColor(Color.parseColor(color));
        }

        if (arr[0].equals(op) && arr[3].equals(op) && arr[6].equals(op)){
            txtCuadro1.setTextColor(Color.parseColor(color));
            txtCuadro4.setTextColor(Color.parseColor(color));
            txtCuadro7.setTextColor(Color.parseColor(color));
        }

        if (arr[1].equals(op) && arr[4].equals(op) && arr[7].equals(op)){
            txtCuadro2.setTextColor(Color.parseColor(color));
            txtCuadro5.setTextColor(Color.parseColor(color));
            txtCuadro8.setTextColor(Color.parseColor(color));
        }

        if (arr[2].equals(op) && arr[5].equals(op) && arr[8].equals(op)){
            txtCuadro3.setTextColor(Color.parseColor(color));
            txtCuadro6.setTextColor(Color.parseColor(color));
            txtCuadro9.setTextColor(Color.parseColor(color));
        }

        if (arr[0].equals(op) && arr[4].equals(op) && arr[8].equals(op)){
            txtCuadro1.setTextColor(Color.parseColor(color));
            txtCuadro5.setTextColor(Color.parseColor(color));
            txtCuadro9.setTextColor(Color.parseColor(color));
        }

        if (arr[2].equals(op) && arr[4].equals(op) && arr[6].equals(op)){
            txtCuadro3.setTextColor(Color.parseColor(color));
            txtCuadro5.setTextColor(Color.parseColor(color));
            txtCuadro7.setTextColor(Color.parseColor(color));
        }

    }

    public void inicioTurno(int cond){
        String nombre = "";
        switch (cond){
            case 1:
                turno = 1;
                lblNombre.setText(jugadorO);
                nombre = jugadorO;
                break;
            case 2:
                turno = 2;
                lblNombre.setText(jugadorX);
                nombre = jugadorX;
                break;
        }
        lblTitulo.setText("Jugador: ");
        btnO.setVisibility(View.INVISIBLE);
        btnX.setVisibility(View.INVISIBLE);
        txtCuadro1.setVisibility(View.VISIBLE);
        txtCuadro2.setVisibility(View.VISIBLE);
        txtCuadro3.setVisibility(View.VISIBLE);
        txtCuadro4.setVisibility(View.VISIBLE);
        txtCuadro5.setVisibility(View.VISIBLE);
        txtCuadro6.setVisibility(View.VISIBLE);
        txtCuadro7.setVisibility(View.VISIBLE);
        txtCuadro8.setVisibility(View.VISIBLE);
        txtCuadro9.setVisibility(View.VISIBLE);

        Toast.makeText(MainActivity.this, "Inicia "+nombre, Toast.LENGTH_SHORT).show();
        numCasillas = 0;
    }

    public void btnClicko(int cond){
        String[] arr = captTexto();

        String op;
        //Shared (dice que se guarda en el data/data)
        SharedPreferences hist = getSharedPreferences("HistorialPuntaje", Context.MODE_PRIVATE);
        SharedPreferences.Editor histEdit = hist.edit();
        lblTitulo.setVisibility(View.VISIBLE);
        lblNombre.setTextSize(25);

        switch (cond){
            case 1:
                op = "O";
                lblNombre.setText(jugadorO);
                if ((arr[0].equals(op) && arr[1].equals(op) && arr[2].equals(op))
                        || (arr[3].equals(op) && arr[4].equals(op) && arr[5].equals(op))
                        || (arr[6].equals(op) && arr[7].equals(op) && arr[8].equals(op))
                        || (arr[0].equals(op) && arr[3].equals(op) && arr[6].equals(op))
                        || (arr[1].equals(op) && arr[4].equals(op) && arr[7].equals(op))
                        || (arr[2].equals(op) && arr[5].equals(op) && arr[8].equals(op))
                        || (arr[0].equals(op) && arr[4].equals(op) && arr[8].equals(op))
                        || (arr[2].equals(op) && arr[4].equals(op) && arr[6].equals(op))){
                    Toast.makeText(this, "Gana "+lblNombre.getText().toString()+" (O)", Toast.LENGTH_SHORT).show();

                    lblNombre.setText(jugadorO);
                    lblTitulo.setText("Ganador: ");
                    cambioColor(1,arr);

                    btnO.setVisibility(View.INVISIBLE);
                    btnX.setVisibility(View.INVISIBLE);
                    btnReinicio.setVisibility(View.VISIBLE);
                    histEdit.putInt("PuntajeO", puntO + 1); // Probar
                    histEdit.commit();
                    // Evita que los EditText se ponga antes de poner el boton
                    txtCuadro1.setEnabled(false);
                    txtCuadro2.setEnabled(false);
                    txtCuadro3.setEnabled(false);
                    txtCuadro4.setEnabled(false);
                    txtCuadro5.setEnabled(false);
                    txtCuadro6.setEnabled(false);
                    txtCuadro7.setEnabled(false);
                    txtCuadro8.setEnabled(false);
                    txtCuadro9.setEnabled(false);

                    numCasillas = 0;
                } else {
                    numCasillas += 1;
                    lblNombre.setText(jugadorX);
                    Toast.makeText(this, "Sigue "+lblNombre.getText().toString()+" (X)", Toast.LENGTH_SHORT).show();
                    //btnO.setVisibility(View.INVISIBLE);
                    //btnX.setVisibility(View.VISIBLE);
                    turno = 2;
                }
                break;
            case 2:
                op = "X";
                lblNombre.setText(jugadorX);
                if ((arr[0].equals(op) && arr[1].equals(op) && arr[2].equals(op))
                        || (arr[3].equals(op) && arr[4].equals(op) && arr[5].equals(op))
                        || (arr[6].equals(op) && arr[7].equals(op) && arr[8].equals(op))
                        || (arr[0].equals(op) && arr[3].equals(op) && arr[6].equals(op))
                        || (arr[1].equals(op) && arr[4].equals(op) && arr[7].equals(op))
                        || (arr[2].equals(op) && arr[5].equals(op) && arr[8].equals(op))
                        || (arr[0].equals(op) && arr[4].equals(op) && arr[8].equals(op))
                        || (arr[2].equals(op) && arr[4].equals(op) && arr[6].equals(op))){
                    Toast.makeText(this, "Gana "+lblNombre.getText().toString()+" (X)", Toast.LENGTH_SHORT).show();

                    lblNombre.setText(jugadorX);
                    lblTitulo.setText("Ganador: ");
                    cambioColor(2,arr);

                    btnO.setVisibility(View.INVISIBLE);
                    btnX.setVisibility(View.INVISIBLE);
                    btnReinicio.setVisibility(View.VISIBLE);
                    histEdit.putInt("PuntajeX", puntX + 1); // Probar
                    histEdit.commit();
                    // Evita que los EditText se ponga antes de poner el boton
                    txtCuadro1.setEnabled(false);
                    txtCuadro2.setEnabled(false);
                    txtCuadro3.setEnabled(false);
                    txtCuadro4.setEnabled(false);
                    txtCuadro5.setEnabled(false);
                    txtCuadro6.setEnabled(false);
                    txtCuadro7.setEnabled(false);
                    txtCuadro8.setEnabled(false);
                    txtCuadro9.setEnabled(false);

                    numCasillas = 0;
                } else {
                    numCasillas += 1;
                    lblNombre.setText(jugadorO);
                    Toast.makeText(this, "Sigue "+lblNombre.getText().toString()+" (O)", Toast.LENGTH_SHORT).show();
                    //btnO.setVisibility(View.VISIBLE);
                    //btnX.setVisibility(View.INVISIBLE);
                    turno = 1;
                }
                break;
            default:
                Toast.makeText(this,"Hay un error :'v", Toast.LENGTH_SHORT);
                break;
        }

        if (numCasillas == 9){
            Toast.makeText(MainActivity.this, "Empate :v", Toast.LENGTH_SHORT).show();
            btnReinicio.setVisibility(View.VISIBLE);
            lblTitulo.setText("Empate alv :v");
            lblNombre.setText("");
        }
    }
}
