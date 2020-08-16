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
public class ackley extends Funcion{

    public ackley() {
        super(-32.768,32.768);
    }

    @Override
    public double calcular(double[] vector) {
        double suma1 =0, suma2 =0;
        for(double valor: vector){
            suma1+= Math.pow(valor, 2);
            suma2 += Math.cos(2*Math.PI*valor);
        }
         double reg1 = Math.exp(1)- Math.exp(suma2/(double)vector.length);
        return   20 - 20 * Math.exp(-0.2*Math.sqrt(suma1/(double)vector.length)) - reg1;
    }
    
}
