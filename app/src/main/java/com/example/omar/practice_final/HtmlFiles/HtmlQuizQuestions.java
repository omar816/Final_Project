package com.example.omar.practice_final.HtmlFiles;

/**
 * Created by Omar on 2017-12-11.
 */
public class HtmlQuizQuestions {
    public String mQuestions[][] = {
            {
                "Something has gone horribly wrong. There is no topic for this quiz."
            },

            {
                "What is HTML an acronym for?",
                "How do you write 'x' as a comment",
                "Who is making the Web standards?",
                "Choose the correct HTML element for the largest heading:",
                "What is the correct HTML element for inserting a line break?",
                "What is the correct HTML for adding a background color?",
                "Choose the correct HTML element to define important text",
                "Choose the correct HTML element to define emphasized text",
                "Which character is used to indicate an end tag?",
                "How can you open a link in a new tab/browser window?"
            },
            {
                "What does CSS Stand for?",
                "How do you colour an element blue in CSS?"
            }
    };

    private String mChoices[][][] = {
        {
            {"There is no quiz", "There is no quiz", "There is no quiz", "There is no quiz"}
        },
        {
            {"Hypertext Markup Language", "Hypertext MicroLanugage", "Hyper-Link Markup Tensil", "Hotmail"},
            {"<!x>", "###x", "//x", "<!--x-->"},
            {"The World Wide Web Consortium", "Microsoft", "Google", "Mozilla"},
            {"<head>", "<h6>", "<h1>", "<heading>"},
            {"<br>", "/t", "<t>", "<break>"},
            {"<background>yellow</background>", "<body style=\"background-color:yellow;\">", "<body bg=\"yellow\">", "yellow"},
            {"<strong>", "<important>", "<i>", "<b>"},
            {"<i>", "<italic>", "<em>", "<special>"},
            {"<", "*", "/", "^"},
            {"<a href=\"url\" target=\"new\">", "<a href=\"url\" new>", "<a href=\"url\" target=\"_blank\">", "No possible way!"},
        },
        {
            {"Collaborative Stylization Strategy", "Colour Setting Sheet", "Cascading Style Sheet", "Cassidy Stevenson & Smith"},
            {"{color: blue;}","setColor(blue);","<blue>","{color=blue};"}
        }
    };

    private String correctAnswers[][] = {
            {
                "There is no answer."
            },
            {
                "Hypertext Markup Language", "<!--x-->", "The World Wide Web Consortium",
                "<h1>", "<br>", "<body style=\"background-color:yellow;\">", "<strong>", "<em>", "/",
                "<a href=\"url\" target=\"new\">"
            },
            {
                "Cascading Style Sheet",
                "{color: blue;}"
            }
    };

    public String getQuestion(int quizNumber, int a){
        String question = mQuestions[quizNumber][a];
        return question;
    }
    public String getChoice1(int quizNumber, int a){
        String choice = mChoices[quizNumber][a][0];
        return choice;
    }
    public String getChoice2(int quizNumber, int a){
        String choice = mChoices[quizNumber][a][1];
        return choice;
    }
    public String getChoice3(int quizNumber, int a){
        String choice = mChoices[quizNumber][a][2];
        return choice;
    }
    public String getChoice4(int quizNumber, int a){
        String choice = mChoices[quizNumber][a][3];
        return choice;
    }

    public String getCorrectAnswers(int quizNumber, int a) {
        String answer = correctAnswers[quizNumber][a];
        return answer;
    }
}
