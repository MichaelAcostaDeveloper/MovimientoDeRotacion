package michael.acosta.movimientoderotacion.ProcesosMomentoAngular;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_calculo_inercia extends AppCompatActivity {
    Double Momentum,velocidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_calculo_inercia2);

        TextView Lformula=(TextView)findViewById(R.id.momentum_formula);
        TextView L=(TextView)findViewById(R.id.momentum_valor);
        TextView wformula=(TextView)findViewById(R.id.velocidad_formula);
        TextView w=(TextView)findViewById(R.id.velocidad_valor);
        TextView I=(TextView)findViewById(R.id.resultado);

        Intent recibir=getIntent();
        int c= recibir.getIntExtra("c",0);
        switch (c){
            case 1:
                //caso 1
                Lformula.setText(Html.fromHtml("L<sub>o</sub>"));
                wformula.setText(Html.fromHtml("ω<sub>o</sub>"));
                Momentum=getIntent().getDoubleExtra("Lo",0);
                velocidad=getIntent().getDoubleExtra("wo",0);
                break;
            case 2:
                //caso 2
                Lformula.setText(Html.fromHtml("L<sub>f</sub>"));
                wformula.setText(Html.fromHtml("ω<sub>f</sub>"));
                Momentum=getIntent().getDoubleExtra("Lf",0);
                velocidad=getIntent().getDoubleExtra("wf",0);
                break;
        }
        Double Inercia=getIntent().getDoubleExtra("I",0);
        //ubicacion de los valores en los textView
        L.setText(String.format("%.3f",Momentum));
        w.setText(String.format("%.3f",velocidad));
        I.setText(String.format("%.3f",Inercia));
    }
}
