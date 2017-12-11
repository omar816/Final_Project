package com.example.omar.practice_final.HtmlFiles;

/**
 * Created by Omar on 2017-12-11.
 */
public class HtmlQuizQuestions {
    public String mQuestions[] = {
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
    };

    private String mChoices[][] = {
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
    };

    private String correctAnswers[] = {"Hypertext Markup Language", "<!--x-->", "The World Wide Web Consortium",
            "<h1>", "<br>", "<body style=\"background-color:yellow;\">", "<strong>", "<em>", "/",
            "<a href=\"url\" target=\"new\">"};

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

    public String getCorrectAnswers(int a) {
        String answer = correctAnswers[a];
        return answer;
    }
}
