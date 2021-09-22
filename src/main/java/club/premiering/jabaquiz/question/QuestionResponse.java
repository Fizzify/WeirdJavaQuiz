package club.premiering.jabaquiz.question;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class QuestionResponse {
    //is this a valid response? or did they just type in some random shit
    @Getter private final boolean validResponse;
    //are they right, or are they wrong and bad developer !!!!111!!!11!!!1!!?11klofdgdfgidfjg
    @Getter private final boolean goodResponse;

    public QuestionResponse(final boolean validResponse, final boolean goodResponse) {
        this.validResponse = validResponse;
        this.goodResponse = goodResponse;
    }

    public QuestionResponse(final boolean validResponse) {
        this.validResponse = validResponse;
        this.goodResponse = false;
    }
}
