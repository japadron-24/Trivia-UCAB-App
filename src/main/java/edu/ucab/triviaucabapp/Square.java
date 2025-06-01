package edu.ucab.triviaucabapp;

import java.util.Scanner;

public class Square {
    protected QuestionManager questionManager;
    protected String categoria;
    private Square next;

    public Square() {
        // Constructor por defecto
    }

    public Square(QuestionManager questionManager, String categoria) {
        this.questionManager = questionManager;
        this.categoria = categoria;
    }

    public Square reaction(Scanner scanner, Ficha jugador) {
        Question question = questionManager.getRandomQuestion(categoria);

        if (question == null) {
            System.out.println("No hay preguntas disponibles para esta categoría.");
            return this;
        }

        System.out.println("\n=== PREGUNTA ===");
        System.out.println(question.getQuestion());
        System.out.println("===============\n");
        
        boolean respuestaCorrecta = revisarRespuesta(scanner, question);

        if (respuestaCorrecta) {
            System.out.println("\n¡Respuesta correcta! 🎉");
            System.out.println("Has ganado 1 punto.");
            jugador.incrementarPuntos();
            return getNext();
        } else {
            System.out.println("\n❌ Respuesta incorrecta.");
            System.out.println("La respuesta correcta era: " + question.getAnswer());
            return this;
        }
    }

    public boolean revisarRespuesta(Scanner scanner, Question question) {
        System.out.print("\nTu respuesta: ");
        String respuesta = scanner.nextLine().trim();

        String respuestaNormalizada = respuesta.toLowerCase().replaceAll("\\s+", " ");
        String respuestaCorrectaNormalizada = question.getAnswer().toLowerCase().replaceAll("\\s+", " ");

        if (respuestaNormalizada.equals(respuestaCorrectaNormalizada)) {
            return true;
        }

        if (respuestaNormalizada.length() < 3 || respuestaCorrectaNormalizada.length() < 3) {
            return respuestaNormalizada.equals(respuestaCorrectaNormalizada);
        }

        return respuestaNormalizada.contains(respuestaCorrectaNormalizada) || 
               respuestaCorrectaNormalizada.contains(respuestaNormalizada);
    }

    public Square getNext() {
        return next;
    }

    public void setNext(Square next) {
        this.next = next;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}