/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buscaminas;

import java.util.Scanner;

/**
 *
 * @author jaime
 */
public class Buscaminas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        boolean comprobar;
        int posicionX;
        int posicionY;
        int numMinasTablero;
        char bandera;
        boolean hayBandera;
        boolean EXPLOSION = false;
        boolean victoria = false;
        boolean que;
        
        System.out.println("Introduce el ancho");
        int longitudX = sc.nextInt();
        
        System.out.println("\nIntroduce el alto");
        int longitudY = sc.nextInt();
        
        Tablero tablero = new Tablero(longitudX, longitudY);
        
        do {
            System.out.println("\nIntroduce el numero de minas");
            numMinasTablero = sc.nextInt();
            
            comprobar = tablero.comprobarNumMinas(numMinasTablero);
            
            if (!comprobar) System.out.println("Dato invalido\n");
        } while (!comprobar);
               
                
        tablero.mostrarTableroFalso();
        
        do {
            System.out.println("\nIntroduce la fila");
            posicionX = sc.nextInt();
            
            comprobar = tablero.comprobarPoscionX(posicionX);
            
            if (!comprobar) System.out.println("Dato invalido\n");
        } while (!comprobar);
            
        do {
            System.out.println("\nIntroduce la columna");
            posicionY = sc.nextInt();
            
            comprobar = tablero.comprobarPoscionY(posicionY);
            
            if (!comprobar) System.out.println("Dato invalido\n");
        } while (!comprobar);
        
        tablero.rellenarTablero(posicionX, posicionY, numMinasTablero);
        
        tablero.ponerVisible(posicionX, posicionY);
        tablero.comprobarEspacios(posicionX, posicionY);
        que = tablero.comprobarVictoria();
        
        //---//
        
        if (!que) {
            do {
                tablero.mostrarTablero();

                do {
                    System.out.println("\nSera una bandera? (s/n)");                    
                    bandera = sc.next().charAt(0);
                    
                    comprobar = comprobarBandera(bandera);
                    
                } while (!comprobar);
                
                // wtf la correccion
                if (bandera == 's') hayBandera = true;
                else hayBandera = false;
                
                do {
                    System.out.println("\nIntroduce la fila");
                    posicionX = sc.nextInt();
                    
                    comprobar = tablero.comprobarPoscionX(posicionX);

                    if (!comprobar) System.out.println("Dato invalido");
                } while (!comprobar);

                do {
                    System.out.println("\nIntroduce la columna");
                    posicionY = sc.nextInt();

                    comprobar = tablero.comprobarPoscionY(posicionY);

                    if (!comprobar) System.out.println("Dato invalido");
                } while (!comprobar);

                if (hayBandera) {
                    tablero.ponerBandera(posicionX, posicionY);
                }else{
                    tablero.ponerVisible(posicionX, posicionY);
                    tablero.comprobarEspacios(posicionX, posicionY);

                    EXPLOSION = tablero.comprobarExplosion(posicionX, posicionY);
                    victoria = tablero.comprobarVictoria();
                }                

            } while (!EXPLOSION && !victoria);                            
        }
        
        if (que) {
            tablero.mostrarTablero();
            System.out.println("que");
        }else if(EXPLOSION){
            tablero.mostrarMinasTablero();
            System.out.println("Has perdido");
        }
        else if (victoria) {
            tablero.mostrarTablero();
            System.out.println("Has ganado");
        }
        
    }
    public static boolean comprobarBandera(char bandera){
        boolean comprobar = false;
        
        if (bandera == 's' || bandera == 'n') comprobar = true;
        
        return comprobar;
    }
}
