package album;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Composition {
    protected String title;
    protected double duration;
    private String genre;

    public Composition(String title, double duration) {
        this.title = title;
        this.duration = duration;
        this.genre = this.getClass().getSimpleName().replace("Composition", "");

        if (this.genre.equals("")) {
            this.genre = this.getClass().getSimpleName();
        }
    }

    public double getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title + " - " + genre + " - " + duration + " min";
    }
}

class ClassicalComposition extends Composition {
    public ClassicalComposition(String title, double duration) {
        super(title, duration);
    }
}

class RockComposition extends Composition {
    public RockComposition(String title, double duration) {
        super(title, duration);
    }
}

class PopComposition extends Composition {
    public PopComposition(String title, double duration) {
        super(title, duration);
    }
}

class CompositionUtils {
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

class Album {
    private List<Composition> compositions;

    public Album() {
        compositions = new ArrayList<Composition>();
    }

    public void addComposition(Composition composition) {
        compositions.add(composition);
    }

    public void printCompositions() {
        CompositionUtils.printCompositions(compositions);
    }

    public void sortCompositions() {
        CompositionUtils.sortCompositionsByGenre(compositions);
    }

    public List<String> getComposition(double minDuration, double maxDuration) {
        return CompositionUtils.filterCompositionsByDuration(compositions, minDuration, maxDuration);
    }
}


public class Main {
    public static void main(String[] args) {
        Album album = new Album();

        album.addComposition(new PopComposition("Billie Jean", 5));
        album.addComposition(new RockComposition("Bohemian Rhapsody", 6));
        album.addComposition(new ClassicalComposition("Fur Elise", 8));
        album.addComposition(new ClassicalComposition("Eine kleine Nachtmusik", 16));
        album.addComposition(new RockComposition("Stairway to Heaven", 8));
        album.addComposition(new ClassicalComposition("Symphony No. 5", 10));

        System.out.println("Album list: ");
        album.printCompositions();

        album.sortCompositions();
        System.out.println("Sorted album list: ");
        album.printCompositions();

        System.out.println("Composition found by duration:");
        double minDuration = 8.6;
        double maxDuration = 9.4;
        System.out.println(album.getComposition(minDuration, maxDuration));
    }
}
