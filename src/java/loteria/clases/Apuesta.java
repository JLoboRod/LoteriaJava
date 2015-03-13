package loteria.clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase Apuesta
 * @author JLoboRod
 */
public class Apuesta {
    
    private static final int MAX = 6;
    private int num_valores = 0; 
    private Integer[] valores = new Integer[MAX];

    Apuesta() {
        this.Generar();
        this.num_valores = this.MAX;
    }
    
    public final void Generar() {
        int numero;
        List<Integer> numeros = new ArrayList<Integer>();
        
        do {
            numero = Aleatorio(1,49);
            if(!numeros.contains(numero)){
                numeros.add(numero);
            }
        } while (numeros.size() < MAX);
        
        Collections.sort(numeros); //Ordenamos los números
        numeros.toArray(this.valores); //De la lista a _valores
    }

    /**
     * @return the _valores
     */
    public Integer[] getValores() {
        return valores;
    }
    
    public Integer getValor(int pos)
    {
        return valores[pos];
    }
    public Integer[] numeros()
    {
        return getValores();
    }
    
    public int NumValores(){
        return this.num_valores;
    }
    
    public static int Aleatorio(int ini, int fin) {
        return (int) Math.floor(Math.random() * (fin - ini + 1) + ini);
    }
    
    public boolean contiene(int valor){
        return java.util.Arrays.asList(this.valores).contains(valor);
    }
}