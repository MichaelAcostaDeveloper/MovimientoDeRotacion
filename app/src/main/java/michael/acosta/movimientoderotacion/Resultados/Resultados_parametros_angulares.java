package michael.acosta.movimientoderotacion.Resultados;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.ProcesosParametrosAngulares.ProcesoFrecuencia1;
import michael.acosta.movimientoderotacion.ProcesosParametrosAngulares.ProcesoFrecuencia2;
import michael.acosta.movimientoderotacion.ProcesosParametrosAngulares.ProcesoPeriodo1;
import michael.acosta.movimientoderotacion.ProcesosParametrosAngulares.ProcesoPeriodo2;
import michael.acosta.movimientoderotacion.ProcesosParametrosAngulares.ProcesoVelocidadAngular1;
import michael.acosta.movimientoderotacion.ProcesosParametrosAngulares.ProcesoVelocidadAngular2;
import michael.acosta.movimientoderotacion.R;

public class Resultados_parametros_angulares extends AppCompatActivity {

    TextView res1,res2,res3,m1,m2,m3,i1,i2,i3;
    TableRow et1,et2,et3,et4,et5,et6,et7,et8;
    View li1,li2,li3;
    String datos;
    ImageView imag1,imag2,imag3;
    double f,T,w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        datos = getIntent().getStringExtra("title");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_resultados_parametros_angulares);

        Toolbar tt = (Toolbar) findViewById(R.id.toolbar2);
        tt.setTitle(datos);
        tt.setSubtitle("Resultados");
        setSupportActionBar(tt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tt.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        et1=(TableRow)findViewById(R.id.row1);
        et2=(TableRow)findViewById(R.id.row2);
        et3=(TableRow)findViewById(R.id.row3);
        et4=(TableRow)findViewById(R.id.row4);
        et5=(TableRow)findViewById(R.id.row5);
        et6=(TableRow)findViewById(R.id.row6);
        et7=(TableRow)findViewById(R.id.row7);
        et8=(TableRow)findViewById(R.id.row8);


        li1 = (View) findViewById(R.id.linea1);
        li2 = (View) findViewById(R.id.linea2);
        li3 = (View) findViewById(R.id.linea3);

        res1 = (TextView) findViewById(R.id.textResultado1);
        res2 = (TextView) findViewById(R.id.textResultado2);
        res3 = (TextView) findViewById(R.id.textResultado3);

        m1 = (TextView) findViewById(R.id.m1);
        m2 = (TextView) findViewById(R.id.m2);
        m3 = (TextView) findViewById(R.id.m3);

        i1 = (TextView) findViewById(R.id.i1);
        i2 = (TextView) findViewById(R.id.i2);
        i3 = (TextView) findViewById(R.id.i3);

        imag1 = (ImageView) findViewById(R.id.imagen1);
        imag2 = (ImageView) findViewById(R.id.imagen2);
        imag3 = (ImageView) findViewById(R.id.imagen3);

        //recoleccion de datos del parametros angulares
        Intent recibir = getIntent();
        int caso = recibir.getIntExtra("id", 0);
        switch (caso) {
            case 1:
                f = getIntent().getDoubleExtra("f", 0);
                w = getIntent().getDoubleExtra("w", 0);
                m2.setText("Frecuencia");
                res2.setText(String.format("%.3f", f));
                i2.setText(Html.fromHtml("[hertz]"));
                m3.setText("Velocidad angular");
                res3.setText(String.format("%.3f", w));
                i3.setText("[rad/s]");
                et1.removeAllViews();
                et2.removeAllViews();
                //recoleccion de datos del parametros angulares
                T = getIntent().getDoubleExtra("T", 0);
                //metodos a ejecutarse
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoFrecuencia1(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadAngular1(v);
                    }
                });
                break;
            case 2:
                T = getIntent().getDoubleExtra("T", 0);
                w = getIntent().getDoubleExtra("w", 0);
                m1.setText("Periodo");
                res1.setText(String.format("%.3f", T));
                i1.setText(Html.fromHtml("[s]"));
                m3.setText("Velocidad angular");
                res3.setText(String.format("%.3f", w));
                i3.setText("[rad/s]");
                et4.removeAllViews();
                et5.removeAllViews();
                et3.removeAllViews();
                //recoleccion de datos del parametros angulares
                f = getIntent().getDoubleExtra("f", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoPeriodo1(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadAngular2(v);
                    }
                });
                break;
            case 3:
                f = getIntent().getDoubleExtra("f", 0);
                T = getIntent().getDoubleExtra("T", 0);
                m1.setText("Periodo");
                res1.setText(String.format("%.3f", T));
                i1.setText(Html.fromHtml("[s]"));
                m2.setText("Frecuencia");
                res2.setText(String.format("%.3f", f));
                i2.setText("[hertz]");
                et7.removeAllViewsInLayout();
                et8.removeAllViewsInLayout();

                //recoleccion de datos del parametros angulares
                w = getIntent().getDoubleExtra("w", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoPeriodo2(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoFrecuencia2(v);
                    }
                });
                break;
        }
    }
    //metodos de procesos para los 3 casos
    public void procesoPeriodo1(View view){
        Intent T1 = new Intent(this, ProcesoPeriodo1.class);
        T1.putExtra("titulo",datos);
        T1.putExtra("f",f);
        T1.putExtra("T",T);
        T1.putExtra("w",w);
        startActivity(T1);
    }
        public void procesoPeriodo2(View view){
            Intent T2 = new Intent(this, ProcesoPeriodo2.class);
            T2.putExtra("titulo",datos);
            T2.putExtra("f",f);
            T2.putExtra("T",T);
            T2.putExtra("w",w);
            startActivity(T2);
        }
        public void procesoFrecuencia1(View view){
            Intent f1 = new Intent(this, ProcesoFrecuencia1.class);
            f1.putExtra("titulo",datos);
            f1.putExtra("f",f);
            f1.putExtra("T",T);
            f1.putExtra("w",w);
            startActivity(f1);
        }
        public void procesoFrecuencia2(View view){
            Intent f2 = new Intent(this, ProcesoFrecuencia2.class);
            f2.putExtra("titulo",datos);
            f2.putExtra("f",f);
            f2.putExtra("T",T);
            f2.putExtra("w",w);
            startActivity(f2);
        }
        public void procesoVelocidadAngular1(View view){
            Intent v1 = new Intent(this, ProcesoVelocidadAngular1.class);
            v1.putExtra("titulo",datos);
            v1.putExtra("f",f);
            v1.putExtra("T",T);
            v1.putExtra("w",w);
            startActivity(v1);
        }
        public void procesoVelocidadAngular2(View view){
            Intent v2 = new Intent(this, ProcesoVelocidadAngular2.class);
            v2.putExtra("titulo",datos);
            v2.putExtra("f",f);
            v2.putExtra("T",T);
            v2.putExtra("w",w);
            startActivity(v2);
        }

}
