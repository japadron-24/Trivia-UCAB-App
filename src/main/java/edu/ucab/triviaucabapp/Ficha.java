package edu.ucab.triviaucabapp;

public class Ficha {
    private int puntos;
    private String nombre;

    public Ficha(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    public void incrementarPuntos() {
        this.puntos++;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }
}