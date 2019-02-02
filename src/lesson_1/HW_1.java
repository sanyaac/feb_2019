package lesson_1;

import java.util.*;
import java.text.SimpleDateFormat;

public class HW_1 {

    byte vByte = 21;
    short vShort = 100;
    int vInt = 879;
    long vLong = 23244;

    float vFloat = 2.34F;
    double vDouble = 2134.5343;

    boolean vBool = true;

    String vStr = "ДСА 2019";

    char vChar = 's';

    public static void main(String[] args) {

        System.out.println("a * (b + (c / d)) = " + calculate(4, 5, 4, 2));

        System.out.println("a + b в диапазоне от 10 до 20  -> " + test(3, 16));

        positive_number(0);

        System.out.println("Число отрицатеьное ?  -> " + negative_number(-5));

        hello("Санёк");

        System.out.println("Доказано " + proof(true, false));

        //9. Переменные a и b типа int. Упростите выражение (!(a < b) && !(a > b)).
        boolean a = true;
        boolean b = false;
        System.out.println("(!(a < b) && !(a > b)) = " + (a == b ? true : false));

        System.out.println("Проверка делимости: " + test2(4.5F, 1.5F));

        System.out.println("Проверка, что число больще двух других: " + test3(4.5F, 1.5F, 7));

        leapYear(2016);

        random(10, 20);

        sumRandom();

        calculate2(3.14F);

        System.out.println("Дата входит в промежуток: " + test4(6,20));

        rgbToCMYK(255, 250, 255);

        test5(5, 5, 5);

        System.out.println("Переменные x и y принадлежат [0; 1]:  " + test6(0.5464, 0.9999993453));

    }

    /*
        3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        где a, b, c, d – входные параметры этого метода;
     */
    public static float calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    /*
        4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
        от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    */
    public static boolean test(float a, float b) {
        return a + b >= 10 && a + b <= 20 ? true : false;
    }

    /*
        5. Написать метод, которому в качестве параметра передается целое число, метод должен
        напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль
        считаем положительным числом.
     */
    public static void positive_number(int a) {
        System.out.println("Число " + a + " " + (a >= 0 ? "положительное" : "отрицательное"));
    }

    /*
        6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть
        true, если число отрицательное;
     */
    public static boolean negative_number(int a) {
        return a >= 0 ? false : true;
    }

    /*
        7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод
        должен вывести в консоль сообщение «Привет, указанное_имя!»;
     */
    public static void hello(String vName) {
        System.out.println("Привет, " + vName + "!");
    }

    /*
        8. a и b - переменные типа boolean. Напишите метод, который доказывает, выражение true.
        выражение (!(a && b) && (a || b)) || ((a && b) || !(a || b))
     */
    public static boolean proof(boolean a, boolean b) {
        return (!(a && b) && (a || b)) || ((a && b) || !(a || b)) ? true : false;
    }

    /*
        10. Напишите метод, который получает на вход два положительных числа и выводит true,
         если одно из них нацело делится на другое.
     */
    public static boolean test2(float a, float b) {

        // Откидываю отрицательные число и ноль ( на ноль делить нельзя)
        //Вот насчет нуля сомневаюсь 0 длить на любое число будет 0 т.е. без остатка
        if (a <= 0 || b <= 0) return false;

        if (a % b == 0) return true;

        if (b % a == 0) return true;

        return false;
    }

    /*
        11. Напишите метод, котрый получает на вход 3 положительных числа и проверяет
        что одно из них больше суммы других двух. (Применяется для проверки, могут ли числа быть сторонами треугольника)
     */
    public static boolean test3(float a, float b, float c) {

        if (a < 0 || b < 0 || c < 0) return false;

        if (a + b < c) return true;

        if (a + c < b) return true;

        if (c + b < a) return true;

        return false;
    }

    /*
        12. Написать метод, который определяет является ли год високосным, и выводит сообщение в
        консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й –
        високосный.
     */
    public static void leapYear(int vYear) {

        if (vYear % 4 == 0 && (!(vYear % 100 == 0) || (vYear % 400 == 0))) {
            System.out.println(vYear + " год - високосный");
        } else {
            System.out.println(vYear + " год - невисокосный");
        }
    }

