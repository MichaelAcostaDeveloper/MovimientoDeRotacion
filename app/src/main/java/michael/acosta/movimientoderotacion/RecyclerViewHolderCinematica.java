package michael.acosta.movimientoderotacion;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolderCinematica extends RecyclerView.ViewHolder {
    TextView t1;//variables para titulos y subtitulos
    ImageView imagen;//variable para las imagenes
    public RecyclerViewHolderCinematica(View itemView) {
        super(itemView);
        t1=(TextView)itemView.findViewById(R.id.TextView_tema);//casteo para TextView del layout card_view_cinematica
        imagen=(ImageView)itemView.findViewById(R.id.imagen_tema);//casteo para ImageView del layout card_view_cinematica
    }
}
