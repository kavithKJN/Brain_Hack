package com.example.brain_hack_v1;


import androidx.appcompat.app.AppCompatActivity;

public class QuestionsGK extends AppCompatActivity {

    public String mQuestions[] = {

            "Which of the following is a fruit?",
            "Which of the following is a vegetable?",
            "Which of the following you will not find in school?",
            "Which will you use for clean the house?",
            "Kangaroo baby is called?",
            "Which is the most Brightest planet?",
            "Animal with the longest tail?",
            "Which is the biggest lake in the earth?",
            "Which inventor is called as the father of Computer?",
            "Food is digested in which part of the body?",
            "Monkey baby is called?",
            "Only planet where life is exist?",
            "Animal who sleeps while standing?",
            "Which of the following is a fruit?",
            "Which of the following is a vegetable?",
            "Which of the following you will not find in Restaurants?",
            "Which will you use for long distance?",
            "Cat baby is called?",
            "Which of the following is also called as choppers?",
            "What id the vehicle of Lord Ganesha?",
            "Which planet has the most number of moons?",
            "How many legs does a butterfly have?",
            "Which is the largest continent on Earth",
            "What does RAM stands for?",
            "Time is measured in what units?"

    };

    private String mChoices[][] = {

            {"Mint","Apricot","Carrot","Potato"},
            {"Lotus", "Broccoli", "Chair", "Ball"},
            {"White Board", "Bench", "Teachers", "Electronics Shop" },
            {"Cloth", "Glass", "Vaccume Cleaner", "Plate"},
            {"Calf", "Joey", "Cub", "Pup"},
            {"Satren", "Mars", "Uranus", "Venus" },
            {"Camel", "Giraffe", "Elephant", "Horse"},
            {"Lake District", "Lake Victoria", "Lake Superior", "Caspian Sea"},
            {"Thomas Edison", "Charles Babbage", "Sir Isaac Newton", "Alexander Graham Bell"},
            {"Liver", "Stomach", "Small Intestine", "Large Intestine"},
            {"Calf", "Lamb", "Cub", "Infant"},
            {"Earth", "Moon", "Sun", "Mars"},
            {"Horse", "Elephant", "Giraffe", "Camel"},
            {"PineCorn", "Mint", "Carrot", "PineApple"},
            {"PineApple", "Banana", "Cherry", "Tomato"},
            {"Food", "Dishes", "Toys", "Drink"},
            {"Cycle", "Train", "Skating", "Table"},
            {"Calf", "Kitten", "Cub", "Pup"},
            {"Boat", "Helicopter", "Ship", "Jet"},
            {"Eagle", "Peacock", "Bull", "Rat"},
            {"Mercury","Venus", "Neptune", "Jupiter"},
            {"2", "4", "6", "8"},
            {"North America", "Asia", "Europe", "Africa"},
            {"Right Arm Memory", "read Only Memory", "Read Access Memory"},
            {"Liters", "Meters", "Seconds", "Decibel"}

    };

    private String mCorrectAnswers[] = {"Potato"," Broccoli"," Electronics Shop ","Vaccume Cleaner","Joey","Venus","Giraffe","Caspian Sea","Charles Babbage","Stomach", "Infant", "Earth", "Elephant", "PineApple", "Tomato", "Toys", "Train", "Kitten", "Helicopter", "Rat", "Jupiter", "6", "Asia", "Random Access Memory", "Seconds"};

    public String getQuestion(int a){

        String question = mQuestions[a];
        return question;

    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }

}

