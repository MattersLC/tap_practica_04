package com_grafico;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;

public class GraficoPrueba extends JFrame {

    private String encabezado = "Encabezado";
    private String[] tLeyenda = {"Leyenda 1", "Leyenda 2", "Leyenda 3", "Leyenda 4", "Leyenda 5"};
    private int valores[] = {10, 15, 5, 12, 16};
    //private String[] tLeyenda = {"Leyenda 1", "Leyenda 2"};
    //private int valores[] = {10, 15};

    public GraficoPrueba() {
        Collections.reverse(Arrays.asList(tLeyenda));
        Grafico grph = new Grafico();
        Grafico grph2 = new Grafico(encabezado, tLeyenda);
        grph2.setValores(valores);
        this.add(grph);
        this.add(grph2);
        setVisible(true);
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new GraficoPrueba();
    }
}
