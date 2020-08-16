/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso2;

import Clases.Particula;
import Optimizadores.PSO;
import Optimizadores.UMDA;
import funciones.ackley;
import funciones.perm;
import funciones.rosenbrock;
import funciones.schwefel;
import funciones.sphere;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import org.apache.commons.math3.random.RandomDataGenerator;

/**
 *
 * @author brau
 */
public class PSO2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PSO2 opt = new PSO2();
        int Individuos = 30;
        int Dimensiones = 2;
        int ciclos = opt.ciclos(Individuos, Dimensiones);
        double [] mejores = new double[31];
        for(int i =0;i< 1;i++){
            System.out.println("experimento");
     //  Optimizador op = new UMDA(ciclos, Individuos, Dimensiones, new perm(10));
       Optimizador op = new PSO(ciclos, Individuos, Dimensiones, new schwefel());
       LinkedList<Particula> resul = op.getP();
       mejores[i] = resul.get(0).getFitness();
        System.out.println(resul.get(0).getFitness()+"  "+Arrays.toString(resul.get(0).getVector()));
        }
        Arrays.sort(mejores);
        
        double media = opt.media(mejores);
        double varianza = opt.varianza(mejores, media);
        System.out.println("Media: "+media);
        System.out.println("Varianza : "+varianza);
        System.out.println("Minimo: "+mejores[0]);
        System.out.println("Maximo: "+mejores[mejores.length-1]);
//     double [] vector = {1.0,(1.0/2.0),(1.0/3.0),(1.0/4.0),(1.0/5.0),(1.0/6.0),(1.0/7.0),(1.0/8.0),(1.0/9.0),(1.0/10.0)};
//     Funcion f= new perm(5);
//        System.out.println(f.calcular(vector));
    }
    
    public double media(double[] mejores){
        double res =0;
        for(double d: mejores){
            res+= d;
        }
        return res/(double)mejores.length;
    }
    public double varianza(double[] mejores, double media){
        double res =0;
        for(double d: mejores){
            res+= Math.pow(d- media,2);
        }
        return res/(double)mejores.length;
    }
    public int ciclos(int m, int d) {
        return (d * 100000) / m;
    }
}
