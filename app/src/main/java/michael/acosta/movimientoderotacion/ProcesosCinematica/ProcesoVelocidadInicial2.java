package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoVelocidadInicial2 extends AppCompatActivity {
    TextView v1,v2,v3,resultado,vf_formula,vf_valor,a_formula,a_valor,d_formula,d_valor,exp_formula,exp_valor,exp_vf,expo,exp,v,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_velocidad_inicial2);
        //casteo de variables
        v1=(TextView)findViewById(R.id.v1);
        v1.setText(Html.fromHtml("ω<sub>o</sub>"));
        v2=(TextView)findViewById(R.id.v2);
        v2.setText(Html.fromHtml("ω<sub>o</sub>"));
        v3=(TextView)findViewById(R.id.v3);
        v3.setText(Html.fromHtml("ω<sub>o</sub>"));

        resultado=(TextView)findViewById(R.id.resultado);

        vf_formula=(TextView)findViewById(R.id.vf_formula);
        vf_formula.setText(Html.fromHtml("ω<sub>f</sub>"));
        vf_valor=(TextView)findViewById(R.id.vf_valor);

        a_formula=(TextView)findViewById(R.id.a_formula);
        a_formula.setText(Html.fromHtml("(α)"));
        a_valor=(TextView)findViewById(R.id.a_valor);

        d_formula=(TextView)findViewById(R.id.d_formula);
        d_formula.setText(Html.fromHtml("(Δθ)"));
        d_valor=(TextView)findViewById(R.id.d_valor);

        exp_formula=(TextView)findViewById(R.id.exp_formula);
        exp_formula.setText(Html.fromHtml("<sup>0.5</sup>"));
        exp_valor=(TextView)findViewById(R.id.exp_valor);
        exp_valor.setText(Html.fromHtml("<sup>0.5</sup>"));
        exp_vf=(TextView)findViewById(R.id.exp_vf);
        exp_vf.setText(Html.fromHtml("<sup>2</sup>"));
        e=(TextView)findViewById(R.id.e);
        e.setText(Html.fromHtml("<sup>2</sup>"));


        Double vo=getIntent().getDoubleExtra("vo",0);
        Double a=getIntent().getDoubleExtra("a",0);
        Double vf=getIntent().getDoubleExtra("vf",0);
        Double d=getIntent().getDoubleExtra("d",0);
        //ubicacion de los valores en los textView
        vf_valor.setText(String.format("(%.2f)",vf));
        a_valor.setText(String.format("(%.2f)",a));
        d_valor.setText(String.format("(%.2f)",d));
        resultado.setText(String.format("%.3f",vo));
    }
}
