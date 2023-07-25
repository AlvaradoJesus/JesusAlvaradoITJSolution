package iTj.solutions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertArrayEquals;

@RunWith(MockitoJUnitRunner.class)
public class ArrayEvaluatorImplTest {
    @InjectMocks
    private ArrayEvaluatorImpl arrayEvaluator;

    @Test
    public void getMissedNumbersInArrayComparedToArrayLength_ShouldReturnAnArrayOfNumbersFromLengthSequence_MissedOnArrayParameter(){
        // setup
        int [] arrayToEvaluate = new int[] {13, 15, 15, 11, 9, 1, 5, 2};
        int [] expectedArray = new int[] {3, 4, 6, 7, 8};
        // execute
        int [] result = arrayEvaluator.getMissedNumbersInArrayComparedToArrayLength(arrayToEvaluate);
        // assert
        assertArrayEquals(expectedArray, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMissedNumbersInArrayComparedToArrayLength_ShouldThrowAnIllegalArgumentException_WhenArrayContainsAllNumbersOnLength(){
        // setup
        int [] arrayToEvaluate = new int[] {1,2,3,4};
        // execute
        arrayEvaluator.getMissedNumbersInArrayComparedToArrayLength(arrayToEvaluate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMissedNumbersInArrayComparedToArrayLength_ShouldThrowAnIllegalArgumentException_WhenArrayIsEmpty(){
        // setup
        int [] arrayToEvaluate = new int[0];
        // execute
        arrayEvaluator.getMissedNumbersInArrayComparedToArrayLength(arrayToEvaluate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMissedNumbersInArrayComparedToArrayLength_ShouldThrowAnIllegalArgumentException_WhenArrayIsNull(){
        // execute
        arrayEvaluator.getMissedNumbersInArrayComparedToArrayLength(null);
    }

    @Test
    public void getIndexesToAddForTarget_ShouldReturnAnArrayOfTwoIndexesOnArray_ThatAreEqualsToTarget_WhenTheyAreAdded(){
        // setup
        int [] arrayToEvaluate = new int[] {7,9,15,6};
        int [] expectedArray = new int[] {1,2};
        // execute
        int [] result = arrayEvaluator.getIndexesToAddForTarget(arrayToEvaluate, 24);
        // assert
        assertArrayEquals(expectedArray, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIndexesToAddForTarget_ShouldThrowAnIllegalArgumentException_WhenIsNotPossibleToGetTheTarget(){
        // setup
        int [] arrayToEvaluate = new int[] {7,9,15,6};
        // execute
        arrayEvaluator.getIndexesToAddForTarget(arrayToEvaluate, 300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIndexesToAddForTarget_ShouldThrowAnIllegalArgumentException_WhenIsTheOnlyWayToGetTargetIsToSumSameValueTwice(){
        // setup
        int [] arrayToEvaluate = new int[] {7,5,15,6};
        // execute
        arrayEvaluator.getIndexesToAddForTarget(arrayToEvaluate, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIndexesToAddForTarget_ShouldThrowAnIllegalArgumentException_WhenGivenArrayIsEmpty(){
        // setup
        int [] arrayToEvaluate = new int[0];
        // execute
        arrayEvaluator.getIndexesToAddForTarget(arrayToEvaluate, 300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getIndexesToAddForTarget_ShouldThrowAnIllegalArgumentException_WhenGivenArrayIsNull(){
        // execute
        arrayEvaluator.getIndexesToAddForTarget(null, 300);
    }
}
