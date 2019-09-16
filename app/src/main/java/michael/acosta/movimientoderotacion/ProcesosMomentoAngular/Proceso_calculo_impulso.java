package michael.acosta.movimientoderotacion.ProcesosMomentoAngular;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_calculo_impulso extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_calculo_impulso);

        TextView Lo=(TextView)findViewById(R.id.Lo_Formula);
        TextView Lf=(TextView)findViewById(R.id.Lf_Formula);
        TextView Linicial=(TextView)findViewById(R.id.Lo_valor);
        TextView Lfinal=(TextView)findViewById(R.id.Lf_valor);
        TextView dL=(TextView)findViewById(R.id.resultado);

        Lo.setText(Html.fromHtml("L<sub>o</sub>"));
        Lf.setText(Html.fromHtml("L<sub>f</sub>"));

        Double Momento_inicial=getIntent().getDoubleExtra("Lo",0);
        Double Momento_final=getIntent().getDoubleExtra("Lf",0);
        Double impulso=getIntent().getDoubleExtra("dL",0);
        //ubicacion de los valores en los textView
        Linicial.setText(String.format("%.3f",Momento_inicial));
        Lfinal.setText(String.format("%.3f",Momento_final));
        dL.setText(String.format("%.3f",impulso));
    }
}
