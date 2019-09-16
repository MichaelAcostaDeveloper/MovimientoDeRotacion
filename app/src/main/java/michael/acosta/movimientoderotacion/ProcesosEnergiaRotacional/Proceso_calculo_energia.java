package michael.acosta.movimientoderotacion.ProcesosEnergiaRotacional;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_calculo_energia extends AppCompatActivity {

    Double Inercia,velocidad,Energia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_calculo_energia);

        TextView Iformula=(TextView)findViewById(R.id.inercia_formula);
        TextView wformula=(TextView)findViewById(R.id.velocidad_formula);
        TextView IValor=(TextView)findViewById(R.id.inercia_valor);
        TextView wValor=(TextView)findViewById(R.id.vel_valor);
        TextView E=(TextView)findViewById(R.id.resultado);

        Intent recibir=getIntent();
        int c= recibir.getIntExtra("c",0);
        switch (c){
            case 1:
                //caso 1
                Iformula.setText(Html.fromHtml("(I)"));
                wformula.setText(Html.fromHtml("(ω<sub>o</sub>)<sup>2</sup>"));
                Inercia=getIntent().getDoubleExtra("I",0);
                velocidad=getIntent().getDoubleExtra("wo",0);
                Energia=getIntent().getDoubleExtra("Eo",0);
                break;
            case 2:
                //caso 2
                Iformula.setText(Html.fromHtml("(I)"));
                wformula.setText(Html.fromHtml("(ω<sub>f</sub>)<sup>2</sup>"));
                Inercia=getIntent().getDoubleExtra("I",0);
                velocidad=getIntent().getDoubleExtra("wf",0);
                Energia=getIntent().getDoubleExtra("Ef",0);
                break;
        }

        //ubicacion de los valores en los textView
        IValor.setText(String.format("%.3f",Inercia));
        wValor.setText(String.format("%.3f",Math.pow(velocidad,2)));
        E.setText(String.format("%.3f",Energia));
    }
}
