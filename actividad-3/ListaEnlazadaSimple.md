# Actividad 3: Lista enlazada simple: búsqueda, modificación y eliminación

**Responsable:** Percy Daniel Perez Rojas
**Evaluación:** PA2 – Grupo 7 

## 1. Algoritmo De Búsqueda
### Explicación

A diferencia de un arreglo, una lista enlazada no permite acceso directo por índice: para llegar a un nodo hay que pasar por todos los anteriores. Por eso la búsqueda es un **recorrido secuencial** que parte de `cabeza` y avanza de nodo en nodo comparando el código. Termina cuando encuentra la coincidencia (devuelve el nodo) o cuando llega a `NULL` (devuelve `null`). La búsqueda **no modifica ningún enlace**.

### Pseudocódigo

```
buscar(codigo):
    actual = cabeza
    mientras actual ≠ NULL:
        si actual.codigo == codigo:
            retornar actual
        actual = actual.siguiente
    retornar NULL
```

### Código

```java
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
```
### Ejemplo

Buscar `S003` en la lista de cinco nodos: se comparan `S001`, `S002` y `S003`; en el tercer nodo hay coincidencia y se devuelve la referencia.

```
      visita 1        visita 2        visita 3  ← coincide
HEAD -> [S001] -----> [S002] -----> [S003] -----> [S004] -----> [S005] -> NULL
```

Salida real del programa: `Buscar S003: encontrado`


## 2. Algoritmo para Modificar
### Explicación

Modificar consta de dos pasos: **ubicar** el nodo con `buscar` y **actualizar** su campo `estado`. Si el código no existe, no se modifica nada y se informa al usuario. Es importante notar que solo cambia el contenido del nodo: `siguiente` no se toca, el nodo no cambia de posición y la longitud de la lista es la misma.

### Pseudocódigo

```
modificar(codigo, nuevoEstado):
    nodo = buscar(codigo)
    si nodo == NULL:
        mostrar "No existe la solicitud " + codigo
        terminar proceso
    nodo.estado = nuevoEstado
```

### Código

```java
public void modificar(String codigo, String nuevoEstado) {
    Nodo nodo = buscar(codigo);
    if (nodo == null) {
        System.out.println("No existe la solicitud " + codigo);
        return;
    }
    nodo.estado = nuevoEstado;
}
```

### Ejemplo

`modificar("S003", "Atendida")` — solo cambia el dato del tercer nodo:

```
Antes:   ... -> [S003 | Pendiente] -> [S004 | Pendiente] -> ...
Después: ... -> [S003 | Atendida ] -> [S004 | Pendiente] -> ...
                         ↑ cambia el dato, el enlace sigue apuntando a S004
```

Salida real del programa:

```
HEAD -> [S001 | Pendiente] -> [S002 | Pendiente] -> [S003 | Atendida] -> [S004 | Pendiente] -> [S005 | Pendiente] -> NULL
```

## 3. Algoritmo para Eliminar
### Explicación

Eliminar un nodo **no consiste en borrarlo**, sino en **dejarlo fuera de la cadena de referencias**: una vez que ningún nodo lo apunta, queda desconectado de la lista. El recorrido usa dos referencias, `anterior` y `actual`, porque para saltar un nodo hace falta modificar el enlace del que viene antes.

Se distinguen tres reajustes de enlaces, más dos casos de control:

| Caso | Reajuste de enlaces |
|---|---|
| Lista vacía (`cabeza == NULL`) | No hay nada que eliminar; se informa y termina. |
| **Primer nodo** | `cabeza = cabeza.siguiente` — la cabeza pasa a apuntar al segundo nodo. |
| **Nodo intermedio** | `anterior.siguiente = actual.siguiente` — el anterior salta al que sigue. |
| **Último nodo** | `anterior.siguiente = actual.siguiente`, y como `actual.siguiente` es `NULL`, el anterior se convierte en el nuevo final. |
| Código inexistente | Se recorre toda la lista sin modificar ningún enlace y se informa. |

### Pseudocódigo

```
eliminar(codigo):
    si cabeza == NULL:
        mostrar "La lista está vacía"
        terminar proceso

    si cabeza.codigo == codigo:          // caso: primer nodo
        cabeza = cabeza.siguiente
        terminar proceso

    anterior = cabeza
    actual = cabeza.siguiente
    mientras actual ≠ NULL:
        si actual.codigo == codigo:      // caso: intermedio o último
            anterior.siguiente = actual.siguiente
            terminar proceso
        anterior = actual
        actual = actual.siguiente

    mostrar "No existe la solicitud " + codigo
```

