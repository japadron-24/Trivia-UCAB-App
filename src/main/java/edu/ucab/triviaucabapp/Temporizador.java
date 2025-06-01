package edu.ucab.triviaucabapp;

public class Temporizador {
    private int tiempoMaximoSegundos;
    private boolean estaActivo;

    public Temporizador(int tiempoMaximoSegundos) {
        this.tiempoMaximoSegundos = tiempoMaximoSegundos;
        this.estaActivo = false;
    }

    public void iniciar() {
        estaActivo = true;
        System.out.println("Temporizador iniciado por " + tiempoMaximoSegundos + " segundos");
        
        Thread hiloTemporizador = new Thread(() -> {
            int tiempoRestante = tiempoMaximoSegundos;
            while (estaActivo && tiempoRestante > 0) {
                System.out.println("Tiempo restante: " + tiempoRestante + " segundos");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                tiempoRestante--;
            }
            if (tiempoRestante <= 0) {
                System.out.println("¡Se acabó el tiempo!");
            }
            estaActivo = false;
        });
        
        hiloTemporizador.start();
    }

    public void detener() {
        estaActivo = false;
        System.out.println("Temporizador detenido");
    }
}