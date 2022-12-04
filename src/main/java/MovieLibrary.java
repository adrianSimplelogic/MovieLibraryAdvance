import java.util.List;

public class MovieLibrary {

    private List<Movie> movies;

    public MovieLibrary() {
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    //moje bazgroły
    //treśc zadania https://github.com/mtadla-simplelogic/MovieLibraryAdvanced

    public void getMoviesFromTo(int s, int e) {
        for (Movie movies : movies) {
            if (movies.getYear() >= s && movies.getYear() <= e) {
                System.out.println(movies.getTitle() + "(" + movies.getYear() + ")");
                System.out.println("========================================");
            }
        }
    }

    public void getRandomMovie() {
        int randomIndex = (int) (Math.random() * movies.size());
        System.out.println(movies.get(randomIndex).toString());
        System.out.println("========================================");
    }

    public void findMovies(String fn, String ln) {
        for (Movie movie : movies) {
            if (movie.getActors().toString().contains(fn) && movie.getActors().toString().contains(ln)) {
                System.out.println(movie);
                System.out.println("========================================");
            }
        }
        System.out.println("Koniec wyników");
    }
}
