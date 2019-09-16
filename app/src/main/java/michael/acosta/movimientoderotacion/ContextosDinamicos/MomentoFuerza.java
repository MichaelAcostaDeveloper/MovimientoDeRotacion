package michael.acosta.movimientoderotacion.ContextosDinamicos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;
import michael.acosta.movimientoderotacion.Resultados.Resultados_momento_fuerza;

public class MomentoFuerza extends AppCompatActivity {
    TextView T1, T2, T3, T4, T5, t1, t2, t3, t4, t5;
    EditText ed1, ed2, ed3, ed4, ed5;
    double valor1, valor2, valor3, valor4, valor5, I, F, T, r, a, m;
    ImageView imagen;
    int posicion, dato;
    String datos;
    TextInputLayout ti1, ti2, ti3, ti4, ti5;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_momento_fuerza);
        Intent recibir = getIntent();
        datos = recibir.getStringExtra("id");
        Toolbar tt = (Toolbar) findViewById(R.id.toolbar1);
        tt.setTitle(datos);
        tt.setSubtitle("Datos del problema");
        setSupportActionBar(tt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tt.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        imagen = (ImageView) findViewById(R.id.imageView);
        posicion = getIntent().getIntExtra("im", 0);
        switch (posicion) {
            case 1:
                imagen.setImageResource(R.drawable.anillocilindricoinercia);
                imagen.setElevation(200);
                break;
            case 2:
                imagen.setImageResource(R.drawable.cilindrosolidoinercia);
                imagen.setElevation(200);
                break;
            case 3:
                imagen.setImageResource(R.drawable.cilindroanular);
                imagen.setElevation(200);
                break;
            case 4:
                imagen.setImageResource(R.drawable.esferainercia);
                imagen.setElevation(200);
                break;
            case 5:
                imagen.setImageResource(R.drawable.cascoesferico);
                imagen.setElevation(200);
                break;
            case 6:
                imagen.setImageResource(R.drawable.placa);
                imagen.setElevation(200);
                break;
            case 7:
                imagen.setImageResource(R.drawable.varillacentroinercia);
                imagen.setElevation(200);
                break;
            case 8:
                imagen.setImageResource(R.drawable.varillaejeextremoinercia);
                imagen.setElevation(200);
                break;
            case 9:
                imagen.setImageResource(R.drawable.particula);
                imagen.setElevation(200);
                break;
        }

        //casteo de filas
        final TableRow fila1 = (TableRow) findViewById(R.id.fila1);
        final TableRow fila2 = (TableRow) findViewById(R.id.fila2);
        final TableRow fila3 = (TableRow) findViewById(R.id.fila3);
        final TableRow fila4 = (TableRow) findViewById(R.id.fila4);
        final TableRow fila5 = (TableRow) findViewById(R.id.fila5);

        //variables casteadas y  con simbolos de la Fisica
        ed1 = (EditText) findViewById(R.id.ed1);
        ti1 = (TextInputLayout) findViewById(R.id.ti1);
        T1 = (TextView) findViewById(R.id.T1);
        t1 = (TextView) findViewById(R.id.t1);

        ed2 = (EditText) findViewById(R.id.ed2);
        ti2 = (TextInputLayout) findViewById(R.id.ti2);
        T2 = (TextView) findViewById(R.id.T2);
        t2 = (TextView) findViewById(R.id.t2);

        ed3 = (EditText) findViewById(R.id.ed3);
        ti3 = (TextInputLayout) findViewById(R.id.ti3);
        T3 = (TextView) findViewById(R.id.T3);
        t3 = (TextView) findViewById(R.id.t3);

        ed4 = (EditText) findViewById(R.id.ed4);
        ti4 = (TextInputLayout) findViewById(R.id.ti4);
        T4 = (TextView) findViewById(R.id.T4);
        t4 = (TextView) findViewById(R.id.t4);

        ed5 = (EditText) findViewById(R.id.ed5);
        ti5 = (TextInputLayout) findViewById(R.id.ti5);
        T5 = (TextView) findViewById(R.id.T5);
        t5 = (TextView) findViewById(R.id.t5);

        editextWidget(ti1);
        editextWidget(ti2);
        editextWidget(ti3);
        editextWidget(ti4);
        editextWidget(ti5);

        //recepcion de datos
        dato = getIntent().getIntExtra("p", 0);
        switch (dato) {
            case 1:
                ed3.setFocusable(false);
                ed5.setFocusable(false);

                fila3.setElevation(2);
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                T3.setTextColor(getColor(R.color.colorSeleccion));
                t3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila5.setElevation(2);
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                T5.setTextColor(getColor(R.color.colorSeleccion));
                t5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);

                fila1.setElevation(100);
                fila2.setElevation(100);
                fila4.setElevation(100);
                break;

            case 2:
                ed3.setFocusable(false);
                ed4.setFocusable(false);

                fila3.setElevation(2);
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                T3.setTextColor(getColor(R.color.colorSeleccion));
                t3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila4.setElevation(2);
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                T4.setTextColor(getColor(R.color.colorSeleccion));
                t4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila1.setElevation(100);
                fila2.setElevation(100);
                fila5.setElevation(100);
                break;
            case 3:
                ed2.setFocusable(false);
                ed5.setFocusable(false);

                fila2.setElevation(2);
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                T2.setTextColor(getColor(R.color.colorSeleccion));
                t2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila5.setElevation(2);
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                T5.setTextColor(getColor(R.color.colorSeleccion));
                t5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);

                fila1.setElevation(100);
                fila3.setElevation(100);
                fila4.setElevation(100);
                break;
            case 4:
                ed2.setFocusable(false);
                ed4.setFocusable(false);

                fila2.setElevation(2);
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                T2.setTextColor(getColor(R.color.colorSeleccion));
                t2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila4.setElevation(2);
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                T4.setTextColor(getColor(R.color.colorSeleccion));
                t4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila1.setElevation(100);
                fila3.setElevation(100);
                fila5.setElevation(100);
                break;

            case 5:
                ed1.setFocusable(false);
                ed5.setFocusable(false);

                fila1.setElevation(2);
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                T1.setTextColor(getColor(R.color.colorSeleccion));
                t1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila5.setElevation(2);
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                T5.setTextColor(getColor(R.color.colorSeleccion));
                t5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);

                fila2.setElevation(100);
                fila3.setElevation(100);
                fila4.setElevation(100);
                break;

            case 6:
                ed1.setFocusable(false);
                ed4.setFocusable(false);

                fila1.setElevation(2);
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                T1.setTextColor(getColor(R.color.colorSeleccion));
                t1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila4.setElevation(2);
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                T4.setTextColor(getColor(R.color.colorSeleccion));
                t4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila5.setElevation(100);
                fila3.setElevation(100);
                fila2.setElevation(100);
                break;

            case 7:
                ed1.setFocusable(false);
                ed3.setFocusable(false);

                fila1.setElevation(2);
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                T1.setTextColor(getColor(R.color.colorSeleccion));
                t1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila3.setElevation(2);
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                T3.setTextColor(getColor(R.color.colorSeleccion));
                t3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila2.setElevation(100);
                fila5.setElevation(100);
                fila4.setElevation(100);
                break;

            case 8:
                ed2.setFocusable(false);
                ed1.setFocusable(false);

                fila2.setElevation(2);
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                T2.setTextColor(getColor(R.color.colorSeleccion));
                t2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila1.setElevation(2);
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                T1.setTextColor(getColor(R.color.colorSeleccion));
                t1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila5.setElevation(100);
                fila3.setElevation(100);
                fila4.setElevation(100);
                break;

            case 9:
                ed3.setFocusable(false);
                ed4.setFocusable(false);
                ed5.setFocusable(false);

                fila3.setElevation(2);
                T3.setTextColor(getColor(R.color.colorSeleccion));
                t3.setTextColor(getColor(R.color.colorSeleccion));
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila4.setElevation(2);
                T4.setTextColor(getColor(R.color.colorSeleccion));
                t4.setTextColor(getColor(R.color.colorSeleccion));
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila5.setElevation(2);
                T5.setTextColor(getColor(R.color.colorSeleccion));
                t5.setTextColor(getColor(R.color.colorSeleccion));
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);

                fila1.setElevation(100);
                fila2.setElevation(100);
                break;

            case 10:
                ed2.setFocusable(false);
                ed4.setFocusable(false);
                ed5.setFocusable(false);

                fila2.setElevation(2);
                T2.setTextColor(getColor(R.color.colorSeleccion));
                t2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila4.setElevation(2);
                T4.setTextColor(getColor(R.color.colorSeleccion));
                t4.setTextColor(getColor(R.color.colorSeleccion));
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila5.setElevation(2);
                T5.setTextColor(getColor(R.color.colorSeleccion));
                t5.setTextColor(getColor(R.color.colorSeleccion));
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);

                fila1.setElevation(100);
                fila3.setElevation(100);
                break;
            case 11:
                ed3.setFocusable(false);
                ed2.setFocusable(false);
                ed5.setFocusable(false);

                fila3.setElevation(2);
                T3.setTextColor(getColor(R.color.colorSeleccion));
                t3.setTextColor(getColor(R.color.colorSeleccion));
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila2.setElevation(2);
                T2.setTextColor(getColor(R.color.colorSeleccion));
                t2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila5.setElevation(2);
                T5.setTextColor(getColor(R.color.colorSeleccion));
                t5.setTextColor(getColor(R.color.colorSeleccion));
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);

                fila1.setElevation(100);
                fila4.setElevation(100);
                break;

            case 12:
                ed3.setFocusable(false);
                ed2.setFocusable(false);
                ed4.setFocusable(false);

                fila3.setElevation(2);
                T3.setTextColor(getColor(R.color.colorSeleccion));
                t3.setTextColor(getColor(R.color.colorSeleccion));
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila2.setElevation(2);
                T2.setTextColor(getColor(R.color.colorSeleccion));
                t2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila4.setElevation(2);
                T4.setTextColor(getColor(R.color.colorSeleccion));
                t4.setTextColor(getColor(R.color.colorSeleccion));
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila1.setElevation(100);
                fila5.setElevation(100);
                break;

            case 13:
                ed1.setFocusable(false);
                ed4.setFocusable(false);
                ed5.setFocusable(false);

                fila1.setElevation(2);
                T1.setTextColor(getColor(R.color.colorSeleccion));
                t1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila4.setElevation(2);
                T4.setTextColor(getColor(R.color.colorSeleccion));
                t4.setTextColor(getColor(R.color.colorSeleccion));
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila5.setElevation(2);
                T5.setTextColor(getColor(R.color.colorSeleccion));
                t5.setTextColor(getColor(R.color.colorSeleccion));
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);

                fila2.setElevation(100);
                fila3.setElevation(100);
                break;

            case 14:
                ed3.setFocusable(false);
                ed2.setFocusable(false);
                ed1.setFocusable(false);

                fila3.setElevation(2);
                T3.setTextColor(getColor(R.color.colorSeleccion));
                t3.setTextColor(getColor(R.color.colorSeleccion));
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila2.setElevation(2);
                T2.setTextColor(getColor(R.color.colorSeleccion));
                t2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila1.setElevation(2);
                T1.setTextColor(getColor(R.color.colorSeleccion));
                t1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila5.setElevation(100);
                fila4.setElevation(100);
                break;
        }
    }

    public void calcular(View view) {
        dato = getIntent().getIntExtra("p", 0);
        switch (dato) {
            case 1:
                if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                }  else if (ed4.getText().toString().isEmpty()) {
                    caso9(view);
                } else if (ed1.getText().toString().isEmpty()) {
                    dialogo_calculo(view).show();
                } else if (ed2.getText().toString().isEmpty()) {
                   caso11(view);
                } else {
                    valor1 = conversor_Numero(ed1.getText().toString());
                    valor2 = conversor_Numero(ed2.getText().toString());
                    valor4 = conversor_Numero(ed4.getText().toString());
                    if (valor4 <= 0) {
                        dialogo_alerta_radio_inercia(view).show();
                    } else if(valor1==0||valor2==0){
                        dialogo_alerta_valorCero(view).show();
                    } else if(valor1==0&valor2==0){
                        dialogo_calculo(view).show();
                    }
                    else if ((valor1 < 0 & valor2 > 0) || (valor1 > 0 & valor2 < 0)) {
                        dialogo_signos(view).show();
                    }
                    else {
                        Intent x = new Intent(this, Resultados_momento_fuerza.class);
                        r = radio(valor1, valor2);
                        m = masa(valor4, r);
                        a = aceleracion(valor1, valor4);
                        x.putExtra("id", 1);
                        x.putExtra("r", r);
                        x.putExtra("m", m);
                        x.putExtra("a", a);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("T", valor1);
                        x.putExtra("F", valor2);
                        x.putExtra("I", valor4);
                        startActivity(x);
                    }
                }
                break;
            case 2:
                if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                }  else if (ed1.getText().toString().isEmpty()) {
                    dialogo_calculo(view).show();
                } else if (ed2.getText().toString().isEmpty()) {
                    caso12(view);
                } else if (ed5.getText().toString().isEmpty()) {
                    caso9(view);
                } else {
                    valor1 = conversor_Numero(ed1.getText().toString());
                    valor2 = conversor_Numero(ed2.getText().toString());
                    valor5 = conversor_Numero(ed5.getText().toString());
                     if(valor1==0||valor2==0||valor5==0){
                        dialogo_alerta_valorCero(view).show();
                    }else if(valor1==0&valor2==0&valor3==0){
                        dialogo_alerta_valorCero(view).show();
                    }

                   else if ((valor1 < 0 & valor2 < 0 & valor5 > 0) || (valor1 < 0 & valor2 > 0 & valor5 < 0) ||
                            (valor1 < 0 & valor2 > 0 & valor5 > 0) || (valor1 > 0 & valor2 < 0 & valor5 < 0) ||
                            (valor1 > 0 & valor2 < 0 & valor5 > 0) || (valor1 > 0 & valor2 > 0 & valor5 < 0)) {
                        dialogo_signos(view).show();
                    }

                    else {
                        Intent x = new Intent(this, Resultados_momento_fuerza.class);
                        r = radio(valor1, valor2);
                        I = inercia(valor1, valor5);
                        m = masa(I, r);
                        x.putExtra("id", 2);
                        x.putExtra("I", I);
                        x.putExtra("m", m);
                        x.putExtra("r", r);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("T", valor1);
                        x.putExtra("F", valor2);
                        x.putExtra("a", valor5);
                        startActivity(x);
                    }
                }
                break;
            case 3:
                if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                }  else if (ed1.getText().toString().isEmpty()) {
                    dialogo_calculo(view).show();
                } else if (ed3.getText().toString().isEmpty()) {
                    caso11(view);
                } else if (ed4.getText().toString().isEmpty()) {
                    caso10(view);
                } else {
                    valor1 = conversor_Numero(ed1.getText().toString());
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor4 = conversor_Numero(ed4.getText().toString());
                    if ((valor4 <= 0)||(valor3<=0)) {
                        dialogo_alerta_radio_inercia(view).show();
                    }  else {
                        Intent x = new Intent(this, Resultados_momento_fuerza.class);
                        a = aceleracion(valor1, valor4);
                        F = fuerza(valor1, valor3);
                        m = masa(valor4, valor3);
                        x.putExtra("id", 3);
                        x.putExtra("a", a);
                        x.putExtra("m", m);
                        x.putExtra("F", F);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("T", valor1);
                        x.putExtra("r", valor3);
                        x.putExtra("I", valor4);
                        startActivity(x);
                    }
                }
                break;
            case 4:
                if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                }  else if (ed1.getText().toString().isEmpty()) {
                   dialogo_calculo(view).show();
                } else if (ed3.getText().toString().isEmpty()) {
                    caso12(view);
                } else if (ed5.getText().toString().isEmpty()) {
                    caso10(view);
                } else {
                    valor1 = conversor_Numero(ed1.getText().toString());
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor5 = conversor_Numero(ed5.getText().toString());

                    if ((valor1 > 0 & valor5 < 0) || (valor1 < 0 & valor5 > 0)) {
                        dialogo_signos(view).show();
                    }else if(valor1==0||valor5==0){
                        dialogo_alerta_valorCero(view).show();
                    }else if(valor1==0&valor5==0){
                        dialogo_alerta_valorCero(view).show();
                    }
                    else if (valor3 <= 0) {
                        dialogo_alerta_radio_inercia(view).show();
                    }
                    else {
                        Intent x = new Intent(this, Resultados_momento_fuerza.class);
                        I = inercia(valor1, valor5);
                        F = fuerza(valor1, valor3);
                        m = masa(I, valor3);
                        x.putExtra("id", 4);
                        x.putExtra("I", I);
                        x.putExtra("m", m);
                        x.putExtra("F", F);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("T", valor1);
                        x.putExtra("r", valor3);
                        x.putExtra("a", valor5);
                        startActivity(x);
                    }
                }

                break;
            case 5:
                if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                }  else if (ed2.getText().toString().isEmpty()) {
                    dialogo_calculo(view).show();
                } else if (ed3.getText().toString().isEmpty()) {
                    dialogo_calculo(view).show();
                } else if (ed4.getText().toString().isEmpty()) {
                    caso13(view);
                } else {
                    valor2 = conversor_Numero(ed2.getText().toString());
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor4 = conversor_Numero(ed4.getText().toString());

                    if ((valor4 <= 0)||(valor3<=0)) {
                        dialogo_alerta_radio_inercia(view).show();
                    }  else {
                        Intent x = new Intent(this, Resultados_momento_fuerza.class);
                        m = masa(valor4, valor3);
                        T = torque(valor2, valor3);
                        a = aceleracion(T, valor4);
                        x.putExtra("id", 5);
                        x.putExtra("T", T);
                        x.putExtra("m", m);
                        x.putExtra("a", a);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("F", valor2);
                        x.putExtra("r", valor3);
                        x.putExtra("I", valor4);
                        startActivity(x);
                    }
                }

                break;
            case 6:
                if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                }  else if (ed2.getText().toString().isEmpty()) {
                    dialogo_calculo(view).show();
                } else if (ed3.getText().toString().isEmpty()) {
                    dialogo_calculo(view).show();
                } else if (ed5.getText().toString().isEmpty()) {
                    caso13(view);
                } else {
                    valor2 = conversor_Numero(ed2.getText().toString());
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor5 = conversor_Numero(ed5.getText().toString());

                    if ((valor2 > 0 & valor5 < 0) || (valor2 < 0 & valor5 > 0)) {
                        dialogo_signos(view).show();
                    } else if (valor3 <= 0) {
                        dialogo_alerta_radio_inercia(view).show();
                    }else if(valor5==0){
                        dialogo_alerta_valorCero(view).show();
                    }
                    else {
                        Intent x = new Intent(this, Resultados_momento_fuerza.class);
                        T = torque(valor2, valor3);
                        I = fuerza(T, valor5);
                        m = masa(I, valor3);
                        x.putExtra("id", 6);
                        x.putExtra("I", I);
                        x.putExtra("m", m);
                        x.putExtra("T", T);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("F", valor2);
                        x.putExtra("r", valor3);
                        x.putExtra("a", valor5);
                        startActivity(x);
                    }
                }

                break;
            case 7:
                if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                }  else if (ed2.getText().toString().isEmpty()) {
                    caso14(view);
                } else if (ed4.getText().toString().isEmpty()) {
                    dialogo_calculo(view).show();
                } else if (ed5.getText().toString().isEmpty()) {
                    dialogo_calculo(view).show();
                } else {
                    valor2 = conversor_Numero(ed2.getText().toString());
                    valor4 = conversor_Numero(ed4.getText().toString());
                    valor5 = conversor_Numero(ed5.getText().toString());

                    if ((valor2 > 0 & valor5 < 0) || (valor2 < 0 & valor5 > 0)) {
                        dialogo_signos(view).show();
                    } else if(valor2==0){
                        dialogo_alerta_valorCero(view).show();
                    }
                    else if (valor4 <= 0) {
                        dialogo_alerta_radio_inercia(view).show();
                    }
                    else {
                        Intent x = new Intent(this, Resultados_momento_fuerza.class);
                        T = torque(valor4, valor5);
                        r = radio(T, valor2);
                        m = masa(valor4, r);
                        x.putExtra("id", 7);
                        x.putExtra("r", r);
                        x.putExtra("m", m);
                        x.putExtra("T", T);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("F", valor2);
                        x.putExtra("I", valor4);
                        x.putExtra("a", valor5);
                        startActivity(x);
                    }
                }


                break;
            case 8:
                if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                }  else if (ed3.getText().toString().isEmpty()) {
                    caso14(view);
                } else if (ed4.getText().toString().isEmpty()) {
                    dialogo_calculo(view).show();
                } else if (ed5.getText().toString().isEmpty()) {
                    dialogo_calculo(view).show();
                } else {
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor4 = conversor_Numero(ed4.getText().toString());
                    valor5 = conversor_Numero(ed5.getText().toString());

                    if ((valor3 <= 0)||(valor4 <= 0)) {
                        dialogo_alerta_radio_inercia(view).show();
                    }  else {
                        Intent x = new Intent(this, Resultados_momento_fuerza.class);
                        m = masa(valor4, valor3);
                        T = torque(valor4, valor5);
                        F = fuerza(T, valor3);
                        x.putExtra("id", 8);
                        x.putExtra("F", F);
                        x.putExtra("m", m);
                        x.putExtra("T", T);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("r", valor3);
                        x.putExtra("I", valor4);
                        x.putExtra("a", valor5);
                        startActivity(x);
                    }
                }
                break;
            case 9:
                caso9(view);
                break;
            case 10:
                caso10(view);
                break;
            case 11:
                caso11(view);
                break;
            case 12:
                caso12(view);
                break;
            case 13:
                caso13(view);
                break;
            case 14:
                caso14(view);
                break;
        }
    }
    //metodos de los casos especiales
    public void caso9(View view) {
        if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor2 = conversor_Numero(ed2.getText().toString());
            if ((valor1 < 0&valor2>0)||(valor1 > 0&valor2<0)) {
                dialogo_signos(view).show();
            }
            else if(valor2==0){
                dialogo_alerta_valorCero(view).show();
            }
            else {
                Intent y = new Intent(this,Resultados_momento_fuerza.class);
                r = radio(valor1, valor2);
                y.putExtra("id", 9);
                y.putExtra("r", r);
                y.putExtra("title", datos);
                y.putExtra("T", valor1);
                y.putExtra("F", valor2);
                startActivity(y);
            }
        }
    }

    public void caso10(View view) {
        if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor3 = conversor_Numero(ed3.getText().toString());
            if (valor3 <=0) {
                dialogo_alerta_radio_inercia(view).show();
            } else {
                Intent y = new Intent(this, Resultados_momento_fuerza.class);
                F = fuerza(valor1, valor3);
                y.putExtra("id", 10);
                y.putExtra("F", F);
                y.putExtra("title", datos);
                y.putExtra("T", valor1);
                y.putExtra("r", valor3);
                startActivity(y);
            }
        }
    }

    public void caso11(View view) {
        if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            if (valor4 <=0) {
                dialogo_alerta_radio_inercia(view).show();
            } else {
                Intent y = new Intent(this, Resultados_momento_fuerza.class);
                a = aceleracion(valor1, valor4);
                y.putExtra("id", 11);
                y.putExtra("a", a);
                y.putExtra("title", datos);
                y.putExtra("T", valor1);
                y.putExtra("I", valor4);
                startActivity(y);
            }
        }
    }

    public void caso12(View view) {
        if (ed1.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() || ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor5 = conversor_Numero(ed5.getText().toString());
            if ((valor1 < 0&valor5>0)||(valor1 > 0&valor5<0)) {
                dialogo_signos(view).show();
            }else if(valor5==0){
                dialogo_alerta_valorCero(view).show();
            }
            else {
                Intent y = new Intent(this, Resultados_momento_fuerza.class);
                I = inercia(valor1, valor5);
                y.putExtra("id", 12);
                y.putExtra("I", I);
                y.putExtra("title", datos);
                y.putExtra("T", valor1);
                y.putExtra("a", valor5);
                startActivity(y);
            }
        }
    }

    public void caso13(View view) {
        if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor2 = conversor_Numero(ed2.getText().toString());
            valor3 = conversor_Numero(ed3.getText().toString());
            if (valor3 <=0) {
                dialogo_alerta_radio_inercia(view).show();
            } else {
                Intent y = new Intent(this, Resultados_momento_fuerza.class);
                T = torque(valor2, valor3);
                y.putExtra("id", 13);
                y.putExtra("T", T);
                y.putExtra("title", datos);
                y.putExtra("F", valor2);
                y.putExtra("r", valor3);
                startActivity(y);
            }
        }
    }

    public void caso14(View view) {
        if (ed5.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed5.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor5 = conversor_Numero(ed5.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            if (valor4 <=0) {
                dialogo_alerta_radio_inercia(view).show();
            } else {
                Intent y = new Intent(this, Resultados_momento_fuerza.class);
                T = torque(valor4, valor5);
                y.putExtra("id", 14);
                y.putExtra("T", T);
                y.putExtra("title", datos);
                y.putExtra("a", valor5);
                y.putExtra("I", valor4);
                startActivity(y);
            }
        }
    }

    //metodos de funcionamiento
    public Double conversor_Numero(String e) {
        return Double.parseDouble(e);
    }
    public double aceleracion(double a, double b) {
        return (a / b);
    }
    public double radio(double a, double b) {
        return (a / b);
    }
    public double masa(double a, double b) {
        return (a / Math.pow(b, 2));
    }
    public double inercia(double a, double b) {
        return (a / b);
    }
    public double torque(double a, double b) {
        return (a * b);
    }
    public double fuerza(double a, double b) {
        return (a / b);
    }
    //dialogos
    public Dialog dialogo_alerta_magnitudes(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("Debe ingresar los valores de las magnitudes físicas para proceder a los cálculos.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_radio_inercia(View view)   {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("El valor del radio de giro y la inercia siempre son positivos.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_valorCero(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("La fuerza tangencial y el torque no deben ser cero.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_signos(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("Los valores de la Fuerza tangencial, el torque y la aceleracion angular tienen la misma direccion.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_calculo(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("Los valores ingresados no resuelven ningun problema.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

    public void editextWidget(final TextInputLayout e) {
        if (e.getEditText() != null) {
            e.getEditText().addTextChangedListener(new TextWatcher() {//NUEVO METODO
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
        }
    }
}
