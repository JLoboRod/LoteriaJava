/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loteria.clases;

/**
 *
 * @author Joaquin
 */
public class GraficoHelper {
    
    /**
     * Genera el código HTML de un boleto
     * @param b - boleto a generar
     * @return código html
     */
    public static String getHTMLBoleto(Boleto b){
        String html="";
        html += "<table class='boleto shadow'><tr>";
        
        for(int i=0;i<6;i++){
            
            Apuesta apuesta = null;
            
            if(i<b.NumApuestas()){
                apuesta = b.getApuesta(i);
                getHTMLApuesta(apuesta, i+1);
            }
            else{
            
                getHTMLApuesta(i+1);
            }
            
            
            html += "<td>";
            html += (i<b.NumApuestas())?getHTMLApuesta(apuesta, i+1):getHTMLApuesta(i+1);
            html += "</td>";
            /*
            html += "<td>";
            html += getHTMLApuesta(i+1);
            html += "</td>";
            */
        }
        
        html += "</tr></table>";
        return html;
    }
    
    /**
     * Genera el código HTML de una apuesta
     * @param a - La apuesta a generar
     * @param n - El número de apuesta dentro de un boleto
     * @return código html
     */
    public static String getHTMLApuesta(Apuesta a, int n){
        String html="<table class='apuesta'>";
        for(Integer fila=0;fila<10;fila++){
            html += "<tr>";

            for(Integer col=0;col<5;col++){
                Integer valor = col*10 + fila;
                if(fila==0 && col==0){
                    html += "<td class='num_apuesta'>";
                    html += n; 
                }
                else if(a!=null && a.contiene(valor)){
                    html += "<td class='valor_apuesta'>";
                    html += valor;  
                }
                else{
                    html += "<td>";
                    html += valor;
                }
                html += "</td>";
            }
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }
    
    /**
     * Genera el código HTML de una apuesta
     * @param a - La apuesta a generar
     * @param n - El número de apuesta dentro de un boleto
     * @return código html
     */
    public static String getHTMLApuesta(int n){
        String html="<table class='apuesta'>";
        for(Integer fila=0;fila<10;fila++){
            html += "<tr>";

            for(Integer col=0;col<5;col++){
                Integer valor = col*10 + fila;
                if(fila==0 && col==0){
                    html += "<td class='num_apuesta'>";
                    html += n; 
                }
                else{
                    html += "<td>";
                    html += valor;
                }
                html += "</td>";
            }
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }
}
