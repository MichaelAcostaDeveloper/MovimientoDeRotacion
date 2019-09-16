package michael.acosta.movimientoderotacion.persona;
//import com.google.firebase.database.Exclude;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TareaContent {
    public static final List<Tarea> ITEMS = new ArrayList<Tarea>();
    public static final Map<String, Tarea> ITEM_MAP = new HashMap<String, Tarea>();
    //se hace publico este metodo
    public static void addItem(Tarea item) {
        ITEMS.add(item);

    }
    //metodo para actualizar
    public static void updateItem(Tarea tarea){
        ITEMS.set(ITEMS.indexOf(tarea), tarea);
    }
    //metodo para borrar
    public static void deleteItem(Tarea tarea){
        ITEMS.remove(tarea);
    }
    public static void cleanAdapter(){
        ITEMS.clear();
    }
    public static Tarea getTareaA(String numPregunta) {
        for (Tarea work : ITEMS) {
            if (work.getNumPregunta().equals(numPregunta)){
                return work;
            }
        }
        return null;
    }
//objeto tarea
    public static class Tarea {
        private String id;
        private String numPregunta;
        private String respuesta;
        private String unidad;

        public Tarea() {
        }
    //constructor con NUM PREGUNTA, RESULTADO Y UNIDAD
        public Tarea(String numPregunta, String respuesta, String unidad) {
            this.numPregunta = numPregunta;
            this.respuesta = respuesta;
            this.unidad = unidad;
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumPregunta() {
        return numPregunta;
    }

    public void setNumPregunta(String numPregunta) {
        this.numPregunta = numPregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tarea tarea = (Tarea) o;

        return id != null ? id.equals(tarea.id) : tarea.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String toString() {
            return numPregunta;
        }
    }
}
