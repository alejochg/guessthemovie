

public class Game {
    /**
     * Class representation of a "Guess the movie" game. A random movie title is selected from a text file and
     * the user has to guess it. The rules are:
     *      1. Only a letter can be guessed at a time.
     *      2. The user starts with 10 points and loses one for each incorrect guess. The game ends
     *          when there are no points left.
     */

    // String that contains the title to be guessed
    private String movieToGuess;
    private int attempts;
    private String wrongLetters;
    private String correctLetters;
    private boolean hasWon;


    /**
     * Class constructor that initializes a MovieList object from a text file and all other attributes nof the game:
     *      attempts = number of attempts remaining;
     *      wrongLetters = letters guessed that are not in the movie title;
     *      correctLetters = letters guessed that are in the movie title;
     *      hasWon = whether the player has already won the game.
     *
     * @param pathname          Path to file containing the movies' titles.
     */
    public Game(String pathname) {
        MovieList movies = new MovieList(pathname);
        movieToGuess = movies.getRandomMovie();
        attempts = 10;
        wrongLetters = "";
        correctLetters = "";
        hasWon = false;
    }

    /**
     * Method that returns the title of the movie to be guessed.
     *
     * @return title of the movie to be guessed.
     */
    public String getMovieTitle() {
        return movieToGuess;
    }

    /**
     * Method that replaces the letters in the title with underscores if no letter has been guessed,
     * and a string that contains underscores and guessed letters otherwise.
     *
     * @return String that contains the hidden title, and the letters that have been guessed revealed.
     */
    public String getHiddenTitle() {
        if(correctLetters.equals("")) {
            return movieToGuess.replaceAll("[a-zA-Z]", "_");
        } else {
            return movieToGuess.replaceAll("[a-zA-Z&&[^" + correctLetters +"]]","_");
        }
    }
}
