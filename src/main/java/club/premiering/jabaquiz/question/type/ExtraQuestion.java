package club.premiering.jabaquiz.question.type;

import club.premiering.jabaquiz.question.AbstractQuestion;
import club.premiering.jabaquiz.question.QuestionResponse;

public class ExtraQuestion extends AbstractQuestion {
    public ExtraQuestion() {
        super(new String[]{
                "Do you feel like this is too easy? Here's a bonus. What do you think is the variable used for this, 1000.0 \"int\" or \"double\"",
        });
    }

    @Override
    public QuestionResponse onQuestion(String answer) {
        if (answer.equalsIgnoreCase("int")) {
            return new QuestionResponse(true, false);//shit response
        } else if (answer.equalsIgnoreCase("double")) {
            return new QuestionResponse(true, true);
        } else {
            return new QuestionResponse(false);
        }
    }
}