    /*
        13. Напишите метод, который получает на вход два целых числа и выводит случайное число в этом диапазоне.
     */
    public static void random(int a, int b) {

        float vRandNumber;

        if (a > b) {
            vRandNumber = (float) (b + Math.random() * (a - b));
        } else {
            vRandNumber = (float) (a + Math.random() * (b - a));
        }

        System.out.println("Рандомное число в диапазоне от " + a + " до " + b + " : " + vRandNumber);

    }

    /*
        14. Напишите метод, который выводит сумму двух случайных чисел от 1 до 6. (имитация броска кубиков)
     */
    public static void sumRandom() {

        int vRandNumberSum;

        //Т.к. имитация броска кубиков , то числп от 1 до 6 целые
        vRandNumberSum = (int) (Math.round(1 + 5 * Math.random()) + Math.round(1 + 5 * Math.random()));

        System.out.println("Сумма двух кубиков = " + vRandNumberSum);

    }

    /*
        15. Напишите метод, который получает на вход число t и выводит в консоль результат выражения sin(2t) + sin(3t)
     */
    public static void calculate2(float t) {

        System.out.println("sin(2t) + sin(3t) = " + (Math.sin(2 * t) + Math.sin(3 * t)));

    }

    /*
        16. Напишите метод, который получает на вход целочисленные m и d и проверяет, что введённые m-месяц и d-день,
        лежат в промежутке от 20.03 до 20.06.
     */
    public static boolean test4(int m, int d) {

        String vDate1 = "19.03.2019";//Я посчитал, что в промежутке, это значит что и даты ограничений тоже входят
        String vDate2 = "21.06.2019";//Я посчитал, что в промежутке, это значит что и даты ограничений тоже входят

        String vDate0 = "" + Math.abs(d) + "." + Math.abs(m) + ".2019";

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");


        Date vDateOne = null;
        Date vDateTwo = null;
        Date vDateZero = null;

        try {
            vDateOne = format.parse(vDate1);
            vDateTwo = format.parse(vDate2);
            vDateZero = format.parse(vDate0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        if (vDateZero.after(vDateOne) && vDateZero.before(vDateTwo)) return true;

        return false;
    }

    /*
        17. Напишите метод, который на вход получает информацию о цвете в формате RGB и
        переводит ии в формат CMYK. Результат вывести в консоль.
     */
    public static void rgbToCMYK(int r, int g, int b) {
        double vC, vM, vY, vK, minCMY;

        if (r < 0 && r > 255 && g < 0 & g > 255 && b < 0 & b > 255) {
            System.out.println("некорректно задан RGB");
        }

        if (r == 0 && g == 0 && b == 0) {
            vC = 0;
            vM = 0;
            vY = 0;
            vK = 1;
        } else {
            vC = 1.0 - ((double) r / 255.0);
            vM = 1.0 - ((double) g / 255.0);
            vY = 1.0 - ((double) b / 255.0);
            minCMY = Math.min(Math.min(vC, vM), vY);

            vC = (vC - minCMY) / (1 - minCMY);
            vM = (vM - minCMY) / (1 - minCMY);
            vY = (vY - minCMY) / (1 - minCMY);
            vK = minCMY;

            System.out.println("C : " + vC);
            System.out.println("M : " + vM);
            System.out.println("Y : " + vY);
            System.out.println("K : " + vK);

        }
    }

    /*
       18. Напишите метод, который получает на вход 3 целых числа, сравнивает их, и выводит
       в консоль "Все три числа равны" или "не равны".
    */
    public static void test5(int a, int b, int c) {
        System.out.println(a == b && b == c ? "Все три числа равны" : "не равны");
    }

    /*
        19. Напишите метод, который проверяет, что переменные x и y типа double лежат строго в пределах от 0 до 1
     */
    public static boolean test6(double x, double y) {
        return ((x >= 0 && x <= 1) && (y >= 0 && y <= 1)) ? true : false;
    }


}
