package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoVelocidadInicial3 extends AppCompatActivity {
    TextView v1,v2,v3,v4,resultado,vf_formula,vf_valor,dv_valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_velocidad_inicial3);
        v1=(TextView)findViewById(R.id.v1);
        v1.setText(Html.fromHtml("ω<sub>o</sub>"));
        v2=(TextView)findViewById(R.id.v2);
        v2.setText(Html.fromHtml("ω<sub>o</sub>"));
        v3=(TextView)findViewById(R.id.v3);
        v3.setText(Html.fromHtml("ω<sub>o</sub>"));
        v4=(TextView)findViewById(R.id.v4);
        v4.setText(Html.fromHtml("ω<sub>o</sub>"));
        vf_formula=(TextView)findViewById(R.id.vf_formula);
        vf_formula.setText(Html.fromHtml("ω<sub>f</sub>"));

        vf_valor=(TextView)findViewById(R.id.vf_valor);
        dv_valor=(TextView)findViewById(R.id.dv_valor);
        resultado=(TextView)findViewById(R.id.resultado);

        Double vo=getIntent().getDoubleExtra("vo",0);
        Double vf=getIntent().getDoubleExtra("vf",0);
        Double dv=getIntent().getDoubleExtra("dv",0);

        //ubicacion de los valores en los textView
        vf_valor.setText(String.format("(%.2f)",vf));
        dv_valor.setText(String.format("(%.2f)",dv));
        resultado.setText(String.format("%.3f",vo));
    }
}
