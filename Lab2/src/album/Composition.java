package album;

public class Composition {
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
