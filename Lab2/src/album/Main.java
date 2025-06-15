package album;

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
