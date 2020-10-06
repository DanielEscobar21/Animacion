package AnimarObjeto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JPanel {

    private JFrame ventana;
    private Container contenedor;
    private Circulo circulos[];

    public Ventana() {
        ventana = new JFrame("Animando Objetos");
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);

        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        int tamaño = 5;
        this.circulos = new Circulo[tamaño];

        for (int i = 0; i < tamaño; i++) {
            this.circulos[i] = new Circulo(800, 600, 25, 10);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circulo circulo : circulos) {
            circulo.dibujar(g);
        }

    }

    public void animar() {
        while (this.ventana.isVisible()) {
            for (Circulo circulo : circulos) {
                circulo.animar();
            }
            try {
                Thread.sleep(50);

            } catch (Exception e) {

            }
            repaint();
        }
    }

}
