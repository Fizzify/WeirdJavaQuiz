package club.premiering.jabaquiz.util;

import java.util.List;
import java.util.Random;

public class ListHelper {
    private static final Random random = new Random();

    public static <T> boolean isFirstInList(final List<T> list, final T element) {
        return list.indexOf(element) == 0;
    }

    public static <T> boolean isLastInList(final List<T> list, final T element) {
        return list.indexOf(element) == list.size() - 1;
    }

    public static <T> T getRandomElementInList(final List<T> list) {
        final int randomIndex = random.nextInt(list.size());//the paramater is the amount of numbers, starts at 0 counting up
        return list.get(randomIndex);
    }
}
