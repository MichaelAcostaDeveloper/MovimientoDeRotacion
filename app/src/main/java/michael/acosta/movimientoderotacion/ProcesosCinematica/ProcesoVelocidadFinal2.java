package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoVelocidadFinal2 extends AppCompatActivity {
    TextView vf1,vf2,vf3,vf4,vo_formula,vo_valor,vm_formula,vm_valor,resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_velocidad_final2);

        vf1=(TextView)findViewById(R.id.vf1);
        vf1.setText(Html.fromHtml("ω<sub>f</sub>"));
        vf2=(TextView)findViewById(R.id.vf2);
        vf2.setText(Html.fromHtml("ω<sub>f</sub>"));
        vf3=(TextView)findViewById(R.id.vf3);
        vf3.setText(Html.fromHtml("ω<sub>f</sub>"));
        vf4=(TextView)findViewById(R.id.vf4);
        vf4.setText(Html.fromHtml("ω<sub>f</sub>"));

        vo_formula=(TextView)findViewById(R.id.vo_Formula);
        vo_formula.setText(Html.fromHtml("ω<sub>o</sub>"));
        vo_valor=(TextView)findViewById(R.id.vo_valor);

        vm_formula=(TextView)findViewById(R.id.vm_Formula);
        vm_formula.setText(Html.fromHtml("(ω<sub>m</sub>)"));
        vm_valor=(TextView)findViewById(R.id.vm_valor) ;

        resultado=(TextView)findViewById(R.id.resultado);

        Double vo=getIntent().getDoubleExtra("vo",0);
        Double vm=getIntent().getDoubleExtra("vm",0);
        Double vf=getIntent().getDoubleExtra("vf",0);
        //ubicacion de los valores en los textView
        vo_valor.setText(String.format("%.3f",vo));
        vm_valor.setText(String.format("(%.3f)",vm));
        resultado.setText(String.format("%.3f", vf));
    }
}
