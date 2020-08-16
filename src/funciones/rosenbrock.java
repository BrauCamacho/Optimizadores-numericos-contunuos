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
public class rosenbrock extends Funcion{

    public rosenbrock() {
        super(-5,10);
    }

    @Override
    public double calcular(double[] vector) {
        double suma =0;
       for(int i =0;i < vector.length-1;i++) {
           suma += (100*Math.pow(vector[i+1]-Math.pow(vector[i],2),2)+Math.pow(vector[i]-1,2));
       }
       return suma;
    }
    
}
