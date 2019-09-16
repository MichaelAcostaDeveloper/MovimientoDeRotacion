package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoVelocidadInicial1 extends AppCompatActivity {
    TextView v1,v2,v3,v4,vm_formula,vf_formula,vm_valor,vf_valor,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_velocidad_inicial1);

        v1=(TextView)findViewById(R.id.v1);
        v1.setText(Html.fromHtml("ω<sub>o</sub>"));
        v2=(TextView)findViewById(R.id.v2);
        v2.setText(Html.fromHtml("ω<sub>o</sub>"));
        v3=(TextView)findViewById(R.id.v3);
        v3.setText(Html.fromHtml("ω<sub>o</sub>"));
        v4=(TextView)findViewById(R.id.v4);
        v4.setText(Html.fromHtml("ω<sub>o</sub>"));

        vf_formula=(TextView)findViewById(R.id.vf_Formula);
        vf_formula.setText(Html.fromHtml("ω<sub>f</sub>"));
        vf_valor=(TextView)findViewById(R.id.vf_valor);

        vm_formula=(TextView)findViewById(R.id.vm_Formula);
        vm_formula.setText(Html.fromHtml("(ω<sub>m</sub>)"));
        vm_valor=(TextView)findViewById(R.id.vm_valor) ;

        resultado=(TextView)findViewById(R.id.resultado);

        Double vo=getIntent().getDoubleExtra("vo",0);
        Double vm=getIntent().getDoubleExtra("vm",0);
        Double vf=getIntent().getDoubleExtra("vf",0);
        //ubicacion de los valores en los textView
        vf_valor.setText(String.format("%.3f",vf));
        vm_valor.setText(String.format("(%.3f)",vm));
        resultado.setText(String.format("%.3f", vo));
    }
}
