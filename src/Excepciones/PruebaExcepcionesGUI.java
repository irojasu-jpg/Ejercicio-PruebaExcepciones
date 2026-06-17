package Excepciones;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfaz grafica de usuario (Swing) para el ejercicio PruebaExcepciones.
 * Esta clase no duplica la logica de manejo de excepciones del ejercicio
 * original: reutiliza el metodo {@link #ejecutarPrueba()}, que contiene
 * exactamente los mismos bloques try/catch/finally que la version de
 * consola {@link PruebaExcepciones#main(String[])}, con la unica
 * diferencia de que en lugar de imprimir cada linea con
 * {@code System.out.println} la acumula en una lista que luego se
 * muestra en un area de texto.
 * @version 1.0/2026
 */
public class PruebaExcepcionesGUI extends JFrame {

    private final JTextArea areaResultados;

    public PruebaExcepcionesGUI() {
        super("Prueba de Excepciones");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JButton botonEjecutar = new JButton("Ejecutar prueba de excepciones");

        areaResultados = new JTextArea(12, 45);
        areaResultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultados);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(botonEjecutar);

        add(panelBoton, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        botonEjecutar.addActionListener(evento -> ejecutarYMostrar());

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Ejecuta la prueba de excepciones y vuelca cada linea de salida en
     * el area de resultados, limpiando el contenido previo.
     */
    private void ejecutarYMostrar() {
        areaResultados.setText("");
        List<String> lineas = ejecutarPrueba();
        for (String linea : lineas) {
            areaResultados.append(linea + System.lineSeparator());
        }
    }

    /**
     * Metodo reutilizable que contiene la misma logica de los dos
     * bloques try/catch/finally definidos en
     * {@link PruebaExcepciones#main(String[])}, devolviendo cada
     * mensaje como una linea de una lista en lugar de imprimirlo
     * directamente por consola. El orden de las lineas devueltas es
     * identico al orden en que se imprimirian en la version de consola.
     * @return Lista con las lineas de salida producidas por la prueba
     */
    public static List<String> ejecutarPrueba() {
        List<String> salida = new ArrayList<>();

        // Primer bloque try
        try {
            salida.add("Ingresando al primer try");
            int cociente = 100000 / 0; // Se lanza una excepcion
            salida.add("Despues de la division"); /* Esta instruccion nunca sera ejecutada */
        } catch (ArithmeticException e) { // Se captura la excepcion
            salida.add("Division por cero"); /* Se agrega este mensaje */
        } finally {
            /* La sentencia finally siempre se ejecuta, ocurra o no una excepcion */
            salida.add("Ingresando al primer finally");
        }

        // Segundo bloque try
        try {
            salida.add("Ingresando al segundo try");
            Object objeto = null;
            objeto.toString(); // Se lanza una excepcion (NullPointerException)
            /* Esta instruccion nunca sera ejecutada porque se lanzo una excepcion */
            salida.add("Imprimiendo objeto");
        } catch (ArithmeticException e) { /* La excepcion lanzada no es de este tipo */
            salida.add("Division por cero");
        } catch (Exception e) { // Se captura la excepcion (NullPointerException es subclase de Exception)
            salida.add("Ocurrio una excepcion"); /* Se agrega este mensaje */
        } finally {
            /* La sentencia finally siempre se ejecuta, ocurra o no una excepcion */
            salida.add("Ingresando al segundo finally");
        }

        return salida;
    }

    /**
     * Metodo main que lanza la interfaz grafica de PruebaExcepciones.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PruebaExcepcionesGUI ventana = new PruebaExcepcionesGUI();
            ventana.setVisible(true);
        });
    }
}
