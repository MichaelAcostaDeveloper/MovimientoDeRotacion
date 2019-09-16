package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoAceleracionFormat1 extends AppCompatActivity {
TextView dv_valor,dt_valor,resultado,unidad;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_aceleracion_format1);

        dv_valor=(TextView)findViewById(R.id.dv_valor);
        dt_valor=(TextView)findViewById(R.id.dt_valor);
        resultado=(TextView)findViewById(R.id.resultado);
        unidad=(TextView)findViewById(R.id.unidad);



        unidad.setText(Html.fromHtml("[rad/s<sup>2</sup>]"));

        Double dv=getIntent().getDoubleExtra("dv",0);
        Double t=getIntent().getDoubleExtra("t",0);
        Double a=getIntent().getDoubleExtra("a",0);
        //ubicacion de los valores en los textView
        dv_valor.setText(String.format("%.3f",dv));
        dt_valor.setText(String.format("%.3f",t));
        resultado.setText(String.format("%.3f", a));







    }
}
