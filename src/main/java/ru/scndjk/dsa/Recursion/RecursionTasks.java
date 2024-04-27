package ru.scndjk.dsa.Recursion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecursionTasks {
    /**
     * 1. Возведение числа N в степень M
     */
    public static long power(int base, int power) {
        if (power == 1) {
            return base;
        }

        return base * power(base, power - 1);
    }

    /**
     * 2. Вычисление суммы цифр числа
     */
    public static long sumDigits(int number) {
        if (number == 0) {
            return 0;
        }

        return (number % 10) + sumDigits(number / 10);
    }

    /**
     * 3. Расчёт длины списка, для которого разрешена только операция удаления первого элемента pop(0)
     * (и получение длины конечно)
     */
    public static <T> int lengthOfList(List<T> list) {
        if (list.isEmpty()) {
            return 0;
        }

        list.remove(0);
        return 1 + lengthOfList(list);
    }

    /**
     * 4. Проверка, является ли строка палиндромом
     */
    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        final char first = str.charAt(0);
        final char last = str.charAt(str.length() - 1);

        if (first != last) {
            return false;
        }

        return isPalindrome(str.substring(1, str.length() - 1));
    }

    /**
     * 5. Печать только чётных значений из списка
     */
    public static void printEvenNumbers(List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }

        if (list.get(0) % 2 == 0) {
            System.out.println(list.get(0));
        }

        printEvenNumbers(list.subList(1, list.size()));
    }

    /**
     * 6. Печать элементов списка с чётными индексами
     */
    public static void printEvenIndexesElements(List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }

        if (list.size() % 2 == 0) {
            System.out.println(list.get(0));
        }

        printEvenIndexesElements(list.subList(1, list.size()));
    }

    /**
     * 7. Нахождение второго максимального числа в списке
     * (с учётом, что максимальных может быть несколько, если они равны)
     */
    public static Integer secondMax(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }

        if (list.size() == 1) {
            return list.get(0);
        }

        int max = Math.max(list.get(0), list.get(1));
        int secondMax = Math.min(list.get(0), list.get(1));

        return secondMax(list, 2, max, secondMax);
    }

    private static Integer secondMax(List<Integer> list, int index, int max, int secondMax) {
        if (index == list.size()) {
            return secondMax;
        }

        int currentNumber = list.get(index);

        if (currentNumber > max) {
            return secondMax(list, index + 1, currentNumber, max);
        }

        if (currentNumber > secondMax) {
            return secondMax(list, index + 1, max, currentNumber);
        }

        return secondMax(list, index + 1, max, secondMax);
    }

    /**
     * 8. Поиск всех файлов в заданном каталоге, включая файлы, расположенные в подкаталогах произвольной вложенности
     */
    public static List<String> findFiles(String path) throws IOException {
        List<String> files = new ArrayList<>();
        File dir = new File(path);

        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isDirectory()) {
                files.addAll(findFiles(file.getAbsolutePath()));
            } else {
                files.add(file.getAbsolutePath());
            }
        }

        return files;
    }

    /**
     * 9*. Генерация всех корректных сбалансированных комбинаций круглых скобок (параметр -- количество открывающих скобок)
     */
    public static List<String> generateParentheses(int n) {
        List<String> parentheses = new ArrayList<>();
        recursiveGenerateParentheses(parentheses, 0, 0, "", n);

        return parentheses;
    }

    private static void recursiveGenerateParentheses(List<String> parentheses, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            parentheses.add(s);

            return;
        }

        if (left < n) {
            recursiveGenerateParentheses(parentheses, left + 1, right, s + "(", n);
        }

        if (right < left) {
            recursiveGenerateParentheses(parentheses, left, right + 1, s + ")", n);
        }
    }
}
