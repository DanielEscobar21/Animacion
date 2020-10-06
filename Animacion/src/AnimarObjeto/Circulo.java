package AnimarObjeto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circulo {
    private int coordenada_x, coordenada_y;
    private int radio;
    private Color color;
    private int sentido;
    private final int ARRIBA    = 1;
    private final int ARR_DER   = 2;
    private final int DERECHA   = 3;
    private final int ABAJ_DER  = 4;
    private final int ABAJO     = 5;
    private final int ABAJ_IZQ  = 6;
    private final int IZQUIERDA = 7;
    private final int ARR_IZQ   = 8;
    private int velocidad;
    private int margen_arr, margen_aba, margen_izq, margen_der;
    private Random random;
    
    
    public Circulo (int alto, int ancho, int radio, int velocidad){
        random = new Random ();
        color = new Color (random.nextInt(255), random.nextInt(255), random.nextInt(255));
        this.coordenada_x = this.random.nextInt(ancho - radio);
        coordenada_y = this.random.nextInt(alto - radio);
        this.radio = radio;
        this.sentido = (this.random.nextInt(8) + 1);
        this.velocidad = velocidad;
        this.margen_arr = 0;
        this.margen_izq = 0;
        this.margen_der = ancho;
        this.margen_aba = alto;
    }
    
    public void dibujar (Graphics graphics){
        graphics.setColor(this.color);
        graphics.fillOval(this.coordenada_x, this.coordenada_y,this.radio,this.radio);
        animar();
    }
    
    public void animar (){
        int x_positiva = this.coordenada_x + this.velocidad;
        int y_positiva = this.coordenada_y + this.velocidad;
        int x_negativa = this.coordenada_x - this.velocidad;
        int y_negativa = this.coordenada_y - this.velocidad;
        
        switch (this.sentido){
            case ARRIBA: 
                if(y_negativa > this.margen_arr){
                    this.coordenada_y = y_negativa;
                }
                else{
                    this.sentido = this.random.nextInt(8) + 1;
                }
                break;
            case ARR_DER:
                if(y_negativa > this.margen_arr && x_positiva < this.margen_der){
                    this.coordenada_y = y_negativa;
                    this.coordenada_x = x_positiva;
                }
                else{
                    this.sentido = this.random.nextInt(8) + 1;
                }
                break;
            case DERECHA:
                 if(x_positiva < this.margen_der){
                    this.coordenada_x = x_positiva;
                }
                else{
                    this.sentido = this.random.nextInt(8) + 1;
                }
                break;
            case ABAJ_DER:
                if(y_positiva < this.margen_aba && x_positiva < this.margen_der){
                    this.coordenada_y = y_positiva;
                    this.coordenada_x = x_positiva;
                }
                else{
                    this.sentido = this.random.nextInt(8) + 1;
                }
                break;
            case ABAJO:
                if(y_positiva < this.margen_aba){
                    this.coordenada_y = y_positiva;
                }
                else{
                    this.sentido = this.random.nextInt(8) + 1;
                }
                break;
            case ABAJ_IZQ:
                if(y_positiva < this.margen_aba && x_negativa > this.margen_izq){
                    this.coordenada_y = y_positiva;
                    this.coordenada_x = x_negativa;
                }
                else{
                    this.sentido = this.random.nextInt(8) + 1;
                }
                break;
            case IZQUIERDA:
                if(x_negativa > this.margen_izq){
                    this.coordenada_x = x_negativa;
                }
                else{
                    this.sentido = this.random.nextInt(8) + 1;
                }
                break;
            case ARR_IZQ:
                if(y_negativa > this.margen_arr && x_negativa > this.margen_izq){
                    this.coordenada_y = y_negativa;
                    this.coordenada_x = x_negativa;
                }
                else{
                    this.sentido = this.random.nextInt(8) + 1;
                }
                break;
        }
    }
}
