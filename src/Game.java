import java.util.Scanner;

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
    private Scanner letterScanner = new Scanner(System.in);


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
     * Method that returns the string that contains the wrong guesses.
     *
     * @return string that contains the wrong guesses.
     */
    public String getWrongLetters(){
        return wrongLetters;
    }

    /**
     * Method that returns the string that contains the correct guesses.
     *
     * @return string that contains the correct guesses.
     */
    public String getCorrectLetters(){
        return correctLetters;
    }

    /**
     * Method that returns true if the game was won and false otherwise.
     *
     * @return true if the game was won and false otherwise.
     */
    public boolean gameWon() {
        return hasWon;
    }

    /**
     * Method that replaces the letters in the title with underscores if no letter has been guessed,
     * and a string that contains underscores and guessed letters otherwise.
     *
     * @return String that contains the hidden title, and reveals the letters that have been guessed.
     */
    public String getHiddenTitle() {
        if(correctLetters.equals("")) {
            return movieToGuess.replaceAll("[a-zA-Z]", "_");
        } else {
            return movieToGuess.replaceAll("[a-zA-Z&&[^" + correctLetters +"]]","_");
        }
    }

    /**
     * Method that asks the user for a letter and validates it. If the input is not a letter, throws an error
     * message. Else, if the letter has already been guessed, throws an error message indicating that. If the
     * input is valid, it returns it as a string.
     *
     * @return String that contains a validated input.
     */
    private String getUserInput() {
        System.out.print("Guess a letter: ");
        String letter = letterScanner.nextLine().toLowerCase();

        if(!letter.matches("[a-z]")) {
            System.out.println("That's not a letter!");
            return getUserInput();
        }
        else if (wrongLetters.contains(letter) || correctLetters.contains(letter)){
            System.out.println("You already guessed that letter!");
            return getUserInput();
        } else {
            return letter;
        }
    }

    /**
     * Method that verifies if the game has ended. It doesn't determine if it was won or lost.
     *
     * @return Boolean that determines that the game ended
     */
    public boolean gameEnded() {
        if(attempts <= 0) {
            return true;
        }
        if(!getHiddenTitle().contains("_")){
            hasWon = true;
            return true;
        }
        return false;
    }
    /**
     * Method that classifies a validated guess from getUserInput() into correctLetters or wrongLetters.
     */
    public void turn() {
        String guess = getUserInput();

        if(movieToGuess.toLowerCase().contains(guess)) {
            correctLetters += guess + guess.toUpperCase();
            System.out.println("Great! The title so far is: " + this.getHiddenTitle());
        } else {
            wrongLetters += " " + guess;
            System.out.println("Oops! Wrong guess! These are all the wrong guesses so far: " +
                                this.getWrongLetters());
            attempts--;
            System.out.println("Points left = " + attempts);
        }
    }
}
