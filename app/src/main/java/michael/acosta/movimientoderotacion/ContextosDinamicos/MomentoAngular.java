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
import michael.acosta.movimientoderotacion.Resultados.Resultados_momento_angular;
public class MomentoAngular extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4, ed5;
    double valor1, valor2, valor3, valor4, valor5, dw, dL, I, Lo, Lf, wo, wf;
    TextView tx1, tx2, tx3, tx4, tx5, text1, text2, text3, text4, text5;
    ImageView imagen;
    int posicion, dato;
    String datos;
    TextInputLayout ti1, ti2, ti3, ti4, ti5;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_momento_angular);
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
        text1 = (TextView) findViewById(R.id.text1);
        text1.setText(Html.fromHtml("ω<sub>o</sub>:"));
        tx1 = (TextView) findViewById(R.id.tx1);
        ed1 = (EditText) findViewById(R.id.ed1);
        ti1 = (TextInputLayout) findViewById(R.id.ti1);

        text2 = (TextView) findViewById(R.id.text2);
        text2.setText(Html.fromHtml("ω<sub>f</sub>:"));
        tx2 = (TextView) findViewById(R.id.tx2);
        ed2 = (EditText) findViewById(R.id.ed2);
        ti2 = (TextInputLayout) findViewById(R.id.ti2);

        text3 = (TextView) findViewById(R.id.text3);
        text3.setText(Html.fromHtml("L<sub>o</sub>:"));
        tx3 = (TextView) findViewById(R.id.tx3);
        ed3 = (EditText) findViewById(R.id.ed3);
        ti3 = (TextInputLayout) findViewById(R.id.ti3);

        text4 = (TextView) findViewById(R.id.text4);
        text4.setText(Html.fromHtml("L<sub>f</sub>:"));
        tx4 = (TextView) findViewById(R.id.tx4);
        ed4 = (EditText) findViewById(R.id.ed4);
        ti4 = (TextInputLayout) findViewById(R.id.ti4);

        text5 = (TextView) findViewById(R.id.text5);
        tx5 = (TextView) findViewById(R.id.tx5);
        ed5 = (EditText) findViewById(R.id.ed5);
        ti5 = (TextInputLayout) findViewById(R.id.ti5);

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
                ed4.setFocusable(false);
                ed5.setFocusable(false);

                fila3.setElevation(2);
                text3.setTextColor(getColor(R.color.colorSeleccion));
                tx3.setTextColor(getColor(R.color.colorSeleccion));
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila4.setElevation(2);
                text4.setTextColor(getColor(R.color.colorSeleccion));
                tx4.setTextColor(getColor(R.color.colorSeleccion));
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila5.setElevation(2);
                text5.setTextColor(getColor(R.color.colorSeleccion));
                tx5.setTextColor(getColor(R.color.colorSeleccion));
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);

                fila1.setElevation(100);
                fila2.setElevation(100);
                break;
            case 2:
                ed2.setFocusable(false);
                ed4.setFocusable(false);
                ed5.setFocusable(false);

                fila2.setElevation(2);
                text2.setTextColor(getColor(R.color.colorSeleccion));
                tx2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila4.setElevation(2);
                text4.setTextColor(getColor(R.color.colorSeleccion));
                tx4.setTextColor(getColor(R.color.colorSeleccion));
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila5.setElevation(2);
                text5.setTextColor(getColor(R.color.colorSeleccion));
                tx5.setTextColor(getColor(R.color.colorSeleccion));
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);

                fila1.setElevation(100);
                fila3.setElevation(100);
                break;
            case 3:
                ed3.setFocusable(false);
                ed4.setFocusable(false);
                ed2.setFocusable(false);

                fila3.setElevation(2);
                text3.setTextColor(getColor(R.color.colorSeleccion));
                tx3.setTextColor(getColor(R.color.colorSeleccion));
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila4.setElevation(2);
                text4.setTextColor(getColor(R.color.colorSeleccion));
                tx4.setTextColor(getColor(R.color.colorSeleccion));
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila2.setElevation(2);
                text2.setTextColor(getColor(R.color.colorSeleccion));
                tx2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila1.setElevation(100);
                fila5.setElevation(100);
                break;
            case 4:
                ed1.setFocusable(false);
                ed3.setFocusable(false);
                ed5.setFocusable(false);

                fila1.setElevation(2);
                text1.setTextColor(getColor(R.color.colorSeleccion));
                tx1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila3.setElevation(2);
                text3.setTextColor(getColor(R.color.colorSeleccion));
                tx3.setTextColor(getColor(R.color.colorSeleccion));
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila5.setElevation(2);
                text5.setTextColor(getColor(R.color.colorSeleccion));
                tx5.setTextColor(getColor(R.color.colorSeleccion));
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);

                fila4.setElevation(100);
                fila2.setElevation(100);
                break;
            case 5:
                ed3.setFocusable(false);
                ed4.setFocusable(false);
                ed1.setFocusable(false);

                fila3.setElevation(2);
                text3.setTextColor(getColor(R.color.colorSeleccion));
                tx3.setTextColor(getColor(R.color.colorSeleccion));
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila4.setElevation(2);
                text4.setTextColor(getColor(R.color.colorSeleccion));
                tx4.setTextColor(getColor(R.color.colorSeleccion));
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila1.setElevation(2);
                text1.setTextColor(getColor(R.color.colorSeleccion));
                tx1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila2.setElevation(100);
                fila5.setElevation(100);
                break;
            case 6:
                ed1.setFocusable(false);
                ed2.setFocusable(false);
                ed5.setFocusable(false);

                fila1.setElevation(2);
                text1.setTextColor(getColor(R.color.colorSeleccion));
                tx1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila2.setElevation(2);
                text2.setTextColor(getColor(R.color.colorSeleccion));
                tx2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila5.setElevation(2);
                text5.setTextColor(getColor(R.color.colorSeleccion));
                tx5.setTextColor(getColor(R.color.colorSeleccion));
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);

                fila3.setElevation(100);
                fila4.setElevation(100);
                break;
            case 7:
                ed1.setFocusable(false);
                ed2.setFocusable(false);
                ed4.setFocusable(false);

                fila1.setElevation(2);
                text1.setTextColor(getColor(R.color.colorSeleccion));
                tx1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila2.setElevation(2);
                text2.setTextColor(getColor(R.color.colorSeleccion));
                tx2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila4.setElevation(2);
                text4.setTextColor(getColor(R.color.colorSeleccion));
                tx4.setTextColor(getColor(R.color.colorSeleccion));
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);

                fila3.setElevation(100);
                fila5.setElevation(100);
                break;
            case 8:
                ed1.setFocusable(false);
                ed2.setFocusable(false);
                ed3.setFocusable(false);

                fila1.setElevation(2);
                text1.setTextColor(getColor(R.color.colorSeleccion));
                tx1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);

                fila2.setElevation(2);
                text2.setTextColor(getColor(R.color.colorSeleccion));
                tx2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);

                fila3.setElevation(2);
                text3.setTextColor(getColor(R.color.colorSeleccion));
                tx3.setTextColor(getColor(R.color.colorSeleccion));
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);

                fila4.setElevation(100);
                fila5.setElevation(100);
                break;
        }
    }

    public void calcular(View view) {
        dato = getIntent().getIntExtra("p", 0);
        switch (dato) {
            case 1:
                if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor1 = conversor_Numero(ed1.getText().toString());
                    valor2 = conversor_Numero(ed2.getText().toString());
                    Intent x = new Intent(this, Resultados_momento_angular.class);//cambiar la actividad de respuestas
                    dw = variacion_velocidad(valor2, valor1);
                    x.putExtra("id", 1);
                    x.putExtra("dw", dw);
                    x.putExtra("title", datos);
                    //envio de datos
                    x.putExtra("wo", valor1);
                    x.putExtra("wf", valor2);
                    startActivity(x);
                }
                break;
            case 2:
                if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed1.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor1 = conversor_Numero(ed1.getText().toString());
                    valor3 = conversor_Numero(ed3.getText().toString());
                    if ((valor1 < 0 & valor3 > 0) || (valor1 > 0 & valor3 < 0)) {
                        dialogo_signos(view).show();
                    }else if(valor1==0){
                    dialogo_velocidad(view).show();}
                    else {
                        Intent x = new Intent(this, Resultados_momento_angular.class);//cambiar la actividad de respuestas
                        I = inercia1(valor3, valor1);
                        x.putExtra("id", 2);
                        x.putExtra("I", I);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("wo", valor1);
                        x.putExtra("Lo", valor3);
                        startActivity(x);
                    }
                }
                break;
            case 3:
                if (ed1.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed1.getText().toString().isEmpty() || ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor1 = conversor_Numero(ed1.getText().toString());
                    valor5 = conversor_Numero(ed5.getText().toString());
                    if (valor5 < 0) {
                        dialogo_alerta_inercia(view).show();
                    } else {
                        Intent x = new Intent(this, Resultados_momento_angular.class);//cambiar la actividad de respuestas
                        Lo = momento(valor5, valor1);
                        x.putExtra("id", 3);
                        x.putExtra("Lo", Lo);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("wo", valor1);
                        x.putExtra("I", valor5);
                        startActivity(x);
                    }
                }
                break;
            case 4:
                if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed2.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                        valor2 = conversor_Numero(ed2.getText().toString());
                        valor4 = conversor_Numero(ed4.getText().toString());
                        if((valor2 < 0 & valor4 > 0) || (valor2 > 0 & valor4 < 0)){
                            dialogo_signos(view).show();
                        }
                        else if(valor2==0){
                            dialogo_velocidad(view).show();
                        }
                        else {
                            Intent x = new Intent(this, Resultados_momento_angular.class);//cambiar la actividad de respuestas
                            I = inercia1(valor4, valor2);
                            x.putExtra("id", 4);
                            x.putExtra("I", I);
                            x.putExtra("title", datos);
                            //envio de datos
                            x.putExtra("wf", valor2);
                            x.putExtra("Lf", valor4);
                            startActivity(x);
                        }
                }
                break;
            case 5:
                if (ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed2.getText().toString().isEmpty() || ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor2 = conversor_Numero(ed2.getText().toString());
                    valor5 = conversor_Numero(ed5.getText().toString());
                    if (valor5 < 0) {
                        dialogo_alerta_inercia(view).show();
                    } else {
                        Intent x = new Intent(this, Resultados_momento_angular.class);//cambiar la actividad de respuestas
                        Lf = momento(valor5, valor2);
                        x.putExtra("id", 5);
                        x.putExtra("Lf", Lf);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("wf", valor2);
                        x.putExtra("I", valor5);
                        startActivity(x);
                    }
                }
                break;
            case 6:
                if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor4 = conversor_Numero(ed4.getText().toString());
                    Intent x = new Intent(this, Resultados_momento_angular.class);//cambiar la actividad de respuestas
                    dL = impulso(valor4, valor3);
                    x.putExtra("id", 6);
                    x.putExtra("dL", dL);
                    x.putExtra("title", datos);
                    //envio de datos
                    x.putExtra("Lo", valor3);
                    x.putExtra("Lf", valor4);
                    startActivity(x);

                }
                break;
            case 7:
                if (ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed3.getText().toString().isEmpty() || ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor3 = conversor_Numero(ed3.getText().toString());
                    valor5 = conversor_Numero(ed5.getText().toString());
                    if (valor5 < 0) {
                        dialogo_alerta_inercia(view).show();
                    } else {
                        Intent x = new Intent(this, Resultados_momento_angular.class);//cambiar la actividad de respuestas
                        wo = velocidad(valor3, valor5);
                        x.putExtra("id", 7);
                        x.putExtra("wo", wo);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("Lo", valor3);
                        x.putExtra("I", valor5);
                        startActivity(x);
                    }
                }
                break;
            case 8:
                if (ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else if (ed4.getText().toString().isEmpty() || ed5.getText().toString().isEmpty()) {
                    dialogo_alerta_magnitudes(view).show();
                } else {
                    valor4 = conversor_Numero(ed4.getText().toString());
                    valor5 = conversor_Numero(ed5.getText().toString());
                    if (valor5 < 0) {
                        dialogo_alerta_inercia(view).show();
                    } else {
                        Intent x = new Intent(this, Resultados_momento_angular.class);//cambiar la actividad de respuestas
                        wf = velocidad(valor4, valor5);
                        x.putExtra("id", 8);
                        x.putExtra("wf", wf);
                        x.putExtra("title", datos);
                        //envio de datos
                        x.putExtra("Lf", valor4);
                        x.putExtra("I", valor5);
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
    public double variacion_velocidad(double a, double b) {
        return (a - b);
    }
    public double inercia1(double a, double b) {
        return (a / b);
    }
    public double momento(double a, double b) {
        return (a * b);
    }
    public double impulso(double a, double b) {
        return (a - b);
    }
    public double velocidad(double a, double b) {
        return (a / b);
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
    public Dialog dialogo_alerta_inercia(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("El valor de la inercia siempre es positivo.");
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
        builder.setMessage("Tanto la velocidad como el momentum angular deben tener la misma direccion.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_velocidad(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("La velocidad angular no pueder ser 0 si exite cantidad de movimiento angular.");
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
