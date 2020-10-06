package AnimarObjeto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circulo {

    //coordenada
    private int coordenada_x, coordenada_y;
    private int radio;

    private Color color;
    private int sentido;
    private final int ARRIBA = 1,
            ARRIBADERECHA = 1,
            DERECHA = 1,
            ABAJODERECHA = 1,
            ABAJO = 1,
            ABAJOIZQUIERDA = 1,
            IZQUIERDA = 1,
            ARRIBAIZQUIERDA = 1;
    private int velocidad;
    private int rapido;
    private int minimo_x, minimo_y, maximo_x, maximo_y;
    private Random random;

    public Circulo(int alto, int ancho, int radio, int velocidad) {
        random = new Random();
        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        this.coordenada_x = this.random.nextInt(ancho - radio);
        this.coordenada_y = this.random.nextInt(alto - radio);
        this.radio = radio;
        this.sentido = 1 + random.nextInt(9);
        this.velocidad = velocidad;
        this.minimo_x = 0;
        this.minimo_y = 0;
        this.maximo_x = ancho;
        this.maximo_y = alto;

    }

    public void dibujar(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.coordenada_x, this.coordenada_y, this.radio, this.radio);
    }

    public void animar() {
        int x_positiva = this.coordenada_x + this.velocidad;
        int y_positiva = this.coordenada_y + this.velocidad;
        int x_negativa = this.coordenada_x - this.velocidad;
        int y_negativa = this.coordenada_y - this.velocidad;

        switch (this.sentido) {
            case ARRIBA:
                if (y_negativa > this.minimo_y) {
                    this.coordenada_y = y_negativa;
                } else {
                    this.sentido = 1 + random.nextInt(0);
                }
                break;

            case ARRIBADERECHA:
                if ((x_positiva < this.maximo_x) && (y_negativa > this.minimo_y)) {
                       this.coordenada_x=x_positiva;
                       this.coordenada_y=y_negativa;
                } else {
                    this.sentido=1+random.nextInt(8);
                }
                break;
                
            case ARRIBA:
                if (x_positiva< this.maximo_x) {
                    this.coordenada_x = x_positiva;
                } else {
                    this.sentido = 1 + random.nextInt(0);
                }
                break;
                
            case ABAJODERECHA:
                if ((x_positiva < this.maximo_x) && (y_negativa > this.minimo_y)) {
                    this.coordenada_y = y_negativa;
                } else {
                    this.sentido = 1 + random.nextInt(0);
                }
                break;
        }

    }

}
