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
    private Apuesta[] _apuestas;
    
    Boleto(){
        this.Generar();
    }
    
    Boleto(int apuestas){
        this.Generar(apuestas);
    }

    private void Generar() {
        this._apuestas = new Apuesta[MAX_APUESTAS];
        for (int i = 0; i < MAX_APUESTAS; i++) {
            this._apuestas[i] = new Apuesta();
        }
    }
    
    private void Generar(int n) {
        this._apuestas = new Apuesta[n];
        for (int i = 0; i < n; i++) {
            this._apuestas[i] = new Apuesta();
        }
    }
    
    /**
     * @return the _apuestas
     */
    public Apuesta[] getApuestas() {
        return _apuestas;
    }

    /**
     * @param _apuestas the _apuestas to set
     */
    public void setApuestas(Apuesta[] _apuestas) {
        this._apuestas = _apuestas;
    }
    
    
}
