package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoVelocidadAngularMediaFormat1 extends AppCompatActivity {
 TextView vm1,vm2,vm3,vmFormula1_resultado,resultado,unidad,vfFormula1,voFormula1,vf_Valor,vo_Valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_velocidad_angular_media_format1);

        vm1=(TextView)findViewById(R.id.vm1);
        vm2=(TextView)findViewById(R.id.vm2);
        vm3=(TextView)findViewById(R.id.vm3);
        vmFormula1_resultado = (TextView)findViewById(R.id.vmFormula1_resultado);
        resultado=(TextView)findViewById(R.id.resultado);
        unidad=(TextView)findViewById(R.id.unidad);
        vfFormula1=(TextView)findViewById(R.id.vfFormula1);
        voFormula1=(TextView)findViewById(R.id.voFormula1);
        vf_Valor=(TextView)findViewById(R.id.vf_valor);
        vo_Valor=(TextView)findViewById(R.id.vo_valor);



        vm2.setText(Html.fromHtml("ω<sub>m</sub>"));
        vm3.setText(Html.fromHtml("ω<sub>m</sub>"));
        vmFormula1_resultado.setText(Html.fromHtml("ω<sub>m</sub>"));
        vfFormula1.setText(Html.fromHtml("ω<sub>f</sub>"));
        voFormula1.setText(Html.fromHtml("ω<sub>o</sub>"));

        unidad.setText("[rad/s]");

        //paso de valores del Resultados_Cinematica al ProcesoVaruaiconVelocidadAngularFormat1
        Double vm=getIntent().getDoubleExtra("vm",0);
        Double vo=getIntent().getDoubleExtra("vo",0);
        Double vf=getIntent().getDoubleExtra("vf",0);
        //ubicacion de los valores en los textView
        vo_Valor.setText(String.format("%.3f",vo));
        vf_Valor.setText(String.format("%.3f",vf));
        resultado.setText(String.format("%.3f", vm));
    }
}
