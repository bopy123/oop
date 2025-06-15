package album;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompositionUtils {
    public static void printCompositions(List<Composition> compositions) {
        for (Composition composition : compositions) {
            System.out.println(composition.toString());
        }
    }

    public static void sortCompositionsByGenre(List<Composition> compositions) {
        Collections.sort(compositions, Comparator.comparing(Composition::getGenre));
    }

    public static List<String> filterCompositionsByDuration(List<Composition> compositions, double minDuration, double maxDuration) {
        isValidDurationRange(minDuration, maxDuration);
        List<String> result = filterCompositions(compositions, minDuration, maxDuration);

        if (result.isEmpty()) {
            result.add("No compositions found in the specified duration range.");
        }
        return result;
    }

    private static void isValidDurationRange(double minDuration, double maxDuration) {
        if (minDuration > maxDuration) {
            throw new IllegalArgumentException("minDuration cannot be greater than maxDuration");
        }
    }

    private static List<String> filterCompositions(List<Composition> compositions, double minDuration, double maxDuration) {
        List<String> result = new ArrayList<>();
        for (Composition composition : compositions) {
            if (isWithinDurationRange(composition.getDuration(), minDuration, maxDuration)) {
                result.add(composition.toString());
            }
        }
        return result;
    }

    private static boolean isWithinDurationRange(double duration, double minDuration, double maxDuration) {
        return minDuration <= duration && duration <= maxDuration;
    }
}
