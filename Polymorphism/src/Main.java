import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Movie theMovie = Movie.getMovie("ScienceFiction", "Star Wars");
        theMovie.watchMovie();

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Enter type (A for Adventure, C for comedy, S for Science Fiction, or Q to quit.");
            String type = scanner.nextLine();

            if ("Qq".contains(type)){
                break;
            }

            System.out.println("Enter Movie Title:");
            String title = scanner.nextLine();

            Movie movie =  Movie.getMovie(type, title);
            movie.watchMovie();

        }
    }
}