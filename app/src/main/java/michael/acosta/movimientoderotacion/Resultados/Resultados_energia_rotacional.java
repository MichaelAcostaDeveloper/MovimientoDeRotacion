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

import michael.acosta.movimientoderotacion.ProcesosEnergiaRotacional.Proceso_calculo_energia;
import michael.acosta.movimientoderotacion.ProcesosEnergiaRotacional.Proceso_calculo_inercia;
import michael.acosta.movimientoderotacion.ProcesosEnergiaRotacional.Proceso_calculo_velocidad;
import michael.acosta.movimientoderotacion.ProcesosEnergiaRotacional.Proceso_variacion_energia;
import michael.acosta.movimientoderotacion.ProcesosEnergiaRotacional.Proceso_variacion_velocidad;
import michael.acosta.movimientoderotacion.R;

public class Resultados_energia_rotacional extends AppCompatActivity {
    TextView res,m,unidad;
    TableRow et1,et2,et3;
    View li1;
    String datos;
    ImageView imag;
    double wo,wf,dw,Eo,Ef,dE,I;

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
                Eo = getIntent().getDoubleExtra("Eo", 0);
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
                Eo = getIntent().getDoubleExtra("Eo", 0);
                res.setText(String.format("%.3f", Eo));
                m.setText("Energía cinética inicial");

                unidad.setText(Html.fromHtml("[J]"));
                //recoleccion de datos

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoEnergia1(v);
                    }
                });
                break;
            case 4:
                wf = getIntent().getDoubleExtra("wf", 0);
                Ef = getIntent().getDoubleExtra("Ef", 0);
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
                Ef = getIntent().getDoubleExtra("Ef", 0);
                m.setText("Energía cinética final");
                res.setText(String.format("%.3f", Ef));
                unidad.setText(Html.fromHtml("[J]"));
                //recoleccion de datos

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoEnergia2(v);
                    }
                });
                break;
            case 6:
                Ef = getIntent().getDoubleExtra("Ef", 0);
                Eo = getIntent().getDoubleExtra("Eo", 0);
                dE = getIntent().getDoubleExtra("dE", 0);
                m.setText("Variación de la energía cinética ");
                res.setText(String.format("%.3f", dE));
                unidad.setText(Html.fromHtml("[J]"));
                //recoleccion de datos

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoTrabajo(v);
                    }
                });
                break;
            case 7:
                Eo = getIntent().getDoubleExtra("Eo", 0);
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
                Ef = getIntent().getDoubleExtra("Ef", 0);
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
    public void procesoTrabajo(View view){
        Intent T = new Intent(this, Proceso_variacion_energia.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("Eo",Eo);
        T.putExtra("Ef",Ef);
        T.putExtra("dE",dE);
        startActivity(T);
    }
    public void procesoEnergia1(View view){
        Intent T = new Intent(this, Proceso_calculo_energia.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("wo",wo);
        T.putExtra("I",I);
        T.putExtra("Eo",Eo);
        T.putExtra("c",1);//caso de aplicacion
        startActivity(T);
    }
    public void procesoEnergia2(View view){
        Intent T = new Intent(this, Proceso_calculo_energia.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("wf",wf);
        T.putExtra("I",I);
        T.putExtra("Ef",Ef);
        T.putExtra("c",2);//caso de aplicacion
        startActivity(T);
    }
    public void procesoVelocidad1(View view){
        Intent T = new Intent(this, Proceso_calculo_velocidad.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("Eo",Eo);
        T.putExtra("I",I);
        T.putExtra("wo",wo);
        T.putExtra("c",1);//caso de aplicacion
        startActivity(T);
    }
    public void procesoVelocidad2(View view){
        Intent T = new Intent(this, Proceso_calculo_velocidad.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("Ef",Ef);
        T.putExtra("I",I);
        T.putExtra("wf",wf);
        T.putExtra("c",2);//caso de aplicacion
        startActivity(T);
    }
    public void procesoInercia1(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("Eo",Eo);
        T.putExtra("wo",wo);
        T.putExtra("I",I);
        T.putExtra("c",1);//caso de aplicacion
        startActivity(T);
    }
    public void procesoInercia2(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("Ef",Ef);
        T.putExtra("wf",wf);
        T.putExtra("I",I);
        T.putExtra("c",2);//caso de aplicacion
        startActivity(T);
    }
    public void procesoVariacionVelocidad(View view){
        Intent T = new Intent(this, Proceso_variacion_velocidad    .class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("wo",wo);
        T.putExtra("wf",wf);
        T.putExtra("dw",dw);
        startActivity(T);
    }
}
