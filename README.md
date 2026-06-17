# Ejercicio - Prueba de Excepciones

Implementacion del ejercicio "Prueba de Excepciones" del libro *Ejercicios
de programacion orientada a objetos con Java y UML* (paginas 400-403).

## Enunciado

Se proporciona la clase `PruebaExcepciones`, que contiene un metodo `main`
con dos bloques `try/catch/finally`. El ejercicio plantea la siguiente
pregunta: **¿Cual es el resultado de la ejecucion del metodo main del
siguiente programa? Determinar que se imprime en pantalla.**

- En el primer bloque `try` se realiza una division entera por cero
  (`100000 / 0`), lo que lanza una `ArithmeticException`. Esta excepcion es
  capturada por el `catch (ArithmeticException e)` correspondiente, y el
  bloque `finally` se ejecuta siempre a continuacion.
- En el segundo bloque `try` se invoca el metodo `toString()` sobre una
  referencia `null`, lo que lanza una `NullPointerException`. Como esta
  excepcion no es de tipo `ArithmeticException`, no es capturada por el
  primer `catch`; en cambio, es capturada por el segundo `catch (Exception
  e)`, ya que `NullPointerException` es subclase de `Exception`. El bloque
  `finally` correspondiente se ejecuta a continuacion.

Es un ejercicio puramente conceptual sobre el orden de evaluacion de los
bloques `try`, `catch` y `finally` en Java.

## Salida esperada en consola

```
Ingresando al primer try
Division por cero
Ingresando al primer finally
Ingresando al segundo try
Ocurrio una excepcion
Ingresando al segundo finally
```

## Estructura del proyecto

```
Ejercicio-PruebaExcepciones/
|-- src/
|   `-- Excepciones/
|       |-- PruebaExcepciones.java       (clase original, version consola)
|       `-- PruebaExcepcionesGUI.java    (interfaz grafica Swing)
|-- diagrams/
|   |-- class_diagram.png
|   |-- state_diagram.png
|   |-- use_case_diagram.png
|   `-- Diagramas_PruebaExcepciones.docx
|-- bin/                                  (clases compiladas)
`-- README.md
```

La clase `PruebaExcepciones` reproduce exactamente el codigo del libro,
con sus dos bloques `try/catch/finally` imprimiendo por consola mediante
`System.out.println`. La interfaz grafica `PruebaExcepcionesGUI` reutiliza
la misma logica de manejo de excepciones a traves del metodo estatico
`PruebaExcepcionesGUI.ejecutarPrueba()`, que contiene los mismos bloques
`try/catch/finally` pero acumula cada linea de salida en una lista en
lugar de imprimirla directamente, evitando asi duplicar la logica del
ejercicio.

## Compilacion

Desde la raiz del proyecto:

```bash
javac -d bin src/Excepciones/*.java
```

## Ejecucion (version consola)

```bash
java -cp bin Excepciones.PruebaExcepciones
```

El programa no requiere ningun dato de entrada y produce siempre la misma
salida por consola (ver seccion "Salida esperada en consola").

## Ejecucion (version grafica)

```bash
java -cp bin Excepciones.PruebaExcepcionesGUI
```

Se abre una ventana con un boton "Ejecutar prueba de excepciones" y un
area de resultados. Al pulsar el boton se ejecuta la misma logica de los
dos bloques `try/catch/finally` del ejercicio original y se muestran, en
el area de texto y en el mismo orden que en la version de consola, las
lineas de salida producidas.

## Diagramas

En la carpeta `diagrams/` se incluyen el diagrama de clases UML, el
diagrama de maquina de estados (que ilustra el flujo de ejecucion de los
bloques try/catch/finally), el diagrama de casos de uso, y un documento
Word (`Diagramas_PruebaExcepciones.docx`) con la explicacion de los tres
diagramas.
