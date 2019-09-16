package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoVelocidadFinal3 extends AppCompatActivity {
    TextView v,v1,v2,v3,expo,exp,e,exp_formula,exp_vo,exp_valor,vo_formula,vo_valor,a_formula,a_valor,d_formula,d_valor,resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_velocidad_final3);

        v1=(TextView)findViewById(R.id.v1);
        v1.setText(Html.fromHtml("ω<sub>f</sub>"));
        v2=(TextView)findViewById(R.id.v2);
        v2.setText(Html.fromHtml("ω<sub>f</sub>"));
        v3=(TextView)findViewById(R.id.v3);
        v3.setText(Html.fromHtml("ω<sub>f</sub>"));
        e=(TextView)findViewById(R.id.e);
        e.setText(Html.fromHtml("<sup>2</sup>"));
        exp_formula=(TextView)findViewById(R.id.exp_formula);
        exp_formula.setText(Html.fromHtml("<sup>0.5</sup>"));
        exp_vo=(TextView)findViewById(R.id.exp_vo);
        exp_vo.setText(Html.fromHtml("<sup>2</sup>"));
        exp_valor=(TextView)findViewById(R.id.exp_valor);
        exp_valor.setText(Html.fromHtml("<sup>0.5</sup>"));

        vo_formula=(TextView)findViewById(R.id.vo_formula);
        vo_formula.setText(Html.fromHtml("ω<sub>o</sub>"));
        vo_valor=(TextView)findViewById(R.id.vo_valor);

        a_formula=(TextView)findViewById(R.id.a_formula);
        a_formula.setText(Html.fromHtml("(α)"));
        a_valor=(TextView)findViewById(R.id.a_valor);

        d_formula=(TextView)findViewById(R.id.d_formula);
        d_formula.setText(Html.fromHtml("(Δθ)"));
        d_valor=(TextView)findViewById(R.id.d_valor);

        resultado=(TextView)findViewById(R.id.resultado);

        Double vo=getIntent().getDoubleExtra("vo",0);
        Double a=getIntent().getDoubleExtra("a",0);
        Double vf=getIntent().getDoubleExtra("vf",0);
        Double d=getIntent().getDoubleExtra("d",0);
        //ubicacion de los valores en los textView
        vo_valor.setText(String.format("(%.2f)",vo));
        a_valor.setText(String.format("(%.2f)",a));
        d_valor.setText(String.format("(%.2f)",d));
        resultado.setText(String.format("%.3f",vf));
    }
}
