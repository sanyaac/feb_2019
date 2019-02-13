package lesson_3;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class HW_3 {

    public static void main(String[] args) {

        guessRandomNumber();

        guessWord();

    }


    /*
    1 Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
    попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
    указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
    выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */

    public static void guessRandomNumber() {

        boolean nextNumber = true;
        boolean correctAnswer = false;
        int randomIntNumber = 0;
        int countAttempt = 0;
        int number;
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);

        do {

            countAttempt++;

            if (countAttempt == 1) randomIntNumber = random.nextInt(10);

            System.out.print(MessageFormat.format("Введите свое число (попытка {0} из 3) : ", countAttempt));
            number = scanner.nextInt();

            if (number == randomIntNumber) {
                correctAnswer = true;
            } else if (number < randomIntNumber) {
                System.out.println(MessageFormat.format("Число {0} меньше задуманного. ", number));
            } else {
                System.out.println(MessageFormat.format("Число {0} больше задуманного. ", number));
            }

            if (correctAnswer || countAttempt == 3) {
                System.out.println((correctAnswer ? "Чистая победа!!!" : "Игра проиграна(((."));

                System.out.print("Повторить игру еще раз? 1 – да / 0 – нет : ");
                nextNumber = scanner.nextInt() == 1 ? true : false;

                countAttempt = 0;
                correctAnswer = false;
            }

        } while (nextNumber);

        System.out.println("Игра закончена.");

    }

//}

/*
    2 * Создать массив из слов
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
    "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
    "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если
    слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    apple – загаданное
    apricot - ответ игрока
    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно, можно пользоваться:
    String str = "apple";
    str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово
    Используем только маленькие буквы
 */

    public static void guessWord() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();

        //Получаем случайное слово из массива.
        String word = words[random.nextInt(words.length)];

        String userWord, strMask;

        Scanner scanner = new Scanner(System.in);

        int countChar = 0;

        do {
            System.out.print("Введите свое слово : ");
            userWord = scanner.nextLine();

            if (word.equals(userWord)) break;
            else {
                strMask = "";

                for (int i = 0; i < word.length(); i++) {
                    if (userWord.length() > i && word.charAt(i) == userWord.charAt(i))
                        strMask += word.charAt(i);
                    else
                        strMask += "#";
                }

                //Узнаем сколько надо добавить # в конец строки
                countChar = word.length() > 15 ? 0 : 15 - word.length();

                strMask += makeString("#", countChar);

                System.out.println("Совпавшие буквы : " + strMask);
            }

        } while (true);

        System.out.println("Игра закончена. S");
    }

    public static String makeString(String string, int count) {

        String str = new String();

        for (int i = 0; i < count; i++) str += string;

        return str;
    }

}

