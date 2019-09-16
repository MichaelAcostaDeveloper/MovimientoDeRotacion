package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoVelocidadInicial4 extends AppCompatActivity {
    TextView v1,v2,v3,v4,d_valor,t1_valor,t2_valor,a_valor,resultado,exp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_velocidad_inicial4);
        v2=(TextView)findViewById(R.id.v2);
        v2.setText(Html.fromHtml("ω<sub>o</sub>"));
        v3=(TextView)findViewById(R.id.v3);
        v3.setText(Html.fromHtml("ω<sub>o</sub>"));
        v4=(TextView)findViewById(R.id.v4);
        v4.setText(Html.fromHtml("ω<sub>o</sub>"));
        d_valor=(TextView)findViewById(R.id.d_valor);
        t1_valor=(TextView)findViewById(R.id.t1_valor);
        t2_valor=(TextView)findViewById(R.id.t2_valor);
        a_valor=(TextView)findViewById(R.id.a_valor);
        resultado=(TextView)findViewById(R.id.resultado);

        Double a=getIntent().getDoubleExtra("a",0);
        Double t=getIntent().getDoubleExtra("t",0);
        Double d=getIntent().getDoubleExtra("d",0);
        Double vo=getIntent().getDoubleExtra("vo",0);

        //ubicacion de los valores en los textView
        a_valor.setText(String.format("(%.3f)",a));
        t1_valor.setText(String.format("(%.3f)",t));
        t2_valor.setText(String.format("(%.3f)",t));
        d_valor.setText(String.format("(%.3f)",d));
        resultado.setText(String.format("%.3f",vo));
    }
}
