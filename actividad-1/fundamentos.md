# Actividad 1: Fundamentos y representación de listas enlazadas

**Responsable:** Joseph Gianmarco Soberon Leon  
**Evaluación:** PA2 – Grupo 7

## 1. Definición de lista enlazada

Una lista enlazada es una estructura de datos dinámica compuesta por nodos conectados mediante referencias.

Cada nodo almacena un dato y una referencia que permite acceder al siguiente nodo.

A diferencia de los arreglos, los nodos de una lista enlazada no necesitan ocupar posiciones consecutivas de memoria.

## 2. Clasificación de listas enlazadas

### Lista simplemente enlazada

Cada nodo contiene un dato y una referencia al siguiente nodo. Su recorrido se realiza hacia adelante.

### Lista doblemente enlazada

Cada nodo contiene un dato y dos referencias: una hacia el nodo anterior y otra hacia el siguiente. Permite recorrer la lista en ambas direcciones.

### Lista circular

El último nodo se conecta nuevamente con el primero, formando un ciclo. Existen listas circulares simples y dobles.

## 3. Caso práctico: solicitudes de atención

Una organización necesita registrar y gestionar solicitudes de atención.

Para representar esta situación se utiliza una lista simplemente enlazada con cinco nodos:

**Cabeza → S001 → S002 → S003 → S004 → S005 → NULL**

Cada nodo almacena el código de una solicitud y una referencia al siguiente nodo.

- S001: primera solicitud y cabeza de la lista.
- S002, S003 y S004: solicitudes intermedias.
- S005: última solicitud, cuya referencia apunta a NULL.

## 4. Funcionamiento de la estructura

Para consultar una solicitud, se comienza desde la cabeza y se recorren los nodos siguiendo sus referencias hasta encontrar el elemento solicitado o llegar al final.

Por ejemplo, para encontrar S004, se revisan sucesivamente S001, S002, S003 y S004.

La lista permite incorporar nuevas solicitudes modificando los enlaces correspondientes.

## 5. Representación gráfica


```mermaid
flowchart LR
    HEAD --> S001
    S001 --> S002
    S002 --> S003
    S003 --> S004
    S004 --> S005
    S005 --> NULL
```

**Figura 1.** Representación de cinco solicitudes de atención mediante una lista simplemente enlazada.

Cada nodo almacena el código de una solicitud y una referencia al siguiente nodo. HEAD señala el primer nodo y NULL representa el final de la lista.


## 6. Conclusión

Las listas enlazadas permiten organizar información dinámica mediante nodos conectados. Su principal ventaja es facilitar operaciones de inserción y eliminación mediante cambios en los enlaces, aunque localizar un elemento puede requerir recorrer varios nodos.
