package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoCalculoDesplazamiento1 extends AppCompatActivity {
TextView vm_Formula,vm_valor,dt_valor,resultado,unidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_calculo_desplazamiento1);
        vm_Formula=(TextView)findViewById(R.id.vm_Formula);
        vm_valor=(TextView)findViewById(R.id.vm_valor);
        dt_valor=(TextView)findViewById(R.id.dt_valor);
        resultado=(TextView)findViewById(R.id.resultado);
        unidad=(TextView)findViewById(R.id.unidad);


        vm_Formula.setText(Html.fromHtml("ω<sub>m</sub>"));
        unidad.setText("[rad]");

        Double vm=getIntent().getDoubleExtra("vm",0);
        Double t=getIntent().getDoubleExtra("t",0);
        Double d=getIntent().getDoubleExtra("d",0);
        //ubicacion de los valores en los textView
        vm_valor.setText(String.format("%.3f",vm));
        dt_valor.setText("("+String.format("%.3f",t)+")");
        resultado.setText(String.format("%.3f", d));
    }
}
