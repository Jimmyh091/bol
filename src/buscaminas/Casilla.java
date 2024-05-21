/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaminas;
//Juande
/**
 *
 * @author jaime
 */
public class Casilla {
    private boolean mina = false;
    private boolean visible = false;
    private int numMinas;
    private boolean visto;
    private boolean bandera = false;
    
    public Casilla(){
        mina = false;
        visible = false;
    }
    
    public Casilla(int numMinas){
        this.numMinas = numMinas;
    }
    
    public boolean getVisible(){
        return visible;
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    
    public int getNumMinas(){
        return numMinas;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }    

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    
    
}