### Código

```java
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
```

### Ejemplo: los tres reajustes de enlaces

**a) Eliminar el primer nodo — `eliminar("S001")`**

```
Antes:    HEAD -> [S001] -> [S002] -> [S003] -> [S004] -> [S005] -> NULL
Después:  HEAD ------------> [S002] -> [S003] -> [S004] -> [S005] -> NULL
          HEAD ahora apunta a S002; S001 queda fuera de la lista.
```

**b) Eliminar un nodo intermedio — `eliminar("S003")`**

```
Antes:    HEAD -> [S002] -> [S003] -> [S004] -> [S005] -> NULL
                     anterior   actual
Después:  HEAD -> [S002] ------------> [S004] -> [S005] -> NULL
          S002.siguiente ahora apunta a S004; S003 queda desconectado.
```

**c) Eliminar el último nodo — `eliminar("S005")`**

```
Antes:    HEAD -> [S002] -> [S004] -> [S005] -> NULL
                              anterior   actual
Después:  HEAD -> [S002] -> [S004] -> NULL
          S004.siguiente pasa a NULL; S004 es el nuevo último nodo.
```

Salida real del programa tras las tres eliminaciones:

```
HEAD -> [S002 | Pendiente] -> [S004 | Pendiente] -> NULL
```

## 4.Comparacion de la eficiencia básica de inserción y eliminación según el punto de intervención.

Lo determinante no es el costo de **re-enlazar** —que siempre es O(1), porque son una o dos asignaciones— sino el costo de **ubicar** el punto de intervención, que obliga a recorrer la lista desde `HEAD`.

Mediciones sobre la lista de ejemplo de 5 nodos (nodos visitados en una ejecución instrumentada del programa):

| Operación | Punto | Nodos recorridos (n = 5) | Enlaces modificados | Complejidad |
|---|---|---|---|---|
| Inserción | Inicio | 0 | 2 (`nuevo.siguiente`, `cabeza`) | **O(1)** |
| Inserción | Intermedio | hasta el nodo de referencia (k) | 2 | **O(n)** |
| Inserción | Final | 5 | 1 (`ultimo.siguiente`) | **O(n)** |
| Eliminación | Inicio | 1 | 1 (`cabeza`) | **O(1)** |
| Eliminación | Intermedio | 3 (para `S003`) | 1 (`anterior.siguiente`) | **O(n)** |
| Eliminación | Final | 5 | 1 (`anterior.siguiente = NULL`) | **O(n)** |

**Conclusiones**

1. **El inicio siempre es el punto más barato**: la lista guarda una referencia directa a `cabeza`, por lo que insertar o eliminar allí es O(1) sin importar cuántos nodos tenga la lista.
2. **El final es el punto más caro** en una lista simple, porque no existe una referencia a la cola: hay que recorrer los n nodos para encontrarlo. Si la lista mantuviera un puntero `cola`, la **inserción** al final bajaría a O(1); la **eliminación** al final seguiría siendo O(n), ya que para dejar el penúltimo como nuevo final hay que llegar hasta él y los enlaces solo apuntan hacia adelante (ese es el problema que resuelve una lista doblemente enlazada).
3. **Frente a un arreglo**, los costos se invierten. El arreglo accede a cualquier posición en O(1), pero insertar o eliminar en el interior obliga a desplazar los elementos posteriores, O(n). La lista enlazada no desplaza nada, solo reasigna referencias, pero paga el recorrido para llegar al punto. Por eso la lista enlazada es la estructura adecuada para el caso planteado: un registro de solicitudes con altas y bajas constantes.



## Conclusión

Las tres operaciones comparten la misma base: el recorrido secuencial desde `HEAD`. La búsqueda localiza el nodo sin alterar la estructura; la modificación cambia el dato del nodo y deja los enlaces intactos; la eliminación es la única que reconfigura la cadena de referencias, y lo hace de forma distinta según el nodo sea el primero, uno intermedio o el último. En todos los casos el trabajo real está en **llegar** al nodo, no en **re-enlazarlo**, y esa es la propiedad que define la eficiencia de una lista simplemente enlazada.
