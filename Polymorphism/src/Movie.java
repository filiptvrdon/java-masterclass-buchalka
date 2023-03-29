public class Movie {
    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    public static Movie getMovie(String type, String title){
        return switch (type.toUpperCase().charAt(0)) {
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };
    }
    public void watchMovie(){
        String instanceType = this.getClass().getSimpleName();
        System.out.println(instanceType);
        System.out.println(title + " is a "+ instanceType + " film");
    }

}

class Adventure extends Movie {

    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something Bad Happens");
    }

    public void watchAdventure(){
        System.out.println("watching an adventure");
    }
}

class Comedy extends Movie {

    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Something funny",
                "More funny stuff",
                "Happy funny ending");
    }
    public void watchComedy(){
        System.out.println("watching a comedy");
    }
}

class ScienceFiction extends Movie {

    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Bad aliens do Bad stuff",
                "Good guys chase aliens around universe",
                "Planet blows up with aliens");
    }

    public void watchScienceFiction(){
        System.out.println("watching a sci-fi thriller");
    }
}
