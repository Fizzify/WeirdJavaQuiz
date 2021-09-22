package club.premiering.jabaquiz.question;

import lombok.Getter;

public abstract class AbstractQuestion {
    @Getter
    private final String[] question;

    public AbstractQuestion(final String[] question) {
        this.question = question;
    }

    //returns: is a valid answer?
    public abstract QuestionResponse onQuestion(final String answer);
}
