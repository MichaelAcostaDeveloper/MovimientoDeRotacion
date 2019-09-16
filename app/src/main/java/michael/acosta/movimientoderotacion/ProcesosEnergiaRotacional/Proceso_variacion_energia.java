package michael.acosta.movimientoderotacion.ProcesosEnergiaRotacional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_variacion_energia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_variacion_energia);

        TextView Eo=(TextView)findViewById(R.id.Eco_Formula);
        TextView Ef=(TextView)findViewById(R.id.Ecf_Formula);
        TextView Einicial=(TextView)findViewById(R.id.Eco_valor);
        TextView Efinal=(TextView)findViewById(R.id.Ecf_valor);
        TextView dE=(TextView)findViewById(R.id.resultado);

        Eo.setText(Html.fromHtml("Ec<sub>o</sub>"));
        Ef.setText(Html.fromHtml("Ec<sub>f</sub>"));

        Double Energia_inicial=getIntent().getDoubleExtra("Eo",0);
        Double Energia_final=getIntent().getDoubleExtra("Ef",0);
        Double Variacion_energia=getIntent().getDoubleExtra("dE",0);
        //ubicacion de los valores en los textView
        Einicial.setText(String.format("%.3f",Energia_inicial));
        Efinal.setText(String.format("%.3f",Energia_final));
        dE.setText(String.format("%.3f",Variacion_energia));
    }
}
