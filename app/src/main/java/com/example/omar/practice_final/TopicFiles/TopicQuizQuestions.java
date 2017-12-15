package com.example.omar.practice_final.TopicFiles;

/**
 * Created by Omar on 2017-12-11.
 */
public class TopicQuizQuestions {

    public String mQuestions[][] = {
        {   // No topic
            "Something has gone horribly wrong. There is no topic for this quiz."
        },

        {   // HTML
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
        {   //CSS
            "What does CSS Stand for?",
            "How do you colour an element blue in CSS?"
        },
        {   //JavaScript
            "What's the most common use for JavaScript?",
            "How would you describe JS as a language?"
        },
        {   //Java
            "How do you write a Java comment?",
            "Print the string \"Hello World!\""
        },
        {   //C++
            "How do you print to the screen in C++?",
            "What's new in C++ from original C?"
        },
        {   //Python
            "Which of the following is not a part of the Python philosophy?",
            "What is Python named after?"
        }

    };

    private String mChoices[][][] = {
        {   // No topic
            {"There is no quiz", "There is no quiz", "There is no quiz", "There is no quiz"}
        },
        {   //HTML
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
        {   //CSS
            {"Collaborative Stylization Strategy", "Colour Setting Sheet", "Cascading Style Sheet", "Cassidy Stevenson & Smith"},
            {"{color: blue;}","setColor(blue);","<blue>","{color=blue};"}
        },
        {   //JavaScript
            {"Replacing Java programs","Android Applications","DHTML","Robotics"},
            {"Compiled, low-level, weakly typed", "Interpreted, high-level, dynamic, weakly typed", "Interpreted, high-level, dynamic, strongly typed", "It's just a fancy word for Java"}
        },
        {   //Java
            {"#like this", "--like this", "//like this", "::like this"},
            {"put message \"Hello World!\"", "System.out.println(\"Hello World!\");", "print.out.(\"Hello World!\")", "writeToScreen(Hello World!)"}
        },
        {   //C++
            {"cout.std.println();","std::cout>>","print();","std::cout<<"},
            {"The ++", "Object oriented programming", "Operators", "DHTML Support"}
        },
        {   //Python
            {"Beautiful is better than ugly", "Implicit is better than explicit", "Simple is better than complex", "Complex is better than complicated"},
            {"The creator", "The Myanmar short-tailed python", "The British comedy group, Monty Python", "The Angolan python" }
        }
    };

    private String correctAnswers[][] = {
            {   //No topic
                "There is no answer."
            },
            {   //HTML
                "Hypertext Markup Language",
                "<!--x-->",
                "The World Wide Web Consortium",
                "<h1>",
                "<br>",
                "<body style=\"background-color:yellow;\">",
                "<strong>",
                "<em>",
                "/",
                "<a href=\"url\" target=\"new\">"
            },
            {   //CSS
                "Cascading Style Sheet",
                "{color: blue;}"
            },
            {   //JavaScript
                "DHTML",
                "Interpreted, high-level, dynamic, weakly typed"
            },
            {   //Java
                "//like this",
                "System.out.println(\"Hello World!\");"
            },
            {   //C++
                "std::cout<<",
                "Object oriented programming"
            },
            {   //Python
                    "Implicit is better than explicit",
                    "The British comedy group, Monty Python"
            }
    };

    //Have each question associated with its corresponding answers
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
