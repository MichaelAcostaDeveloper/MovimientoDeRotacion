package michael.acosta.movimientoderotacion.estudiante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstudianteContent {
    //muestra de un arrglo
    public static final List<Estudiante> ITEMS = new ArrayList<Estudiante>();
    //muestra de mapa de estudiante por ID
    public static final Map<String, Estudiante> ITEM_MAP = new HashMap<String, Estudiante>();

    //metodos utiles
    public static void addItem(Estudiante item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
    public static void cleanAdapter(){
        ITEMS.clear();
    }

    public static void updateItem(Estudiante nombre){
        ITEMS.set(ITEMS.indexOf(nombre),nombre);
        ITEM_MAP.put(nombre.getId(),nombre);
    }

    public static void deleteItem(Estudiante nombre){
        ITEMS.remove(nombre);
        ITEM_MAP.remove(nombre);
    }


    //objeto
    public static class Estudiante{
        private String id;
        private String nombre;
        public Estudiante() {
        }
        public Estudiante(String nombre) {
            this.nombre = nombre;
        }

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Estudiante that = (Estudiante) o;

            return id != null ? id.equals(that.id) : that.id == null;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

}
