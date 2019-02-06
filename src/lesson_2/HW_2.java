package lesson_2;

import java.util.Arrays;

public class HW_2 {

    public static void main(String[] args) {

        /*
        1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */
        int[] intArr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < intArr1.length; i++) {
            switch (intArr1[i]) {
                case 0:
                    intArr1[i] = 1;
                    break;
                case 1:
                    intArr1[i] = 0;
                    break;
            }
        }
        System.out.println("Задание 1: " + Arrays.toString(intArr1));


        /*
        2 Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
         значениями 0 3 6 9 12 15 18 21;
         */
        int[] intArr2 = new int[8];
        for (int i = 0; i < intArr2.length; i++) {
            intArr2[i] = i * 3;
        }
        System.out.println("Задание 2: " + Arrays.toString(intArr2));


        /*
        3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
        умножить на 2;
         */
        int[] intArr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < intArr3.length; i++) {
            if (intArr3[i] < 6) intArr3[i] = intArr3[i] * 2;
        }
        System.out.println("Задание 3: " + Arrays.toString(intArr3));


        /*
        4 Создать квадратный двумерный целочисленный массив (количество строк и столбцов
        одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         */
        int[][] intArr4 = new int[4][4];
        for (int i = 0; i < intArr4.length; i++) {
            for (int j = 0; j < intArr4[i].length; j++) {
                if (i == j) intArr4[i][j] = 1;
            }
        }
        System.out.println("Задание 4: " + Arrays.deepToString(intArr4));


        /*
        5 ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без
        помощи интернета);
         */
        int[] intArr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, -1};

        int min = intArr5[0];
        int max = intArr5[0];

        for (int i = 1; i < intArr5.length; i++) {

            if (intArr5[i] > max) max = intArr5[i];

            if (intArr5[i] < min) min = intArr5[i];
        }
        System.out.println("Задание 5: min = " + min + " max = " + max);


        //Задание 6
        int[] intArr6 = {10,20, 30, 30,30};
        System.out.println("Задание 6: = " + checkBalance(intArr6));


        //Задание 7
        String[] arr7 = {"10", "20", "30", "40", "50"};
        shiftArr(arr7, -8);
        System.out.println("Задание 7: " + Arrays.toString(arr7));


    }


    /*
     6 **  Написать метод, в который передается не пустой одномерный целочисленный массив,
     метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части
     массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) →
     false, checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не
     входят.
     */
    public static boolean checkBalance(int[] arr) {

        int sumLeftPart, sumRightPart;

        sumLeftPart = 0;

        for (int i = 0; i < arr.length; i++) {

            sumLeftPart = sumLeftPart + arr[i];

            sumRightPart = 0;

            for (int j = i + 1; j < arr.length; j++) {
                sumRightPart = sumRightPart + arr[j];
            }

            if (sumLeftPart == sumRightPart) return true;
        }

        return false;
    }


    /*
    7 **** Написать метод, которому на вход подаётся одномерный массив и число n (может быть
     положительным, или отрицательным), при этом метод должен сместить все элементы
     массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    public static void shiftArr(String[] arr, int n) {

        int shift = n % arr.length;

        if (n < 0) shift = arr.length + shift;

        for (int i = 0; i < shift; i++) {

            String buffer = arr[0];
            arr[0] = arr[arr.length - 1];

            for (int j = 1; j < arr.length - 1; j++) {
                arr[arr.length - j] = arr[arr.length - j - 1];
            }

            arr[1] = buffer;
        }

        return;
    }

}
