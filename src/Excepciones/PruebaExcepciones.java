package Excepciones;

/**
 * Esta clase denominada PruebaExcepciones lanza diferentes
 * excepciones en situaciones especificas del programa. Los mensajes
 * que se muestran en pantalla ayudan a identificar la porcion de codigo
 * que se ejecuto o no.
 * @version 1.2/2020
 */
public class PruebaExcepciones {

    /**
     * Metodo main con dos bloques try que generan excepciones que
     * deben ser gestionadas
     * @throws ArithmeticException Excepcion aritmetica de division por cero
     * @throws Exception Excepcion general
     */
    public static void main(String args[]) {
        // Primer bloque try
        try {
            System.out.println("Ingresando al primer try");
            int cociente = 100000 / 0; // Se lanza una excepcion
            System.out.println("Despues de la division"); /* Esta instruccion nunca sera ejecutada */
        } catch (ArithmeticException e) { // Se captura la excepcion
            System.out.println("Division por cero"); /* Se imprime en pantalla este mensaje */
        } finally {
            /* La sentencia finally siempre se ejecuta, ocurra o no una excepcion */
            System.out.println("Ingresando al primer finally");
        }

        // Segundo bloque try
        try {
            System.out.println("Ingresando al segundo try");
            Object objeto = null;
            objeto.toString(); // Se lanza una excepcion (NullPointerException)
            /* Esta instruccion nunca sera ejecutada porque se lanzo una excepcion */
            System.out.println("Imprimiendo objeto");
        } catch (ArithmeticException e) { /* La excepcion lanzada no es de este tipo */
            System.out.println("Division por cero");
        } catch (Exception e) { // Se captura la excepcion (NullPointerException es subclase de Exception)
            System.out.println("Ocurrio una excepcion"); /* Se imprime en pantalla este mensaje */
        } finally {
            /* La sentencia finally siempre se ejecuta, ocurra o no una excepcion */
            System.out.println("Ingresando al segundo finally");
        }
    }
}
