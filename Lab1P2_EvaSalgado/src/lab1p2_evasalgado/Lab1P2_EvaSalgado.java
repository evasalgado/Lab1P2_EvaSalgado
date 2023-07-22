/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_evasalgado;

import java.util.Scanner;

/**
 *
 * @author evaja
 */
public class Lab1P2_EvaSalgado {

    /**
     * @param args the command line arguments
     */
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("---Menu---");
            System.out.println("1. Ejercicio 1\n2. Ejercicio 2\n3. Salir");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    double a,
                     b,
                     c;
                    double desplazamiento = 100;
                    System.out.println("Ingrese valor de a: ");
                    a = leer.nextDouble();
                    System.out.println("Ingrese valor de b: ");
                    b = leer.nextDouble();
                    System.out.println("Ingrese valor de c: ");
                    c = leer.nextDouble();
                    int cont = 0;
                    double resultado =0;
                    System.out.println("Su respuesta es: "+NewtonRhapson(a, b, c, desplazamiento,cont,resultado));

                    break;
                case 2:
                    int x = 0,
                    n = 0;
                    System.out.println("Ingrese el valor de x: ");
                    x = leer.nextInt();
                    System.out.println("Ingrese el valor de n: ");
                    n = leer.nextInt();
                    int cont2=0;
                    double result = 0;
                     
                    System.out.println("Seno de x: " + TaylorSeno(x, n, cont2, result));
                    System.out.println("Coseno de x: "+TaylorCoseno(x, n, cont2, result));
                    
                    
                    double pi = 1.57;
                    if(x<pi){
                        cont = 1;
                        System.out.println("Tangente de x: "+TaylorTangente(x, n, cont, result));
                    } else {
                        System.out.println("Lo siento, x es mayor que pi/2");
                    }

                    break;
                case 3:
                    System.out.println("Gracias por usar mi programa");

                    break;
                default:
                    System.out.println("Numero invalido");
                    break;
            }

        }
    }

    public static double NewtonRhapson(double a, double b, double c, double desplazamiento, int cont, double result) {
        double x= 0, y=0;
        double va =  Math.pow(a, 2); //a de vertice
        double vb =  b;//b de vertice
        double xo1 = 0,xo2=0;
        
        if(cont==desplazamiento){
            return result;
        }else {
           x=(-1*vb)/(2*va);
           y=(a*Math.pow(x, 2))+(b*x)+c;
           xo1 = (x)-200;
           xo2= (x)+200;
           result = (xo1/xo2);
           
           return NewtonRhapson(a, b, c, desplazamiento, cont,result);
        }
           
    }

    public static int TaylorSeno(int x, int n, int cont, double resultado) {

        double acum = 0;
        double exp = 0, denom = 0;
        double factorial = 0;
        int lim = n, valor = x;
        
        
        if (cont == lim) {
            return (int) resultado;
        } else {
            exp = Math.pow(-1, cont);
            denom = (2*cont)+1;
            acum = Math.pow(lim, (2*cont)+1);
            factorial= (exp / denom);
            resultado = factorial * acum;
            cont++;
            return TaylorSeno(x,n,cont,resultado);
        }
    }
    public static int TaylorCoseno(int x, int n, int cont, double resultado) {

        double acum = 0;
        double exp = 0, denom = 0;
        double factorial = 0;
        int lim = n;
        
        
        if (cont == lim) {
            return (int) resultado;
        } else {
            exp = Math.pow(-1, cont);
            denom = (2*cont);
            acum = Math.pow(lim, denom);
            factorial= (exp / denom);
            resultado = factorial * acum;
            cont++;
            return TaylorSeno(x,n,cont,resultado);
        }
    }
    public static int TaylorTangente(int x, int n, int cont, double resultado) {

        double acum = 0;
        double num = 0, denom = 0;
        double factorial = 0;
        int lim = n, b = x;
        
        
        
        if (cont == lim) {
            return (int) resultado;
        } else {
            num = (Math.pow(b, 2*cont))*(Math.pow(-4, cont))*(1-Math.pow(4, cont));
            denom = (2*cont);
            acum = Math.pow(lim, (2*cont)-1);
            factorial= (num / denom);
            resultado = factorial * acum;
            cont++;
            return TaylorSeno(x,n,cont,resultado);
        }
    }
}
