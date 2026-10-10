
public class ListaSolicitudes {

    static class Nodo {
        String dato;
        Nodo siguiente;

        Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public static void main(String[] args) {

        // Crear cinco solicitudes
        Nodo n1 = new Nodo("S001");
        Nodo n2 = new Nodo("S002");
        Nodo n3 = new Nodo("S003");
        Nodo n4 = new Nodo("S004");
        Nodo n5 = new Nodo("S005");

        // Conectar los nodos
        n1.siguiente = n2;
        n2.siguiente = n3;
        n3.siguiente = n4;
        n4.siguiente = n5;

        // Establecer la cabeza
        Nodo cabeza = n1;

        // Recorrer la lista
        Nodo actual = cabeza;

        System.out.println("SOLICITUDES DE ATENCION:");

        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
