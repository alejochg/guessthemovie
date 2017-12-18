import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessTheMovie {

    public static void main(String [] args) throws Exception {
        //Declare scanner for user input
        Scanner userInput = new Scanner(System.in);
        //Declare variable for number of points
        int points = 10;
        //Declare variable that determines if user has won
        boolean hasWon = false;
        //  Randomly select a title
        String title = getRandomTitle();
        String hiddenTitle = setupTitle(title);

        //WHILE there are attempts left AND user hasn't won:
        while(points > 0 && !hasWon) {

        }
        //  Scan user input
        //      Compare user input with title
        //      IF user input matches some letters
        //          Reveal letters
        //      ELSE user input doesn't match at all
        //          Decrease points
        //          Store letter in array
        //          Display letters for the user
        //  IF user has won
        //      Exit loop AND Set boolean to true
        //IF loop is over and boolean is true
        //  Display winning message
        //ELSE
        //  Display losing message

    }

    public static String setupTitle(String title) throws Exception{
        int wordLength = title.length();
        //Create a string that has same number of underscores as letters
        //in hidden title
        String underscoreGuess = "";
        for(int i = 0; i <wordLength; i++) {
            if(title.charAt(i) == ' ') {
                underscoreGuess = underscoreGuess + " ";
            } else {
                underscoreGuess = underscoreGuess + "_";
            }
        }
        return underscoreGuess;
    }
    public static String getRandomTitle() throws Exception {
        // Create the string variable that will be returned
        String title;
        // Initialize file with movie titles
        File file = new File("testingfile.txt");
        // Create a scanner for the file
        Scanner fileScanner = new Scanner(file);
        // Create an array of strings to store the movie titles
        List<String> movieTitles = new ArrayList<>();
        // Read file and populate the movie titles array
        while(fileScanner.hasNextLine()) {
            movieTitles.add(fileScanner.nextLine());
        }
        // Get size of the array
        int arrSize = movieTitles.size();
        // Generate a random number from 0 to arrSize
        int randomIndex = (int) (Math.random() * arrSize);
        // Get the title and return it
        title = movieTitles.get(randomIndex);
        return title;
    }
}
