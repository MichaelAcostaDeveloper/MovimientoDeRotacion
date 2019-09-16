package michael.acosta.movimientoderotacion.ProcesosEnergiaRotacional;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_calculo_inercia extends AppCompatActivity {
Double Energia,velocidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_calculo_inercia);

        TextView Eformula=(TextView)findViewById(R.id.energia_formula);
        TextView E=(TextView)findViewById(R.id.energia_valor);
        TextView wformula=(TextView)findViewById(R.id.velocidad_formula);
        TextView w=(TextView)findViewById(R.id.velocidad_valor);
        TextView I=(TextView)findViewById(R.id.resultado);

        Intent recibir=getIntent();
        int caso= recibir.getIntExtra("c",0);
        switch (caso){
            case 1:
                //caso 1
                Eformula.setText(Html.fromHtml("2(Ec<sub>o</sub>)"));
                wformula.setText(Html.fromHtml("(ω<sub>o</sub>)<sup>2</sup>"));
                Energia=getIntent().getDoubleExtra("Eo",0);
                velocidad=getIntent().getDoubleExtra("wo",0);
                break;
            case 2:
                //caso 2
                Eformula.setText(Html.fromHtml("2(Ec<sub>f</sub>)"));
                wformula.setText(Html.fromHtml("(ω<sub>f</sub>)<sup>2</sup>"));
                Energia=getIntent().getDoubleExtra("Ef",0);
                velocidad=getIntent().getDoubleExtra("wf",0);
                break;
        }
        Double Inercia=getIntent().getDoubleExtra("I",0);
        //ubicacion de los valores en los textView
        E.setText(String.format("%.3f",Energia*2));
        w.setText(String.format("%.3f",Math.pow(velocidad,2)));
        I.setText(String.format("%.3f",Inercia));
    }
}
