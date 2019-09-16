package michael.acosta.movimientoderotacion.ContextosCinematicos;
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
import michael.acosta.movimientoderotacion.Resultados.Resultados_parametros_angulares;
public class ParametrosAngulares extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    double valor1, valor2, valor3, T, f, w;
    TextView tx1, tx2, tx3, text1, text2, text3;
    ImageView imagen;
    int posicion;
    String datos;
    TextInputLayout ti1, ti2, ti3;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros_angulares);
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
        });//flecha ATRAS
        imagen = (ImageView) findViewById(R.id.imageView);
        posicion = getIntent().getIntExtra("im", 0);

        switch (posicion) {
            case 2:
                imagen.setImageResource(R.drawable.frecuencia_periodo);
                imagen.setElevation(200);
                break;
        }
        //casteo de filas
        final TableRow fila1 = (TableRow) findViewById(R.id.fila1);
        final TableRow fila2 = (TableRow) findViewById(R.id.fila2);
        final TableRow fila3 = (TableRow) findViewById(R.id.fila3);
        //variables casteadas y  con simbolos de la Fisica
        text1 = (TextView) findViewById(R.id.text1);
        text1.setText(Html.fromHtml("T:"));
        tx1 = (TextView) findViewById(R.id.tx1);
        tx1.setText("[s]");
        ed1 = (EditText) findViewById(R.id.ed1);
        ti1 = (TextInputLayout) findViewById(R.id.inputT);
        text2 = (TextView) findViewById(R.id.text2);
        text2.setText(Html.fromHtml("f:"));
        tx2 = (TextView) findViewById(R.id.tx2);
        tx2.setText("[hertz]");
        ed2 = (EditText) findViewById(R.id.ed2);
        ti2 = (TextInputLayout) findViewById(R.id.inputF);
        text3 = (TextView) findViewById(R.id.text3);
        text3.setText(Html.fromHtml("ω:"));
        tx3 = (TextView) findViewById(R.id.tx3);
        tx3.setText("[rad/s]");
        ed3 = (EditText) findViewById(R.id.ed3);
        ti3 = (TextInputLayout) findViewById(R.id.inputW);
        editextWidget(ti1);
        editextWidget(ti2);
        editextWidget(ti3);

        //recepcion de datos
        int dato = getIntent().getIntExtra("p", 0);
        switch (dato) {
            case 1:
                ed2.setFocusable(false);
                ed3.setFocusable(false);
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
                fila1.setElevation(100);
                break;
            case 2:
                ed1.setFocusable(false);
                ed3.setFocusable(false);
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
                fila2.setElevation(100);
                break;
            case 3:
                ed1.setFocusable(false);
                ed2.setFocusable(false);
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
                fila3.setElevation(100);
                break;
        }
    }
    //metodo de funcionamiento del boton
    public void calcular(View view) {
         if (ed1.isEnabled()) {
            caso1(view);
        } else if (ed2.isEnabled()) {
            caso2(view);
        } else if (ed3.isEnabled()) {
            caso3(view);
        }
        //CASO PARA TODOS LOS DEMAS
        else {
            dialogo_alerta_magnitudes(view).show();
        }
    }

    //metodos de funcionamiento BASE
    public void caso1(View view) {
        if(ed1.getText().toString().isEmpty()){
            dialogo_alerta_magnitudes(view).show();
        }
        else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
            valor1 = conversor_Numero(ed1.getText().toString());
            if (valor1 <= 0) {
                dialogo_alerta_tiempo(view).show();
            }

            else {
                Intent x = new Intent(this, Resultados_parametros_angulares.class);//cambiar el actvity
                f = frecuencia1(valor1);
                w = velocidadAngular1(valor1);
                x.putExtra("id", 1);
                x.putExtra("f", f);
                x.putExtra("w", w);
                x.putExtra("title", datos);
                //envio de datos
                x.putExtra("T", valor1);
                startActivity(x);
            }
        }
    }
    public void caso2(View view) {
        if(ed2.getText().toString().isEmpty()){
            dialogo_alerta_magnitudes(view).show();
        }
        else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
            valor2 = conversor_Numero(ed2.getText().toString());
            if (valor2 <= 0) {
                dialogo_alerta_frecuencia(view).show();
            }//poner dialogo
            else {
                Intent y = new Intent(this, Resultados_parametros_angulares.class);//cambiar el actvity
                T = periodo1(valor2);
                w = velocidadAngular2(valor2);
                y.putExtra("id", 2);
                y.putExtra("T", T);
                y.putExtra("w", w);
                y.putExtra("title", datos);
                //envio de datos
                y.putExtra("f", valor2);
                startActivity(y);
            }
        }

    }
    public void caso3(View view) {
        if(ed3.getText().toString().isEmpty()){
            dialogo_alerta_magnitudes(view).show();
        }
        else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
            valor3 = conversor_Numero(ed3.getText().toString());
            if (valor3 == 0) {
                dialogo_alerta_SinMovimiento(view).show();
            }//poner dialogo
            else {
                Intent z = new Intent(this, Resultados_parametros_angulares.class);//cambiar el actvity
                T = periodo2(valor3);
                f = frecuencia2(valor3);
                z.putExtra("id", 3);
                z.putExtra("T", T);
                z.putExtra("f", f);
                z.putExtra("title", datos);
                //envio de datos
                z.putExtra("w", valor3);
                startActivity(z);
            }
        }
         }

    //metodos para los calculos matematicos
    public Double conversor_Numero(String e) {

            return Double.parseDouble(e);
    }
    public double frecuencia1(double a) {
        return (1 / a);
    }
    public double frecuencia2(double a) {
        return (a / (2 * Math.PI));
    }
    public double velocidadAngular1(double a) {
        return ((2 * Math.PI) / a);
    }
    public double velocidadAngular2(double a) {
        return ((2 * Math.PI) * a);
    }
    public double periodo1(double a) {
        return (1 / a);
    }
    public double periodo2(double a) {
        return ((2 * Math.PI) / a);
    }

    //alertas de apredizaje
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
    public Dialog dialogo_alerta_tiempo(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("El tiempo siempre es una magnitud física positiva.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ed1.setText("");
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_frecuencia(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("La frecuancia es una magnitud física positiva.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ed2.setText("");
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_SinMovimiento(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("La condiciones establecidas no generan movimiento circular.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ed3.setText("");
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
