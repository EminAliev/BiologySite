package models;

public class Result {
    private int id;
    private int correctAnswer;
    private int wrongAnswer;
    private int countCorrect;
    private int idQuestion;
    private int idUser;

    public Result() {
    }

    public Result(int id, int correctAnswer, int wrongAnswer, int idQuestion, int idUser, int countCorrect) {
        this.id = id;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
        this.idQuestion = idQuestion;
        this.idUser = idUser;
        this.countCorrect = countCorrect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(int wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getCountCorrect() {
        return countCorrect;
    }

    public void setCountCorrect(int countCorrect) {
        this.countCorrect = countCorrect;
    }
}
