package club.premiering.jabaquiz;

import club.premiering.jabaquiz.question.AbstractQuestion;
import club.premiering.jabaquiz.question.QuestionResponse;
import club.premiering.jabaquiz.question.type.AllmanQuestion;
import club.premiering.jabaquiz.question.type.UppercasePackageNamingQuestion;
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
        final int indexOfQuestion = this.questions.indexOf(abstractQuestion);
        String prefix;
        if (indexOfQuestion == 0) {
            prefix = "[first question!]";
        } else if (indexOfQuestion == this.questions.size() - 1) {//size - 1 is max index
            prefix = "[last question woo im almost done!]";
        } else {
            prefix = "[first question!]";
        }
        System.out.println(prefix + " " + abstractQuestion.getQuestion());
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
            this.score--;
        }
    }

    private void evaluateAnswers() {
        if (this.score == this.questions.size()) {
            System.out.println("[results!] you are a pretty good developer! you follow all of the java coding style guidelines!");
        } else if (this.score > 0) {
            System.out.println("[resutls um] you are about there, you just do some things wrong, you'll get there bud dw dw.");
        } else if (this.score == 0) {
            System.out.println("[results yikes] you're probably still learning, and that's okay!");
        } else {
            System.out.println("[sit down lmao, here are ur results] you probably dont code java, or you skid all day all night.");
        }
    }
}
