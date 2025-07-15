import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        do {
            System.out.println("*****************************************************");
            System.out.println("Enter the text from which to extract a date, please :");

            // Read the input from the user
            Scanner dealInfos = new Scanner(System.in);

            String input = dealInfos.nextLine();

            // Print the input to the console
            System.out.println("Processing the provided text: \"" + input + "\"...");

            // Call the getCleanedInput method to clean the input
            Date extractedDate = utils.DateProcessing.getMatchedDate(input);

            // Print the cleaned input to the console
            System.out.println(extractedDate != null ?
                    "The following date was matched : \033[32m\"" + extractedDate + "\"\033[0m" :
                    "\033[31mNo date was matched in the provided text.\033[0m");
        } while (true);
    }
}
