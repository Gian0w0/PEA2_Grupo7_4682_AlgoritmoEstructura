// ==========================================
// Actividad 4: Listas Dobles y Circulares en Java
// ==========================================

// 1. Nodo y Lista Doblemente Enlazada (Soporte Bidireccional)
class NodoDoble {
    String casoId;
    NodoDoble siguiente;
    NodoDoble anterior;

    public NodoDoble(String casoId) {
        this.casoId = casoId;
        this.siguiente = null;
        this.anterior = null;
    }
}

class ListaDobleSolicitudes {
    NodoDoble head;

    public void insertarFinal(String casoId) {
        NodoDoble nuevoNodo = new NodoDoble(casoId);
        if (head == null) {
            head = nuevoNodo;
        } else {
            NodoDoble actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
            nuevoNodo.anterior = actual;
        }
    }
}

// 2. Nodo y Lista Circular (Rotación de Turnos / Módulos)
class NodoCircular {
    String modulo;
    NodoCircular siguiente;

    public NodoCircular(String modulo) {
        this.modulo = modulo;
        this.siguiente = null;
    }
}

class ListaCircularTurnos {
    NodoCircular head;

    public void agregar(String modulo) {
        NodoCircular nuevoNodo = new NodoCircular(modulo);
        if (head == null) {
            head = nuevoNodo;
            nuevoNodo.siguiente = head;
        } else {
            NodoCircular actual = head;
            while (actual.siguiente != head) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo_nodo;
            nuevo_nodo.siguiente = head;
        }
    }
}
