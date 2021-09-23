import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle1 {
    private final File entries = new File("resources/day1");

    public int twoEntries() {
        try {
            Scanner scanner = new Scanner(entries);

            while(scanner.hasNextInt()) {
                int current = scanner.nextInt();

                Scanner scanner2 = new Scanner(entries);

                while(scanner2.hasNextInt()) {
                    int test = scanner2.nextInt();

                    if(current + test == 2020)
                        return current * test;
                }
            }

            return 1;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return 0;
    }

    public int threeEntries() {
        try {
            Scanner scanner = new Scanner(entries);

            while(scanner.hasNextInt()) {
                int current = scanner.nextInt();

                Scanner scanner2 = new Scanner(entries);

                while(scanner2.hasNextInt()) {
                    int test = scanner2.nextInt();

                    if(current + test < 2020) {
                        Scanner scanner3 = new Scanner(entries);

                        while(scanner3.hasNextInt()) {
                            int test2 = scanner3.nextInt();

                            if(current + test + test2 == 2020)
                                return current * test * test2;
                        }
                    }
                }
            }

            return 1;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return 0;
    }
}
