package michael.acosta.movimientoderotacion.ProcesosCinematica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class ProcesoTiempo1 extends AppCompatActivity {
    TextView t1,t2,t3,tFormula1_resultado,dFormula1,vmFormula1,d_valor,vm_valor,resultado,unidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_tiempo1);

        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        tFormula1_resultado=(TextView)findViewById(R.id.tFormula1_resultado);
        dFormula1=(TextView)findViewById(R.id.dFormula1);
        vmFormula1=(TextView)findViewById(R.id.vmFormula1);
        d_valor=(TextView)findViewById(R.id.d_valor);
        vm_valor=(TextView)findViewById(R.id.vm_valor);

        unidad=(TextView)findViewById(R.id.unidad);
        resultado=(TextView)findViewById(R.id.resultado);

        t1.setText(Html.fromHtml("Δt"));
        t2.setText(Html.fromHtml("Δt"));
        t3.setText(Html.fromHtml("Δt"));
        tFormula1_resultado.setText(Html.fromHtml("Δt"));
        dFormula1.setText(Html.fromHtml("Δθ"));
        vmFormula1.setText(Html.fromHtml("ω<sub>m</sub>"));
        unidad.setText("[s]");


       Double d=getIntent().getDoubleExtra("d",0);
       Double vm=getIntent().getDoubleExtra("vm",0);
       Double t=getIntent().getDoubleExtra("t",0);
        //ubicacion de los valores en los textView
       d_valor.setText(String.format("%.3f",d));
       vm_valor.setText(String.format("%.3f",vm));
       resultado.setText(String.format("%.3f", t));
    }
}
