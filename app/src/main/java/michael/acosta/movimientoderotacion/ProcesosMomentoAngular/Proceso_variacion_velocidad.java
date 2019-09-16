package michael.acosta.movimientoderotacion.ProcesosMomentoAngular;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_variacion_velocidad extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_variacion_velocidad);

        TextView wo=(TextView)findViewById(R.id.wo_Formula);
        TextView wf=(TextView)findViewById(R.id.wf_Formula);
        TextView winicial=(TextView)findViewById(R.id.wo_valor);
        TextView wfinal=(TextView)findViewById(R.id.wf_valor);
        TextView dw=(TextView)findViewById(R.id.resultado);

        wo.setText(Html.fromHtml("ω<sub>o</sub>"));
        wf.setText(Html.fromHtml("ω<sub>f</sub>"));

        Double Velocidad_inicial=getIntent().getDoubleExtra("wo",0);
        Double Velocidad_final=getIntent().getDoubleExtra("wf",0);
        Double Variacion_velocidad=getIntent().getDoubleExtra("dw",0);
        //ubicacion de los valores en los textView
        winicial.setText(String.format("%.3f",Velocidad_inicial));
        wfinal.setText(String.format("%.3f",Velocidad_final));
        dw.setText(String.format("%.3f",Variacion_velocidad));
    }
}
