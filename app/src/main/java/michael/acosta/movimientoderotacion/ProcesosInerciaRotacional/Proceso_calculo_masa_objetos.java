package michael.acosta.movimientoderotacion.ProcesosInerciaRotacional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import michael.acosta.movimientoderotacion.R;

public class Proceso_calculo_masa_objetos extends AppCompatActivity {
    Double inercia,radio,masa;

    TextView TnumeradorFormula,TnumeradorEcuacion,TnumeradorValor,TdenominadorFormula,TdenominadorEcuacion,Tdenominadorvalor,resultado,valor_radio,valor_inercia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String temaActivity=getIntent().getStringExtra("titulo");
        setTitle(temaActivity);
        setTheme(R.style.Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_calculo_masa_objetos);

        TnumeradorFormula=(TextView)findViewById(R.id.numeradorFormula);
        TnumeradorEcuacion=(TextView)findViewById(R.id.numeradorEcuacion);
        TnumeradorValor=(TextView)findViewById(R.id.numeradorValor);
        TdenominadorFormula=(TextView)findViewById(R.id.denominadorFormula);
        TdenominadorEcuacion=(TextView)findViewById(R.id.denominadorEcuacion);
        Tdenominadorvalor=(TextView)findViewById(R.id.denominadorValor);

        resultado=(TextView)findViewById(R.id.resultado);
        valor_inercia=(TextView)findViewById(R.id.inercia);
        valor_radio=(TextView)findViewById(R.id.radio);

        int caso= getIntent().getIntExtra("objeto",0);
        switch (caso){
            case 1:
                TnumeradorFormula.setText("2");
                TnumeradorEcuacion.setText("2");
                TnumeradorValor.setText("2");
                TdenominadorFormula.setText("1");
                TdenominadorEcuacion.setText("1");
                Tdenominadorvalor.setText("1");
                break;
            case 2:
                TnumeradorFormula.setText("5");
                TnumeradorEcuacion.setText("5");
                TnumeradorValor.setText("5");
                TdenominadorFormula.setText("2");
                TdenominadorEcuacion.setText("2");
                Tdenominadorvalor.setText("2");
                break;
            case 3:
                TnumeradorFormula.setText("3");
                TnumeradorEcuacion.setText("3");
                TnumeradorValor.setText("3");
                TdenominadorFormula.setText("2");
                TdenominadorEcuacion.setText("2");
                Tdenominadorvalor.setText("2");
                break;
            case 4:
                TnumeradorFormula.setText("3");
                TnumeradorEcuacion.setText("3");
                TnumeradorValor.setText("3");
                TdenominadorFormula.setText("1");
                TdenominadorEcuacion.setText("1");
                Tdenominadorvalor.setText("1");
                break;
            case 5:
                TnumeradorFormula.setText("12");
                TnumeradorEcuacion.setText("12");
                TnumeradorValor.setText("12");
                TdenominadorFormula.setText("1");
                TdenominadorEcuacion.setText("1");
                Tdenominadorvalor.setText("1");
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

        inercia=getIntent().getDoubleExtra("I",0);
        radio=getIntent().getDoubleExtra("r",0);
        masa=getIntent().getDoubleExtra("m",0);
        valor_inercia.setText(String.format("%.3f",inercia));
        valor_radio.setText(String.format("%.3f",radio));
        resultado.setText(String.format("%.3f",masa));

    }
}
