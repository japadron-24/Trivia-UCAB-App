package edu.ucab.triviaucabapp;

import java.util.Scanner;

public class SquareCategory extends Square {
    private Timer timer;

    public SquareCategory(QuestionManager questionManager, String categoria) {
        super(questionManager, categoria);
        this.timer = new Timer(30); // 30 segundos por defecto para responder
    }

    @Override
    public Square reaction(Scanner scanner, Ficha jugador) {
        Question question = questionManager.getRandomQuestion(categoria);

        if (question == null) {
            System.out.println("\n⚠️ No hay preguntas disponibles para la categoría: " + categoria);
            return this;
        }

        System.out.println("\n=== PREGUNTA DE " + categoria.toUpperCase() + " ===");
        System.out.println(question.getQuestion());
        System.out.println("===============================\n");

        timer.start();
        boolean respuestaCorrecta = revisarRespuesta(scanner, question);
        timer.stop();

        if (respuestaCorrecta) {
            System.out.println("\n🎉 ¡Respuesta correcta!");
            System.out.println("Has ganado 1 punto en la categoría " + categoria);
            jugador.incrementarPuntos();
            return getNext();
        } else {
            System.out.println("\n❌ Respuesta incorrecta.");
            System.out.println("La respuesta correcta era: " + question.getAnswer());
            return this;
        }
    }
}