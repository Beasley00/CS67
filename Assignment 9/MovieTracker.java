import java.util.HashMap;
import java.util.HashSet;

/**
 * Name:Carter Beasley
 * Date:10/8
 */

public class MovieTracker {

    private HashMap<String, HashSet<Movie>> watchedMovies;  // userName -> movies watched

    /**
     * Constructs a new, empty MovieTracker.
     */
    public MovieTracker() {
        watchedMovies = new HashMap<String, HashSet<Movie>>();
    }

    /**
     * addMovie records that the given user has watched the given movie.
     * If the user is new, an empty set is created for them first.
     */
    public void addMovie(String userName, Movie movie) 
    {
        if (!watchedMovies.containsKey(userName)) 
        {
            watchedMovies.put(userName, new HashSet<Movie>());
        }
        watchedMovies.get(userName).add(movie);
    }

    /**
     * getMovies returns the set of movies the given user has watched.
     */
    public HashSet<Movie> getMovies(String userName) 
    {
        return watchedMovies.get(userName);
    }
    /**
     * hasWatched checks whether the given user has watched the given movie.
     */
    public boolean hasWatched(String userName, Movie movie)
    {
        if(watchedMovies.containsKey(userName) && watchedMovies.get(userName).contains(movie))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

}
