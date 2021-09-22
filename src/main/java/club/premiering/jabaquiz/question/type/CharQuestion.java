package club.premiering.jabaquiz.question.type;

import club.premiering.jabaquiz.question.AbstractQuestion;
import club.premiering.jabaquiz.question.QuestionResponse;

public class CharQuestion extends AbstractQuestion {
    public CharQuestion() {
        super(new String[]{
                "This variable ONLY uses 1 letter of any kind, which variable is this? \"string\" or \"char\"",
        });
    }

    @Override
    public QuestionResponse onQuestion(String answer) {
        if (answer.equalsIgnoreCase("string")) {
            return new QuestionResponse(true, false);//shit response
        } else if (answer.equalsIgnoreCase("char")) {
            return new QuestionResponse(true, true);
        } else {
            return new QuestionResponse(false);
        }
    }
}
