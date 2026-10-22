/**
 * Name:Carter Beasley
 * Date:10/8
 */
public class Assignment9 {

    public static void main(String[] args) {
        MovieTracker tracker = new MovieTracker();

        // Create a few movies
        Movie inception = new Movie("Inception", 148, 2010, "PG-13");
        Movie up = new Movie("Up", 96,  2009, "PG");
        Movie jaws = new Movie("Jaws", 124, 1975, "PG");
        Movie matrix = new Movie("The Matrix", 136, 1999, "R");
        Movie frozen = new Movie("Frozen", 102, 2013, "PG");

        // Add Movies to Users
        tracker.addMovie("alice", inception);
        tracker.addMovie("alice", up);
        tracker.addMovie("alice", matrix);

        tracker.addMovie("bob", jaws);
        tracker.addMovie("bob", matrix);

        tracker.addMovie("carter", matrix);
        tracker.addMovie("carter", frozen);
        tracker.addMovie("carter", matrix); // Test duplicate movie for carter

        // Check if a user has watched a movie
        System.out.println("=== hasWatched ===");
        System.out.println("alice has watched Inception: " + tracker.hasWatched("alice", inception));
        System.out.println("carter has watched The Matrix: " + tracker.hasWatched("carter", matrix));
        System.out.println("bob has watched Frozen: " + tracker.hasWatched("bob", frozen));

        // getMovies returns the set of movies for one user
        System.out.println("=== getMovies ===");
        System.out.println("alice: " + tracker.getMovies("alice"));
        System.out.println("bob: " + tracker.getMovies("bob"));
        System.out.println("carter: " + tracker.getMovies("carter"));
    }
}
