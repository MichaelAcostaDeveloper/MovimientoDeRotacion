package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoVariacionVelocidadAngularFormat1 extends AppCompatActivity {
    TextView dvFormula1,vfFormula1,voFormula1,dvFormula1_calculo,vfFormula1_valor,voFormula1_valor,dvFormula1_resultado,resultado,unidad,dv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_variacion_velocidad_format1);
        dvFormula1=(TextView)findViewById(R.id.dvFormula1);
        vfFormula1=(TextView)findViewById(R.id.vfFormula1);
        voFormula1=(TextView)findViewById(R.id.voFormula1);
        dvFormula1_calculo=(TextView)findViewById(R.id.dvFormula1_calculo);
        vfFormula1_valor=(TextView)findViewById(R.id.vfFormula1_valor);
        voFormula1_valor=(TextView)findViewById(R.id.voFormula1_valor);
        dvFormula1_resultado=(TextView)findViewById(R.id.dvFormula1_resultado);
        resultado=(TextView)findViewById(R.id.resultado);
        unidad=(TextView)findViewById(R.id.unidad);
        dv=(TextView)findViewById(R.id.dv);



        dvFormula1.setText("Δω");
        dv.setText("Δω");
        dvFormula1_calculo.setText("Δω");
        dvFormula1_resultado.setText("Δω");
        vfFormula1.setText(Html.fromHtml("ω<sub>f</sub>"));
        voFormula1.setText(Html.fromHtml("ω<sub>o</sub>"));
        unidad.setText("[rad/s]");

        //paso de valores del Resultados_Cinematica al ProcesoVaruaiconVelocidadAngularFormat1
        Double dv=getIntent().getDoubleExtra("dv",0);
        Double vo=getIntent().getDoubleExtra("vo",0);
        Double vf=getIntent().getDoubleExtra("vf",0);
        //ubicacion de los valores en los textView
        voFormula1_valor.setText(String.format("%.3f",vo));
        vfFormula1_valor.setText(String.format("%.3f",vf));
        resultado.setText(String.format("%.3f", dv));
    }
}
