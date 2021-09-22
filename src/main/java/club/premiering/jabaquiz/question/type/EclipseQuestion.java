package club.premiering.jabaquiz.question.type;

import club.premiering.jabaquiz.question.AbstractQuestion;
import club.premiering.jabaquiz.question.QuestionResponse;

public class EclipseQuestion extends AbstractQuestion {
    public EclipseQuestion() {
        super(new String[]{
                "Do you use Eclipse IDE for your programming? \"yes\" or \"no\"",
                "Example of IDE's are Intellij, Eclipse and NetBeans."
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
