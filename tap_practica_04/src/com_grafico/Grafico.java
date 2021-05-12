package com_grafico;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

// Se tiene que implementar Serializable
/* Es necesario uque el primer constructor esté sin parámetros para que muestre datos vacíos al iniciar el programa, y que posteriormente puedan ser adaptados a los
   datos que brinde el usuario*/
public class Grafico extends JComponent implements Serializable {

    private int nFiguras; // Número de barras
    private JLabel[] etis; // Etiquetas para el valor a mostrar
    private int [] vals = {0, 0, 0}; // Valores de cada barra, se dan valores por omisión
    //Se consideran diez colores para diez valores
    private static Color[] color = {Color.BLUE, Color.GREEN, Color.CYAN, Color.YELLOW, Color.PINK, Color.WHITE, Color.RED, Color.ORANGE, Color.MAGENTA};
    private static JLabel[] leyendaBarra; // Muestra el título de la leyenda
    private static JLabel[] colorB; // Identificación del color de las barras
    private JLabel titulo; // Título
    private String tTitulo; // Texto del título
    private String[] tLeyenda; // Títulos de las leyendas que identifican a cada barra

    public Grafico() {
        // Valores por omisión
        titulo = new JLabel("");
        etis = new JLabel[0];
        leyendaBarra = new JLabel[0];
        colorB = new JLabel[0];
        tLeyenda = new String[0];
    }

    public Grafico(String encabezado, String[] tLeyenda) {
        nFiguras = tLeyenda.length;
        this.tLeyenda = tLeyenda; // Texto de cada leyenda
        leyendaBarra = new JLabel[tLeyenda.length];
        tTitulo = encabezado;
        setLeyendas(this.tLeyenda);
        iniciarElementos(); // Método para iniciar los valores
    }

    public void iniciarElementos() { // Creación e inicio de los valores de cada barra
        vals = new int[nFiguras];
        for (int nv=0; nv<nFiguras; nv++) { // Inicia los valores
            vals[nv] = 0;
        }
        // Crea y agrega la etiqueta del título
        titulo = new JLabel(tTitulo);
        add(titulo);
        // Crea e inicia los demás arreglos
        etis = new JLabel[nFiguras];
        colorB = new JLabel[nFiguras];
        for (int i=0; i<nFiguras; i++) {
            etis[i] = new JLabel(""+0);
            add(etis[i]);
        }
        // Identificación del color de cada barra de colorB[]
        for (int k=0; k<nFiguras; k++) {
            colorB[k] = new JLabel("");
            colorB[k].setBackground(color[k]);
            colorB[k].setOpaque(true);
            add(colorB[k]);
        }
    }

    // Método para asignar títulos
    public void setTitulo(String encabezado) {
        tTitulo = encabezado;
    }

    // Método para asignar leyendas
    public void setLeyendas(String tLeyenda[]) {
        nFiguras = tLeyenda.length;
        this.tLeyenda = tLeyenda;
        leyendaBarra = new JLabel[tLeyenda.length];
        for (int e=0; e<tLeyenda.length; e++) {
            leyendaBarra[e] = new JLabel(tLeyenda[e]);
            this.add(leyendaBarra[e]);
        }
        iniciarElementos();
    }

    public void setValores(int valores[]) {
        // Actualiza los valores y los asigna a sus etiquetas
        for (int va=0; va<nFiguras; va++) {
            vals[va] = valores[va];
            etis[va] = new JLabel(""+valores[va]);
            add(etis[va]);
        }
    }

    @Override
    public void paintComponent(Graphics f) {
        int i;
        int j=1;
        int extra = 10;
        int ancho = getWidth();
        int alto = getHeight()-20;
        titulo.setBounds((int)((ancho-f.getFontMetrics().stringWidth(titulo.getText()))/2), 10, titulo.getText().length()*8, 20);
        int separa = (int) (ancho/(nFiguras)*0.10);
        int anchoB = (int) (ancho/(nFiguras)-separa);
        int anchoC = (int) (ancho/10)-(separa);
        // Ubica a cada elemento en su posición
        for (i=0; i<nFiguras; i++) {
            f.setColor(color[i]); // Establece el color de la barra
            // Posiciona el valor de cada barra
            etis[i].setBounds(separa+i*(anchoB+separa)+(anchoB/2), (alto-20*colorB.length)-vals[i]*5-etis[i].getHeight()-2, 30, 20);
            // Crea la barra de color en posición especificada
            f.fill3DRect(separa+i*(anchoB+separa), ((alto-20*colorB.length)-vals[i]*5), anchoB, vals[i]*5, true);
            colorB[i].setBounds(anchoC, (alto-20*colorB.length)+extra, 15, 15);
            leyendaBarra[nFiguras-1-i].setBounds(anchoC+20, (alto-20*colorB.length)+extra, 160, 15);
            j++;
            extra+=20;
        }
    }
}