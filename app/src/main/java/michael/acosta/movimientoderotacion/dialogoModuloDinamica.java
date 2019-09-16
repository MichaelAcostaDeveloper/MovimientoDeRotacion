package michael.acosta.movimientoderotacion;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class dialogoModuloDinamica extends DialogFragment {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(getContext(),
                android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View vista=inflater.inflate(R.layout.dialogo_bienvenida,null);
        builder.setTitle("Información");
        builder.setIcon(R.drawable.airscrew);
        //builder.setCanceledOnTouchOutside(false);
        builder.setCancelable(false);
        builder.setView(vista);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),
                        "Seleccione el objeto que desea analizar.",Toast.LENGTH_SHORT).show();
                dismiss();
                           }
        });
        TextView textView=(TextView)vista.findViewById(R.id.contenidoDialogo);
        textView.setText("Bienvenido a RotationDroid.\n" +
                         "Este módulo permite resolver problemas de dinámica de rotación.\n");
        return builder.create();
    }
}

