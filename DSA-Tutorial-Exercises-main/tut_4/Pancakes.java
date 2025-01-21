package tut_4;

import java.util.Arrays;

public class Pancakes {

    public static void main(String[] args) {
        int[] pancakes = { 1, 7, 4, 6, 2, 8, 3, 5 };
        int[] result = new int[pancakes.length];
        System.out.println(Arrays.toString(spatulaFlip(1, pancakes)));
        //sortPancakes(pancakes);
        //System.out.println(Arrays.toString(pancakes)); // Expected sorted output
    }

    //public static int[] sortPancakes(int[] pancakes) {
        
    //}
    


    private static int[] spatulaFlip(int pos, int[] pancakes) {
        int[] result = new int[pancakes.length];

        for(int j=0; j<pancakes.length; j++) {
            result[j] = pancakes[j];
        }

        int m = pos;

        for(int i = pancakes.length-1; i >= pos; i--) {
            result[m] = pancakes[i];
            m = m + 1;
        }

        return result;
    }

}
