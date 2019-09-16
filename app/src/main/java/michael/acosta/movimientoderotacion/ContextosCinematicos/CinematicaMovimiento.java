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
import michael.acosta.movimientoderotacion.Resultados.Resultados_Cinematica;
public class CinematicaMovimiento extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4, ed5;
    double valor1, valor2, valor3, valor4, valor5, dv, vm, t, a, d, vo, vf;
    TextView tx1, tx2, tx3, tx4, tx5, text1, text2, text3, text4, text5;
    ImageView imagen;
    int posicion;
    String datos;
    TextInputLayout ti1, ti2, ti3, ti4, ti5;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cinematica);
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
                imagen.setImageResource(R.drawable.movcinematica);
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
        tx1.setText("[rad/s]");
        ed1 = (EditText) findViewById(R.id.ed1);
        ti1 = (TextInputLayout) findViewById(R.id.inputVeloI);

        text2 = (TextView) findViewById(R.id.text2);
        text2.setText(Html.fromHtml("ω<sub>f</sub>:"));
        tx2 = (TextView) findViewById(R.id.tx2);
        tx2.setText("[rad/s]");
        ed2 = (EditText) findViewById(R.id.ed2);
        ti2 = (TextInputLayout) findViewById(R.id.inputVeloF);

        text3 = (TextView) findViewById(R.id.text3);
        tx3 = (TextView) findViewById(R.id.tx3);
        tx3.setText("[rad]");
        ed3 = (EditText) findViewById(R.id.ed3);
        ti3 = (TextInputLayout) findViewById(R.id.inputD);

        text4 = (TextView) findViewById(R.id.text4);
        tx4 = (TextView) findViewById(R.id.tx4);
        tx4.setText("[s]");
        ed4 = (EditText) findViewById(R.id.ed4);
        ti4 = (TextInputLayout) findViewById(R.id.inputT);

        text5 = (TextView) findViewById(R.id.text5);
        tx5 = (TextView) findViewById(R.id.tx5);
        tx5.setText(Html.fromHtml("[rad/s<sup>2</sup>]"));
        ed5 = (EditText) findViewById(R.id.ed5);
        ti5 = (TextInputLayout) findViewById(R.id.inputA);

        editextWidget(ti1);
        editextWidget(ti2);
        editextWidget(ti3);
        editextWidget(ti4);
        editextWidget(ti5);

        //recepcion de datos
        int dato = getIntent().getIntExtra("p", 0);
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
                ed1.setFocusable(false);
                ed2.setFocusable(false);
                ed5.setFocusable(false);
                fila1.setElevation(2);
                text1.setTextColor(getColor(R.color.colorSeleccion));
                tx1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);
                fila5.setElevation(2);
                text5.setTextColor(getColor(R.color.colorSeleccion));
                tx5.setTextColor(getColor(R.color.colorSeleccion));
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);
                fila2.setElevation(2);
                text2.setTextColor(getColor(R.color.colorSeleccion));
                tx2.setTextColor(getColor(R.color.colorSeleccion));
                ed2.setTextColor(getColor(R.color.colorSeleccion));
                ti2.setHint("");
                ti2.setEnabled(false);
                fila3.setElevation(100);
                fila4.setElevation(100);
                break;
            case 3:
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
            case 4:
                //codigo
                ed4.setFocusable(false);
                ed5.setFocusable(false);
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
                fila3.setElevation(100);
                break;
            case 5:
                //codigo
                ed3.setFocusable(false);
                ed5.setFocusable(false);
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
                fila1.setElevation(100);
                fila2.setElevation(100);
                fila4.setElevation(100);
                break;
            case 6:
                //codigo
                ed4.setFocusable(false);
                ed3.setFocusable(false);
                fila4.setElevation(2);
                text4.setTextColor(getColor(R.color.colorSeleccion));
                tx4.setTextColor(getColor(R.color.colorSeleccion));
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);
                fila3.setElevation(2);
                text3.setTextColor(getColor(R.color.colorSeleccion));
                tx3.setTextColor(getColor(R.color.colorSeleccion));
                ed3.setTextColor(getColor(R.color.colorSeleccion));
                ti3.setHint("");
                ti3.setEnabled(false);
                fila1.setElevation(100);
                fila2.setElevation(100);
                fila5.setElevation(100);
                break;
            case 7:
                //codigo
                ed2.setFocusable(false);
                ed5.setFocusable(false);
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
                fila1.setElevation(100);
                fila4.setElevation(100);
                fila3.setElevation(100);
                break;
            case 8:
                //codigo
                ed4.setFocusable(false);
                ed2.setFocusable(false);
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
                fila3.setElevation(100);
                break;
            case 9:
                //codigo
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
                fila4.setElevation(100);
                fila5.setElevation(100);
                break;
            case 10:
                //codigo
                ed1.setFocusable(false);
                ed5.setFocusable(false);
                fila1.setElevation(2);
                text1.setTextColor(getColor(R.color.colorSeleccion));
                tx1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);
                fila5.setElevation(2);
                text5.setTextColor(getColor(R.color.colorSeleccion));
                tx5.setTextColor(getColor(R.color.colorSeleccion));
                ed5.setTextColor(getColor(R.color.colorSeleccion));
                ti5.setHint("");
                ti5.setEnabled(false);
                fila4.setElevation(100);
                fila2.setElevation(100);
                fila3.setElevation(100);
                break;
            case 11:
                //codigo
                ed1.setFocusable(false);
                ed4.setFocusable(false);
                fila1.setElevation(2);
                text1.setTextColor(getColor(R.color.colorSeleccion));
                tx1.setTextColor(getColor(R.color.colorSeleccion));
                ed1.setTextColor(getColor(R.color.colorSeleccion));
                ti1.setHint("");
                ti1.setEnabled(false);
                fila4.setElevation(2);
                text4.setTextColor(getColor(R.color.colorSeleccion));
                tx4.setTextColor(getColor(R.color.colorSeleccion));
                ed4.setTextColor(getColor(R.color.colorSeleccion));
                ti4.setHint("");
                ti4.setEnabled(false);
                fila5.setElevation(100);
                fila2.setElevation(100);
                fila3.setElevation(100);
                break;
            case 12:
                //codigo
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
                fila4.setElevation(100);
                fila5.setElevation(100);
                fila3.setElevation(100);
                break;
            case 13:
                //codigo
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
                fila4.setElevation(100);
                fila5.setElevation(100);
                fila3.setElevation(100);
                break;
        }
    }
    //metodo de funcionamiento del boton
    public void calcular(View view) {
        //CASO 5  HABILITADOS
        if (ed1.isEnabled() & ed2.isEnabled() & ed3.isEnabled() & ed4.isEnabled() & ed5.isEnabled()) {
            if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                caso12(view);
            }//dv
            else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                caso13(view);
            }//vm
            else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                caso11(view);
            } else if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                caso1(view);
            } else if (ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                caso2(view);
            } else if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                caso3(view);
            } else if (ed1.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                caso6(view);
            } else if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                caso7(view);
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
                caso9(view);
            } else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                caso4(view);
            } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                caso8(view);
            } else if (ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                caso5(view);
            } else if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                caso10(view);
            } else {
                dialogo_alerta_DatosExcesivos(view).show();
            }


        }//PRIMER CASO CON 4  HABILITADOS
        else if (ed1.isEnabled() & ed2.isEnabled() & ed3.isEnabled() & ed4.isEnabled()) {
            if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                caso11(view);
            }//calculo de vm y dv
            else if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed3.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed3.getText().toString().isEmpty() & ed1.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
                caso13(view);
            }//calculo de vm
            else if (ed4.getText().toString().isEmpty()) {
                caso1(view);
            } else if (ed3.getText().toString().isEmpty()) {
                caso2(view);
            } else if (ed2.getText().toString().isEmpty()) {
                caso5(view);
            } else if (ed1.getText().toString().isEmpty()) {
                caso6(view);
            } else {
                dialogo_alerta_DatosExcesivos(view).show();
            }
        }//SEGUNDO CASO CON 4 CHEKCLIST HABILITADOS
        else if (ed1.isEnabled() & ed2.isEnabled() & ed3.isEnabled() & ed5.isEnabled()) {
            if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                caso11(view);
            }//calculo de vm y dv
            else if (ed5.getText().toString().isEmpty()) {
                caso1(view);
            } else if (ed2.getText().toString().isEmpty()) {
                caso10(view);
            } else if (ed3.getText().toString().isEmpty()) {
                caso3(view);
            } else if (ed1.getText().toString().isEmpty()) {
                caso7(view);
            } else {
                dialogo_alerta_DatosExcesivos(view).show();
            }
        }//TERCER CASO CON 4 CHEKCLIST HABILITADOS
        else if (ed2.isEnabled() & ed3.isEnabled() & ed4.isEnabled() & ed5.isEnabled()) {
            if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                caso12(view);
            }//calculo de dv
            else if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                caso13(view);
            }//calculo de vm
            else if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed5.getText().toString().isEmpty()) {
                caso6(view);
            } else if (ed4.getText().toString().isEmpty()) {
                caso7(view);
            } else if (ed3.getText().toString().isEmpty()) {
                caso8(view);
            } else if (ed2.getText().toString().isEmpty()) {
                caso9(view);
            } else {
                dialogo_alerta_DatosExcesivos(view).show();
            }
        }//CUARTO CASO CON 4 CHEKCLIST HABILITADOS
        else if (ed1.isEnabled() & ed3.isEnabled() & ed4.isEnabled() & ed5.isEnabled()) {
            if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
                caso12(view);
            }//calculo de dv
            else if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed5.getText().toString().isEmpty()) {
                caso5(view);
            } else if (ed4.getText().toString().isEmpty()) {
                caso10(view);
            } else if (ed3.getText().toString().isEmpty()) {
                caso4(view);
            } else if (ed1.getText().toString().isEmpty()) {
                caso9(view);
            } else {
                dialogo_alerta_DatosExcesivos(view).show();
            }
        }//QUINTO CASO CON 4 CHEKCLIST HABILITADOS
        else if (ed1.isEnabled() & ed2.isEnabled() & ed4.isEnabled() & ed5.isEnabled()) {
            if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
                caso12(view);
            }//calculo de dv
            else if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed1.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else if (ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
                caso11(view);
            }//calculo de dv, vm
            else if (ed5.getText().toString().isEmpty()) {
                caso2(view);
            } else if (ed4.getText().toString().isEmpty()) {
                caso3(view);
            } else if (ed2.getText().toString().isEmpty()) {
                caso4(view);
            } else if (ed1.getText().toString().isEmpty()) {
                caso8(view);
            } else {
                dialogo_alerta_DatosExcesivos(view).show();
            }
        }//CASOS CON 3 CHECKLIST HABILITADOS
        else if (ed1.isEnabled() & ed2.isEnabled() & ed3.isEnabled()) {
            caso1(view);
        } else if (ed1.isEnabled() & ed2.isEnabled() & ed4.isEnabled()) {
            caso2(view);
        } else if (ed1.isEnabled() & ed2.isEnabled() & ed5.isEnabled()) {
            caso3(view);
        } else if (ed1.isEnabled() & ed4.isEnabled() & ed5.isEnabled()) {
            caso4(view);
        } else if (ed1.isEnabled() & ed3.isEnabled() & ed4.isEnabled()) {
            caso5(view);
        } else if (ed2.isEnabled() & ed3.isEnabled() & ed4.isEnabled()) {
            caso6(view);
        } else if (ed2.isEnabled() & ed3.isEnabled() & ed5.isEnabled()) {
            caso7(view);
        } else if (ed2.isEnabled() & ed4.isEnabled() & ed5.isEnabled()) {
            caso8(view);
        } else if (ed3.isEnabled() & ed4.isEnabled() & ed5.isEnabled()) {
            if(ed5.getText().toString().isEmpty()){caso13(view);}
            else{caso9(view);}

        } else if (ed1.isEnabled() & ed3.isEnabled() & ed5.isEnabled()) {
            caso10(view);
        } else if (ed1.isEnabled() & ed2.isEnabled()) {
            caso11(view);
        } else if (ed4.isEnabled() & ed5.isEnabled()) {
            caso12(view);
        } else if (ed3.isEnabled() & ed4.isEnabled()) {
            caso13(view);
        }
        //CASOS CON 2 CHECKLIST HABILITADOS
        else if (ed1.isEnabled() & ed3.isEnabled()) {
            if ((ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) || ed1.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else {
                dialogo_alerta_SinMovimiento(view).show();
            }
        } else if (ed1.isEnabled() & ed4.isEnabled()) {
            if ((ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) || ed1.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else {
                dialogo_alerta_SinMovimiento(view).show();
            }
        } else if (ed1.isEnabled() & ed5.isEnabled()) {
            if ((ed1.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) || ed1.getText().toString().isEmpty() || ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else {
                dialogo_alerta_SinMovimiento(view).show();
            }
        } else if (ed2.isEnabled() & ed3.isEnabled()) {
            if ((ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) || ed2.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else {
                dialogo_alerta_SinMovimiento(view).show();
            }
        } else if (ed2.isEnabled() & ed4.isEnabled()) {
            if ((ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) || ed2.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else {
                dialogo_alerta_SinMovimiento(view).show();
            }
        } else if (ed2.isEnabled() & ed5.isEnabled()) {
            if ((ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) || ed2.getText().toString().isEmpty() || ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else {
                dialogo_alerta_SinMovimiento(view).show();
            }
        } else if (ed3.isEnabled() & ed5.isEnabled()) {
            if ((ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) || ed3.getText().toString().isEmpty() || ed5.getText().toString().isEmpty()) {
                dialogo_alerta_magnitudes(view).show();
            } else {
                dialogo_alerta_SinMovimiento(view).show();
            }
        } else if (ed1.isEnabled() & ed2.isEnabled()) {
            if ((ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) || ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty()) {
                caso11(view);
            } else {
                dialogo_alerta_SinMovimiento(view).show();
            }
        }
        else if (ed3.isEnabled() & ed4.isEnabled()) {
            if ((ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) || ed3.getText().toString().isEmpty() || ed4.getText().toString().isEmpty()) {
                caso13(view);
            } else {
                dialogo_alerta_SinMovimiento(view).show();
            }
        }

        //CASO PARA TODOS LOS DEMAS
        else {
            dialogo_alerta_magnitudes(view).show();
        }
    }
    //metodos de funcionamiento BASE
    public void caso1(View view) {
        if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed3.getText().toString().isEmpty()) {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor2 = conversor_Numero(ed2.getText().toString());
            Intent x = new Intent(this, Resultados_Cinematica.class);
            vm = velocidad_media(valor2, valor1);
            dv = variacion_velocidad(valor2, valor1);
            x.putExtra("id", 11);
            x.putExtra("dv", dv);
            x.putExtra("vm", vm);
            x.putExtra("title", datos);
            //envio de datos
            x.putExtra("vo", valor1);
            x.putExtra("vf", valor2);
            startActivity(x);

        } else {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor2 = conversor_Numero(ed2.getText().toString());
            valor3 = conversor_Numero(ed3.getText().toString());
            //El desplazamiento es siempre positivo
            if (valor3 < 0) {
                dialogo_alerta_desplazamientos(view).show();
            } else {
                if (valor1 == 0 & valor2 == 0 & valor3 == 0) {
                    dialogo_alerta_reposo(view).show();
                } else if ((valor1 == ((-1) * (valor2)) || valor2 == ((-1) * (valor1))) & valor3 == 0) {
                    dialogo_alerta_Movimiento_Especial_Acelerado_Desacelerado_caso1(view).show();
                } else if ((valor1 == ((-1) * (valor2)) || valor2 == ((-1) * (valor1))) & valor3 != 0) {
                    dialogo_alerta_Movimiento_Especial_Acelerado_Desacelerado_caso2(view).show();
                } else if (valor1 == 0 & valor2 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor2 == 0 & valor3 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor1 == 0 & valor3 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor3 == 0) {
                    dialogo_alerta_desplazamientos(view).show();
                } else {
                    Intent i = new Intent(this, Resultados_Cinematica.class);
                    double dv = variacion_velocidad(valor2, valor1);
                    double vm = velocidad_media(valor1, valor2);
                    if (vm < 0) {
                        valor3 = (-1) * valor3;
                    }
                    double t = division(valor3, vm);
                    double a = division(dv, t);
                    i.putExtra("id", 1);
                    i.putExtra("dv", dv);
                    i.putExtra("vm", vm);
                    i.putExtra("t", t);
                    i.putExtra("a", a);
                    i.putExtra("title", datos);
                    //envio de datos
                    i.putExtra("vo", valor1);
                    i.putExtra("vf", valor2);
                    i.putExtra("d", valor3);
                    startActivity(i);

                }
            }
        }
    }
    public void caso2(View view) {
        if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed4.getText().toString().isEmpty()) {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor2 = conversor_Numero(ed2.getText().toString());
            Intent x = new Intent(this, Resultados_Cinematica.class);
            vm = velocidad_media(valor1, valor2);
            dv = variacion_velocidad(valor2, valor1);

            x.putExtra("id", 11);
            x.putExtra("vm", vm);
            x.putExtra("dv", dv);
            x.putExtra("title", datos);
            //envio de datos
            x.putExtra("vo", valor1);
            x.putExtra("vf", valor2);
            startActivity(x);

        } else {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor2 = conversor_Numero(ed2.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            if (valor4 < 0) {
                dialogo_alerta_tiempo(view).show();
            } else {
                if (valor1 == 0 & valor2 == 0 & valor4 == 0) {
                    dialogo_alerta_reposo(view).show();
                } else if (valor1 == 0 & valor2 == 0) {
                    dialogo_alerta_velocidadesNulasconTiempo(view).show();
                } else if (valor1 == 0 & valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor2 == 0 & valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else {
                    Intent j = new Intent(this, Resultados_Cinematica.class);
                    double dv = variacion_velocidad(valor2, valor1);
                    double vm = velocidad_media(valor1, valor2);
                    if (vm < 0) {
                        vm = (-1) * vm;
                    }
                    double d = producto(vm, valor4);
                    double a = division(dv, valor4);
                    j.putExtra("id", 2);
                    j.putExtra("dv", dv);
                    j.putExtra("vm", vm);
                    j.putExtra("d", d);
                    j.putExtra("a", a);
                    j.putExtra("title", datos);
                    //envio de datos
                    j.putExtra("vo", valor1);
                    j.putExtra("vf", valor2);
                    j.putExtra("t", valor4);
                    startActivity(j);
                }
            }
        }
    }
    public void caso3(View view) {
        if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed5.getText().toString().isEmpty()) {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor2 = conversor_Numero(ed2.getText().toString());
            Intent x = new Intent(this, Resultados_Cinematica.class);
            vm = velocidad_media(valor1, valor2);
            dv = variacion_velocidad(valor2, valor1);

            x.putExtra("id", 11);
            x.putExtra("vm", vm);
            x.putExtra("dv", dv);
            x.putExtra("title", datos);
            //envio de datos
            x.putExtra("vo", valor1);
            x.putExtra("vf", valor2);
            x.putExtra("a", valor5);
            startActivity(x);

        } else {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor2 = conversor_Numero(ed2.getText().toString());
            valor5 = conversor_Numero(ed5.getText().toString());

            if (valor1 == 0 & valor2 == 0 & valor5 == 0) {
                dialogo_alerta_reposo(view).show();
            } else if (valor1 == 0 & valor2 == 0) {
                dialogo_alerta_SinMovimiento(view).show();
            } else if (valor1 == 0 & valor5 == 0) {
                dialogo_alerta_SinMovimiento(view).show();
            } else if (valor2 == 0 & valor5 == 0) {
                dialogo_alerta_SinMovimiento(view).show();
            } else if (valor5 == 0) {
                if (valor1 == valor2) {
                    Intent x = new Intent(this, Resultados_Cinematica.class);
                    vm = velocidad_media(valor1, valor2);
                    dv = variacion_velocidad(valor2, valor1);
                    x.putExtra("id", 11);
                    x.putExtra("vm", vm);
                    x.putExtra("dv", dv);
                    x.putExtra("title", datos);
                    //envio de datos
                    x.putExtra("vo", valor1);
                    x.putExtra("vf", valor2);
                    x.putExtra("a", valor5);
                    startActivity(x);

                } else {
                    dialogo_alerta_SinMovimiento(view).show();
                }
            } else if (valor1 == valor2 & valor5 != 0) {
                dialogo_alerta_SinMovimiento(view).show();
            } else if ((valor1 < 0 & valor2 < 0) & ((valor2 > valor1) & valor5 < 0)) {
                dialogo_alerta_aceleracionCasoDesacelerado(view).show();
            } else if ((valor1 < 0 & valor2 < 0) & ((valor2 < valor1) & valor5 > 0)) {
                dialogo_alerta_aceleracionCasoAcelerado(view).show();
            } else if ((valor1 == 0 & valor2 < 0) & valor5 > 0) {
                dialogo_alerta_aceleracionCasoAcelerado(view).show();
            } else if ((valor1 < 0 & valor2 == 0) & valor5 < 0) {
                dialogo_alerta_aceleracionCasoDesacelerado(view).show();
            } else if ((valor1 == 0 & valor2 > 0) & valor5 < 0) {
                dialogo_alerta_aceleracionCasoAcelerado(view).show();
            } else if ((valor1 > 0 & valor2 == 0) & valor5 > 0) {
                dialogo_alerta_aceleracionCasoDesacelerado(view).show();
            } else if ((valor1 > 0 & valor2 > 0) & ((valor2 > valor1) & valor5 < 0)) {
                dialogo_alerta_aceleracionCasoAcelerado(view).show();
            } else if ((valor1 > 0 & valor2 > 0) & ((valor2 < valor1) & valor5 > 0)) {
                dialogo_alerta_aceleracionCasoDesacelerado(view).show();
            } else if ((valor1 > 0 || valor1 < 0) & (valor2 > 0 || valor2 < 0) & ((valor2 > valor1) & valor5 < 0)) {
                dialogo_alerta_DESACELERACION(view).show();
            } else if ((valor1 > 0 || valor1 < 0) & (valor2 > 0 || valor2 < 0) & ((valor2 < valor1) & valor5 > 0)) {
                dialogo_alerta_DESACELERACION(view).show();
            } else {
                Intent k = new Intent(this, Resultados_Cinematica.class);
                double dv = variacion_velocidad(valor2, valor1);
                double vm = velocidad_media(valor1, valor2);
                double t = division(dv, valor5);
                if (vm < 0) {
                    vm = (-1) * vm;
                }
                double d = producto(vm, t);
                k.putExtra("id", 3);
                k.putExtra("dv", dv);
                k.putExtra("vm", vm);
                k.putExtra("t", t);
                k.putExtra("d", d);
                k.putExtra("title", datos);
                //envio de datos
                k.putExtra("vo", valor1);
                k.putExtra("vf", valor2);
                k.putExtra("a", valor5);
                startActivity(k);
            }
        }
    }
    public void caso4(View view) {
        if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty()) {
            valor5 = conversor_Numero(ed5.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            if (valor4 < 0) {
                dialogo_alerta_tiempo(view).show();
            } else {
                Intent y = new Intent(this, Resultados_Cinematica.class);
                dv = producto(valor4, valor5);
                y.putExtra("id", 12);
                y.putExtra("dv", dv);
                y.putExtra("title", datos);
                //envio de datos
                y.putExtra("vo", valor1);
                y.putExtra("t", valor4);
                y.putExtra("a", valor5);
                startActivity(y);

            }
        } else if (ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            valor5 = conversor_Numero(ed5.getText().toString());
            if (valor4 < 0) {
                dialogo_alerta_tiempo(view).show();
            } else {
                if (valor1 == 0 & valor4 == 0 & valor5 == 0) {
                    dialogo_alerta_reposo(view).show();
                } else if (valor1 == 0 & valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor1 == 0 & valor5 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor4 == 0 & valor5 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else {
                    Intent m = new Intent(this, Resultados_Cinematica.class);
                    vf = valor1 + (valor4 * valor5);
                    dv = variacion_velocidad(vf, valor1);
                    vm = velocidad_media(valor1, vf);
                    if (vm < 0) {
                        vm = (-1) * vm;
                    }
                    d = producto(vm, valor4);

                    m.putExtra("id", 4);
                    m.putExtra("dv", dv);
                    m.putExtra("vm", vm);
                    m.putExtra("vf", vf);
                    m.putExtra("d", d);
                    m.putExtra("title", datos);
                    m.putExtra("vo", valor1);
                    m.putExtra("t", valor4);
                    m.putExtra("a", valor5);
                    startActivity(m);

                }
            }
        }
    }
    public void caso5(View view) {
        if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty()) {
            valor4 = conversor_Numero(ed4.getText().toString());
            valor3 = conversor_Numero(ed3.getText().toString());
            if (valor4 <= 0) {
                dialogo_alerta_tiempo(view).show();
            } else {
                Intent b = new Intent(this, Resultados_Cinematica.class);
                vm = division(valor3, valor4);
                b.putExtra("id", 13);
                b.putExtra("vm", vm);
                b.putExtra("title", datos);
                b.putExtra("d", valor3);
                b.putExtra("t", valor4);
                startActivity(b);

            }
        } else if (ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor3 = conversor_Numero(ed3.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            if ((valor4 <= 0 & valor3 <= 0) || valor4 <= 0 || valor3 <= 0) {
                dialogo_alerta_Desplazamiento_Tiempo(view).show();
            } else {
                if (valor1 == 0 & valor3 == 0 & valor4 == 0) {
                    dialogo_alerta_reposo(view).show();
                } else if (valor1 == 0 & valor3 == 0) {
                    dialogo_alerta_reposo(view).show();
                } else if (valor1 == 0 & valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor3 == 0 & valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor3 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else {
                    Intent n = new Intent(this, Resultados_Cinematica.class);
                    vm = division(valor3, valor4);
                    vf = (2 * vm) - valor1;
                    dv = variacion_velocidad(vf, valor1);
                    a = division(dv, valor4);

                    n.putExtra("id", 5);
                    n.putExtra("dv", dv);
                    n.putExtra("vm", vm);
                    n.putExtra("a", a);
                    n.putExtra("vf", vf);
                    n.putExtra("vo", valor1);
                    n.putExtra("d", valor3);
                    n.putExtra("t", valor4);
                    n.putExtra("title", datos);
                    startActivity(n);

                }
            }
        }
    }
    public void caso6(View view) {
        if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty()) {
            valor4 = conversor_Numero(ed4.getText().toString());
            valor3 = conversor_Numero(ed3.getText().toString());
            if (valor4 <= 0) {
                dialogo_alerta_tiempo(view).show();
            } else {
                Intent b = new Intent(this, Resultados_Cinematica.class);
                vm = division(valor3, valor4);
                b.putExtra("id", 13);
                b.putExtra("vm", vm);
                b.putExtra("title", datos);
                b.putExtra("d", valor3);
                b.putExtra("t", valor4);
                startActivity(b);

            }
        } else if (ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor2 = conversor_Numero(ed2.getText().toString());
            valor3 = conversor_Numero(ed3.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            if ((valor4 <= 0 & valor3 <= 0) || valor4 <= 0 || valor3 <= 0) {
                dialogo_alerta_Desplazamiento_Tiempo(view).show();
            } else {
                if (valor2 == 0 & valor3 == 0 & valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor2 == 0 & valor3 == 0) {
                    dialogo_alerta_reposo(view).show();
                } else if (valor2 == 0 & valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor3 == 0 & valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor3 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else {
                    Intent p = new Intent(this, Resultados_Cinematica.class);
                    vm = division(valor3, valor4);
                    vo = (2 * vm) - valor2;
                    dv = variacion_velocidad(valor2, vo);
                    a = division(dv, valor4);

                    p.putExtra("id", 6);
                    p.putExtra("dv", dv);
                    p.putExtra("vm", vm);
                    p.putExtra("a", a);
                    p.putExtra("vo", vo);
                    p.putExtra("title", datos);
                    p.putExtra("vf", valor2);
                    p.putExtra("d", valor3);
                    p.putExtra("t", valor4);
                    startActivity(p);

                }
            }
        }
    }
    public void caso7(View view) {
        if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor2 = conversor_Numero(ed2.getText().toString());
            valor3 = conversor_Numero(ed3.getText().toString());
            valor5 = conversor_Numero(ed5.getText().toString());
            if (valor3 < 0) {
                dialogo_alerta_desplazamientos(view).show();
            } else {
                if (valor3 == 0 & valor2 == 0 & valor5 == 0) {
                    dialogo_alerta_reposo(view).show();
                } else if (valor2 == 0 & valor3 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor2 == 0 & valor5 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor3 == 0 & valor5 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor3 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else {
                    if ((discriminanteResta(valor2, valor3, valor5)) < 0) {
                        dialogo_alerta_SinMovimiento(view).show();
                    } else {
                        Intent q = new Intent(this, Resultados_Cinematica.class);
                        vo = raiz_resta(valor2, valor3, valor5);
                        vm = velocidad_media(valor2, vo);
                        dv = variacion_velocidad(valor2, vo);
                        if (vm < 0) {
                            vm = (-1) * vm;
                        }
                        t = division(valor3, vm);

                        q.putExtra("id", 7);
                        q.putExtra("dv", dv);
                        q.putExtra("vm", vm);
                        q.putExtra("t", t);
                        q.putExtra("vo", vo);
                        q.putExtra("vf", valor2);
                        q.putExtra("d", valor3);
                        q.putExtra("a", valor5);
                        q.putExtra("title", datos);
                        startActivity(q);

                    }
                }
            }
        }
    }
    public void caso8(View view) {
        if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed2.getText().toString().isEmpty()) {
            valor5 = conversor_Numero(ed5.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            if (valor4 < 0) {
                dialogo_alerta_tiempo(view).show();
            } else {
                Intent y = new Intent(this, Resultados_Cinematica.class);
                dv = producto(valor4, valor5);

                y.putExtra("id", 12);
                y.putExtra("dv", dv);
                y.putExtra("a", valor5);
                y.putExtra("t", valor4);
                y.putExtra("title", datos);
                startActivity(y);
            }
        } else if (ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor2 = conversor_Numero(ed2.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            valor5 = conversor_Numero(ed5.getText().toString());
            if (valor4 < 0) {
                dialogo_alerta_tiempo(view).show();
            } else if (valor2 == 0 & valor4 == 0 & valor5 == 0) {
                dialogo_alerta_reposo(view).show();
            } else if (valor2 == 0 & valor4 == 0) {
                dialogo_alerta_SinMovimiento(view).show();
            } else if (valor2 == 0 & valor5 == 0) {
                dialogo_alerta_reposo(view).show();
            } else if (valor4 == 0 & valor5 == 0) {
                dialogo_alerta_SinMovimiento(view).show();
            } else if (valor4 == 0) {
                dialogo_alerta_SinMovimiento(view).show();
            } else {
                Intent r = new Intent(this, Resultados_Cinematica.class);
                dv = producto(valor4, valor5);
                vo = valor2 - dv;
                vm = velocidad_media(valor2, vo);
                if (vm < 0) {
                    vm = (-1) * vm;
                }
                d = producto(vm, valor4);

                r.putExtra("id", 8);
                r.putExtra("dv", dv);
                r.putExtra("vm", vm);
                r.putExtra("vo", vo);
                r.putExtra("d", d);
                r.putExtra("a", valor5);
                r.putExtra("t", valor4);
                r.putExtra("vf", valor2);
                r.putExtra("title", datos);
                startActivity(r);

            }
        }
    }
    public void caso9(View view) {
        if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed3.getText().toString().isEmpty()) {
            valor4 = conversor_Numero(ed4.getText().toString());
            valor5 = conversor_Numero(ed5.getText().toString());
            if (valor4 <= 0) {
                dialogo_alerta_tiempo(view).show();
            } else {
                Intent b = new Intent(this, Resultados_Cinematica.class);
                dv = producto(valor4, valor5);
                b.putExtra("id", 12);
                b.putExtra("dv", dv);
                b.putExtra("t", valor4);
                b.putExtra("a", valor5);
                b.putExtra("title", datos);
                startActivity(b);
            }
        } else if (ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed5.getText().toString().isEmpty()) {

            valor4 = conversor_Numero(ed4.getText().toString());
            valor3 = conversor_Numero(ed3.getText().toString());
            if ((valor4 <= 0 & valor3 <= 0) || valor4 <= 0 || valor3 <= 0) {
                dialogo_alerta_tiempo(view).show();
            } else {
                Intent b = new Intent(this, Resultados_Cinematica.class);
                vm = division(valor3, valor4);
                b.putExtra("id", 13);
                b.putExtra("vm", vm);
                b.putExtra("d", d);
                b.putExtra("t", t);
                b.putExtra("title", datos);
                startActivity(b);
            }
        } else {
            valor3 = conversor_Numero(ed3.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            valor5 = conversor_Numero(ed5.getText().toString());
            if ((valor3 < 0 & valor4 < 0) || valor3 < 0 || valor4 < 0) {
                dialogo_alerta_Desplazamiento_Tiempo(view).show();
            } else if (valor3 < 0) {
                dialogo_alerta_Desplazamiento_Tiempo(view).show();
            } else if (valor4 < 0) {
                dialogo_alerta_Desplazamiento_Tiempo(view).show();
            } else {
                if (valor3 == 0 & valor4 == 0 & valor5 == 0) {
                    dialogo_alerta_reposo(view).show();
                } else if (valor3 == 0 & valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor3 == 0 & valor5 == 0) {
                    dialogo_alerta_reposo(view).show();
                } else if (valor3 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor4 == 0 & valor5 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor4 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else {
                    Intent s = new Intent(this, Resultados_Cinematica.class);
                    vm = division(valor3, valor4);
                    vo = (valor3 - (0.5 * valor5 * Math.pow(valor4, 2))) / valor4;
                    vf = 2 * vm - vo;
                    dv = vf - vo;
                    s.putExtra("id", 9);
                    s.putExtra("dv", dv);
                    s.putExtra("vm", vm);
                    s.putExtra("vo", vo);
                    s.putExtra("vf", vf);
                    s.putExtra("d", valor3);
                    s.putExtra("t", valor4);
                    s.putExtra("a", valor5);
                    s.putExtra("title", datos);
                    startActivity(s);
                }
            }
        }
    }
    public void caso10(View view) {
        if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed3.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor3 = conversor_Numero(ed3.getText().toString());
            valor5 = conversor_Numero(ed5.getText().toString());
            if (valor3 < 0) {
                dialogo_alerta_desplazamientos(view).show();
            } else {
                if (valor1 == 0 & valor3 == 0 & valor5 == 0) {
                    dialogo_alerta_reposo(view).show();
                } else if (valor1 == 0 & valor3 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor1 == 0 & valor5 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor3 == 0 & valor5 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else if (valor3 == 0) {
                    dialogo_alerta_SinMovimiento(view).show();
                } else {
                    if (discriminanteSuma(valor1, valor3, valor5) < 0) {
                        dialogo_alerta_SinMovimiento(view).show();
                    } else {
                        Intent w = new Intent(this, Resultados_Cinematica.class);
                        vf = raiz_suma(valor1, valor3, valor5);
                        dv = vf - valor1;
                        vm = velocidad_media(valor1, vf);
                        if (vm < 0) {
                            vm = (-1) * vm;
                        }
                        t = division(valor3, vm);

                        w.putExtra("id", 10);
                        w.putExtra("dv", dv);
                        w.putExtra("vm", vm);
                        w.putExtra("vf", vf);
                        w.putExtra("t", t);
                        w.putExtra("vo", valor1);
                        w.putExtra("d", valor3);
                        w.putExtra("a", valor5);

                        w.putExtra("title", datos);
                        startActivity(w);

                    }

                }
            }
        }
    }
    public void caso11(View view) {
        if (ed1.getText().toString().isEmpty() & ed2.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor1 = conversor_Numero(ed1.getText().toString());
            valor2 = conversor_Numero(ed2.getText().toString());
            Intent x = new Intent(this, Resultados_Cinematica.class);
            vm = velocidad_media(valor1, valor2);
            dv = variacion_velocidad(valor2, valor1);

            x.putExtra("id", 11);
            x.putExtra("dv", dv);
            x.putExtra("vm", vm);
            x.putExtra("title", datos);
            //envio de datos
            x.putExtra("vo", valor1);
            x.putExtra("vf", valor2);
            startActivity(x);

        }
    }
    public void caso12(View view) {
        if (ed4.getText().toString().isEmpty() & ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed4.getText().toString().isEmpty() || ed5.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor5 = conversor_Numero(ed5.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            if (valor4 < 0) {
                dialogo_alerta_tiempo(view).show();
            } else {
                Intent y = new Intent(this, Resultados_Cinematica.class);
                dv = producto(valor4, valor5);

                y.putExtra("id", 12);
                y.putExtra("dv", dv);
                y.putExtra("title", datos);
                y.putExtra("t", valor4);
                y.putExtra("a", valor5);
                startActivity(y);

            }
        }
    }
    public void caso13(View view) {
        if (ed3.getText().toString().isEmpty() & ed4.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else if (ed4.getText().toString().isEmpty() || ed3.getText().toString().isEmpty()) {
            dialogo_alerta_magnitudes(view).show();
        } else {
            valor3 = conversor_Numero(ed3.getText().toString());
            valor4 = conversor_Numero(ed4.getText().toString());
            if ((valor4 <= 0 & valor3 <= 0) || valor4 <= 0 || valor3 <= 0) {
                dialogo_alerta_Desplazamiento_Tiempo(view).show();
            } else {
                Intent y = new Intent(this, Resultados_Cinematica.class);
                vm = division(valor3, valor4);

                y.putExtra("id", 13);
                y.putExtra("vm", vm);
                y.putExtra("title", datos);
                //envio de datos
                y.putExtra("t", valor4);
                y.putExtra("d", valor3);
                startActivity(y);

            }
        }
    }

    //metodos para los calculos matematicos
    public Double conversor_Numero(String e) {
            return Double.parseDouble(e);
        }
    public double velocidad_media(double a, double b) {
        return ((a + b) / 2);
    }
    public double variacion_velocidad(double a, double b) {
        return (a - b);
    }
    public double division(double a, double b) {
        return a / b;
    }
    public double producto(double a, double b) {
        return a * b;
    }
    public double discriminanteResta(double a, double b, double c) {
        double rd = (Math.pow(a, 2)) - (2 * b * c);
        return rd;
    }
    public double discriminanteSuma(double a, double b, double c) {
        double rd = (Math.pow(a, 2)) + (2 * b * c);
        return rd;
    }
    public double raiz_resta(double a, double b, double c) {
        double r = (Math.pow(a, 2)) - (2 * b * c);
        return Math.sqrt(r);
    }
    public double raiz_suma(double a, double b, double c) {
        double r = (Math.pow(a, 2)) + (2 * b * c);
        return Math.sqrt(r);
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
                ed4.setText("");
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_desplazamientos(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("El desplazamiento angular Δθ contempla cambios de posición angular.\n" +
                "Ingrese un nuevo valor.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ed3.setText("");
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_velocidadesNulasconTiempo(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("El objeto esta en estado de reposo.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ed4.setText("");
                ed1.setText("");
                ed2.setText("");
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_reposo(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("El objeto esta en reposo, no existe variación de la velocidad angular.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ed3.setText("");
                ed4.setText("");
                ed1.setText("");
                ed2.setText("");
                ed5.setText("");
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_aceleracionCasoDesacelerado(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("Cambie el signo de la aceleración.\n" +
                "El movimiento es desacelerado, la velocidad inicial es mayor que la velocidad final.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_aceleracionCasoAcelerado(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("Cambie el signo de la aceleración.\n" +
                "El movimiento es acelerado, la velocidad inicial es menor que la velocidad final.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
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
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_Desplazamiento_Tiempo(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("El tiempo y el desplazamiento angular son magnitudes positivas.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ed3.setText("");
                ed4.setText("");
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_DatosExcesivos(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("Solo se necesita 3 magnitudes físicas para proceder a los cálculos.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_Movimiento_Especial_Acelerado_Desacelerado_caso1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("Cuando ω (velocidad angular) inicial o final son inversas, el desplazamiento Δθ siempre es cero por defecto.\n" +
                "Ingrese otra magnitud física. ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ed3.setText("");
                dialog.cancel();
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_Movimiento_Especial_Acelerado_Desacelerado_caso2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("Para este caso, el desplazamiento angular Δθ siempre es cero por defecto.\n" +
                "Ingrese otra magnitud física. ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ed3.setText("");
                dialog.cancel();
                // Snackbar.make(view, "Alerta",Snackbar.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
    public Dialog dialogo_alerta_DESACELERACION(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TemaDialogoAlertas);
        //builder.setTitle("Información");
        builder.setMessage("El movimiento es desacelerado, cambie el signo de la aceleración angular α.\n");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ed3.setText("");
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


