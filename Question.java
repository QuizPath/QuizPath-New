/*
 * Class for individual question
 */
package quiz.path.pkg9.pkg14.pkg14;

import java.util.*;

public class Question {
    
    private int count;
    private String question;
    private String answer;
    private String keyWord;
    private String explination;
    private String subject;
    
    String getQuestion() {
        return question;
    }

    void setQuestion(String q) {
        question=q;
    }
    
    String getAnswer() {
        return answer;
    }
    
    void setAnswer(String a) {
        answer=a;
    }
    
    String getKeyWord() {
        return keyWord;
    }
    
    void setKeyWord(String kw) {
        keyWord=kw;
    }
    
    String getExplination() {
        return explination;
    }
    
    void setExplination(String e) {
        explination=e;
    }
    
    String getSubject() {
        return subject;
    }
    
    void setSubject(String s) {
        subject=s;
    }
    
    public String toString() {
        String output = "[" + question + ", " + answer + ", " + keyWord + ", " + explination + "," + subject + "]";
        return output;
    }
    
    void print() {
        System.out.println("Question-"+question+" Answer-"+answer+" Keywords-"+keyWord+"Explination-"+explination);
    }
}
