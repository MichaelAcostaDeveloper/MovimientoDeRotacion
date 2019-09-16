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
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;
import michael.acosta.movimientoderotacion.Resultados.Resultados_inercia_rotacional;
public class InerciaRotacional extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4;
    double valor1, valor2, valor3, valor4, r, I, m;
    TextView tx1, tx2, tx3, tx4, text1, text2, text3, text4;
    ImageView imagen;
    int posicion, dato, id;
    String datos;
    TextInputLayout ti1, ti2, ti3, ti4;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inercia_rotacional);
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

        id = getIntent().getIntExtra("solidoRigido", 0);
        //variables casteadas y  con simbolos de la Fisica
        switch (id) {
            case 1:
                text1 = (TextView) findViewById(R.id.text1);
                text1.setText(Html.fromHtml("m:"));
                tx1 = (TextView) findViewById(R.id.tx1);
                ed1 = (EditText) findViewById(R.id.ed1);
                ti1 = (TextInputLayout) findViewById(R.id.ti1);
                ti1.setHint("masa");

                text2 = (TextView) findViewById(R.id.text2);
                text2.setText(Html.fromHtml("I:"));
                tx2 = (TextView) findViewById(R.id.tx2);
                ed2 = (EditText) findViewById(R.id.ed2);
                ti2 = (TextInputLayout) findViewById(R.id.ti2);
                ti2.setHint("inercia rotacional");

                text3 = (TextView) findViewById(R.id.text3);
                text3.setText(Html.fromHtml("R:"));
                tx3 = (TextView) findViewById(R.id.tx3);
                ed3 = (EditText) findViewById(R.id.ed3);
                ti3 = (TextInputLayout) findViewById(R.id.ti3);
                ti3.setHint("radio");

                fila4.removeAllViews();

                editextWidget(ti1);
                editextWidget(ti2);
                editextWidget(ti3);

                break;
            case 2:
                text1 = (TextView) findViewById(R.id.text1);
                text1.setText(Html.fromHtml("m:"));
                tx1 = (TextView) findViewById(R.id.tx1);
                ed1 = (EditText) findViewById(R.id.ed1);
                ti1 = (TextInputLayout) findViewById(R.id.ti1);
                ti1.setHint("masa");

                text2 = (TextView) findViewById(R.id.text2);
                text2.setText(Html.fromHtml("I:"));
                tx2 = (TextView) findViewById(R.id.tx2);
                ed2 = (EditText) findViewById(R.id.ed2);
                ti2 = (TextInputLayout) findViewById(R.id.ti2);
                ti2.setHint("inercia rotacional");

                text3 = (TextView) findViewById(R.id.text3);
                text3.setText(Html.fromHtml("R<sub>1</sub>:"));
                tx3 = (TextView) findViewById(R.id.tx3);
                ed3 = (EditText) findViewById(R.id.ed3);
                ti3 = (TextInputLayout) findViewById(R.id.ti3);
                ti3.setHint("radio mayor");

                text4 = (TextView) findViewById(R.id.text4);
                text4.setText(Html.fromHtml("R<sub>2</sub>:"));
                tx4 = (TextView) findViewById(R.id.tx4);
                ed4 = (EditText) findViewById(R.id.ed4);
                ti4 = (TextInputLayout) findViewById(R.id.ti4);
                ti4.setHint("radio menor");

                editextWidget(ti1);
                editextWidget(ti2);
                editextWidget(ti3);
                editextWidget(ti4);
                break;
            case 3:
                text1 = (TextView) findViewById(R.id.text1);
                text1.setText(Html.fromHtml("m:"));
                tx1 = (TextView) findViewById(R.id.tx1);
                ed1 = (EditText) findViewById(R.id.ed1);
                ti1 = (TextInputLayout) findViewById(R.id.ti1);
                ti1.setHint("masa");

                text2 = (TextView) findViewById(R.id.text2);
                text2.setText(Html.fromHtml("I:"));
                tx2 = (TextView) findViewById(R.id.tx2);
                ed2 = (EditText) findViewById(R.id.ed2);
                ti2 = (TextInputLayout) findViewById(R.id.ti2);
                ti2.setHint("inercia rotacional");

                text3 = (TextView) findViewById(R.id.text3);
                text3.setText(Html.fromHtml("a:"));
                tx3 = (TextView) findViewById(R.id.tx3);
                ed3 = (EditText) findViewById(R.id.ed3);
                ti3 = (TextInputLayout) findViewById(R.id.ti3);
                ti3.setHint("longitud");

                text4 = (TextView) findViewById(R.id.text4);
                text4.setText(Html.fromHtml("b:"));
                tx4 = (TextView) findViewById(R.id.tx4);
                ed4 = (EditText) findViewById(R.id.ed4);
                ti4 = (TextInputLayout) findViewById(R.id.ti4);
                ti4.setHint("ancho");

                editextWidget(ti1);
                editextWidget(ti2);
                editextWidget(ti3);
                editextWidget(ti4);
                break;
        }


        //recepcion de datos
        dato = getIntent().getIntExtra("p", 0);
        switch (dato) {
            case 1:
                ed2.setFocusable(false);

                fila2.setElevation(2);
                text2.setTextColor(getColor(R.color.colorSeleccion));
                tx2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila1.setElevation(100);
                fila3.setElevation(100);
                break;
            case 2:
                ed3.setFocusable(false);

                fila3.setElevation(2);
                text3.setTextColor(getColor(R.color.colorSeleccion));
                tx3.setTextColor(getColor(R.color.colorSeleccion));
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila1.setElevation(100);
                fila2.setElevation(100);
                break;
            case 3:
                ed1.setFocusable(false);

                fila1.setElevation(2);
                text1.setTextColor(getColor(R.color.colorSeleccion));
                tx1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila2.setElevation(100);
                fila3.setElevation(100);
                break;
            case 4:
                ed2.setFocusable(false);

                fila2.setElevation(2);
                text2.setTextColor(getColor(R.color.colorSeleccion));
                tx2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila4.setElevation(100);
                fila1.setElevation(100);
                fila3.setElevation(100);
                break;
            case 5:
                ed1.setFocusable(false);

                fila1.setElevation(2);
                text1.setTextColor(getColor(R.color.colorSeleccion));
                tx1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila4.setElevation(100);
                fila2.setElevation(100);
                fila3.setElevation(100);
                break;
            case 6:
                ed2.setFocusable(false);

                fila2.setElevation(2);
                text2.setTextColor(getColor(R.color.colorSeleccion));
                tx2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila4.setElevation(100);
                fila1.setElevation(100);
                fila3.setElevation(100);
                break;
            case 7:
                ed1.setFocusable(false);

                fila1.setElevation(2);
                text1.setTextColor(getColor(R.color.colorSeleccion));
                tx1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila4.setElevation(100);
                fila2.setElevation(100);
                fila3.setElevation(100);
                break;
        }
    }

    public void calcular(View view) {
        dato = getIntent().getIntExtra("p", 0);
        switch (dato) {
            case 1:
                if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed1.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor1 = conversor_Numero(ed1.getText().toString());
                    valor3 = conversor_Numero(ed3.getText().toString());
                    if ((valor1 <= 0 & valor3 <= 0) || (valor1 <= 0 || valor3 <= 0)) {
                        dialogo_signos(view).show();
                    } else {
                        Intent x = new Intent(this, Resultados_inercia_rotacional.class);
                        switch (datos) {
                            case "Cilindro Sólido":
                                I = inerciaCilindro(valor1, valor3);
                                x.putExtra("subcaso", 1);
                                break;
                            case "Esfera sólida":
                                I = inerciaEsfera(valor1, valor3);
                                x.putExtra("subcaso", 2);
                                break;
                            case "Esfera Hueca":
                                I = inerciaEsferaHueca(valor1, valor3);
                                x.putExtra("subcaso", 3);
                                break;
                            case "Varilla con eje extremo":
                                I = inerciaVarillaExtremo(valor1, valor3);
                                x.putExtra("subcaso", 4);
                                break;
                            case "Varilla con eje central":
                                I = inerciaVarillaCentral(valor1, valor3);
                                x.putExtra("subcaso", 5);
                                break;
                            case "Partículas":
                                I = inerciaParticula_Anillo(valor1, valor3);
                                x.putExtra("subcaso", 6);
                                break;
                            case "Anillo cilíndrico":
                                I = inerciaParticula_Anillo(valor1, valor3);
                                x.putExtra("subcaso", 7);
                                break;

                        }
                        x.putExtra("id", 1);
                        x.putExtra("I", I);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("m", valor1);
                        x.putExtra("r", valor3);

                        startActivity(x);

                    }
                }
                break;
            case 2:
                if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor1 = conversor_Numero(ed1.getText().toString());
                    valor2 = conversor_Numero(ed2.getText().toString());
                    if ((valor1 <= 0 & valor2 <= 0) || (valor1 <= 0 || valor2 <= 0)) {
                        dialogo_signos(view).show();
                    } else {
                        Intent x = new Intent(this, Resultados_inercia_rotacional.class);

                        switch (datos) {
                            case "Cilindro Sólido":
                                r = radioCilindro(valor2, valor1);
                                x.putExtra("subcaso", 1);
                                break;
                            case "Esfera sólida":
                                r = radioEsfera(valor2, valor1);
                                x.putExtra("subcaso", 2);
                                break;
                            case "Esfera Hueca":
                                r = radioEsferaHueca(valor2, valor1);
                                x.putExtra("subcaso", 3);
                                break;
                            case "Varilla con eje extremo":
                                r = radioVarillaExtremo(valor2, valor1);
                                x.putExtra("subcaso", 4);
                                break;
                            case "Varilla con eje central":
                                r = radioVarillaCentral(valor2, valor1);
                                x.putExtra("subcaso", 5);
                                break;
                            case "Partículas":
                                r = radioParticula_Anillo(valor2, valor1);
                                x.putExtra("subcaso", 6);
                                break;
                            case "Anillo cilíndrico":
                                r = radioParticula_Anillo(valor2, valor1);
                                x.putExtra("subcaso", 7);
                                break;
                        }

                        x.putExtra("id", 2);
                        x.putExtra("r", r);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("m", valor1);
                        x.putExtra("I", valor2);
                        startActivity(x);
                    }
                }
                break;
            case 3:
                if (ed3.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed2.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor2 = conversor_Numero(ed2.getText().toString());
                    if ((valor3 <= 0 & valor2 <= 0) || (valor3 <= 0 || valor2 <= 0)) {
                        dialogo_signos(view).show();
                    } else {
                        Intent x = new Intent(this, Resultados_inercia_rotacional.class);
                        switch (datos) {
                            case "Cilindro Sólido":
                                m = masaCilindro(valor2, valor3);
                                x.putExtra("subcaso", 1);
                                break;
                            case "Esfera sólida":
                                m = masaEsfera(valor2, valor3);
                                x.putExtra("subcaso", 2);
                                break;
                            case "Esfera Hueca":
                                m = masaEsferaHueca(valor2, valor3);
                                x.putExtra("subcaso", 6);
                                break;
                            case "Varilla con eje extremo":
                                m = masaVarillaExtremo(valor2, valor3);
                                x.putExtra("subcaso", 4);
                                break;
                            case "Varilla con eje central":
                                m = masaVarillaCentral(valor2, valor3);
                                x.putExtra("subcaso", 5);
                                break;
                            case "Partículas":
                                m = masaParticula_Anillo(valor2, valor3);
                                x.putExtra("subcaso", 6);
                                break;
                            case "Anillo cilíndrico":
                                m = masaParticula_Anillo(valor2, valor3);
                                x.putExtra("subcaso", 7);
                                break;
                        }


                        x.putExtra("id", 3);
                        x.putExtra("m", m);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("r", valor3);
                        x.putExtra("I", valor2);
                        startActivity(x);
                    }
                }
                break;
            case 4:
                if (ed1.getText().toString().isEmpty() || ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed1.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed1.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor1 = conversor_Numero(ed1.getText().toString());
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor4 = conversor_Numero(ed4.getText().toString());
                    if (valor1 <= 0 || valor3 <= 0 || valor4 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor1 <= 0 || valor3 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor1 <= 0 || valor4 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor4 <= 0 || valor3 <= 0) {
                        dialogo_signos(view).show();
                    }else if(valor3==valor4){
                        dialogo_inconsistencia(view).show();
                    }else if(valor3<=valor4){
                        dialogo_radios(view).show();
                    }
                    else {
                        Intent x = new Intent(this, Resultados_inercia_rotacional.class);
                        I = inerciaCilindroHueco(valor1, valor3, valor4);
                        x.putExtra("id", 4);
                        x.putExtra("I", I);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("m", valor1);
                        x.putExtra("r1", valor3);
                        x.putExtra("r2", valor4);
                        startActivity(x);
                    }
                }
                break;
            case 5:
                if (ed2.getText().toString().isEmpty() || ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed2.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed2.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor2 = conversor_Numero(ed2.getText().toString());
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor4 = conversor_Numero(ed4.getText().toString());
                    if (valor2 <= 0 || valor3 <= 0 || valor4 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor2 <= 0 || valor3 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor2 <= 0 || valor4 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor4 <= 0 || valor3 <= 0) {
                        dialogo_signos(view).show();
                    } else if(valor3==valor4){
                        dialogo_inconsistencia(view).show();
                    }else if(valor3<=valor4){
                        dialogo_radios(view).show();
                    }
                    else {
                        Intent x = new Intent(this, Resultados_inercia_rotacional.class);
                        m = masaCilindroHueco(valor2, valor3, valor4);
                        x.putExtra("id", 5);
                        x.putExtra("m", m);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("I", valor4);
                        x.putExtra("r1", valor3);
                        x.putExtra("r2", valor4);
                        startActivity(x);
                    }
                }
                break;
            case 6:
                if (ed1.getText().toString().isEmpty() || ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed1.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed1.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor1 = conversor_Numero(ed1.getText().toString());
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor4 = conversor_Numero(ed4.getText().toString());
                    if (valor1 <= 0 || valor3 <= 0 || valor4 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor1 <= 0 || valor3 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor1 <= 0 || valor4 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor4 <= 0 || valor3 <= 0) {
                        dialogo_signos(view).show();
                    } else {
                        Intent x = new Intent(this, Resultados_inercia_rotacional.class);
                        I = inerciaPlaca(valor1, valor3, valor4);
                        x.putExtra("id", 6);
                        x.putExtra("I", I);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("m", valor1);
                        x.putExtra("a", valor3);
                        x.putExtra("b", valor4);
                        startActivity(x);
                    }
                }
                break;
            case 7:
                if (ed2.getText().toString().isEmpty() || ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed2.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed2.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor2 = conversor_Numero(ed2.getText().toString());
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor4 = conversor_Numero(ed4.getText().toString());
                    if (valor2 <= 0 || valor3 <= 0 || valor4 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor2 <= 0 || valor3 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor2 <= 0 || valor4 <= 0) {
                        dialogo_signos(view).show();
                    } else if (valor4 <= 0 || valor3 <= 0) {
                        dialogo_signos(view).show();
                    } else {
                        Intent x = new Intent(this, Resultados_inercia_rotacional.class);
                        m = masaPlaca(valor2, valor3, valor4);
                        x.putExtra("id", 7);
                        x.putExtra("m", m);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("I", valor4);
                        x.putExtra("a", valor3);
                        x.putExtra("b", valor4);
                        startActivity(x);
                    }
                }
                break;
        }
    }

    //metodos de funcionamiento
    public Double conversor_Numero(String e) {
        return Double.parseDouble(e);
    }
    public double inerciaParticula_Anillo(double a, double b) {
        return (a * Math.pow(b, 2));
    }
    public double radioParticula_Anillo(double a, double b) {
        return (Math.pow((a / b), 0.5));
    }
    public double masaParticula_Anillo(double a, double b) {
        return (a / Math.pow(b, 2));
    }
    public double inerciaCilindroHueco(double a, double b, double c) {
        return (0.5 * a * ((Math.pow(b, 2)) + (Math.pow(c, 2))));
    }
    public double masaCilindroHueco(double a, double b, double c) {
        return ((2 * a) / ((Math.pow(b, 2)) + (Math.pow(c, 2))));
    }
    public double inerciaPlaca(double a, double b, double c) {
        return ((0.083) * a * ((Math.pow(b, 2)) + (Math.pow(c, 2))));
    }
    public double masaPlaca(double a, double b, double c) {
        return ((12 * a) / ((Math.pow(b, 2)) + (Math.pow(c, 2))));
    }
    public double inerciaCilindro(double a, double b) {
        return ((0.5) * a * Math.pow(b, 2));
    }
    public double radioCilindro(double a, double b) {
        return (Math.pow(((2 * a) / b), 0.5));
    }
    public double masaCilindro(double a, double b) {
        return ((2 * a) / Math.pow(b, 2));
    }
    public double inerciaEsfera(double a, double b) {
        return ((0.4) * a * Math.pow(b, 2));
    }
    public double radioEsfera(double a, double b) {
        return (Math.pow(((5 * a) / (2 * b)), 0.5));
    }
    public double masaEsfera(double a, double b) {
        return ((5 * a) / 2 * (Math.pow(b, 2)));
    }
    public double inerciaEsferaHueca(double a, double b) {
        return ((0.67) * a * Math.pow(b, 2));
    }
    public double radioEsferaHueca(double a, double b) {
        return (Math.pow(((3 * a) / (2 * b)), 0.5));
    }
    public double masaEsferaHueca(double a, double b) {
        return ((3 * a) / 2 * (Math.pow(b, 2)));
    }
    public double inerciaVarillaCentral(double a, double b) {
        return ((0.083) * a * Math.pow(b, 2));
    }
    public double radioVarillaCentral(double a, double b) {
        return (Math.pow(((12 * a) / (1 * b)), 0.5));
    }
    public double masaVarillaCentral(double a, double b) {
        return ((12 * a) / 1 * (Math.pow(b, 2)));
    }
    public double inerciaVarillaExtremo(double a, double b) {
        return ((0.33) * a * Math.pow(b, 2));
    }
    public double radioVarillaExtremo(double a, double b) {
        return (Math.pow(((3 * a) / (1 * b)), 0.5));
    }
    public double masaVarillaExtremo(double a, double b) {
        return ((3 * a) / 1 * (Math.pow(b, 2)));
    }

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
    public Dialog dialogo_signos(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("Los valores de masa, inercia y parámetros geométricos son positivos.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_inconsistencia(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("Los valores de los radios del cilindro son diferentes, un valor mayor y otro menor");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_radios(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("Verifique los valores de los radios en los casilleros señalados.");
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
