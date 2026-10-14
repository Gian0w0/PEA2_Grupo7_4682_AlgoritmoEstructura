## 2.4 Inserción después de un nodo dado

Esta operación permite insertar una nueva solicitud después de un nodo específico de la lista enlazada. En este caso, se registra la solicitud **S007 inmediatamente después de S003**.

### Pseudocódigo

```text
FUNCIÓN INSERTAR_DESPUES(codigoReferencia, solicitud)
    actual ← BUSCAR(codigoReferencia)

    SI actual = NULL ENTONCES
        RETORNAR FALSO
    FIN SI

    nuevo ← CREAR_NODO(solicitud)
    nuevo.siguiente ← actual.siguiente
    actual.siguiente ← nuevo

    RETORNAR VERDADERO
FIN FUNCIÓN
```

En este pseudocódigo, `BUSCAR` devuelve el nodo localizado según su código de referencia. En una implementación en Java, el método `buscar` puede devolver la solicitud encontrada para consultar sus datos, mientras que `insertarDespues` localiza internamente el nodo y actualiza sus enlaces.

### Representación gráfica

**Antes de insertar S007:**

```text
S002 → S003 → S004 → S005 → NULL
```

**Después de insertar S007:**

```text
S002 → S003 → S007 → S004 → S005 → NULL
```

**Figura 4.** Fragmento de la lista después de insertar S007 entre S003 y S004.

### Estado de la lista antes y después

**Antes:**

```text
cabeza → S000 → S001 → S002 → S003 → S004 → S005 → S006 → NULL
```

**Después:**

```text
cabeza → S000 → S001 → S002 → S003 → S007 → S004 → S005 → S006 → NULL
```

### Explicación del procedimiento

1. Primero, se busca el nodo S003 utilizando su código de referencia.
2. Una vez localizado, se crea el nuevo nodo S007.
3. El enlace `siguiente` del nuevo nodo se establece para apuntar al nodo que anteriormente seguía a S003, es decir, S004.
4. Después, se modifica el enlace `siguiente` de S003 para que apunte a S007.
5. Finalmente, la función devuelve `VERDADERO` para indicar que la inserción se realizó correctamente.

El orden de las asignaciones es importante, ya que permite conservar la conexión con el resto de la lista.

Si el nodo de referencia no existe, la función devuelve `FALSO` y la lista permanece sin modificaciones. Si S003 fuera el último nodo, S007 quedaría al final de la lista.

### Análisis de complejidad

- **Búsqueda del nodo:** O(n), porque puede ser necesario recorrer la lista hasta encontrar el código de referencia.
- **Actualización de los enlaces:** O(1), porque solo se modifican dos referencias.
- **Complejidad total de la operación:** O(n), debido al tiempo necesario para localizar el nodo de referencia.

### Conclusión

El recorrido y las operaciones de inserción permiten gestionar dinámicamente las solicitudes de atención. El recorrido facilita consultar los registros existentes, mientras que las inserciones al inicio, al final y después de un nodo permiten incorporar nuevas solicitudes en distintas posiciones.

Estas operaciones demuestran cómo una lista simplemente enlazada organiza sus elementos mediante referencias, sin necesidad de desplazar los demás nodos.
