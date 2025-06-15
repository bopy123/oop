package album;

import java.util.ArrayList;
import java.util.List;

public class Album {
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
