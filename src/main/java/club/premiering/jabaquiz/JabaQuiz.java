package club.premiering.jabaquiz;

import club.premiering.jabaquiz.question.AbstractQuestion;
import club.premiering.jabaquiz.question.QuestionResponse;
import club.premiering.jabaquiz.question.type.*;
import club.premiering.jabaquiz.util.ListHelper;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JabaQuiz {
    @Getter private static JabaQuiz instance;

    private final List<AbstractQuestion> questions = new ArrayList<>();

    private int score;

    public JabaQuiz() {
        instance = this;

        this.questions.add(new AllmanQuestion());
        this.questions.add(new UppercasePackageNamingQuestion());
        this.questions.add(new YouTubeTutorialQuestion());
        this.questions.add(new EclipseQuestion());
        this.questions.add(new CharQuestion());
        this.questions.add(new PrintQuestion());
        this.questions.add(new ExtraQuestion());

        System.out.println("[info!] generated questions");
        System.out.println("[info!] asking questions");

        this.askQuestions();
        this.evaluateAnswers();
    }

    private void askQuestions() {
        final Scanner scanner = new Scanner(System.in);

        for (final AbstractQuestion abstractQuestion : this.questions) {
            this.askQuestion(abstractQuestion, scanner);
        }
    }

    private void askQuestion(final AbstractQuestion abstractQuestion, final Scanner scanner) {
        System.out.println(" ");
        String prefix;
        if (ListHelper.isFirstInList(this.questions, abstractQuestion)) {
            prefix = "[first question!]";
        } else if (ListHelper.isLastInList(this.questions, abstractQuestion)) {//size - 1 is max index
            prefix = "[last question woo im almost done!]";
        } else {
            prefix = "[first question!]";
        }
        for (final String questionLine : abstractQuestion.getQuestion()) {
            System.out.println(prefix + " " + questionLine);
        }
        System.out.println("[info!] please type in your response");
        System.out.print("[answer!] Type here: ");

        final String answer = scanner.next();
        final QuestionResponse questionResponse = abstractQuestion.onQuestion(answer);

        if (!questionResponse.isValidResponse()) {
            System.out.println("[uh oh!] that is not a valid response, please try again.");
            this.askQuestion(abstractQuestion, scanner);
            return;
        }

        if (questionResponse.isGoodResponse()) {
            System.out.println("[good shit!] good response bud!");
            this.score++;
        } else {
            System.out.println("[dumb ass!] shit response + ratio lmao");
        }
    }

    private void evaluateAnswers() {
        System.out.println(" ");
        System.out.println("[your score!] " + this.score + "/" + this.questions.size());
        if (this.score == this.questions.size()) {
            System.out.println("[results!] you are a pretty good developer! you got all of the questions right!!");
        } else if (this.score > this.questions.size() / 2) {
            System.out.println("[resutls um] you are kinda there, you just do some things wrong, you'll get there bud dw dw.");
        } else if (this.score > 0) {
            System.out.println("[results yikes] you're probably still learning, and that's okay! or you were guessing and got some right");
        } else {
            System.out.println("[results bigger yikessss] you got none right, you will get there eventually though!");
        }
    }
}
