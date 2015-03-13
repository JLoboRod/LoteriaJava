package loteria.clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase Boleto
 * @author JLoboRod
 */
public class Boleto {
    private static final int MAX_APUESTAS = 8;
    private Apuesta[] apuestas;
    private int reintegro;
    private int precio;
    
    public Boleto(){
        this.Generar();
    }
    
    public Boleto(int apuestas){
        this.Generar(apuestas);
    }

    public void Generar(int n) {
        this.apuestas = new Apuesta[n];
        for (int i = 0; i < n; i++) {
            this.apuestas[i] = new Apuesta();
        }
        this.reintegro = Aleatorio(1, 9);
        this.precio = n;
    }
    
    public void Generar(){
        this.Generar(MAX_APUESTAS);
    }
    
    /**
     * @return the _apuestas
     */
    public Apuesta[] getApuestas() {
        return apuestas;
    }
    
    public Apuesta getApuesta(int pos){
        return apuestas[pos];
    }
    
    /**
     * @param apuestas the _apuestas to set
     */
    public void setApuestas(Apuesta[] _apuestas) {
        this.apuestas = _apuestas;
    }
    
    public int NumApuestas(){
        return this.apuestas.length;
    }
    
    public static int Aleatorio(int ini, int fin) {
        return (int) Math.floor(Math.random() * (fin - ini + 1) + ini);
    }
    
    public int getPrecio(){
        return this.precio;
    }
    
    public int getReintegro(){
        return this.reintegro;
    }
    
}
