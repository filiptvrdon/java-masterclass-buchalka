public class NextMain {
    public static void main(String[] args) {
        /*
        Movie movie =  Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        jaws.watchMovie();

        Object comedy =  Movie.getMovie("C", "Jaws");
        Comedy comedyMovie = (Comedy) comedy;
        comedyMovie.watchComedy();

        var airplane = Movie.getMovie("C", "Airplane");
        airplane.watchMovie();

        var plane = new Comedy("Airplane");
        plane.watchComedy();
*/

        Object unknownObject = Movie.getMovie("A", "Jaws");
        if (unknownObject instanceof Adventure adventure){
            adventure.watchMovie();
        } else if (unknownObject instanceof Comedy comedia) {
            comedia.watchComedy();
        } else if (unknownObject instanceof ScienceFiction syfy){
            syfy.watchMovie();
        }

    }
}
