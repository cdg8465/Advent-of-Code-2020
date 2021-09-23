import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle2 {
    private final File entries = new File("resources/day2");

    public int numOfValidPasswords() {
        int count = 0;

        try {
            Scanner scanner = new Scanner(entries);

            while(scanner.hasNextLine())
                if(checkPassword(parseArgs(scanner.nextLine())))
                    count++;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return count;
    }

    private String[] parseArgs(String line) {
        // Get full line of arguments
        String[] args = line.split(" ");

        // Get hyphenated numbers
        String[] hyphenated = args[0].split("-");

        return new String[]{args[2], args[1].substring(0, 1), hyphenated[0], hyphenated[1]};
    }

    public int numOfValidPasswordsNewRules() {
        int count = 0;

        try {
            Scanner scanner = new Scanner(entries);

            while(scanner.hasNextLine())
                if(checkPassword2(parseArgs(scanner.nextLine())))
                    count++;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return count;
    }

    private boolean checkPassword(String[] args) {
        int count = 0;

        for(int i = 0; i < args[0].length(); i++)
            if(("" + args[0].charAt(i)).equals(args[1]))
                count++;

        return count >= Integer.parseInt(args[2]) && count <= Integer.parseInt(args[3]);
    }

    private boolean checkPassword2(String[] args) {
        if(("" + args[0].charAt(Integer.parseInt(args[2]) - 1)).equals(args[1]) && !("" + args[0].charAt(Integer.parseInt(args[3]) - 1)).equals(args[1]))
            return true;
        else return ("" + args[0].charAt(Integer.parseInt(args[3]) - 1)).equals(args[1]) && !("" + args[0].charAt(Integer.parseInt(args[2]) - 1)).equals(args[1]);
    }
}
