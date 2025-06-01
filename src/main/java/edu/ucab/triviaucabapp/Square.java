package edu.ucab.triviaucabapp;

import java.util.Scanner;

public class Square {
    private Question questions;
    private String categoria;
    private Square next;

    @Override
    public Square reaction(Scanner scanner, Ficha jugador) {
        Question question = questions.getRandomQuestion(categoria);

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

        // Normalizar las respuestas (eliminar espacios extras, convertir a minúsculas)
        String respuestaNormalizada = respuesta.toLowerCase().replaceAll("\\s+", " ");
        String respuestaCorrectaNormalizada = question.getAnswer().toLowerCase().replaceAll("\\s+", " ");

        // Verificar respuesta exacta
        if (respuestaNormalizada.equals(respuestaCorrectaNormalizada)) {
            return true;
        }

        // Verificar si la respuesta contiene la respuesta correcta o viceversa
        if (respuestaNormalizada.contains(respuestaCorrectaNormalizada) || 
            respuestaCorrectaNormalizada.contains(respuestaNormalizada)) {
            
            // Si las respuestas son muy cortas (menos de 3 caracteres), exigir coincidencia exacta
            if (respuestaNormalizada.length() < 3 || respuestaCorrectaNormalizada.length() < 3) {
                return respuestaNormalizada.equals(respuestaCorrectaNormalizada);
            }
            return true;
        }

        return false;
    }

    // Getters y setters aquí...
    public Square getNext() {
        return next;
    }
}