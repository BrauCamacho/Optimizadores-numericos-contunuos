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
public class perm extends Funcion {

    public perm(int dim) {
        super((double) -dim, (double) dim);
    }

    @Override
    public double calcular(double[] vector) {
        double suma_total =0;
        for(int i =1;i < vector.length+1;i++){
            double suma = 0;
        for(int j =1;j < vector.length+1;j++){
            suma+=(j+10)*(Math.pow(vector[j-1], i)-(1.0/Math.pow(j, i)));
        } 
        suma_total+= Math.pow(suma, 2);
        }
        return suma_total;
    }

}
