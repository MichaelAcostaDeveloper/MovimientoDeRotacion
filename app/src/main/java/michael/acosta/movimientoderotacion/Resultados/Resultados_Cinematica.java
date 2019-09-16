package michael.acosta.movimientoderotacion.Resultados;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoAceleracionFormat1;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoCalculoDesplazamiento1;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoTiempo1;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoTiempo2;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoVariacionVelocidadAngularFormat1;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoVariacionVelocidadAngularFormat2;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoVelocidadAngularMediaFormat1;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoVelocidadAngularMediaFormat2;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoVelocidadFinal1;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoVelocidadFinal2;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoVelocidadFinal3;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoVelocidadInicial1;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoVelocidadInicial2;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoVelocidadInicial3;
import michael.acosta.movimientoderotacion.ProcesosCinematica.ProcesoVelocidadInicial4;
import michael.acosta.movimientoderotacion.R;
public class Resultados_Cinematica extends AppCompatActivity {
    TextView res1, res2, res3, res4, m1, m2, m3, m4, i1, i2, i3, i4;
    RelativeLayout et3, et4, et5, et6, et7, et8;
    View li1, li2, li3;
    String datos;
    ImageView imag1, imag2, imag3, imag4;
    double vo, vf, d, t, dv, vm, a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primaryColor));
        datos = getIntent().getStringExtra("title");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_resultados_cinematica);
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
        et3 = (RelativeLayout) findViewById(R.id.tercera);
        et4 = (RelativeLayout) findViewById(R.id.cuarta);
        et5 = (RelativeLayout) findViewById(R.id.quinta);
        et6 = (RelativeLayout) findViewById(R.id.sexta);
        et7 = (RelativeLayout) findViewById(R.id.septima);
        et8 = (RelativeLayout) findViewById(R.id.octava);
        li1 = (View) findViewById(R.id.linea1);
        li2 = (View) findViewById(R.id.linea2);
        li3 = (View) findViewById(R.id.linea3);
        res1 = (TextView) findViewById(R.id.textResultado1);
        res2 = (TextView) findViewById(R.id.textResultado2);
        res3 = (TextView) findViewById(R.id.textResultado3);
        res4 = (TextView) findViewById(R.id.textResultado4);
        m1 = (TextView) findViewById(R.id.m1);
        m2 = (TextView) findViewById(R.id.m2);
        m3 = (TextView) findViewById(R.id.m3);
        m4 = (TextView) findViewById(R.id.m4);
        i1 = (TextView) findViewById(R.id.i1);
        i2 = (TextView) findViewById(R.id.i2);
        i3 = (TextView) findViewById(R.id.i3);
        i4 = (TextView) findViewById(R.id.i4);
        imag1 = (ImageView) findViewById(R.id.imagen1);
        imag2 = (ImageView) findViewById(R.id.imagen2);
        imag3 = (ImageView) findViewById(R.id.imagen3);
        imag4 = (ImageView) findViewById(R.id.imagen4);
        //recoleccion de datos del CinematicaMovimiento
        Intent recibir = getIntent();
        int caso = recibir.getIntExtra("id", 0);
        switch (caso) {
            case 1:
                dv = getIntent().getDoubleExtra("dv", 0);
                vm = getIntent().getDoubleExtra("vm", 0);
                t = getIntent().getDoubleExtra("t", 0);
                a = getIntent().getDoubleExtra("a", 0);
                m1.setText("Variación de velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText(Html.fromHtml("[rad/s]"));
                m2.setText("Velocidad angular media");
                res2.setText(String.format("%.3f", vm));
                i2.setText("[rad/s]");
                m3.setText("Tiempo transcurrido");
                res3.setText(String.format("%.3f", t));
                i3.setText("[s]");
                m4.setText("Aceleracion angular");
                res4.setText(String.format("%.3f", a));
                i4.setText(Html.fromHtml("[rad/s<sup>2</sup>]"));
                //recoleccion de datos del CinematicaMovimiento
                vo = getIntent().getDoubleExtra("vo", 0);
                vf = getIntent().getDoubleExtra("vf", 0);
                d = getIntent().getDoubleExtra("d", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVariacionVelocidadAngular(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoTiempo1(v);
                    }
                });
                imag4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoAceleracion1(v);
                    }
                });
                break;
            case 2:
                dv = getIntent().getDoubleExtra("dv", 0);
                vm = getIntent().getDoubleExtra("vm", 0);
                d = getIntent().getDoubleExtra("d", 0);
                a = getIntent().getDoubleExtra("a", 0);
                m1.setText("Variación de la velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText("[rad/s]");
                m2.setText("Velocidad angular media");
                res2.setText(String.format("%.3f", vm));
                i2.setText("[rad/s]");
                m3.setText("Desplazamiento angular");
                res3.setText(String.format("%.3f", d));
                i3.setText("[rad]");
                m4.setText("Aceleración angular");
                res4.setText(String.format("%.3f", a));
                i4.setText(Html.fromHtml("[rad/s<sup>2</sup>]"));
                //recoleccion de datos del CinematicaMovimiento
                vo = getIntent().getDoubleExtra("vo", 0);
                vf = getIntent().getDoubleExtra("vf", 0);
                t = getIntent().getDoubleExtra("t", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVariacionVelocidadAngular(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoDesplazamiento1(v);
                    }
                });
                imag4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoAceleracion1(v);
                    }
                });
                break;
            case 3:
                dv = getIntent().getDoubleExtra("dv", 0);
                vm = getIntent().getDoubleExtra("vm", 0);
                t = getIntent().getDoubleExtra("t", 0);
                d = getIntent().getDoubleExtra("d", 0);
                m1.setText("Variación de la velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText("[rad/s]");
                m2.setText("Velocidad angular media");
                res2.setText(String.format("%.3f", vm));
                i2.setText("[rad/s]");
                m3.setText("Tiempo transcurrido");
                res3.setText(String.format("%.3f", t));
                i3.setText("[s]");
                m4.setText("Desplazamiento angular");
                res4.setText(String.format("%.3f", d));
                i4.setText("[rad]");
                //recoleccion de datos del CinematicaMovimiento
                vo = getIntent().getDoubleExtra("vo", 0);
                vf = getIntent().getDoubleExtra("vf", 0);
                a = getIntent().getDoubleExtra("a", 0);
                //metodos a ejecutarse
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVariacionVelocidadAngular(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoTiempo2(v);
                    }
                });
                imag4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoDesplazamiento1(v);
                    }
                });

                break;
            case 4:
                dv = getIntent().getDoubleExtra("dv", 0);
                vm = getIntent().getDoubleExtra("vm", 0);
                vf = getIntent().getDoubleExtra("vf", 0);
                d = getIntent().getDoubleExtra("d", 0);
                m1.setText("Variación de la velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText("[rad/s]");
                m2.setText("Velocidad angular media");
                res2.setText(String.format("%.3f", vm));
                i2.setText("[rad/s]");
                m3.setText("Velocidad angular final");
                res3.setText(String.format("%.3f", vf));
                i3.setText("[rad/s]");
                m4.setText("Desplazamiento angular");
                res4.setText(String.format("%.3f", d));
                i4.setText("[rad]");
                //recoleccion de datos del CinematicaMovimiento
                vo = getIntent().getDoubleExtra("vo", 0);
                t = getIntent().getDoubleExtra("t", 0);
                a = getIntent().getDoubleExtra("a", 0);

                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoVariacionVelocidad2(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoVelocidadFinal(v);
                    }
                });
                imag4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoDesplazamiento1(v);
                    }
                });
                break;
            case 5:
                dv = getIntent().getDoubleExtra("dv", 0);
                vm = getIntent().getDoubleExtra("vm", 0);
                a = getIntent().getDoubleExtra("a", 0);
                vf = getIntent().getDoubleExtra("vf", 0);
                m1.setText("Variación de la velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText("[rad/s]");
                m2.setText("Velocidad angular media");
                res2.setText(String.format("%.3f", vm));
                i2.setText("[rad/s]");
                m3.setText("Aceleración angular");
                res3.setText(String.format("%.3f", a));
                i3.setText(Html.fromHtml("[rad/s<sup>2</sup>]"));
                m4.setText("Velocidad angular final");
                res4.setText(String.format("%.3f", vf));
                i4.setText("[rad/s]");
                //recoleccion de datos del CinematicaMovimiento
                vo = getIntent().getDoubleExtra("vo", 0);
                d = getIntent().getDoubleExtra("d", 0);
                t = getIntent().getDoubleExtra("t", 0);
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVariacionVelocidadAngular(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia2(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoAceleracion1(v);
                    }
                });
                imag4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoVelocidadFinal2(v);
                    }
                });
                break;
            case 6:
                dv = getIntent().getDoubleExtra("dv", 0);
                vm = getIntent().getDoubleExtra("vm", 0);
                a = getIntent().getDoubleExtra("a", 0);
                vo = getIntent().getDoubleExtra("vo", 0);
                m1.setText("Variación de la velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText("[rad/s]");
                m2.setText("Velocidad angular media");
                res2.setText(String.format("%.3f", vm));
                i2.setText("[rad/s]");
                m3.setText("Aceleración angular");
                res3.setText(String.format("%.3f", a));
                i3.setText(Html.fromHtml("[rad/s<sup>2</sup>]"));
                m4.setText("Velocidad angular inicial");
                res4.setText(String.format("%.3f", vo));
                i4.setText("[rad/s]");
                //recoleccion de datos del CinematicaMovimiento
                vf = getIntent().getDoubleExtra("vf", 0);
                d = getIntent().getDoubleExtra("d", 0);
                t = getIntent().getDoubleExtra("t", 0);

                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVariacionVelocidadAngular(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia2(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoAceleracion1(v);
                    }
                });
                imag4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoVelocidadInicial1(v);
                    }
                });

                break;
            case 7:
                dv = getIntent().getDoubleExtra("dv", 0);
                vm = getIntent().getDoubleExtra("vm", 0);
                t = getIntent().getDoubleExtra("t", 0);
                vo = getIntent().getDoubleExtra("vo", 0);
                m1.setText("Variación de la velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText("[rad/s]");
                m2.setText("Velocidad angular media");
                res2.setText(String.format("%.3f", vm));
                i2.setText("[rad/s]");
                m3.setText("Tiempo transcurrido");
                res3.setText(String.format("%.3f", t));
                i3.setText("[s]");
                m4.setText("Velocidad angular inicial");
                res4.setText(String.format("%.3f", vo));
                i4.setText("[rad/s]");
                //recoleccion de datos del CinematicaMovimiento
                vf = getIntent().getDoubleExtra("vf", 0);
                d = getIntent().getDoubleExtra("d", 0);
                a = getIntent().getDoubleExtra("a", 0);
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVariacionVelocidadAngular(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoTiempo1(v);
                    }
                });
                imag4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoVelocidadInicial2(v);
                    }
                });

                break;
            case 8:
                dv = getIntent().getDoubleExtra("dv", 0);
                vm = getIntent().getDoubleExtra("vm", 0);
                vo = getIntent().getDoubleExtra("vo", 0);
                d = getIntent().getDoubleExtra("d", 0);
                m1.setText("Variación de la velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText("[rad/s]");
                m2.setText("Velocidad angular media");
                res2.setText(String.format("%.3f", vm));
                i2.setText("[rad/s]");
                m3.setText("Velocidad angular inicial");
                res3.setText(String.format("%.3f", vo));
                i3.setText("[rad/s]");
                m4.setText("Desplazamiento angular");
                res4.setText(String.format("%.3f", d));
                i4.setText("[rad]");
                //recoleccion de datos del CinematicaMovimiento
                vf = getIntent().getDoubleExtra("vf", 0);
                t = getIntent().getDoubleExtra("t", 0);
                a = getIntent().getDoubleExtra("a", 0);
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoVariacionVelocidad2(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoVelocidadInicial3(v);
                    }
                });
                imag4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoDesplazamiento1(v);
                    }
                });
                break;
            case 9:
                dv = getIntent().getDoubleExtra("dv", 0);
                vm = getIntent().getDoubleExtra("vm", 0);
                vo = getIntent().getDoubleExtra("vo", 0);
                vf = getIntent().getDoubleExtra("vf", 0);
                m1.setText("Variación de la velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText("[rad/s]");
                m2.setText("Velocidad angular media");
                res2.setText(String.format("%.3f", vm));
                i2.setText("[rad/s]");
                m3.setText("Velocidad angular inicial");
                res3.setText(String.format("%.3f", vo));
                i3.setText("[rad/s]");
                m4.setText("Velocidad angular final");
                res4.setText(String.format("%.3f", vf));
                i4.setText("[rad/s]");
                //recoleccion de datos del CinematicaMovimiento
                d = getIntent().getDoubleExtra("d", 0);
                t = getIntent().getDoubleExtra("t", 0);
                a = getIntent().getDoubleExtra("a", 0);
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVariacionVelocidadAngular(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia2(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoVelocidadInicial4(v);
                    }
                });
                imag4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoVelocidadFinal2(v);
                    }
                });

                break;
            case 10:
                dv = getIntent().getDoubleExtra("dv", 0);
                vm = getIntent().getDoubleExtra("vm", 0);
                vf = getIntent().getDoubleExtra("vf", 0);
                t = getIntent().getDoubleExtra("t", 0);
                m1.setText("Variación de la velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText("[rad/s]");
                m2.setText("Velocidad angular media");
                res2.setText(String.format("%.3f", vm));
                i2.setText("[rad/s]");
                m3.setText("Velocidad angular final");
                res3.setText(String.format("%.3f", vf));
                i3.setText("[rad/s]");
                m4.setText("Tiempo transcurrido");
                res4.setText(String.format("%.3f", t));
                i4.setText("[s]");
                //recoleccion de datos del CinematicaMovimiento
                vo = getIntent().getDoubleExtra("vo", 0);
                d = getIntent().getDoubleExtra("d", 0);
                a = getIntent().getDoubleExtra("a", 0);
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVariacionVelocidadAngular(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia(v);
                    }
                });
                imag3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoVelocidadFinal3(v);
                    }
                });
                imag4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoTiempo1(v);
                    }
                });

                break;

            case 11:
                dv = getIntent().getDoubleExtra("dv", 0);
                vm = getIntent().getDoubleExtra("vm", 0);
                m1.setText("Variacion de la velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText("[rad/s]");
                m2.setText("Velocidad media");
                res2.setText(String.format("%.3f", vm));
                i2.setText("[rad/s]");
                //RECOLECIION DE DATOS
                vo = getIntent().getDoubleExtra("vo", 0);
                vf = getIntent().getDoubleExtra("vf", 0);
                et5.setVisibility(View.INVISIBLE);
                et6.setVisibility(View.INVISIBLE);
                et7.setVisibility(View.INVISIBLE);
                et8.setVisibility(View.INVISIBLE);
                li2.setVisibility(View.INVISIBLE);
                li3.setVisibility(View.INVISIBLE);
                //metodos
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVariacionVelocidadAngular(v);
                    }
                });
                imag2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia(v);
                    }
                });
                break;
            case 12:
                dv = getIntent().getDoubleExtra("dv", 0);
                m1.setText("Variación de la velocidad");
                res1.setText(String.format("%.3f", dv));
                i1.setText("[rad/s]");
                et3.setVisibility(View.INVISIBLE);
                et4.setVisibility(View.INVISIBLE);
                et5.setVisibility(View.INVISIBLE);
                et6.setVisibility(View.INVISIBLE);
                et7.setVisibility(View.INVISIBLE);
                et8.setVisibility(View.INVISIBLE);
                li1.setVisibility(View.INVISIBLE);
                li2.setVisibility(View.INVISIBLE);
                li3.setVisibility(View.INVISIBLE);
                //recoleccion de datos del CinematicaMovimiento
                vf = getIntent().getDoubleExtra("vf", 0);
                t = getIntent().getDoubleExtra("t", 0);
                a = getIntent().getDoubleExtra("a", 0);
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoCalculoVariacionVelocidad2(v);
                    }
                });
                break;
            case 13:
                vm = getIntent().getDoubleExtra("vm", 0);
                m1.setText("Velocidad angular media");
                res1.setText(String.format("%.3f", vm));
                i1.setText("[rad/s]");
                d = getIntent().getDoubleExtra("d", 0);
                t = getIntent().getDoubleExtra("t", 0);
                et3.setVisibility(View.INVISIBLE);
                et4.setVisibility(View.INVISIBLE);
                et5.setVisibility(View.INVISIBLE);
                et6.setVisibility(View.INVISIBLE);
                et7.setVisibility(View.INVISIBLE);
                et8.setVisibility(View.INVISIBLE);
                li1.setVisibility(View.INVISIBLE);
                li2.setVisibility(View.INVISIBLE);
                li3.setVisibility(View.INVISIBLE);
                imag1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        procesoVelocidadMedia2(v);
                    }
                });
                break;
        }
    }

    //metodos de procesos para los 13 casos
    public void procesoVariacionVelocidadAngular(View view) {
        Intent dv1 = new Intent(this, ProcesoVariacionVelocidadAngularFormat1.class);
        dv1.putExtra("titulo", datos);
        dv1.putExtra("vo", vo);
        dv1.putExtra("vf", vf);
        dv1.putExtra("dv", dv);//variacion de velocidad
        startActivity(dv1);
    }
    public void procesoVelocidadMedia(View view) {
        Intent vm1 = new Intent(this, ProcesoVelocidadAngularMediaFormat1.class);
        vm1.putExtra("titulo", datos);
        vm1.putExtra("vo", vo);
        vm1.putExtra("vf", vf);
        vm1.putExtra("vm", vm);//velocidad media
        startActivity(vm1);
    }
    public void procesoCalculoTiempo1(View view) {
        Intent a = new Intent(this, ProcesoTiempo1.class);
        a.putExtra("titulo", datos);
        a.putExtra("d", d);//desplazamiento angular
        a.putExtra("vm", vm);//velocidad media
        a.putExtra("t", t);//tiempo resultado
        startActivity(a);
    }
    public void procesoCalculoAceleracion1(View view) {
        Intent b = new Intent(this, ProcesoAceleracionFormat1.class);
        b.putExtra("titulo", datos);
        b.putExtra("t", t);//tiempo calculado
        b.putExtra("dv", dv);//variacion velocidad
        b.putExtra("a", a);//aceleracion resultado
        startActivity(b);
    }
    public void procesoCalculoDesplazamiento1(View view) {
        Intent f = new Intent(this, ProcesoCalculoDesplazamiento1.class);
        f.putExtra("titulo", datos);
        f.putExtra("vm", vm);//velocidad media
        f.putExtra("t", t);//tiempo
        f.putExtra("d", d); //desplazamiento resultado
        startActivity(f);
    }
    public void procesoCalculoTiempo2(View view) {
        Intent t2 = new Intent(this, ProcesoTiempo2.class);
        t2.putExtra("titulo", datos);
        t2.putExtra("t", t);//tiempo
        t2.putExtra("dv", dv);//variacion velocidad
        t2.putExtra("a", a);//aceleracion
        startActivity(t2);
    }
    public void procesoCalculoVariacionVelocidad2(View view) {
        Intent t2 = new Intent(this, ProcesoVariacionVelocidadAngularFormat2.class);
        t2.putExtra("titulo", datos);
        t2.putExtra("t", t);//tiempo
        t2.putExtra("dv", dv);//variacion velocidad
        t2.putExtra("a", a);//aceleracion
        startActivity(t2);
    }
    public void procesoCalculoVelocidadFinal(View view) {
        Intent t2 = new Intent(this, ProcesoVelocidadFinal1.class);
        t2.putExtra("titulo", datos);
        t2.putExtra("vo", vo);//tiempo
        t2.putExtra("dv", dv);//variacion velocidad
        t2.putExtra("vf", vf);//aceleracion
        startActivity(t2);
    }
    public void procesoVelocidadMedia2(View view) {
        Intent vm2 = new Intent(this, ProcesoVelocidadAngularMediaFormat2.class);
        vm2.putExtra("titulo", datos);
        vm2.putExtra("d", d);
        vm2.putExtra("t", t);
        vm2.putExtra("vm", vm);//velocidad media
        startActivity(vm2);
    }
    public void procesoCalculoVelocidadFinal2(View view) {
        Intent t2 = new Intent(this, ProcesoVelocidadFinal2.class);
        t2.putExtra("titulo", datos);
        t2.putExtra("vo", vo);//velocidad inicial
        t2.putExtra("vm", vm);//velocidad media
        t2.putExtra("vf", vf);//velocidad final
        startActivity(t2);
    }
    public void procesoCalculoVelocidadInicial1(View view) {
        Intent t2 = new Intent(this, ProcesoVelocidadInicial1.class);
        t2.putExtra("titulo", datos);
        t2.putExtra("vo", vo);//velocidad inicial
        t2.putExtra("vm", vm);//velocidad media
        t2.putExtra("vf", vf);//velocidad final
        startActivity(t2);
    }
    public void procesoCalculoVelocidadInicial2(View view) {
        Intent u = new Intent(this, ProcesoVelocidadInicial2.class);
        u.putExtra("titulo", datos);
        u.putExtra("vo", vo);//velocidad inicial
        u.putExtra("a", a);//velocidad media
        u.putExtra("vf", vf);//velocidad final
        u.putExtra("d", d);//desplazamiento angular
        startActivity(u);
    }
    public void procesoCalculoVelocidadInicial3(View view) {
        Intent t = new Intent(this, ProcesoVelocidadInicial3.class);
        t.putExtra("titulo", datos);
        t.putExtra("vo", vo);//velocidad inicial
        t.putExtra("dv", dv);//velocidad media
        t.putExtra("vf", vf);//velocidad final
        startActivity(t);
    }
    public void procesoCalculoVelocidadInicial4(View view) {
        Intent m = new Intent(this, ProcesoVelocidadInicial4.class);
        m.putExtra("titulo", datos);
        m.putExtra("vo", vo);//velocidad inicial
        m.putExtra("a", a);//aceleracion
        m.putExtra("t", t);//tiempo
        m.putExtra("d", d);//desplazamiento
        startActivity(m);
    }
    public void procesoCalculoVelocidadFinal3(View view) {
        Intent u = new Intent(this, ProcesoVelocidadFinal3.class);
        u.putExtra("titulo", datos);
        u.putExtra("vo", vo);//velocidad inicial
        u.putExtra("a", a);//velocidad media
        u.putExtra("vf", vf);//velocidad final
        u.putExtra("d", d);//desplazamiento angular
        startActivity(u);
    }
}
