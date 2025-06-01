package edu.ucab.triviaucabapp;

import java.util.Scanner;

public class SquareCategory extends Square {
    private QuestionManager questionManager;
    private String category;
    private Timer timer;

    public SquareCategory(QuestionManager questionManager, String category) {
        this.questionManager = questionManager;
        this.category = category;
        this.timer = new Timer(30); // 30 segundos por defecto para responder
    }

    @Override
    public Square reaction(Scanner scanner, Ficha jugador) {
        // Obtener una pregunta aleatoria de la categoría
        Question question = questionManager.getRandomQuestion(category);

        if (question == null) {
            System.out.println("\n⚠️ No hay preguntas disponibles para la categoría: " + category);
            return this;
        }

        System.out.println("\n=== PREGUNTA DE " + category.toUpperCase() + " ===");
        System.out.println(question.getQuestion());
        System.out.println("===============================\n");

        // Iniciar el temporizador
        timer.start();

        // Obtener y verificar la respuesta
        boolean respuestaCorrecta = revisarRespuesta(scanner, question);

        // Detener el temporizador
        timer.stop();

        if (respuestaCorrecta) {
            System.out.println("\n🎉 ¡Respuesta correcta!");
            System.out.println("Has ganado 1 punto en la categoría " + category);
            jugador.incrementarPuntos();
            return getNext();
        } else {
            System.out.println("\n❌ Respuesta incorrecta.");
            System.out.println("La respuesta correcta era: " + question.getAnswer());
            return this;
        }
    }

    @Override
    public boolean revisarRespuesta(Scanner scanner, Question question) {
        System.out.print("\nTu respuesta: ");
        String respuesta = scanner.nextLine().trim();

        // Normalizar las respuestas
        String respuestaNormalizada = respuesta.toLowerCase().replaceAll("\\s+", " ");
        String respuestaCorrectaNormalizada = question.getAnswer().toLowerCase().replaceAll("\\s+", " ");

        // Verificar respuesta exacta
        if (respuestaNormalizada.equals(respuestaCorrectaNormalizada)) {
            return true;
        }

        // Para respuestas muy cortas, exigir coincidencia exacta
        if (respuestaNormalizada.length() < 3 || respuestaCorrectaNormalizada.length() < 3) {
            return respuestaNormalizada.equals(respuestaCorrectaNormalizada);
        }

        // Verificar si la respuesta contiene la respuesta correcta o viceversa
        return respuestaNormalizada.contains(respuestaCorrectaNormalizada) || 
               respuestaCorrectaNormalizada.contains(respuestaNormalizada);
    }

    // Getters y setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}