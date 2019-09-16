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

import michael.acosta.movimientoderotacion.ProcesosMomentoFuerza.ProcesoAceleracion;
import michael.acosta.movimientoderotacion.ProcesosMomentoFuerza.ProcesoFuerza;
import michael.acosta.movimientoderotacion.ProcesosMomentoFuerza.ProcesoInercia;
import michael.acosta.movimientoderotacion.ProcesosMomentoFuerza.ProcesoMasa;
import michael.acosta.movimientoderotacion.ProcesosMomentoFuerza.ProcesoRadio;
import michael.acosta.movimientoderotacion.ProcesosMomentoFuerza.ProcesoTorque;
import michael.acosta.movimientoderotacion.R;

public class Resultados_momento_fuerza extends AppCompatActivity {
    TextView res1, res2, res3, m1, m2, m3, i1, i2, i3;
    TableRow tab1, tab2, tab3, tab4, tab5, tab6, tab7, tab8;
    View li1, li2;
    String datos;
    ImageView imag1, imag2, imag3;
    double m, I, r, T, F, a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        datos = getIntent().getStringExtra("title");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_momento_fuerza);
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
        tab1 = (TableRow) findViewById(R.id.row1);
        tab2 = (TableRow) findViewById(R.id.row2);
        tab3 = (TableRow) findViewById(R.id.row3);
        li1 = (View) findViewById(R.id.linea1);
        tab4 = (TableRow) findViewById(R.id.row4);
        tab5 = (TableRow) findViewById(R.id.row5);
        tab6 = (TableRow) findViewById(R.id.row6);
        li2 = (View) findViewById(R.id.linea2);
        tab7 = (TableRow) findViewById(R.id.row7);
        tab8 = (TableRow) findViewById(R.id.row8);

        res1 = (TextView) findViewById(R.id.Resultado1);
        res2 = (TextView) findViewById(R.id.Resultado2);
        res3 = (TextView) findViewById(R.id.Resultado3);

        m1 = (TextView) findViewById(R.id.m1);
        m2 = (TextView) findViewById(R.id.m2);
        m3 = (TextView) findViewById(R.id.m3);

        i1 = (TextView) findViewById(R.id.unidad1);
        i2 = (TextView) findViewById(R.id.unidad2);
        i3 = (TextView) findViewById(R.id.unidad3);

        imag1 = (ImageView) findViewById(R.id.imagen1);
        imag2 = (ImageView) findViewById(R.id.imagen2);
        imag3 = (ImageView) findViewById(R.id.imagen3);
        //recoleccion de datos del CinematicaMovimiento
        Intent recibir = getIntent();
        int caso = recibir.getIntExtra("id", 0);
        switch (caso) {
            case 1:
                a = getIntent().getDoubleExtra("a", 0);
                r = getIntent().getDoubleExtra("r", 0);
                m = getIntent().getDoubleExtra("m", 0);
                m1.setText("Aceleracion angular");
                res1.setText(String.format("%.3f", a));
                i1.setText(Html.fromHtml("[rad/s<sup>2</sup>]"));
                m2.setText("Radio de giro");
                res2.setText(String.format("%.3f", r));
                i2.setText("[m]");
                m3.setText("Masa");
                res3.setText(String.format("%.3f", m));
                i3.setText("[kg]");
                //recoleccion de datos
                T = getIntent().getDoubleExtra("T", 0);
                F = getIntent().getDoubleExtra("F", 0);
                I = getIntent().getDoubleExtra("I", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoAceleracion(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoRadio(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMasa(v);
                    }
                });
                break;
            case 2:
                r = getIntent().getDoubleExtra("r", 0);
                I = getIntent().getDoubleExtra("I", 0);
                m = getIntent().getDoubleExtra("m", 0);
                m1.setText("Radio de giro");
                res1.setText(String.format("%.3f", r));
                i1.setText("[m]");
                m2.setText("Inercia rotacional");
                res2.setText(String.format("%.3f", I));
                i2.setText(Html.fromHtml("[kg.m<sup>2</sup>]"));
                m3.setText("Masa");
                res3.setText(String.format("%.3f", m));
                i3.setText("[kg]");
                //recoleccion de datos
                T = getIntent().getDoubleExtra("T", 0);
                F = getIntent().getDoubleExtra("F", 0);
                a = getIntent().getDoubleExtra("a", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoRadio(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoInercia(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMasa(v);
                    }
                });
                break;
            case 3:
                a = getIntent().getDoubleExtra("a", 0);
                m = getIntent().getDoubleExtra("m", 0);
                F = getIntent().getDoubleExtra("F", 0);
                m1.setText("Aceleracion angular");
                res1.setText(String.format("%.3f", a));
                i1.setText(Html.fromHtml("[rad/s<sup>2</sup>]"));
                m2.setText("Masa");
                res2.setText(String.format("%.3f", m));
                i2.setText("[kg]");
                m3.setText("Fuerza");
                res3.setText(String.format("%.3f", F));
                i3.setText("[N]");
                //recoleccion de datos
                T = getIntent().getDoubleExtra("T", 0);
                I = getIntent().getDoubleExtra("I", 0);
                r = getIntent().getDoubleExtra("r", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoAceleracion(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMasa(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoFuerza(v);
                    }
                });
                break;
            case 4:
                I = getIntent().getDoubleExtra("I", 0);
                F = getIntent().getDoubleExtra("F", 0);
                m = getIntent().getDoubleExtra("m", 0);
                m1.setText("Inercia rotacional");
                res1.setText(String.format("%.3f", I));
                i1.setText(Html.fromHtml("[kg.m<sup>2</sup>]"));
                m2.setText("Fuerza tangencial");
                res2.setText(String.format("%.3f", F));
                i2.setText("[N]");
                m3.setText("Masa");
                res3.setText(String.format("%.3f", m));
                i3.setText("[kg]");
                //recoleccion de datos
                T = getIntent().getDoubleExtra("T", 0);
                r = getIntent().getDoubleExtra("r", 0);
                a = getIntent().getDoubleExtra("a", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoInercia(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoFuerza(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMasa(v);
                    }
                });
                break;
            case 5:
                m = getIntent().getDoubleExtra("m", 0);
                T = getIntent().getDoubleExtra("T", 0);
                a = getIntent().getDoubleExtra("a", 0);
                m1.setText("Masa");
                res1.setText(String.format("%.3f", m));
                i1.setText(Html.fromHtml("[kg]"));
                m2.setText("Torque");
                res2.setText(String.format("%.3f", T));
                i2.setText("[N.m]");
                m3.setText("Aceleracion angular");
                res3.setText(String.format("%.3f", a));
                i3.setText(Html.fromHtml("[rad/s<sup>2</sup>]"));
                //recoleccion de datos
                F = getIntent().getDoubleExtra("F", 0);
                r = getIntent().getDoubleExtra("r", 0);
                I = getIntent().getDoubleExtra("I", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMasa(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoTorque1(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoAceleracion(v);
                    }
                });
                break;
            case 6:
                T = getIntent().getDoubleExtra("T", 0);
                m = getIntent().getDoubleExtra("m", 0);
                I = getIntent().getDoubleExtra("I", 0);
                m1.setText("Torque");
                res1.setText(String.format("%.3f", T));
                i1.setText(Html.fromHtml("[N.m]"));
                m2.setText("Masa");
                res2.setText(String.format("%.3f", m));
                i2.setText("[kg]");
                m3.setText("Inercia rotacional");
                res3.setText(String.format("%.3f", I));
                i3.setText(Html.fromHtml("[kg.m<sup>2</sup>]"));
                //recoleccion de datos
                F = getIntent().getDoubleExtra("F", 0);
                r = getIntent().getDoubleExtra("r", 0);
                a = getIntent().getDoubleExtra("a", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoTorque1(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMasa(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoInercia(v);
                    }
                });
                break;
            case 7:
                T = getIntent().getDoubleExtra("T", 0);
                r = getIntent().getDoubleExtra("r", 0);
                m = getIntent().getDoubleExtra("m", 0);
                m1.setText("Torque");
                res1.setText(String.format("%.3f", T));
                i1.setText(Html.fromHtml("[N.m]"));
                m2.setText("Radio de giro");
                res2.setText(String.format("%.3f", r));
                i2.setText("[m]");
                m3.setText("Masa");
                res3.setText(String.format("%.3f", m));
                i3.setText(Html.fromHtml("[kg]"));
                //recoleccion de datos
                I = getIntent().getDoubleExtra("I", 0);
                F = getIntent().getDoubleExtra("F", 0);
                a = getIntent().getDoubleExtra("a", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoTorque2(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoRadio(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMasa(v);
                    }
                });
                break;
            case 8:
                m = getIntent().getDoubleExtra("m", 0);
                T = getIntent().getDoubleExtra("T", 0);
                F = getIntent().getDoubleExtra("F", 0);
                m1.setText("Masa");
                res1.setText(String.format("%.3f", m));
                i1.setText(Html.fromHtml("[kg]"));
                m2.setText("Torque");
                res2.setText(String.format("%.3f", T));
                i2.setText("[N.m]");
                m3.setText("Fuerza tangencial");
                res3.setText(String.format("%.3f", F));
                i3.setText(Html.fromHtml("[N]"));
                //recoleccion de datos
                r = getIntent().getDoubleExtra("r", 0);
                I = getIntent().getDoubleExtra("I", 0);
                a = getIntent().getDoubleExtra("a", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoMasa(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoTorque2(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoFuerza(v);
                    }
                });
                break;
            case 9:
                r=getIntent().getDoubleExtra("r",0);
                m1.setText("Radio de giro");
                res1.setText(String.format("%.3f", r));
                i1.setText("[m]");
                //RECOLECIION DE DATOS
                T=getIntent().getDoubleExtra("T",0);
                F=getIntent().getDoubleExtra("F",0);
                tab4.setVisibility(View.INVISIBLE);
                tab5.setVisibility(View.INVISIBLE);
                tab6.setVisibility(View.INVISIBLE);
                tab7.setVisibility(View.INVISIBLE);
                tab8.setVisibility(View.INVISIBLE);
                //metodos
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoRadio(v);
                    }
                });
                break;

            case 10:
                F=getIntent().getDoubleExtra("F",0);
                m1.setText("Fuerza tangencial");
                res1.setText(String.format("%.3f", F));
                i1.setText("[N]");
                //RECOLECIION DE DATOS
                T=getIntent().getDoubleExtra("T",0);
                r=getIntent().getDoubleExtra("r",0);
                tab4.setVisibility(View.INVISIBLE);
                tab5.setVisibility(View.INVISIBLE);
                tab6.setVisibility(View.INVISIBLE);
                tab7.setVisibility(View.INVISIBLE);
                tab8.setVisibility(View.INVISIBLE);
                //metodos
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoFuerza(v);
                    }
                });
                break;
            case 11:
                a=getIntent().getDoubleExtra("a",0);
                m1.setText("Aceleracion angular");
                res1.setText(String.format("%.3f", a));
                i1.setText(Html.fromHtml("[rad/s<sup>2</sup>]"));
                //RECOLECIION DE DATOS
                T=getIntent().getDoubleExtra("T",0);
                I=getIntent().getDoubleExtra("I",0);
                tab4.setVisibility(View.INVISIBLE);
                tab5.setVisibility(View.INVISIBLE);
                tab6.setVisibility(View.INVISIBLE);
                tab7.setVisibility(View.INVISIBLE);
                tab8.setVisibility(View.INVISIBLE);
                //metodos
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoAceleracion(v);
                    }
                });
                break;
            case 12:
            I=getIntent().getDoubleExtra("I",0);
            m1.setText("Inercia rotacional");
            res1.setText(String.format("%.3f", I));
            i1.setText(Html.fromHtml("[kg.m<sup>2</sup>]"));
            //RECOLECIION DE DATOS
            T=getIntent().getDoubleExtra("T",0);
            a=getIntent().getDoubleExtra("a",0);
            tab4.setVisibility(View.INVISIBLE);
            tab5.setVisibility(View.INVISIBLE);
            tab6.setVisibility(View.INVISIBLE);
            tab7.setVisibility(View.INVISIBLE);
            tab8.setVisibility(View.INVISIBLE);
            //metodos
            imag1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    procesoInercia(v);
                }
            });
            break;
            case 13:
                T=getIntent().getDoubleExtra("T",0);
                m1.setText("Torque");
                res1.setText(String.format("%.3f", T));
                i1.setText(Html.fromHtml("[N.m]"));
                //RECOLECIION DE DATOS
                F=getIntent().getDoubleExtra("F",0);
                r=getIntent().getDoubleExtra("r",0);
                tab4.setVisibility(View.INVISIBLE);
                tab5.setVisibility(View.INVISIBLE);
                tab6.setVisibility(View.INVISIBLE);
                tab7.setVisibility(View.INVISIBLE);
                tab8.setVisibility(View.INVISIBLE);
                //metodos
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoTorque1(v);
                    }
                });
                break;
            case 14:
                T=getIntent().getDoubleExtra("T",0);
                m1.setText("Torque");
                res1.setText(String.format("%.3f", T));
                i1.setText(Html.fromHtml("[N.m]"));
                //RECOLECIION DE DATOS
                I=getIntent().getDoubleExtra("I",0);
                a=getIntent().getDoubleExtra("a",0);
                tab4.setVisibility(View.INVISIBLE);
                tab5.setVisibility(View.INVISIBLE);
                tab6.setVisibility(View.INVISIBLE);
                tab7.setVisibility(View.INVISIBLE);
                tab8.setVisibility(View.INVISIBLE);
                //metodos
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoTorque2(v);
                    }
                });
                break;



        }
    }

    //metodos de procesos para los 13 casos
    public void procesoAceleracion(View view) {
        Intent pmf = new Intent(this, ProcesoAceleracion.class);
        pmf.putExtra("titulo", datos);
        pmf.putExtra("a", a);
        pmf.putExtra("T", T);
        pmf.putExtra("I", I);
        startActivity(pmf);
    }

    public void procesoTorque1(View view) {
        Intent pmf = new Intent(this, ProcesoTorque.class);
        pmf.putExtra("titulo", datos);
            pmf.putExtra("T", T);
            pmf.putExtra("F", F);
            pmf.putExtra("r", r);
            pmf.putExtra("c",1);
            startActivity(pmf);
    }
    public void procesoTorque2(View view) {
        Intent pmf = new Intent(this, ProcesoTorque.class);
        pmf.putExtra("titulo", datos);
        pmf.putExtra("T", T);
        pmf.putExtra("I", I);
        pmf.putExtra("a", a);
        pmf.putExtra("c",2);
        startActivity(pmf);
    }

    public void procesoFuerza(View view) {
        Intent pmf = new Intent(this, ProcesoFuerza.class);
        pmf.putExtra("titulo", datos);
        pmf.putExtra("F", F);
        pmf.putExtra("T", T);
        pmf.putExtra("r", r);
        startActivity(pmf);
    }

    public void procesoMasa(View view) {
        Intent pmf = new Intent(this, ProcesoMasa.class);
        pmf.putExtra("titulo", datos);
        pmf.putExtra("m", m);
        pmf.putExtra("I", I);
        pmf.putExtra("r", r);
        startActivity(pmf);
    }

    public void procesoInercia(View view) {
        Intent pmf = new Intent(this, ProcesoInercia.class);
        pmf.putExtra("titulo", datos);
        pmf.putExtra("a", a);
        pmf.putExtra("T", T);
        pmf.putExtra("I", I);
        startActivity(pmf);
    }

    public void procesoRadio(View view) {
        Intent pmf = new Intent(this, ProcesoRadio.class);
        pmf.putExtra("titulo", datos);
        pmf.putExtra("r", r);
        pmf.putExtra("T", T);
        pmf.putExtra("F", F);
        startActivity(pmf);
    }

}
