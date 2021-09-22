package club.premiering.jabaquiz.question.type;

import club.premiering.jabaquiz.question.AbstractQuestion;
import club.premiering.jabaquiz.question.QuestionResponse;

public class PrintQuestion extends AbstractQuestion {
    public PrintQuestion() {
        super(new String[]{
                "Which do you think is the correct way of printing, System.print() or System.out.println() \"1st\" or \"2nd\"",
        });
    }

    @Override
    public QuestionResponse onQuestion(String answer) {
        if (answer.equalsIgnoreCase("1st")) {
            return new QuestionResponse(true, false);//shit response
        } else if (answer.equalsIgnoreCase("2nd")) {
            return new QuestionResponse(true, true);
        } else {
            return new QuestionResponse(false);
        }
    }
}
