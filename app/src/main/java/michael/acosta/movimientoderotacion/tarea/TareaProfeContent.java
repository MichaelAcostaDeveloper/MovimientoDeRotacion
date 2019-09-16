package michael.acosta.movimientoderotacion.tarea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TareaProfeContent {
    //Arreglo de muestra
    public static final List<TareaProfe> ITEMS = new ArrayList<TareaProfe>();
    //Un mapa de elementos de muestra (TareaProfe), por ID.
    public static final Map<String, TareaProfe> ITEM_MAP = new HashMap<String, TareaProfe>();
    public static void addItem(TareaProfe item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.codigo, item);
    }
    public static void updateItem(TareaProfe item) {
        ITEMS.set(ITEMS.indexOf(item), item);
        ITEM_MAP.put(item.getCodigo(), item);
    }
    public static void deleteItem(TareaProfe item) {
        ITEMS.remove(item);
        ITEM_MAP.remove(item);
    }
    public static void cleanAdapter(){
        ITEMS.clear();
    }
    public static TareaProfe getTareaProfeA(String name) {
        for (TareaProfe nombre : ITEMS) {
            if (nombre.getNombre().equals(name)){
                return nombre;
            }
        }
        return null;
    }
    //Objeto Tarea.
    public static class TareaProfe {
        private String id;
        private String codigo;
        private String nombre;
        private String detalle;
        //constructor vacio
        public TareaProfe() {
        }
        public TareaProfe(String codigo, String nombre, String detalle) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.detalle = detalle;
        }
        public TareaProfe(String id, String codigo, String nombre, String detalle) {
            this.id = id;
            this.codigo = codigo;
            this.nombre = nombre;
            this.detalle = detalle;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getCodigo() {
            return codigo;
        }
        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getDetalle() {
            return detalle;
        }
        public void setDetalle(String detalle) {
            this.detalle = detalle;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TareaProfe that = (TareaProfe) o;
            return id != null ? id.equals(that.id) : that.id == null;
        }
        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }
    }
}