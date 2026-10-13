# PA2 — Actividad 2A: Recorrido e inserción en listas enlazadas

**Curso:** Algoritmo y Estructura de Datos Basados en Inteligencia Artificial  
**Grupo:** 7  
**Responsable:** Claudio  
**Tema:** Gestión de solicitudes de atención mediante listas enlazadas simples.

## 1. Recorrido completo de la lista

### Objetivo

Recorrer todos los nodos de una lista enlazada simple para mostrar los códigos de las solicitudes registradas. El recorrido comienza en el primer nodo y finaliza cuando se llega a `NULL`.

### Pseudocódigo

```text
Algoritmo RecorrerLista
    actual <- inicio

    Mientras actual <> NULL Hacer
        Escribir actual.codigo
        actual <- actual.siguiente
    FinMientras
FinAlgoritmo
```

### Explicación

Primero, la variable `actual` apunta al primer nodo de la lista. Después, se muestra el código de la solicitud y se avanza al siguiente nodo mediante el campo `siguiente`. Este proceso se repite hasta que `actual` sea igual a `NULL`.

### Complejidad

La complejidad temporal es O(n), porque es necesario visitar los nodos de la lista para completar el recorrido.

## 2. Inserción al inicio

### Objetivo

Agregar una nueva solicitud al principio de la lista enlazada, convirtiéndola en el primer nodo.

### Pseudocódigo

```text
Algoritmo InsertarInicio(codigo)
    nuevo <- CrearNodo(codigo)
    nuevo.siguiente <- inicio
    inicio <- nuevo
FinAlgoritmo
```

### Representación gráfica

**Antes de insertar S000:**

`inicio -> [S001] -> [S002] -> [S003] -> NULL`

**Después de insertar S000:**

`inicio -> [S000] -> [S001] -> [S002] -> [S003] -> NULL`

### Explicación

Se crea un nuevo nodo con el código de la solicitud. Luego, su enlace `siguiente` apunta al nodo que anteriormente era el primero. Finalmente, el puntero `inicio` se actualiza para que apunte al nuevo nodo.

Si la lista está vacía, el nuevo nodo se convierte en el primero y su enlace `siguiente` queda en `NULL`.

### Complejidad

La complejidad temporal es O(1), porque solo se necesita crear el nodo y actualizar las referencias, sin recorrer la lista.

## 3. Inserción al final

### Objetivo

Agregar una nueva solicitud después del último nodo de la lista enlazada simple.

### Pseudocódigo

```text
Algoritmo InsertarFinal(codigo)
    nuevo <- CrearNodo(codigo)
    nuevo.siguiente <- NULL

    Si inicio = NULL Entonces
        inicio <- nuevo
    SiNo
        actual <- inicio

        Mientras actual.siguiente <> NULL Hacer
            actual <- actual.siguiente
        FinMientras

        actual.siguiente <- nuevo
    FinSi
FinAlgoritmo
```

### Representación gráfica

**Antes de insertar S004:**

`inicio -> [S001] -> [S002] -> [S003] -> NULL`

**Después de insertar S004:**

`inicio -> [S001] -> [S002] -> [S003] -> [S004] -> NULL`

### Explicación

Primero se crea el nuevo nodo y se establece su enlace `siguiente` en `NULL`, porque será el último elemento.

Si la lista está vacía, el puntero `inicio` apunta al nuevo nodo. Si contiene elementos, se recorre hasta encontrar el último nodo, cuyo campo `siguiente` es `NULL`. Finalmente, se actualiza ese enlace para conectarlo con el nuevo nodo.

### Complejidad

La complejidad temporal es O(n), porque en esta implementación se recorre la lista para localizar el último nodo. Si se mantuviera un puntero adicional al final, la inserción podría realizarse en O(1).

## 4. Conclusión

El recorrido y las operaciones de inserción permiten administrar dinámicamente las solicitudes de atención. El recorrido facilita consultar los registros existentes, mientras que la inserción al inicio y al final permite agregar nuevas solicitudes en diferentes posiciones. La lista enlazada simple ofrece flexibilidad para gestionar los elementos mediante la actualización de sus enlaces.
