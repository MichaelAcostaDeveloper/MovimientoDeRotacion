package michael.acosta.movimientoderotacion.ProcesosMomentoAngular;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_calculo_velocidad extends AppCompatActivity {
    Double Momento,velocidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_calculo_velocidad2);



        TextView Mformula=(TextView)findViewById(R.id.momentum_formula);
        TextView Mvalor=(TextView)findViewById(R.id.momentum_valor);
        TextView Ivalor=(TextView)findViewById(R.id.inercia_valor);
        TextView resultado=(TextView)findViewById(R.id.resultado);

        Intent recibir=getIntent();
        int caso= recibir.getIntExtra("c",0);
        switch (caso){
            case 1:
                //caso 1
                Mformula.setText(Html.fromHtml("(L<sub>o</sub>)"));
                velocidad=getIntent().getDoubleExtra("wo",0);
                Momento=getIntent().getDoubleExtra("Lo",0);
                break;
            case 2:
                //caso 2
                Mformula.setText(Html.fromHtml("(L<sub>f</sub>)"));
                velocidad=getIntent().getDoubleExtra("wf",0);
                Momento=getIntent().getDoubleExtra("Lf",0);
                break;
        }

        Double Inercia=getIntent().getDoubleExtra("I",0);
        //ubicacion de los valores en los textView
        Mvalor.setText(String.format("%.3f",Momento));
        resultado.setText(String.format("%.3f",velocidad));
        Ivalor.setText(String.format("%.3f",Inercia));
    }
}
