package michael.acosta.movimientoderotacion;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolderDinamica extends RecyclerView.ViewHolder {
    TextView t1D;
    ImageView imagenD;
    public RecyclerViewHolderDinamica(View itemView) {
        super(itemView);
        t1D=(TextView)itemView.findViewById(R.id.TextView_temaDinamica);
        imagenD=(ImageView)itemView.findViewById(R.id.imagen_temaDinamica);
    }
}
