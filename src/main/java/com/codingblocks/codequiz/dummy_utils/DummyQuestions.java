package com.codingblocks.codequiz.dummy_utils;

import com.codingblocks.codequiz.models.Option;
import com.codingblocks.codequiz.models.Question;
import com.codingblocks.codequiz.models.Topic;

import java.util.ArrayList;

/**
 * Created by piyush0 on 27/12/16.
 */
public class DummyQuestions {
    public static Question getDummyQuestion() {

        ArrayList<Option> options = new ArrayList<>();


        options.add(new Option("op1", true));
        options.add(new Option("op2", false));
        options.add(new Option("op3", true));
        options.add(new Option("op4", false));


        ArrayList<Topic> tags = new ArrayList<>();
        tags.add(new Topic("Java"));
        tags.add(new Topic("C++"));

        Question question = new Question("Which among the following is the correct output for this code snippet ? \\n\\n```\\nint p = 10;  \\nfor (int i = 0; i<12; i++);  \\n{  \\n  cout<<p++;  \\n}  \\n```",
                options, tags, "2016",0);

//        Question question = new Question("EFG",options,tags,"2016",0);

        return question;
    }

    public static ArrayList<Question> getDummyQuestions() {

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(getDummyQuestion());
        ArrayList<Option> options1 = new ArrayList<>();

        options1.add(new Option("1op", true));
        options1.add(new Option("2op", false));
        options1.add(new Option("3op", false));
        options1.add(new Option("4op", true));

        ArrayList<Topic> tags1 = new ArrayList<>();
        tags1.add(new Topic("Java"));
        tags1.add(new Topic("C++"));


        ArrayList<Option> options2 = new ArrayList<>();

        options2.add(new Option("op5", true));
        options2.add(new Option("op6", true));
        options2.add(new Option("op7", true));
        options2.add(new Option("op8", false));
        ArrayList<Topic> tags2 = new ArrayList<>();
        tags2.add(new Topic("Java"));
        tags2.add(new Topic("Python"));


        Question question1 = new Question("What is abcde?",
                options1, tags1, "12/42/41",1);

        Question question2 = new Question("What is 2?",
                options2, tags2, "2/42/3",2);

        questions.add(question1);
        questions.add(question2);


        ArrayList<Option> options3 = new ArrayList<>();
        options3.add(new Option("opa", true));
        options3.add(new Option("opb", false));
        options3.add(new Option("opc", false));
        options3.add(new Option("opd", false));
        Question question3 = new Question("What is 3?", options3, new ArrayList<Topic>(), "2/4/24",3);

        questions.add(question3);

        return questions;

    }
}
