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
public class schwefel extends Funcion{

    public schwefel() {
        super(-500,500);
    }

    @Override
    public double calcular(double[] vector) {
        double regreso =0;
        for (double valor:vector){
            regreso+= valor* Math.sin(Math.sqrt(Math.abs(valor)));
        }
        return 418.9829*vector.length -regreso;
    }
    
}
