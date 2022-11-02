/*Create a quiz program that will take questions, option and answer from admin user and save it to the question bank ,
Then if any user want to give the quiz, random 5 questions will be shown to the user from the question bank.
Program output:
       1. Add Quiz
       2. Start Quiz

        if user select option 1,
        then system will tell user to input a question,
        4 options and correct answer to save data in a quiz bank.
       The quiz bank will be a json file.
*/

package MCQ;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz
{
    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        String filename = "./src/main/resources/QuesList.json";
        JSONParser jsonParser = new JSONParser();
        Object ques = jsonParser.parse(new FileReader(filename));
        JSONArray quesList = (JSONArray) ques;

        FileWriter fileWriter = new FileWriter(filename);

        JSONObject quesObj = new JSONObject();

        System.out.println("Welcome to Quiz");
        System.out.println("If you want to add a question to the quiz: PRESS 1");
        System.out.println("If you want to attempt the quiz: Press 2");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();

        if(choice == 1)
        {
            System.out.println("Input your question: ");
            String question = sc.nextLine();

            System.out.println("Option A: ");
            String optionA = sc.nextLine();
            
            System.out.println("Option B: ");
            String optionB = sc.nextLine();
            
            System.out.println("Option C: ");
            String optionC = sc.nextLine();
            
            System.out.println("Option D: ");
            String optionD = sc.nextLine();
            
            System.out.println("Input correct answer option (A/B/C/D)");
            String answer = sc.nextLine();

            quesObj.put("Question :", question);
            quesObj.put("A :", optionA);
            quesObj.put("B :", optionB);
            quesObj.put("C :", optionC);
            quesObj.put("D :", optionD);
            quesObj.put("Answer :", answer);

            quesList.add(quesObj);
            fileWriter.write(quesList.toString());
            fileWriter.flush();
            System.out.println("Your question was added successfully");

        }
        else if (choice==2)
        {
            int count = 0;
            int lowerLimit = 1;
            int upperLimit = 15;
            int j = (int) (Math.random() * (upperLimit - lowerLimit) + lowerLimit);
//            int x = (int) Math.floor(j);

            System.out.println("There will be Five questions. Each question has 1 Mark");
            System.out.println("Always answer in CAPS (A/B/C/D), do not write (a/b/c/d)");
            System.out.println("Good Luck!");

            for(int i = 1; i<=5; i++)
            {

                int x = (int) Math.floor(j);

                JSONObject quesNo = (JSONObject) quesList.get(x);

                String question = quesObj.get("Question :").toString();
                String oA = quesObj.get("A :").toString();
                String oB = quesObj.get("B :").toString();
                String oC = quesObj.get("C :").toString();
                String oD = quesObj.get("D :").toString();
                String correctAnswer = quesObj.get("Answer :").toString();

                System.out.println("Ques " + i + " : "+ question);
                System.out.println("A :" + oA);
                System.out.println("A :" + oB);
                System.out.println("A :" + oC);
                System.out.println("A :" + oD);
                System.out.println();

                System.out.println("Please submit your answer: ");
                String answer = sc.nextLine();

                if(answer.equals(correctAnswer))
                {
                    count++;
                }
                else{
                    System.out.println("Incorrect Answer! Go Study!");
                }

            }

            System.out.println("You got "+count+" marks out of 5");
        }

//        quesObj.put("Question :", "Which is the biggest testing of all?");
//        quesObj.put("A :", "Feature Testing");
//        quesObj.put("B :", "Regression Testing");
//        quesObj.put("C :", "Unit Testing");
//        quesObj.put("D :", "Smoke Testing");
//        quesObj.put("Answer :", "B");
//
//        quesList.add(quesObj);
//
//        fileWriter.write(quesList.toString());
//        fileWriter.flush();

//        System.out.println(quesList);
    }

}
