/*
 * Database for QuizPath website
 */
package quiz.path.pkg9.pkg14.pkg14;

import java.util.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class QuizPath91414 {

    private ArrayList<Question> allQuestions = new ArrayList<Question>();
    private ArrayList<Question> questionsForQuiz = new ArrayList<Question>();
    //reads all questions from a file into the database
    public void readQuestionsFromFile()
    {
        BufferedReader reader=null;
        try {
            File file = new File("Questions.txt");
            reader = new BufferedReader(new FileReader(file));
            
            String line;
            while((line=reader.readLine())!=null)
            {
                Question q = new Question();
                q.setQuestion(line);
                line = reader.readLine();
                q.setAnswer(line);
                line = reader.readLine();
                q.setKeyWord(line);
                line = reader.readLine();
                q.setExplination(line);
                line = reader.readLine();
                q.setSubject(line);
                allQuestions.add(q);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
     }
    //prints all questions from database
    public void printQuestions()
    {
        for(int i=0;i<allQuestions.size();i++)
            System.out.println(allQuestions.get(i));
    }
    //sorts through questions data base and uses specifications to make list of questions for quiz
    public void getQuestionsForQuiz()
    {
        ArrayList<Question> possibleQuestions = new ArrayList<Question>();
        String subjectWanted="Computer Science";
        for(int i=0;i<allQuestions.size();i++)
        {
            Question q;
            q=allQuestions.get(i);
            if(q.getSubject().equals(subjectWanted))
                possibleQuestions.add(q);
            else
                continue;
        }
        int count=0;
        Random r = new Random();
        boolean add=true;
        while (count<10)
        {
            int randomInt = r.nextInt(20);
            Question b;
            b=possibleQuestions.get(randomInt);
            for(int j=1;j<questionsForQuiz.size();j++)
            {
                Question f=questionsForQuiz.get(j);
                if(f.getQuestion().equals(b.getQuestion()))
                {
                    add=false;
                    break;
                }
                else
                    add=true;
            }
            if(add==true)
            {
                questionsForQuiz.add(b);
                count++;
            }
            else if(add==false)
                    continue;
        }
        printQuizQuestions();
    }
    //prints questions for specific quiz
    public void printQuizQuestions()
    {
        for(int i=0;i<questionsForQuiz.size();i++)
        {
            Question q;
            q=questionsForQuiz.get(i);
            System.out.println(q.getQuestion());
        }
    }
    //runs main menu of the program
    public void menu()
    {
        Scanner in  = new Scanner (System.in);
        String selected="";
        while(!selected.equals("3"))
        {
            System.out.println("Enter:\n1. To print all questions\n2. To print questions that would show up on quiz\n3. To Quit");
            selected=in.nextLine();
            if (selected.equals("1"))
                printQuestions();
            else if(selected.equals("2"))
                getQuestionsForQuiz();
        }
    }
    
    public void run()
    {
        readQuestionsFromFile();
        menu();
    }
    
    public static void main(String[] args) {
        QuizPath91414 q = new QuizPath91414();
        q.run();
    }
}
