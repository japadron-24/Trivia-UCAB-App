package edu.ucab.triviaucabapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class QuestionManager {
    private Map<String, List<Question>> questionsByCategory;
    private Random random;

    public QuestionManager() {
        this.questionsByCategory = new HashMap<>();
        this.random = new Random();
        initializeQuestions();
    }

    private void initializeQuestions() {
        // Inicializar con algunas preguntas de ejemplo
        addQuestion(new Question("¿Cuál es la capital de Venezuela?", "Caracas", "Geografia"));
        addQuestion(new Question("¿En qué año se fundó la UCAB?", "1953", "Historia"));
        addQuestion(new Question("¿Quién escribió Doña Bárbara?", "Rómulo Gallegos", "Literatura"));
        // Puedes agregar más preguntas aquí
    }

    public void addQuestion(Question question) {
        questionsByCategory.computeIfAbsent(question.getCategory(), k -> new ArrayList<>())
                          .add(question);
    }

    public Question getRandomQuestion(String category) {
        List<Question> questions = questionsByCategory.get(category);
        if (questions == null || questions.isEmpty()) {
            return null;
        }
        return questions.get(random.nextInt(questions.size()));
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionsByCategory.getOrDefault(category, new ArrayList<>());
    }
}