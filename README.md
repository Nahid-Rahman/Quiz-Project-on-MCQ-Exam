# Quiz-Project-on-MCQ-Exam

## Here I have tried to Create a quiz program that will take questions, option and answer from admin user and save it to the question bank. Then if any user want to give the quiz, random 5 questions will be shown to the user from the question bank.

## JSON Format

{
"Question":"Which testing is done by developer?",
"option a":"Unit Testing",
"Option b":"Integration Testing",
"Sanity Testing":"Sanity Testing",
"Option d":"Regression Testing",
"answer":"a"
}

## Scenario

1- if user select option of Add Question, then system will tell user to input a question, 4 options and correct ans to save data in a quiz bank. The quiz bank will be a json file.
2- If user select option of Give Quiz,  then, System> You will be ask 5 questions, each questions has 1 marks. Then after finishing it will show the marks user got.

## CAUTIONS
  - In the main Java file, at the very last I commented out a portion, which will help you understand how I added questions as JSON Format.
  - I have also added the JSON File with questions. You just need to add it under Resource and rename the "File Path" accordingly
