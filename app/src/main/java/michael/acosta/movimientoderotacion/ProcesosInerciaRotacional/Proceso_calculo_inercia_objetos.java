package michael.acosta.movimientoderotacion.ProcesosInerciaRotacional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_calculo_inercia_objetos extends AppCompatActivity {
    Double Inercia,masa,radio;

    TextView TnumeradorFormula,TnumeradorEcuacion,TnumeradorValor,TdenominadorFormula,TdenominadorEcuacion,Tdenominadorvalor,resultado,masaValor,radioValor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_calculo_inercia_objetos);

      TnumeradorFormula=(TextView)findViewById(R.id.numeradorFormula);
      TnumeradorEcuacion=(TextView)findViewById(R.id.numeradorEcuacion);
      TnumeradorValor=(TextView)findViewById(R.id.numeradorValor);
      TdenominadorFormula=(TextView)findViewById(R.id.denominadorFormula);
      TdenominadorEcuacion=(TextView)findViewById(R.id.denominadorEcuacion);
      Tdenominadorvalor=(TextView)findViewById(R.id.denominadorValor);

      resultado=(TextView)findViewById(R.id.resultado);
      masaValor=(TextView)findViewById(R.id.masa_valor);
      radioValor=(TextView)findViewById(R.id.radio_valor);

        int caso= getIntent().getIntExtra("objeto",0);
        switch (caso){
            case 1:
                TnumeradorFormula.setText("1");
                TnumeradorEcuacion.setText("1");
                TnumeradorValor.setText("1");
                TdenominadorFormula.setText("2");
                TdenominadorEcuacion.setText("2");
                Tdenominadorvalor.setText("2");
                break;
            case 2:
                TnumeradorFormula.setText("2");
                TnumeradorEcuacion.setText("2");
                TnumeradorValor.setText("2");
                TdenominadorFormula.setText("5");
                TdenominadorEcuacion.setText("5");
                Tdenominadorvalor.setText("5");
                break;
            case 3:
                TnumeradorFormula.setText("2");
                TnumeradorEcuacion.setText("2");
                TnumeradorValor.setText("2");
                TdenominadorFormula.setText("3");
                TdenominadorEcuacion.setText("3");
                Tdenominadorvalor.setText("3");
                break;
            case 4:
                TnumeradorFormula.setText("1");
                TnumeradorEcuacion.setText("1");
                TnumeradorValor.setText("1");
                TdenominadorFormula.setText("3");
                TdenominadorEcuacion.setText("3");
                Tdenominadorvalor.setText("3");
                break;
            case 5:
                TnumeradorFormula.setText("1");
                TnumeradorEcuacion.setText("1");
                TnumeradorValor.setText("1");
                TdenominadorFormula.setText("12");
                TdenominadorEcuacion.setText("12");
                Tdenominadorvalor.setText("12");
                break;
            case 6:
                TnumeradorFormula.setText("");
                TnumeradorEcuacion.setText("");
                TnumeradorValor.setText("");
                TdenominadorFormula.setText("1");
                TdenominadorEcuacion.setText("1");
                Tdenominadorvalor.setText("1");
                break;
            case 7:
                TnumeradorFormula.setText("");
                TnumeradorEcuacion.setText("");
                TnumeradorValor.setText("");
                TdenominadorFormula.setText("1");
                TdenominadorEcuacion.setText("1");
                Tdenominadorvalor.setText("1");
                break;
        }

        masa=getIntent().getDoubleExtra("m",0);
        radio=getIntent().getDoubleExtra("r",0);
        Inercia=getIntent().getDoubleExtra("I",0);
        masaValor.setText(String.format("%.3f",masa));
        radioValor.setText(String.format("%.3f",radio));
        resultado.setText(String.format("%.3f",Inercia));

    }
}
