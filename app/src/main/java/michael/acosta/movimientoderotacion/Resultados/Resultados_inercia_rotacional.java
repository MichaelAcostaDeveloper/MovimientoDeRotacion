package michael.acosta.movimientoderotacion.Resultados;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.ProcesosInerciaRotacional.Proceso_calculo_inercia_caso_especial;
import michael.acosta.movimientoderotacion.ProcesosInerciaRotacional.Proceso_calculo_inercia_objetos;
import michael.acosta.movimientoderotacion.ProcesosInerciaRotacional.Proceso_calculo_masa_caso_especial;
import michael.acosta.movimientoderotacion.ProcesosInerciaRotacional.Proceso_calculo_masa_objetos;
import michael.acosta.movimientoderotacion.ProcesosInerciaRotacional.Proceso_calculo_radio_objetos;
import michael.acosta.movimientoderotacion.R;


public class Resultados_inercia_rotacional extends AppCompatActivity {
    TextView res,magnitud,unidad;
    String datos;
    ImageView imag;
    double masa,r,I,r_1,r_2,a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        datos = getIntent().getStringExtra("title");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_resultados_inercia_rotacional);

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



        imag = (ImageView) findViewById(R.id.imagen1);

        //recoleccion de datos del parametros angulares
        Intent recibir = getIntent();
        int caso = recibir.getIntExtra("id", 0);
        switch (caso) {
            case 1:
                res = (TextView) findViewById(R.id.resultado1);
                magnitud = (TextView) findViewById(R.id.m1);
                unidad = (TextView) findViewById(R.id.unidad1);
                I = getIntent().getDoubleExtra("I", 0);
                masa = getIntent().getDoubleExtra("m", 0);
                r = getIntent().getDoubleExtra("r", 0);

                magnitud.setText("Inercia rotacional");
                res.setText(String.format("%.3f", I));
                unidad.setText(Html.fromHtml("[kg·m²]"));

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent recibir = getIntent();
                        int subcaso = recibir.getIntExtra("subcaso", 0);
                        switch (subcaso){
                            case 1:
                                procesoInercia1(v);//cilindro solido
                            break;
                            case 2:
                                procesoInercia2(v);//esfera solida
                                break;
                            case 3:
                                procesoInercia3(v);//esfera anular
                                break;
                            case 4:
                                procesoInercia4(v);//varilla ejecentral
                                break;
                            case 5:
                                procesoInercia5(v);//varilla extremo
                                break;
                            case 6:

                                procesoInercia6(v);
                                break;
                            case 7:

                                procesoInercia7(v);
                                break;
                        }

                    }
                });
                break;
            case 2:
                I = getIntent().getDoubleExtra("I", 0);
                masa = getIntent().getDoubleExtra("m", 0);
                r = getIntent().getDoubleExtra("r", 0);
                res = (TextView) findViewById(R.id.resultado1);
                magnitud = (TextView) findViewById(R.id.m1);
                unidad = (TextView) findViewById(R.id.unidad1);
                magnitud.setText("Radio");
                res.setText(String.format("%.3f", r));
                unidad.setText(Html.fromHtml("[m]"));

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent recibir = getIntent();
                        int subcaso = recibir.getIntExtra("subcaso", 0);
                        switch (subcaso){
                            case 1:
                                procesoRadio1(v);
                                break;
                            case 2:
                                procesoRadio2(v);
                                break;
                            case 3:
                                procesoRadio3(v);
                                break;
                            case 4:
                                procesoRadio4(v);
                                break;
                            case 5:
                                procesoRadio5(v);
                                break;
                            case 6:
                                procesoRadio6(v);
                                break;
                            case 7:
                                procesoRadio7(v);
                                break;
                        }
                    }
                });
                break;

            case 3:
                I = getIntent().getDoubleExtra("I", 0);
                masa = getIntent().getDoubleExtra("m", 0);
                r = getIntent().getDoubleExtra("r", 0);
                res = (TextView) findViewById(R.id.resultado1);
                magnitud = (TextView) findViewById(R.id.m1);
                unidad = (TextView) findViewById(R.id.unidad1);
                magnitud.setText("Masa");
                res.setText(String.format("%.3f", masa));
                unidad.setText(Html.fromHtml("[Kg]"));

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent recibir = getIntent();
                        int subcaso = recibir.getIntExtra("subcaso", 0);
                        switch (subcaso){
                            case 1:
                                procesoMasa1(v);
                                break;
                            case 2:
                                procesoMasa2(v);
                                break;
                            case 3:
                                procesoMasa3(v);
                                break;
                            case 4:
                                procesoMasa4(v);
                                break;
                            case 5:
                                procesoMasa5(v);
                                break;
                            case 6:
                                procesoMasa6(v);
                                break;
                            case 7:
                                procesoMasa7(v);
                                break;
                        }
                    }
                });
                break;
            case 4:
                res = (TextView) findViewById(R.id.resultado1);
                magnitud = (TextView) findViewById(R.id.m1);
                unidad = (TextView) findViewById(R.id.unidad1);
                I = getIntent().getDoubleExtra("I", 0);
                masa = getIntent().getDoubleExtra("m", 0);
                r_1 = getIntent().getDoubleExtra("r1", 0);
                r_2 = getIntent().getDoubleExtra("r2", 0);
                magnitud.setText("Inercia rotacional");
                res.setText(String.format("%.3f", I));
                unidad.setText(Html.fromHtml("[kg·m²]"));

                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoInerciaCilindroHueco(v);
                    }
                });
                break;
            case 5:
                res = (TextView) findViewById(R.id.resultado1);
                magnitud = (TextView) findViewById(R.id.m1);
                unidad = (TextView) findViewById(R.id.unidad1);
                I = getIntent().getDoubleExtra("I", 0);
                masa = getIntent().getDoubleExtra("m", 0);
                r_1 = getIntent().getDoubleExtra("r1", 0);
                r_2 = getIntent().getDoubleExtra("r2", 0);
                magnitud.setText("Masa");
                res.setText(String.format("%.3f", masa));
                unidad.setText(Html.fromHtml("[kg]"));
                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMasaCilindroHueco(v);
                    }
                });
                break;
            case 6:
                res = (TextView) findViewById(R.id.resultado1);
                magnitud = (TextView) findViewById(R.id.m1);
                unidad = (TextView) findViewById(R.id.unidad1);
                I = getIntent().getDoubleExtra("I", 0);
                masa = getIntent().getDoubleExtra("m", 0);
                a = getIntent().getDoubleExtra("a", 0);
                b = getIntent().getDoubleExtra("b", 0);
                magnitud.setText("Inercia rotacional");
                res.setText(String.format("%.3f", I));
                unidad.setText(Html.fromHtml("[kg·m²]"));
                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoInerciaPlaca(v);
                    }
                });
                break;
            case 7:
                res = (TextView) findViewById(R.id.resultado1);
                magnitud = (TextView) findViewById(R.id.m1);
                unidad = (TextView) findViewById(R.id.unidad1);
                I = getIntent().getDoubleExtra("I", 0);
                masa = getIntent().getDoubleExtra("m", 0);
                a = getIntent().getDoubleExtra("a", 0);
                b = getIntent().getDoubleExtra("b", 0);
                magnitud.setText("Masa");
                res.setText(String.format("%.3f", I));
                unidad.setText(Html.fromHtml("[kg]"));
                //metodos a ejecutarse
                imag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMasaPlaca(v);
                    }
                });
                break;
        }
    }
    //metodos de procesos para los casos
    public void procesoMasa1(View view){
        Intent T = new Intent(this, Proceso_calculo_masa_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",1);
        startActivity(T);
    }
    public void procesoMasa2(View view){
        Intent T = new Intent(this, Proceso_calculo_masa_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",2);
        startActivity(T);
    }
    public void procesoMasa3(View view){
        Intent T = new Intent(this, Proceso_calculo_masa_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",3);
        startActivity(T);
    }
    public void procesoMasa4(View view){
        Intent T = new Intent(this, Proceso_calculo_masa_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",4);
        startActivity(T);
    }
    public void procesoMasa5(View view){
        Intent T = new Intent(this, Proceso_calculo_masa_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",5);
        startActivity(T);
    }
    public void procesoMasa6(View view){
        Intent T = new Intent(this, Proceso_calculo_masa_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",6);
        startActivity(T);
    }
    public void procesoMasa7(View view){
        Intent T = new Intent(this, Proceso_calculo_masa_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",7);
        startActivity(T);
    }
    public void procesoRadio1(View view){
        Intent T = new Intent(this, Proceso_calculo_radio_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",1);
        startActivity(T);
    }
    public void procesoRadio2(View view){
        Intent T = new Intent(this, Proceso_calculo_radio_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",2);
        startActivity(T);
    }
    public void procesoRadio3(View view){
        Intent T = new Intent(this, Proceso_calculo_radio_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",3);
        startActivity(T);
    }
    public void procesoRadio4(View view){
        Intent T = new Intent(this, Proceso_calculo_radio_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",4);
        startActivity(T);
    }
    public void procesoRadio5(View view){
        Intent T = new Intent(this, Proceso_calculo_radio_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",5);
        startActivity(T);
    }
    public void procesoRadio6(View view){
        Intent T = new Intent(this, Proceso_calculo_radio_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",6);
        startActivity(T);
    }
    public void procesoRadio7(View view){
        Intent T = new Intent(this, Proceso_calculo_radio_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",7);
        startActivity(T);
    }
    public void procesoInercia1(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",1);
        startActivity(T);
    }
    public void procesoInercia2(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",2);
        startActivity(T);
    }
    public void procesoInercia3(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",3);
        startActivity(T);}
        public void procesoInercia4(View view){
            Intent T = new Intent(this, Proceso_calculo_inercia_objetos.class);//cambiar la clase
            T.putExtra("titulo",datos);
            T.putExtra("m",masa);
            T.putExtra("I",I);
            T.putExtra("r",r);
            T.putExtra("objeto",4);
            startActivity(T);
    }
    public void procesoInercia5(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",5);
        startActivity(T);
    }
    public void procesoInercia6(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",6);
        startActivity(T);
    }
    public void procesoInercia7(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia_objetos.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("m",masa);
        T.putExtra("I",I);
        T.putExtra("r",r);
        T.putExtra("objeto",7);
        startActivity(T);
    }

    public void procesoInerciaCilindroHueco(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia_caso_especial.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("I",I);
        T.putExtra("r1",r_1);
        T.putExtra("r2",r_2);
        T.putExtra("m",masa);
        T.putExtra("c",1);
        startActivity(T);
    }

    public void procesoInerciaPlaca(View view){
        Intent T = new Intent(this, Proceso_calculo_inercia_caso_especial.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("I",I);
        T.putExtra("a",a);
        T.putExtra("b",b);
        T.putExtra("m",masa);
        T.putExtra("c",2);
        startActivity(T);
    }

    public void procesoMasaCilindroHueco(View view){
        Intent T = new Intent(this, Proceso_calculo_masa_caso_especial.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("I",I);
        T.putExtra("r1",r_1);
        T.putExtra("r2",r_2);
        T.putExtra("m",masa);
        T.putExtra("c",1);
        startActivity(T);
    }
    public void procesoMasaPlaca(View view){
        Intent T = new Intent(this, Proceso_calculo_masa_caso_especial.class);//cambiar la clase
        T.putExtra("titulo",datos);
        T.putExtra("I",I);
        T.putExtra("a",a);
        T.putExtra("b",b);
        T.putExtra("m",masa);
        T.putExtra("c",2);
        startActivity(T);
    }


}
