import java.util.Arrays;

public class Mergesort {

    /**
     * Take leftArray and rightSequence, which we assume are individually sorted, and combine
     * them, sorted, into outputArray.
     */
    private static void merge(int[] outputArray, int[] leftArray, int[] rightArray) {
        System.out.println("Merging: " + Arrays.toString(leftArray) + " " + Arrays.toString(rightArray));
        int i = 0;     // Index into the left input sequence.
        int j = 0;     // Index into the right input sequence.
        int k = 0;     // Index into the output sequence.

        // While there is data in both input sequences:
        while (i < leftArray.length && j < rightArray.length) {

            // Find the smaller item and insert it into the output sequence.
            if (leftArray[i] < rightArray[j]) {
                outputArray[k] = leftArray[i];
                k++;
                i++;
            } else {
                outputArray[k] = rightArray[j];
                k++;
                j++;
            }
        }

        // We know that one of the sequences has more items to copy, and the other is empty.
        // Copy remaining input from left sequence into the output.
        while (i < leftArray.length) {
            outputArray[k] = leftArray[i];
            k++;
            i++;
        }
        // Copy remaining input from right sequence into output.
        while (j < rightArray.length) {
            outputArray[k] = rightArray[j];
            k++;
            j++;
        }
    }

    public static void mergesort(int[] array) {
        // A array with one element is sorted already.
        if (array.length > 1) {
            System.out.println("mergesort: " + Arrays.toString(array));
            // Split array into halves.
            int halfSize = array.length / 2;
            int[] leftArray = new int[halfSize];
            int[] rightArray = new int[array.length - halfSize];

            // Copy left half of array into leftArray:
            System.arraycopy(array, 0, leftArray, 0, halfSize);

            // Copy right half of array into rightArray:
            System.arraycopy(array, halfSize, rightArray, 0, array.length - halfSize);

            // Sort the halves.
            mergesort(leftArray);
            mergesort(rightArray);

            // Merge the halves.
            merge(array, leftArray, rightArray);
        }
    }

    public static void main(String[] args)
    {
        int[] array = new int[(int)(Math.random() * 30)];
        for (int x = 0; x < array.length; x++)
        {
            array[x] = (int)(Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));
        mergesort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {8,3,4,7,6,2,1,5};
        mergesort(array);
    }
}
