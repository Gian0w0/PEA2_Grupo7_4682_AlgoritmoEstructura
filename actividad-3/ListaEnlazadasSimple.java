public class ListaEnlazadasSimple {

    public static class Nodo {
        String codigo;
        String estado;
        Nodo siguiente;

        Nodo(String codigo, String estado) {
            this.codigo = codigo;
            this.estado = estado;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;


    public void insertarAlInicio(String codigo, String estado) {
        Nodo nuevo = new Nodo(codigo, estado);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public void insertarAlFinal(String codigo, String estado) {
        Nodo nuevo = new Nodo(codigo, estado);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }



    public Nodo buscar(String codigo) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.codigo.equals(codigo)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void modificar(String codigo, String nuevoEstado) {
        Nodo nodo = buscar(codigo);
        if (nodo == null) {
            System.out.println("No existe la solicitud " + codigo);
            return;
        }
        nodo.estado = nuevoEstado;
    }



    public void eliminar(String codigo) {

        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (cabeza.codigo.equals(codigo)) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;
        while (actual != null) {
            if (actual.codigo.equals(codigo)) {
                anterior.siguiente = actual.siguiente;
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        System.out.println("No existe la solicitud " + codigo);
    }

    public void mostrar() {
        Nodo actual = cabeza;
        System.out.print("HEAD -> ");
        while (actual != null) {
            System.out.print("[" + actual.codigo + " | " + actual.estado + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        ListaEnlazadasSimple lista = new ListaEnlazadasSimple();
        lista.insertarAlInicio("S001", "Pendiente");
        lista.insertarAlFinal("S002", "Pendiente");
        lista.insertarAlFinal("S003", "Pendiente");
        lista.insertarAlFinal("S004", "Pendiente");
        lista.insertarAlFinal("S005", "Pendiente");
        lista.mostrar();

        System.out.println("Buscar S003: " + (lista.buscar("S003") != null ? "encontrado" : "no existe"));

        lista.modificar("S003", "Atendida");
        lista.mostrar();

        lista.eliminar("S001"); // primero
        lista.eliminar("S003"); // intermedio
        lista.eliminar("S005"); // último
        lista.mostrar();
    }

}