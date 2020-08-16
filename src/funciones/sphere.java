/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import pso2.Funcion;

/**
 *
 * @author brau
 */
public class sphere extends Funcion{

    public sphere() {
        super(-5.12, 5.12);
    }

    @Override
    public double calcular(double[] vector) {
        double s =0;
     for(double valor: vector){
         s += (valor*valor);
     }   
     return s;
    }
    
}
