package loteria.joaquin;

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
    
    Boleto(){
        this.Generar();
    }
    
    Boleto(int apuestas){
        this.Generar(apuestas);
    }

    public void Generar() {
        this.apuestas = new Apuesta[MAX_APUESTAS];
        for (int i = 0; i < MAX_APUESTAS; i++) {
            this.apuestas[i] = new Apuesta();
        }
    }
    
    public void Generar(int n) {
        this.apuestas = new Apuesta[n];
        for (int i = 0; i < n; i++) {
            this.apuestas[i] = new Apuesta();
        }
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
     * @param _apuestas the _apuestas to set
     */
    public void setApuestas(Apuesta[] _apuestas) {
        this.apuestas = _apuestas;
    }
    
    public int NumApuestas(){
        return this.apuestas.length;
    }
}
