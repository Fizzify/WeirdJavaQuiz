package club.premiering.jabaquiz.question.type;

import club.premiering.jabaquiz.question.AbstractQuestion;
import club.premiering.jabaquiz.question.QuestionResponse;

public class AllmanQuestion extends AbstractQuestion {
    public AllmanQuestion() {
        super(new String[]{
                "Do you use allman (indentation style)? \"yes\" or \"no\"",
                "Example of allman:",
                "public static void main(String[] args)",
                "{",
                "    System.out.println(\"hi!\");",
                "}",
                "",
                "Example of normal Java code:",
                "public static void main(String[] args) {",
                "    System.out.println(\"hi!\");",
                "}"
        });
    }

    @Override
    public QuestionResponse onQuestion(String answer) {
        if (answer.equalsIgnoreCase("yes")) {
            return new QuestionResponse(true, false);//shit response
        } else if (answer.equalsIgnoreCase("no")) {
            return new QuestionResponse(true, true);
        } else {
            return new QuestionResponse(false);
        }
    }
}
