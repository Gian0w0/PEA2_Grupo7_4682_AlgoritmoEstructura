# Actividad 4: Listas Dobles y Circulares

## 1. Listas Doblemente Enlazadas en el Caso de Solicitudes de Atención

### Situación de aplicación
En el flujo de gestión y soporte de solicitudes, los operadores a menudo necesitan revisar los casos históricos. Con frecuencia, requieren avanzar al siguiente caso, pero también retroceder inmediatamente al caso anterior para contrastar datos o verificar cambios previos sin tener que reiniciar la búsqueda o el recorrido desde el inicio de la estructura.

### Justificación frente a una lista simple
Una lista enlazada simple solo permite el recorrido en una sola dirección (siguiente), lo que vuelve ineficiente el retorno a un nodo previo O(n). En contraste, una lista doble incluye dos punteros en cada nodo (siguiente y anterior). Esto permite un desplazamiento bidireccional instantáneo O(1) hacia adelante y hacia atrás, optimizando el tiempo del operador al navegar entre expedientes correlativos.

### Representación Gráfica
[ NULL ] <==> [ Head: Caso 101 ] <==> [ Caso 102 ] <==> [ Tail: Caso 103 ] <==> [ NULL ]

---

## 2. Listas Circulares en el Caso de Solicitudes de Atención

### Situación de aplicación
Se requiere implementar un sistema de asignación y rotación continua (tipo round-robin) entre los diferentes módulos de atención o turnos de los operadores disponibles. Al llegar al último módulo registrado, el flujo del sistema debe retornar automáticamente al primer operador de forma cíclica e indefinida, asegurando que la revisión de casos pendientes nunca se detenga.

### Justificación frente a una lista simple
En una lista simple o doble convencional, al llegar al último nodo el puntero apunta a NULL, lo que cortaría el flujo y requeriría lógica adicional para reiniciar el ciclo. Una lista circular conecta el puntero del último nodo directamente con la cabeza (head) de la lista, formando un anillo cerrado que simplifica enormemente la programación de colas de atención rotativas y tableros de monitoreo en bucle.

### Representación Gráfica
      +-------------------------------------------------------+
      |                                                       |
      v                                                       |
[ Head: Módulo A ] ---> [ Módulo B ] ---> [ Módulo C ] --------+

---

## 3. Implementación Técnica (Código Base en Python)

A continuación se muestra el modelado en código para ambas estructuras aplicadas al caso:

```python
class NodoDoble:
    def __init__(self, caso_id):
        self.caso_id = caso_id
        self.siguiente = None
        self.anterior = None

class ListaDobleSolicitudes:
    def __init__(self):
        self.head = None

    def insertar_final(self, caso_id):
        nuevo_nodo = NodoDoble(caso_id)
        if not self.head:
            self.head = nuevo_nodo
        else:
            actual = self.head
            while actual.siguiente:
                actual = actual.siguiente
            actual.siguiente = nuevo_nodo
            nuevo_nodo.anterior = actual

    def recorrer_adelante(self):
        actual = self.head
        elementos = []
        while actual:
            elementos.append(actual.caso_id)
            actual = actual.siguiente
        return elementos

class NodoCircular:
    def __init__(self, modulo):
        self.modulo = modulo
        self.siguiente = None

class ListaCircularTurnos:
    def __init__(self):
        self.head = None

    def agregar(self, modulo):
        nuevo_nodo = NodoCircular(modulo)
        if not self.head:
            self.head = nuevo_nodo
            nuevo_nodo.siguiente = self.head
        else:
            actual = self.head
            while actual.siguiente != self.head:
                actual = actual.siguiente
            actual.siguiente = nuevo_nodo
            nuevo_nodo.siguiente = self.head

    def simular_rotacion(self, pasos=3):
        if not self.head:
            return []
        resultado = []
        actual = self.head
        for _ in range(pasos):
            resultado.append(actual.modulo)
            actual = actual.siguiente
        return resultado
