package club.premiering.jabaquiz.question.type;

import club.premiering.jabaquiz.question.AbstractQuestion;
import club.premiering.jabaquiz.question.QuestionResponse;

public class YouTubeTutorialQuestion extends AbstractQuestion {
    public YouTubeTutorialQuestion() {
        super(new String[]{
                "Do you only learn Java from YouTube tutorials? \"yes\" or \"no\""
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
