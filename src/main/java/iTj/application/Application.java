package iTj.application;

import com.google.inject.Inject;
import iTj.solutions.ArrayEvaluator;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Application {

    @Inject
    private ArrayEvaluator arrayEvaluator;

    private static final Random random = new Random();
    private final Scanner input = new Scanner(System.in);

    public void startApplication () {
        while (true) {
            System.out.println("Welcome select an option (enter just the number and press enter): \n" +
                    "1) solution for 'get missed number from length sequence in array' \n" +
                    "2) solution for 'get indexes of numbers in array that summed are the given target' \n" +
                    "3) exit");
            try {
                switch (getInput()) {
                    case 1:
                        printResult(arrayEvaluator.getMissedNumbersInArrayComparedToArrayLength(generateRandomArray()));
                        break;
                    case 2:
                        printResult(arrayEvaluator.getIndexesToAddForTarget(generateRandomArray(), generateRandomTarget()));
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("[ERROR] please select a valid input\n");
                        break;

                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage() + "\n");
            }
        }
    }

    private static int[] generateRandomArray() {
        int randomLength = random.nextInt(6) + 5;
        int [] arrayResult = new int[randomLength];
        for (int i = 0; i < randomLength ; i++) {
            arrayResult[i] = random.nextInt(15) + 1;
        }
        System.out.println(String.format("Working with random array: %s", Arrays.toString(arrayResult)));
        return arrayResult;
    }

    private int generateRandomTarget() {
        int target = random.nextInt(20) + 1;
        System.out.println(String.format("Working with random target: %s", target));
        return target;
    }

    private int getInput(){
        int option = 0;
        if(input.hasNextInt()) {
            option = input.nextInt();
        }
        input.nextLine();
        return option;
    }

    private void printResult(int [] arrayResult){
        System.out.println(String.format("Array result to solve solution: %s \n", Arrays.toString(arrayResult)));
    }
}
