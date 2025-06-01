package edu.ucab.triviaucabapp;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el tiempo máximo en segundos: ");
        int tiempoMaximo = scanner.nextInt();
        
        Temporizador temporizador = new Temporizador(tiempoMaximo);
        
        System.out.println("Comandos: 'iniciar' para comenzar temporizador, 'detener' para finalizar, 'salir' para terminar");
        String comando;
        
        do {
            comando = scanner.next().toLowerCase();
            switch (comando) {
                case "iniciar":
                    temporizador.iniciar();
                    break;
                case "detener":
                    temporizador.detener();
                    break;
                case "salir":
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Comando desconocido");
            }
        } while (!comando.equals("salir"));
        
        scanner.close();
    }
}