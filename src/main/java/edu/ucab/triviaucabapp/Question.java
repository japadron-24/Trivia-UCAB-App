package edu.ucab.triviaucabapp;

public class Question {
    private String question;
    private String answer;
    private String category;

    public Question(String question, String answer, String category) {
        this.question = question;
        this.answer = answer;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getCategory() {
        return category;
    }
}