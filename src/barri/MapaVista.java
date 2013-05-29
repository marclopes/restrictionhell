/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import javax.swing.ImageIcon;

/**
 *
 * @author eDU
 */
public class MapaVista extends javax.swing.JPanel {
    private boolean tipoTablero;
    private Casilla [][] casillas ;
    private int tamx, tamy, tamcx, tamcy;
    private boolean cuadrado, inverso;
    private ImageIcon[] imagenespre;
    private ImageIcon[] imagenesusu;
    private ImageIcon calle;
    private int ultimaX;
    private int ultimaY;
    public int espera;
        
    public MapaVista() {
        initComponents();

    }

    public MapaVista(int x,  int y, boolean tipo) {
        espera = 0;
        inverso = false;
        if(x == y) {
            cuadrado = true;
            tamx = x;
            tamcx = 700/x;
            tamcy = 700/x;
            tamy = x;
            casillas = new Casilla[x][x];
        }
        else {
            tamx = x;
            tamy = y;
            cuadrado = false;
            if(x > y) {
                tamcx = x;
                tamcy = y;
            }
            else {
                tamcy = x;
                tamcx = y;
            }
            if(tamx < tamy) {
                inverso = true;
                int aux = tamx;
                tamx = tamy;
                tamy = aux;
            }
            tamcx = 1000/tamcx;
            tamcy = 700/tamcy;
            casillas = new Casilla[tamx][tamy];
        }
        initComponents();
        setLayout(new java.awt.GridLayout(tamx, tamy));
        this.tipoTablero = tipo;
        calle = new ImageIcon("imatges/carretera.jpg");
        imagenespre = new ImageIcon[30];
        imagenesusu = new ImageIcon[10];
        imagenespre[0] = new ImageIcon("imatges/cesped.jpg");
        imagenespre[1] = new ImageIcon("imatges/casa2.jpg");
        imagenespre[2] = new ImageIcon("imatges/casa.jpg");
        imagenespre[3] = new ImageIcon("imatges/mansion.jpg");
        imagenespre[4] = new ImageIcon("imatges/pisopeque.jpg");
        imagenespre[5] = new ImageIcon("imatges/pisomed.jpg");
        imagenespre[6] = new ImageIcon("imatges/edificio.jpg");
        imagenespre[7] = new ImageIcon("imatges/rascacielo.jpg");
        imagenespre[8] = new ImageIcon("imatges/pisogrande.jpg");
        imagenespre[9] = new ImageIcon("imatges/Hospital_Final.jpg");
        imagenespre[10] = new ImageIcon("imatges/hospital.jpg");
        imagenespre[11] = new ImageIcon("imatges/Colegio1.jpg");
        imagenespre[12] = new ImageIcon("imatges/school.jpg");
        imagenespre[13] = new ImageIcon("imatges/policia.jpg");
        imagenespre[14] = new ImageIcon("imatges/bomberos.jpg");
        imagenespre[15] = new ImageIcon("imatges/metro.jpg");
        imagenespre[16] = new ImageIcon("imatges/aeropuerto.jpg");
        imagenespre[17] = new ImageIcon("imatges/teatro.jpg");
        imagenespre[18] = new ImageIcon("imatges/cine.jpg");
        imagenespre[19] = new ImageIcon("imatges/bolera.jpg");
        imagenespre[20] = new ImageIcon("imatges/basket.jpg");
        imagenespre[21] = new ImageIcon("imatges/cc.jpg");
        imagenespre[22] = new ImageIcon("imatges/tiendapeque.jpg");
        imagenespre[23] = new ImageIcon("imatges/ropa.jpg");
        imagenespre[24] = new ImageIcon("imatges/tienda.jpg");
        imagenespre[25] = new ImageIcon("imatges/super.jpg");
        imagenespre[26] = new ImageIcon("imatges/pija.jpg");
        imagenespre[27] = new ImageIcon("imatges/kebab.jpg");
        imagenespre[28] = new ImageIcon("imatges/comercio.jpg");
        imagenespre[29] = new ImageIcon("imatges/uni.jpg");
        
        
        imagenesusu[0] = new ImageIcon("imatges/1.jpg");
        imagenesusu[1] = new ImageIcon("imatges/2.jpg");
        imagenesusu[2] = new ImageIcon("imatges/3.jpg");
        imagenesusu[3] = new ImageIcon("imatges/4.jpg");
        imagenesusu[4] = new ImageIcon("imatges/5.jpg");
        
        for (int i = 0; i < tamx; i++){
            for (int j = 0; j < tamy; j++){
                casillas[i][j] = new Casilla(this); 
                casillas[i][j].setFondo(calle);
                x = (i * tamcx)+1;
                y = (j * tamcy)+1;
                casillas[i][j].setBounds(x, y, (tamcx)-2, (tamcy)-2);
                this.add(casillas[i][j]);
            }
        }
    }
    
    public boolean getTipoTablero(){
        return this.isTipoTablero();
    }
    
    public void pintar(int x, int y){
        this.casillas[x][y].setFondo(imagenesusu[1]);
        this.repaint();
    }

    public int[] getCoordenadas(Casilla casilla) {
        int [] coordenadas = new int[2];
        for (int i=0; i < this.casillas.length; i++) {
            for (int j=0; j < this.casillas[0].length; j++) {
                if (this.casillas[i][j] == casilla) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                }
            }
        }
        return coordenadas;
    }
    
    public Casilla[][] getCasillas() {
        return casillas;
    }
    
    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
    
    public boolean isTipoTablero() {
        return tipoTablero;
    }    
    public void setTipoTablero(boolean tipoTablero) {
        this.tipoTablero = tipoTablero;
    }
    
    public void leerMapa(Integer[][] mapa){
        for(int i = 0; i < tamx; ++i) {
            for(int j = 0; j < tamy; ++j) {
                int aux = 0;
                if(inverso == true) {
                    aux = mapa[j][i];
                }
                else aux = mapa[i][j];
                if(aux == -1)  casillas[i][j].setFondo(calle);
                else if(aux <= 29) {
                    casillas[i][j].setFondo(imagenespre[aux]);
                }
                else {
                    aux = aux%5;
                    casillas[i][j].setFondo(imagenesusu[aux]);
                }
            }
        }
        this.repaint();
    }
    
    public void ultimaSeleccionada(int x,int y){
       ultimaX=x;
       ultimaY=y;
    }
                              
    private void initComponents() {

        setLayout(null);

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        if(tamx == tamy) setPreferredSize(new java.awt.Dimension(700, 700));
        else setPreferredSize(new java.awt.Dimension(1000, 700));
    } 
    
    public int seleccionadaX(){
        return ultimaX;
    }
    
    public int seleccionadaY(){
        return ultimaY;
    }
    
    public int resetEspera(){
        espera=0;
        return espera;
    }
    
    public int getEspera(){
        return espera;
    }
    
    public void finalizaEspera(){
        espera = 1;
    }
                     
}
