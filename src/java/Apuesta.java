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
    private Integer[] _valores = new Integer[MAX];

    Apuesta() {
        this.Generar();
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
        numeros.toArray(this._valores); //De la lista a _valores
    }

    private int Aleatorio(int ini, int fin) {
        return (int) Math.floor(Math.random() * (fin - ini + 1) + ini);
    }

    /**
     * @return the _valores
     */
    public Integer[] getValores() {
        return _valores;
    }

}
