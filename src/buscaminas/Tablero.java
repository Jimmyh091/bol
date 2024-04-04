/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaminas;

/**
 *
 * @author jaime
 */
public class Tablero {
    Casilla[][] tablero;
    int posicionX;
    int posicionY;
    
    // COLORES //
    String rojo = "\u001B[31m";
    String azul = "\u001B[34m";
    String reset = "\u001B[0m";
    
    
    public Tablero(int longitudX, int longitudY){
        
        tablero = new Casilla[longitudX][longitudY];
        
        for (int i = 0; i < longitudX; i++) {
            for (int j = 0; j < longitudY; j++) {
                tablero[i][j] = new Casilla();
            }
        }
                
    }
    
    public void rellenarTablero(int posicionUsX, int posicionUsY, int numMinasTablero){
        
        for (int i = 0; i < numMinasTablero; i++) {
            posicionX = (int) (Math.random() * tablero.length - 0);
            posicionY = (int) (Math.random() * tablero[0].length - 0);
            
            if (tablero[posicionX][posicionY].isMina() || (posicionX == posicionUsX && posicionY == posicionUsY)) i--;
            else tablero[posicionX][posicionY].setMina(true);
        }        
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                
                if (!tablero[i][j].isMina()) {
                    
                    tablero[i][j] = new Casilla(darMinas(i, j));
                }
                
            }
        }
    }
    private int darMinas(int posicionX, int posicionY){
        int numMinas = 0;
        
        posicionX--;
        posicionY--;
        
        int iAux = posicionX;
        int jAux = posicionY;
        
        for (int i = posicionX; i < iAux + 3; i++) {
            for (int j = posicionY; j < jAux + 3; j++) {
                
                if (i >= 0 && i <= (tablero.length - 1) && j >= 0 && j <= (tablero[0].length - 1)) {
                    if (tablero[i][j].isMina()) numMinas++;
                }
                
            }
        }
        
        return numMinas;
    }
    
    public void mostrarTablero(){
        
        for (int i = 0; i < tablero.length; i++) {
            
            ponerEspacios(i);
            
            System.out.print(i + " | ");
            
            for (int j = 0; j < tablero[0].length; j++) {
                
                System.out.print(" ");                
                
                if (tablero[i][j].getVisible()) {

                    if (tablero[i][j].getNumMinas() > 0) System.out.print(tablero[i][j].getNumMinas());
                    else System.out.print(" ");

                }else{

                    if (tablero[i][j].isBandera()) System.out.print(azul + "b" + reset);
                    else System.out.print("?");
                    
                }
                    
            }
            System.out.println("");
        }
        
        System.out.print("     ");
        
        ponerEspacios(0);
        
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("_ ");
        }        
        
        System.out.print("\n      ");
        
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i % 10 + " ");
        }
        
        System.out.print("\n      ");
        
        if (tablero.length > 10) {            
        
            for (int i = 0; i < tablero.length / 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print("  ");
                }
                System.out.print(i + 1);
            }
            
        }        
        
    }
    
    public void mostrarMinasTablero(){
        
        for (int i = 0; i < tablero.length; i++) {
            
            ponerEspacios(i);
            
            System.out.print(i + " | ");
            
            for (int j = 0; j < tablero[0].length; j++) {
                
                System.out.print(" ");                
                
                if (tablero[i][j].isMina()) {
                    System.out.print(rojo + "a" + reset);
                }else{
                    if (tablero[i][j].getVisible()) {
                        if (tablero[i][j].getNumMinas() > 0) System.out.print(tablero[i][j].getNumMinas());
                        else System.out.print(" ");
                    }else{
                        System.out.print("?");
                    }
                }
            }
            System.out.println("");
        }
        
        System.out.print("\n     ");
        
        ponerEspacios(0);
        
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("_ ");
        }        
        
        System.out.print("\n      ");
        
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i % 10 + " ");
        }
        
        System.out.print("\n      ");
        
        if (tablero.length > 10) {            
        
            for (int i = 0; i < tablero.length / 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print("  ");
                }
                System.out.print(i);
            }
            
        }   
    }
    
    public void mostrarTableroFalso(){
        for (int i = 0; i < tablero.length; i++) {
            
            ponerEspacios(i);
            
            System.out.print(i + " | ");
            
            for (int j = 0; j < tablero[0].length; j++) {
                
                System.out.print(" ?");
                
            }
            System.out.println("");
        }
        
        System.out.print("     ");
        
        ponerEspacios(0);
        
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("_ ");
        }        
        
        System.out.print("\n      ");
        
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i % 10 + " ");
        }
        
        System.out.print("\n      ");
        
        if (tablero.length > 10) {            
        
            for (int i = 0; i < tablero.length / 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print("  ");
                }
                System.out.print(i + 1);
            }
            
        }   
        
        }
    
    public boolean comprobarPoscionX(int posicionX){
        boolean comprobar = true;
        
        if (posicionX < 0 | posicionX > (tablero.length - 1)) comprobar = false;
        
        return comprobar;
    }
    
    public boolean comprobarPoscionY(int posicionY){
        boolean comprobar = true;
        
        if (posicionY < 0 | posicionY > (tablero[0].length - 1)) comprobar = false;
        
        return comprobar;
    }
    
    public boolean comprobarNumMinas(int numMinasTablero){
        boolean comprobar = true;
        
        if (numMinasTablero < 0 || numMinasTablero > (tablero.length * tablero[0].length)) comprobar = false;
        
        return comprobar;
    }
    
    public void ponerVisible(int posicionX, int posicionY){
        tablero[posicionX][posicionY].setVisible(true);
    }
    
    private void ponerEspacios(int num){
        int longitud = tablero.length;
        
        String longitudTablero = "" + longitud;
        String longitudNumero = "" + num;
        
        int lengthDeLongitudTablero = longitudTablero.length();
        int lengthDeLongitudNumero = longitudNumero.length();
        
        for (int i = lengthDeLongitudNumero; i < lengthDeLongitudTablero; i++) {
            System.out.print(" ");
        }
    }
    
    public boolean comprobarExplosion(int posicionX, int posicionY){
        boolean explosion = false;
        
        if (tablero[posicionX][posicionY].isMina()) {
            explosion = true;
        }
        
        return explosion;
    }
      
    public boolean comprobarVictoria(){
        boolean victoria = true;
        
        for (int i = 0; i < tablero.length && victoria; i++) {
            for (int j = 0; j < tablero[0].length && victoria; j++) {
                
                if (!tablero[i][j].getVisible() && !tablero[i][j].isMina()) {
                victoria = false;
                }

            }
        }
        
        return victoria;
    }
    
    public void comprobarEspacios(int posicionUsX, int posicionUsY){
        tablero[posicionUsX][posicionUsY].setVisto(true);
        
        int iAux;
        int jAux;
        
        boolean chequeo;
        
        do {
            
            chequeo = false;
            
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[0].length; j++) {

                    if (tablero[i][j].getNumMinas() == 0) {
                        
                        if (j + 1 != tablero[0].length) {
                            if (tablero[i][j].isVisto() == true && tablero[i][j + 1].isVisto() == false  && tablero[i][j + 1].isMina()== false) {

                                chequeo = true;

                                tablero[i][j + 1].setVisto(true);
                                tablero[i][j + 1].setVisible(true);
                            }
                        }
                        if (i + 1 != tablero.length) {
                            if (tablero[i][j].isVisto() == true && tablero[i + 1][j].isVisto() == false  && tablero[i + 1][j].isMina() == false) {

                                chequeo = true;

                                tablero[i + 1][j].setVisto(true);
                                tablero[i + 1][j].setVisible(true);
                            }
                        }
                        if (i + 1 != tablero.length && j + 1 != tablero[0].length) {
                            if (tablero[i][j].isVisto() == true && tablero[i + 1][j + 1].isVisto() == false  && tablero[i + 1][j + 1].isMina() == false) {

                                chequeo = true;

                                tablero[i + 1][j + 1].setVisto(true);
                                tablero[i + 1][j + 1].setVisible(true);
                            }
                        }
                       
                    }
                }
            }

            for (int i = tablero.length - 1; i >= 0; i--) {
                for (int j = tablero[0].length - 1; j >= 0; j--) {

                    if (tablero[i][j].getNumMinas() == 0) {
                    
                        if (j - 1 != -1) {
                            if (tablero[i][j].isVisto() == true && tablero[i][j - 1].isVisto() == false && tablero[i][j - 1].isMina() == false) {

                                chequeo = true;
                                
                                tablero[i][j - 1].setVisto(true);
                                tablero[i][j - 1].setVisible(true);
                            }
                        }
                        if (i - 1 != -1) {
                            if (tablero[i][j].isVisto() == true && tablero[i - 1][j].isVisto() == false  && tablero[i - 1][j].isMina() == false) {
                                
                                chequeo = true;
                                
                                tablero[i - 1][j].setVisto(true);
                                tablero[i - 1][j].setVisible(true);
                            }
                        }
                        if (i - 1 != -1 && j - 1 != -1) {
                            if (tablero[i][j].isVisto() == true && tablero[i - 1][j - 1].isVisto() == false  && tablero[i - 1][j - 1].isMina() == false) {
                                
                                chequeo = true;
                                
                                tablero[i - 1][j - 1].setVisto(true);
                                tablero[i - 1][j - 1].setVisible(true);
                            }
                        }
                        
                    }
                    
                }
            }
            
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[0].length; j++) {
                    tablero[i][j].setVisto(false);
                }
            }            
            
        } while (chequeo);
        
    }
    
    public void ponerBandera(int posicionUsX, int posicionUsY){
        tablero[posicionUsX][posicionUsY].setBandera(!tablero[posicionUsX][posicionUsY].isBandera());
    }
}
