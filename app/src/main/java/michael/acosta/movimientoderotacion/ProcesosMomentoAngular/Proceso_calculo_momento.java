package michael.acosta.movimientoderotacion.ProcesosMomentoAngular;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_calculo_momento extends AppCompatActivity {
    Double Momento,velocidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_calculo_momento);


        TextView wformula=(TextView)findViewById(R.id.velocidad_formula);
        TextView w=(TextView)findViewById(R.id.velocidad_valor);
        TextView L=(TextView)findViewById(R.id.resultado);
        TextView I=(TextView)findViewById(R.id.I_valor);
        Intent recibir=getIntent();
        int caso= recibir.getIntExtra("c",0);
        switch (caso){
            case 1:
                //caso 1
                wformula.setText(Html.fromHtml("(ω<sub>o</sub>)"));
                velocidad=getIntent().getDoubleExtra("wo",0);
                Momento=getIntent().getDoubleExtra("Lo",0);
                break;
            case 2:
                //caso 2
                wformula.setText(Html.fromHtml("(ω<sub>f</sub>)"));
                velocidad=getIntent().getDoubleExtra("wf",0);
                Momento=getIntent().getDoubleExtra("Lf",0);
                break;
        }

        Double Inercia=getIntent().getDoubleExtra("I",0);
        //ubicacion de los valores en los textView
        L.setText(String.format("%.3f",Momento));
        w.setText(String.format("%.3f",velocidad));
        I.setText(String.format("%.3f",Inercia));
    }
}
