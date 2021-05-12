package pruebagraficobarra;

import com_grafico.Grafico;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PruebaGraficoBarra extends JFrame implements ActionListener{

    private String encabezado = "Grafico de ventas";
    private String[] tLeyenda = {"Producto 1", "Producto 2", "Producto 3", "Producto 4", "Producto 5"};
    private int valores[] = {0, 0, 0, 0, 0};
    private int cantidad = 5;
    private JLabel cantProductos;
    private JTextField cProductos;
    private JButton aceptar;
    private JPanel panel;
    
    public PruebaGraficoBarra () {
        cantProductos = new JLabel("Digita la cantidad de productos: ");
        cProductos = new JTextField();
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        panel = new JPanel(new BorderLayout());
        panel.add(cantProductos, BorderLayout.WEST);
        panel.add(cProductos, BorderLayout.CENTER);
        panel.add(aceptar, BorderLayout.EAST);
        this.add(panel, BorderLayout.NORTH);
        
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        cantidad = Integer.parseInt(cProductos.getText());
        tLeyenda = new String[cantidad];
        valores = new int[cantidad];
        JOptionPane.showMessageDialog(null, "Para practicidad, se mostrarán números aleatorios que representan el costo de cada producto.");
        for (int i=0; i<cantidad; i++) {
            tLeyenda[i] = "Producto "+(i+1);
            int numero = (int)(Math.random()*30+1);
            valores[i] = numero;
        }
        
        Collections.reverse(Arrays.asList(tLeyenda));
        PruebaGraficoBarra prueba = new PruebaGraficoBarra();
        Grafico grph2 = new Grafico(encabezado, tLeyenda);
        grph2.setValores(valores);
        prueba.add(grph2);
    }
    
    public static void main(String[] args) {
        new PruebaGraficoBarra();
    }
    
}
