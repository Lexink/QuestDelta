package ua.com.javarush.quest.khmelov.questdelta.entity;

import java.util.Objects;

public class Answer extends AbstractEntity {
    private long questionID;
    private String answerText;

    public static AnswerBuilder builder(){
        return new AnswerBuilder();
    }

    public Answer(long questionID, String answerText) {
        this.questionID = questionID;
        this.answerText = answerText;
    }

    public long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(long questionID) {
        this.questionID = questionID;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Answer answer = (Answer) o;
        return questionID == answer.questionID && Objects.equals(answerText, answer.answerText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), questionID, answerText);
    }

    public static class AnswerBuilder {
        private long questionID;
        private String answerText;

        AnswerBuilder() {
        }

        public AnswerBuilder questionID(long questionID){
            this.questionID = questionID;
            return  this;
        }

        public AnswerBuilder answerText(String answerText){
            this.answerText = answerText;
            return this;
        }

        public Answer build(){
            return new Answer(questionID, answerText);
        }
    }
}