package ru.gb.pugacheva.lesson6j3tests;

import java.util.Arrays;

public class ArraysChecking {

//    public static void main(String[] args) {
//        int[] arr = {4, 4, 4, 1};
//        System.out.println(Arrays.toString(arrayAfterFour(arr)));
//
//        System.out.println(findFourAndOneInArray(arr));
//    }

    public static int[] arrayAfterFour(int[] array) {
        int[] createdArray;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                createdArray = Arrays.copyOfRange(array, i + 1, array.length);
                return createdArray;
            }
        }
        throw new RuntimeException("В заданном массиве должна быть хотя бы одна четверка");
    }

    public static boolean findFourAndOneInArray(int[] array) {
        int countOne = 0;
        int countFour = 0;
        for (int n : array) {
            if (n == 1) {
                countOne++;
            } else if (n == 4) {
                countFour++;
            }
            if (n != 1 && n != 4 || countOne == array.length || countFour == array.length) {
                return false;
            }
        }
        return true;
    }

}



