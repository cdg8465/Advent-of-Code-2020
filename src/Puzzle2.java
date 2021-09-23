import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle2 {
    private final File entries = new File("resources/day2");

    public int numOfValidPasswords() {
        int count = 0;

        try {
            Scanner scanner = new Scanner(entries);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Get full line of arguments
                String[] args = line.split(" ");

                // Get min and max
                String[] minAndMax = args[0].split("-");
                int min = Integer.parseInt(minAndMax[0]);
                int max = Integer.parseInt(minAndMax[1]);

                // Get letter
                String letter = args[1].substring(0, 1);

                // Get password
                String password = args[2];

                if(checkPassword(password, letter, min, max))
                    count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return count;
    }

    private boolean checkPassword(String password, String letter, int min, int max) {
        int count = 0;

        for(int i = 0; i < password.length(); i++)
            if(("" + password.charAt(i)).equals(letter))
                count++;

        return count >= min && count <= max;
    }
}
