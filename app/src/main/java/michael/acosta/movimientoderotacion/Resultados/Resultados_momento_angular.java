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

import michael.acosta.movimientoderotacion.ProcesosMomentoAngular.Proceso_calculo_impulso;
import michael.acosta.movimientoderotacion.ProcesosMomentoAngular.Proceso_calculo_inercia;
import michael.acosta.movimientoderotacion.ProcesosMomentoAngular.Proceso_calculo_velocidad;
import michael.acosta.movimientoderotacion.ProcesosMomentoAngular.Proceso_variacion_velocidad;
import michael.acosta.movimientoderotacion.ProcesosMomentoAngular.Proceso_calculo_momento;
import michael.acosta.movimientoderotacion.R;

public class Resultados_momento_angular extends AppCompatActivity {
    TextView res,m,unidad;
    TableRow et1,et2,et3;
    View li1;
    String datos;
    ImageView imag;
    double wo,wf,dw,Lo,Lf,dL,I;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        datos = getIntent().getStringExtra("title");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_resultados_energia_rotacional);

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

        li1 = (View) findViewById(R.id.linea1);
        res = (TextView) findViewById(R.id.Resultado);
        m = (TextView) findViewById(R.id.m);
        unidad = (TextView) findViewById(R.id.unidad);
        imag = (ImageView) findViewById(R.id.imagen);

        //recoleccion de datos del parametros angulares
        Intent recibir = getIntent();
        int caso = recibir.getIntExtra("id", 0);
        switch (caso) {
            case 1:
                wo = getIntent().getDoubleExtra("wo", 0);
                wf = getIntent().getDoubleExtra("wf", 0);
                dw = getIntent().getDoubleExtra("dw", 0);
                m.setText("Variación de la velocidad angular");
                res.setText(String.format("%.3f", dw));
                unidad.setText(Html.fromHtml("[rad/s]"));

                //recoleccion de datos

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVariacionVelocidad(v);
                    }
                });
                break;
            case 2:
                wo = getIntent().getDoubleExtra("wo", 0);
                Lo = getIntent().getDoubleExtra("Lo", 0);
                I = getIntent().getDoubleExtra("I", 0);
                m.setText("Inercia rotacional");
                res.setText(String.format("%.3f", I));
                unidad.setText(Html.fromHtml("[kg·m²]"));

                //recoleccion de datos

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoInercia1(v);
                    }
                });
                break;

            case 3:
                wo = getIntent().getDoubleExtra("wo", 0);
                I = getIntent().getDoubleExtra("I", 0);
                Lo = getIntent().getDoubleExtra("Lo", 0);
                res.setText(String.format("%.3f", Lo));
                m.setText("Momentum rotacional inicial");

                unidad.setText(Html.fromHtml("kg·m²/s"));
                //recoleccion de datos

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMomento1(v);
                    }
                });
                break;
            case 4:
                wf = getIntent().getDoubleExtra("wf", 0);
                Lf = getIntent().getDoubleExtra("Lf", 0);
                I = getIntent().getDoubleExtra("I", 0);
                m.setText("Inercia rotacional");
                res.setText(String.format("%.3f", I));
                unidad.setText(Html.fromHtml("[kg·m²]"));
                //recoleccion de datos

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoInercia2(v);
                    }
                });
                break;
            case 5:
                wf = getIntent().getDoubleExtra("wf", 0);
                I = getIntent().getDoubleExtra("I", 0);
                Lf = getIntent().getDoubleExtra("Lf", 0);
                m.setText("Momentum rotacional final");
                res.setText(String.format("%.3f", Lf));
                unidad.setText(Html.fromHtml("kg·m²/s"));
                //recoleccion de datos

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMomento2(v);
                    }
                });
                break;
            case 6:
                Lf = getIntent().getDoubleExtra("Lf", 0);
                Lo = getIntent().getDoubleExtra("Lo", 0);
                dL = getIntent().getDoubleExtra("dL", 0);
                m.setText("Impulso rotacional ");
                res.setText(String.format("%.3f", dL));
                unidad.setText(Html.fromHtml("kg·m²/s"));
                //recoleccion de datos

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoImpulso(v);
                    }
                });
                break;
            case 7:
                Lo = getIntent().getDoubleExtra("Lo", 0);
                I = getIntent().getDoubleExtra("I", 0);
                wo = getIntent().getDoubleExtra("wo", 0);
                m.setText("Velocidad angular inicial");
                res.setText(String.format("%.3f", wo));
                unidad.setText(Html.fromHtml("[rad/s]"));
                //recoleccion de datos

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidad1(v);
                    }
                });
                break;
            case 8:
                Lf = getIntent().getDoubleExtra("Lf", 0);
                I = getIntent().getDoubleExtra("I", 0);
                wf = getIntent().getDoubleExtra("wf", 0);
                m.setText("Velocidad angular final");
                res.setText(String.format("%.3f", wf));
                unidad.setText(Html.fromHtml("[rad/s]"));
                //recoleccion de datos

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidad2(v);
                    }
                });
                break;
        }
    }
    //metodos de procesos para los casos
    public void procesoImpulso(View view){
        Intent T = new Intent(this, Proceso_calculo_impulso.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("Lo",Lo);
        T.putExtra("Lf",Lf);
        T.putExtra("dL",dL);
        startActivity(T);
    }
    public void procesoMomento1(View view){
        Intent T = new Intent(this, Proceso_calculo_momento.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("wo",wo);
        T.putExtra("I",I);
        T.putExtra("Lo",Lo);
        T.putExtra("c",1);//caso de aplicacion
        startActivity(T);
    }
    public void procesoMomento2(View view){
        Intent T = new Intent(this, Proceso_calculo_momento.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("wf",wf);
        T.putExtra("I",I);
        T.putExtra("Lf",Lf);
        T.putExtra("c",2);//caso de aplicacion
        startActivity(T);
    }
    public void procesoVelocidad1(View view){
        Intent T = new Intent(this, Proceso_calculo_velocidad.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("Lo",Lo);
        T.putExtra("I",I);
        T.putExtra("wo",wo);
        T.putExtra("c",1);//caso de aplicacion
        startActivity(T);
    }
    public void procesoVelocidad2(View view){
        Intent T = new Intent(this, Proceso_calculo_velocidad.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("Lf",Lf);
        T.putExtra("I",I);
        T.putExtra("wf",wf);
        T.putExtra("c",2);//caso de aplicacion
        startActivity(T);
    }
    public void procesoInercia1(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("Lo",Lo);
        T.putExtra("wo",wo);
        T.putExtra("I",I);
        T.putExtra("c",1);//caso de aplicacion
        startActivity(T);
    }
    public void procesoInercia2(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("Lf",Lf);
        T.putExtra("wf",wf);
        T.putExtra("I",I);
        T.putExtra("c",2);//caso de aplicacion
        startActivity(T);
    }
    public void procesoVariacionVelocidad(View view){
        Intent T = new Intent(this, Proceso_variacion_velocidad.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("wo",wo);
        T.putExtra("wf",wf);
        T.putExtra("dw",dw);
        startActivity(T);
    }
}
