package juegoAhoracdo;

import java.util.Random;
import java.util.Scanner;

public class AhorcadoJava_poli {

    public static void main(String[] args) {
        
        //Llamamos al método que nos llama los nombres propuestos 
        String palabraAcertijo = obtenerPalabraSecreta();
        
        //Textos de presentación para el Usuario
        System.out.println("El ahorcado del Politécnico");
        System.out.println("***************************");
        System.out.println("Adivina una de las 4 palabras ofrecidas por el sistema");
        
        
        char [] guionPalabras = obtenerGuionEnpalabra(palabraAcertijo);
        
        boolean juegoTerminado = false;// Declaramos una variable de tipo boolean para camabiar de estado

        Scanner usuario = new Scanner(System.in);
        int intentos = 10;// Declaramos y asignamos los intentos por cada sesión de usuario
        
        
        do {    
            System.out.println(guionPalabras);
            
            System.out.println("Introduce una letra");//Solicitamos al uaurio degitar la palabra 
            System.out.println("Te quedan " + intentos + " intentos");// Le mencionamos al usuario cuantos intentos le qudan 
            
            
            char letra = usuario.next().charAt(0);
            boolean aciertoDeLetra = false;
            
            
            for (int i = 0; i < palabraAcertijo.length(); i++) {
                if (palabraAcertijo.charAt(i) == letra) {
                    guionPalabras[i] = letra;
                    aciertoDeLetra = true;// Imprimimos la palabra decifrada por el usuario dandole una señal más clara sobre la palabra
                }
            }
            
            if (!aciertoDeLetra){
                System.out.println("No has acertado a ninguna Letra");
                -- intentos;// Descontamos los intentos
                if (intentos==0){
                    System.out.println(" Has perdido el juego");
                    juegoTerminado = true;// Despues de quedar con los intentos en 0, cambiamos el estado de la variable booleana
                }
                   
            }
            else {      
                boolean juegoGanado = !obtenerGuiones(guionPalabras);
                    if (juegoGanado){
                        System.out.println("Has ganado el juego");
                        juegoTerminado = true;
                    }
                    
            }
        } while (!juegoTerminado);
        
        usuario.close();
    }
    
    /*
    Creamos el método obtenerPalabraSecreta la cúal llama
    la clase Random, qué nos permite elegir entre las 4 palabras 1 alazar    
    */
    //*********************************************************************
    //*********************************************************************
    /*    
    */
    static String obtenerPalabraSecreta() {
        String[] palabras = {"herencia", "abstraccion", "polimorfismo", "encapsulamiento"};

        Random aleatorio = new Random();
        int numAle = aleatorio.nextInt(palabras.length);
        return palabras[numAle];
    }
    
    /*
    Por medio del método obtenerGuionEnpalabra asignamos un '_' a la palabra resulta
    por el usuario   
    */
    //*********************************************************************
    //*********************************************************************
    /*    
    */
    static char [] obtenerGuionEnpalabra(String palabra){
        int numPalabraSecreta = palabra.length();
        
        //Llamamos al método obtenerGuionEnpalabra que nos llama los nombres propuestos
        //lo asignamos al array llamado guionPalabras creado 
        char[] guionPalabras = new char[numPalabraSecreta];
        //Procedemos a rellenear nuestro array con guiones bajos de los cuales salen por cada letra que tenga la palabra
        for (int i = 0; i < guionPalabras.length; i++) {
            guionPalabras[i] = '_';
        }
        return guionPalabras;
    }
    /*
    Por medio del método obtenerGuiones asignamos un '_' para posteriormnete
    cambiarla por la palabra acertada por el usuario
    */
    //*********************************************************************
    //*********************************************************************
    /*    
    */
    
    static boolean obtenerGuiones(char[]array){
        for (char l:array) {
            if (l == '_')return true;
        }
        return false;
    }
}
