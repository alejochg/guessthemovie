public class Main {
    public static void main(String args[]) {
        Game game = new Game("movies.txt");

        System.out.println("Welcome to \"Guess the movie!\"");
        System.out.println("The rules are simple: We have hidden a movie title.");
        System.out.println("Try to guess the title one letter at a time. If the letter is correct,");
        System.out.println("we'll reveal it. If it is not, you'll lose a point.");
        System.out.println("Try to guess the title before you lose 10 points.");

        while(!game.gameEnded()) {
            game.turn();
        }

        if(game.gameWon()) {
            System.out.println("Congratulations! You win!");
            System.out.println("The title is " + game.getMovieTitle());
        } else {
            System.out.println("You've lost! Better luck next time.");
            System.out.println("The hidden title was \"" + game.getMovieTitle() + "\"");
        }
    }
}
