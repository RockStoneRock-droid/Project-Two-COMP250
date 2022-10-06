import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PackageQueue economy_shipping = new PackageQueue();
        PackageQueue priority_shipping = new PackageQueue();
        PackageQueue overnight_shipping = new PackageQueue();
        Random rng = new Random();
        //TODO: change these to change how often each one happens.
        //TODO: Make sure they total 100 or chanceArray will have null values in it (which would crash the program if accessed).
        int economyChance = 49, priorityChance = 30, overnightChance = 20;

        //TODO: Use this later to determine which type of shipping each package has.
        String[] chanceArray = fillArray(economyChance, priorityChance, overnightChance);
        //TODO: Use this later to determine which random description is used for each new package.
        String[] descriptionsArray = readDescriptions();

        //TODO: Steps 4+5 here go here.
        for (int i = 0; i < 100; i++) {
            int chance = rng.nextInt((98 - 0) + 1) + 0;
            int weights = rng.nextInt((100 - 1) + 1) + 1;
            int desc = rng.nextInt((49 - 1) + 1) + 1;
            Package pack = new Package (descriptionsArray[desc], weights, null);
            if (chanceArray[chance].equals("economy")) economy_shipping.enqueue(pack);
            else if (chanceArray[chance].equals("priority")) priority_shipping.enqueue(pack);
            else if (chanceArray[chance].equals("overnight")) overnight_shipping.enqueue(pack);

            if (i % 10 == 0) {
                System.out.println(economy_shipping.peek());
                System.out.println(priority_shipping.peek());
                System.out.println(overnight_shipping.peek());
            }
        }

        System.out.println(economy_shipping.getSize());
        System.out.println(priority_shipping.getSize());
        System.out.println(overnight_shipping.getSize());

    }

    public static String[] fillArray(int economyChance, int priorityChance, int overnightChance) {
        //TODO: This is explained in step 2.
        String[] chanceArray = new String[100];
        int arrayPointer = 0;
        Arrays.fill(chanceArray, arrayPointer, arrayPointer + economyChance, "economy");
        arrayPointer += economyChance;
        Arrays.fill(chanceArray, arrayPointer, arrayPointer + priorityChance, "priority");
        arrayPointer += priorityChance;
        Arrays.fill(chanceArray, arrayPointer, arrayPointer + overnightChance, "overnight");

//        for(String shipMethod : chanceArray) {
//            System.out.print(shipMethod + " -> ");
//        }
//        System.out.println("end");

        return chanceArray;
    }

    public static String[] readDescriptions() {
        String[] descriptions = new String[50];

        try {
            Scanner file = new Scanner(new File("src/descriptions.txt"));
            for (int i = 0; i < 50; ++i) {
                descriptions[i] = file.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        }

        return descriptions;
    }
}