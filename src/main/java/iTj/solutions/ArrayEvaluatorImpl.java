package iTj.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayEvaluatorImpl implements ArrayEvaluator {
    @Override
    public int[] getMissedNumbersInArrayComparedToArrayLength(int[] numbersArray) {
        validateArray(numbersArray);
        int length = numbersArray.length;
        List<Integer> missedNumbersInArray = new ArrayList<>();

        for (int number = 1; number <= length; number++) {
            int finalNumber = number;
            if(Arrays.stream(numbersArray).noneMatch(element -> element == finalNumber)){
                missedNumbersInArray.add(number);
            }
        }

        if(missedNumbersInArray.size() == 0) {
            throw new IllegalArgumentException("There are no missed numbers from length sequence on given array");
        }

        return missedNumbersInArray.stream().mapToInt(num -> num).toArray();
    }

    @Override
    public int[] getIndexesToAddForTarget(int[] numbersArray, int target) {
        validateArray(numbersArray);
        List<Integer> indexesToSumForTarget = new ArrayList<>();

        for (int firstIndex = 0; firstIndex < numbersArray.length; firstIndex++) {
            if(indexesToSumForTarget.size() > 0){
                break;
            }
            for (int secondIndex = firstIndex + 1; secondIndex < numbersArray.length; secondIndex++) {
                if(numbersArray[firstIndex] + numbersArray[secondIndex] == target){
                    indexesToSumForTarget.add(firstIndex);
                    indexesToSumForTarget.add(secondIndex);
                    break;
                }
            }
        }

        if(indexesToSumForTarget.size() == 0) {
            throw new IllegalArgumentException(String.format("Impossible to get target: %d by summing two elements of given array: %s", target, Arrays.toString(numbersArray)));
        }
        return indexesToSumForTarget.stream().mapToInt(num -> num).toArray();
    }

    private void validateArray(int [] array){
        if (array == null || array.length < 1){
            throw new IllegalArgumentException("Given array is null or empty");
        }
    }
}
